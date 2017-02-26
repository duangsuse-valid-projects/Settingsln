package org.duangsuse.slauncher;

import android.app.*;
import android.os.*;
import android.content.*;
import android.widget.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		
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
			Toast.makeText(this , "Activity Not Found" ,Toast.LENGTH_SHORT)
				.show();
				finish();
		}
	}
}
