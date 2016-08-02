package com.shalvahadebayo.telcohelper;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by J on 20/06/2016.
 */
public class EnterCodeActivity extends AppCompatActivity
	{
		String ussd;

		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_enter_recharge_pin);

				final EditText rechargePinET = (EditText) findViewById(R.id.recharge_pin);
				final Button rechargeBtn = (Button) findViewById(R.id.recharge_btn);


				assert rechargePinET != null;
				rechargePinET.addTextChangedListener(new TextWatcher()
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
							if (!rechargePinET.getText().toString().equals(""))
							{
								rechargeBtn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
								rechargeBtn.setEnabled(true);
							} else
							{
								rechargeBtn.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
								rechargeBtn.setEnabled(false);
							}
						}
					});

				assert rechargeBtn != null;
				rechargeBtn.setOnClickListener(new View.OnClickListener()
					{
						@Override
						public void onClick(View v)
						{
							String rechargePin = rechargePinET.getText().toString();
							Intent intent = new Intent(Intent.ACTION_CALL);
							intent.setData(Uri.parse("tel:" + ussd + rechargePin + Uri
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



		}

	}
