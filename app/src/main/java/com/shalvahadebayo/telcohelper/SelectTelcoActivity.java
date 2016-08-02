package com.shalvahadebayo.telcohelper;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class SelectTelcoActivity extends AppCompatActivity
	{

		String action;

		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_select_telco);
			
			Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
			setSupportActionBar(toolbar);
			action = TelcoUtils.getActionAsString(getIntent().getStringExtra(MainActivity
					.ITEM_SELECTED))
			setTitle(action);

			getSupportActionBar().setDisplayHomeAsUpEnabled(true);

			setuoView();

		}



		private void setuoView()
		{
			ListView lv = (ListView) findViewById(android.R.id.list);
			String[] mStringArray = getResources().getStringArray(R.array.telcos);
			TelcoListAdapter mAdapter = new TelcoListAdapter(this, R.layout.telco_list_item, R.id
					.telcoName,
					mStringArray);
			assert lv != null;
			lv.setAdapter(mAdapter);
			lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
				{
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id)
					{
						String telco=TelcoUtils.getTelco(""+id);
						if (telco.equals(TelcoUtils.TELCO_NTEL))
							Toast.makeText(getBaseContext(), "Coming Soon...", Toast.LENGTH_SHORT).show();
						else if (action.equals(TelcoUtils.ACTION_RECHARGE_AIRTIME))
						{
							String ussd=TelcoUtils.getUssd(action, telco);
							Intent intent = new Intent(getBaseContext(), EnterCodeActivity.class);
							intent.putExtra("ussd", ussd);
							startActivity(intent);
						}
						else if (action.equals(TelcoUtils.ACTION_PLEASE_CALL_ME))
						{
							String ussd = TelcoUtils.getUssd(action, telco);
							Intent intent1 = new Intent(getBaseContext(), EnterNumberActivity.class);
							intent1.putExtra("ussd", ussd);
							startActivity(intent1);
						}
						else if (action.equals(TelcoUtils.ACTION_CUSTOMER_CARE))
						{
							String ussd = TelcoUtils.getUssd(action, telco);
							Intent intent2 = new Intent(Intent.ACTION_CALL);
							intent2.setData(Uri.parse("tel:" + TelcoUtils.getUssd(action, telco)));
							startActivity(intent2);
						}
						else
						{
							String ussd = TelcoUtils.getUssd(action, telco);
							Intent intent3 = new Intent(Intent.ACTION_CALL);
							Uri uri=Uri.parse("tel:" + TelcoUtils.getUssd(action, telco) + Uri.encode
									("#"));
							intent3.setData(uri);
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
							startActivity(intent3);
						}
				}
			});
	}

		private class TelcoListAdapter extends ArrayAdapter<String>
			{

				public TelcoListAdapter(Context context, int resource, int textViewResourceId, String[]
						strings)
				{
					super(context, resource, textViewResourceId, Arrays.asList(strings));
				}


				@Override
				public View getView(int position, View convertView, ViewGroup parent)
				{
					View view=super.getView(position, convertView, parent);;


					ImageView telcoLogo=(ImageView) view.findViewById(R.id.telco_logo);
					assert telcoLogo != null;
					switch (position)
					{
						case 0:
							telcoLogo.setImageDrawable(getResources().getDrawable(R.drawable.mtn));
							break;
						case 1:
							telcoLogo.setImageDrawable(getResources().getDrawable(R.drawable.glo));
							break;
						case 2:
							telcoLogo.setImageDrawable(getResources().getDrawable(R.drawable.airtel));
							break;
						case 3:
							telcoLogo.setImageDrawable(getResources().getDrawable(R.drawable.etisalat));
							break;
						case 4:
							telcoLogo.setImageDrawable(getResources().getDrawable(R.drawable.ntel));
							break;
					}
					return view;
				}
			}

	}
