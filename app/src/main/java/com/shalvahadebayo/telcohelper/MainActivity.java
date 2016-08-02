package com.shalvahadebayo.telcohelper;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
	{

		//Intent extra to be sent to telco listing activity so we know which action the user selected
		public static final String ITEM_SELECTED = "item_selected";

		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);

			Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
			setSupportActionBar(toolbar);

			setuoView();
		}

		private void setuoView()
		{
			ListView lv=(ListView)findViewById(android.R.id.list);
			String[] mStringArray=getResources().getStringArray(R.array.built_in_commands);
			ArrayAdapter<String> mAdapter=new ArrayAdapter<String>(this, R.layout.simple_list_item,
					mStringArray);
			lv.setAdapter(mAdapter);
			lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
				{
					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id)
					{
						Intent intent=new Intent(getBaseContext(), SelectTelcoActivity.class);
						intent.putExtra(ITEM_SELECTED, ""+id);
						startActivity(intent);
					}
				});
		}



		@Override
		public boolean onCreateOptionsMenu(Menu menu)
		{
			MenuInflater mi = getMenuInflater();
			mi.inflate(R.menu.menu_main, menu);
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item)
		{
			Intent i = new Intent(this, HelpActivity.class);
			startActivity(i);
			return true;
		}

		/*Called when the "Request Feedback" textview is tapped*/
		public void requestFeedback(View view)
		{
				Intent reqIntent = new Intent(Intent.ACTION_SENDTO);
				reqIntent.setData(Uri.parse("mailto:shalvah.adebayo@gmail,com"));
				reqIntent.putExtra(Intent.EXTRA_SUBJECT, "Telco Helper Feature Request");
				reqIntent.putExtra(Intent.EXTRA_TEXT, "Hi there! Could you work on adding this to the " +
						"app?");
				startActivity(reqIntent);
		}
	}
