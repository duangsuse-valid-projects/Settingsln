package org.duangsuse.slauncher;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
//import java.lang.Thread;
import android.view.*;


public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH){
			super.setTheme(android.R.style.Theme_DeviceDefault);
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
			super.setTheme(android.R.style.Theme_Holo);
		}else{
			super.setTheme(android.R.style.Theme_Material);
		}
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.setGravity(Gravity.CENTER);
		//layout.setAlpha(0F);
		getWindow().addFlags(Window.FEATURE_RIGHT_ICON);
		/*Button btnexit = new Button(this);
		Button btnrpy = new Button(this);
		Button btndef = new Button(this);
		Button btnslt = new Button(this);
		layout.addView(btnrpy);
		layout.addView(btnexit);
		layout.addView(btndef);
		layout.addView(btnslt);*/
	
		TextView t = new TextView(this);
		t.setText("Click back To Exit");
		layout.addView(t);
		super.setContentView(layout);
		final EditText input = new EditText(this);
		input.setHint(getString(R.string.hint));
		input.setText("com.android.settings");
		final Intent i = new Intent();
		
		new AlertDialog.Builder(this)
			.setTitle("package?")
			.setIcon(android.R.drawable.ic_media_play)
			.setView(input)
			.setPositiveButton(android.R.string.ok, 
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog , int c) {
					startActi(i.setPackage(input.getText().toString()));
					dialog.dismiss();
				}
			})
			.setNegativeButton(android.R.string.cancel, 
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog , int c) {
					dialog.dismiss();
					finish();
				}
			})
			.show();
    }
	 void startActi(Intent i){
		try{
			startActivity(i);
			finish();
		} catch (Exception ActivityNotFoundException) {
			Toast.makeText(this , "Package Not Found" ,Toast.LENGTH_SHORT)
				.show();
				finish();
		}
	}
}
