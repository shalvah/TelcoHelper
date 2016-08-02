package com.shalvahadebayo.telcohelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by J on 21/06/2016.
 */
public class HelpActivity extends AppCompatActivity
	{
		@Override
		protected void onCreate(@Nullable Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_help);
		}

		public void smsOrMail(View v)
		{
			switch (v.getId())
			{
				case R.id.sms_btn:
					Intent callIntent = new Intent(Intent.ACTION_SENDTO);
					callIntent.setData(Uri.parse("smsto:08165213439"));
					startActivity(callIntent);
					break;
				case R.id.email_btn:
					Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
					mailIntent.setData(Uri.parse("mailto:shalvah.adebayo@gmail,com"));
					mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Telco Helper Feeedback");
					startActivity(mailIntent);
					break;
				case R.id.request_feature_btn:
					Intent reqIntent = new Intent(Intent.ACTION_SENDTO);
					reqIntent.setData(Uri.parse("mailto:shalvah.adebayo@gmail,com"));
					reqIntent.putExtra(Intent.EXTRA_SUBJECT, "Telco Helper Feature Request");
					reqIntent.putExtra(Intent.EXTRA_TEXT, "Hi there! Could you work on adding this to the " +
							"app?");
					startActivity(reqIntent);
					break;
			}
		}

		public void viewSource(View view)
		{
			Intent sourceIntent = new Intent(Intent.ACTION_VIEW);
			sourceIntent.setData(Uri.parse("http://github,com/Shalvah/Telco-Helper"));
			startActivity(sourceIntent);

		}

		public void rateApp(View view)
		{
			Toast.makeText(this,"Coming soon...",  Toast.LENGTH_SHORT).show();
		}
	}
