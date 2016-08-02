package com.shalvahadebayo.telcohelper;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterNumberActivity extends AppCompatActivity
	{
		private static final int PICK_REQUEST_CODE = 1;

		@Override
		protected void onCreate(@Nullable Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_enter_phone_number);

			final String ussd = getIntent().getStringExtra("ussd");
			final EditText phoneNumET = (EditText) findViewById(R.id.phone_num);
			final Button callBtn = (Button) findViewById(R.id.call_btn);
			final Button contactBtn = (Button) findViewById(R.id.select_contact_btn);

			assert phoneNumET != null;
			phoneNumET.addTextChangedListener(new TextWatcher()
				{
					@Override
					public void beforeTextChanged(CharSequence s, int start, int count, int after)
					{

					}

					@Override
					public void onTextChanged(CharSequence s, int start, int before, int count)
					{

					}

					@Override
					public void afterTextChanged(Editable s)
					{
						if (!phoneNumET.getText().toString().equals(""))
						{
							callBtn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
							callBtn.setEnabled(true);
						} else
						{
							callBtn.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
							callBtn.setEnabled(false);
						}
					}
				});

			assert callBtn != null;
			callBtn.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						String phoneNum = phoneNumET.getText().toString();
						Intent intent = new Intent(Intent.ACTION_CALL);
						intent.setData(Uri.parse("tel:" + ussd + phoneNum + Uri
								.encode("#")));
						if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission
								.CALL_PHONE) !=
								PackageManager.PERMISSION_GRANTED)
						{
							// TODO: Consider calling
							//    ActivityCompat#requestPermissions
							// here to request the missing permissions, and then overriding
							//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
							//                                          int[] grantResults)
							// to handle the case where the user grants the permission. See the documentation
							// for ActivityCompat#requestPermissions for more details.
							return;
						}
						startActivity(intent);
					}
				});

			assert contactBtn != null;
			contactBtn.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						Intent pickContact=new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
						pickContact.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
						startActivityForResult(pickContact, PICK_REQUEST_CODE);
					}
				});
		}

		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data)
		{
			if (resultCode==RESULT_OK)
			{
				Uri contactUri=data.getData();
				String[] projection={ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract
						.CommonDataKinds.Phone.DISPLAY_NAME};
				Cursor c= getContentResolver().query(contactUri, projection, null, null, null);
				assert c != null;
				c.moveToFirst();

				final Button contactBtn = (Button) findViewById(R.id.select_contact_btn);
				assert contactBtn != null;
				contactBtn.setText("Change Contact");

				final TextView contactName = (TextView) findViewById(R.id.contact_name);
				assert contactName != null;
				contactName.setText(c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone
						.DISPLAY_NAME)));

				final EditText phoneNumET = (EditText) findViewById(R.id.phone_num);
				assert phoneNumET != null;
				phoneNumET.setText(c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));

			}
		}
	}
