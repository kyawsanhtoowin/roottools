package RootTools.example;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.stericson.RootTools.RootTools;

public class Example extends Activity {
	
	private Button busybox, superuser, isBusyBox, isRootAvailable, isAccessGiven, hasEnoughSpaceOnSdCard;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                
        busybox = (Button) findViewById(R.id.busybox);
        busybox.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		RootTools.offerBusyBox(Example.this);
        	}
        });
        
        superuser = (Button) findViewById(R.id.superuser);
        superuser.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		RootTools.offerSuperUser(Example.this);
        	}
        });
        
        isBusyBox = (Button) findViewById(R.id.isbusybox);
        isBusyBox.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		if (RootTools.isBusyboxAvailable()) {
        			makeToast("BusyBox is available!");
        		} else {
        			makeToast("BusyBox is not available!");
        		}
        	}
        });
        
        isRootAvailable = (Button) findViewById(R.id.isRootAvailable);
        isRootAvailable.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		if (RootTools.isRootAvailable()) {
        			makeToast("Root is available!");
        		} else {
        			makeToast("Root is not available!");
        		}
        	}
        });
        
        isAccessGiven = (Button) findViewById(R.id.isAccessGiven);
        isAccessGiven.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		if (RootTools.isAccessGiven()) {
        			makeToast("Root access has been granted!");
        		} else {
        			makeToast("Root access has not been granted!");
        		}
        	}
        });
        
        hasEnoughSpaceOnSdCard = (Button) findViewById(R.id.hasEnoughSpaceOnSdCard);
        hasEnoughSpaceOnSdCard.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		if (RootTools.hasEnoughSpaceOnSdCard(100)) {
        			makeToast("There is enough space on the SDcard for a 100mb!");
        		} else {
        			makeToast("either there is not enough space on the SDcard for a 100mb, or the SDcard is not mounted as RW!");
        		}
        	}
        });
    }
    
    
    public void makeToast(String msg) {
    	Context context = getApplicationContext();
    	CharSequence text = msg;
    	int duration = Toast.LENGTH_LONG;

    	Toast toast = Toast.makeText(context, text, duration);
    	toast.show();
    }
}