package com.example.apgarscorecalculator;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.dibosh.experiments.android.support.customfonthelper.AndroidCustomFontSupport;

public class MainActivity extends SherlockActivity implements
		OnItemClickListener {

	public static String APP_NAME = "অ্যাপগার স্কোর নির্নায়ক";
	ActionBar actionbar;
	ListView Menu;
	ArrayList<CLVRow> MenuList;
	int[] Drawable = { R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		actionbar = getSupportActionBar();
		Typeface font = Typeface.createFromAsset(getAssets(),
				"font/solaimanlipinormal.ttf");
		SpannableString customText = AndroidCustomFontSupport
				.getCorrectedBengaliFormat(getString(R.string.app_name_bangla),
						font, 1);
		actionbar.setTitle(customText);
		int i = 0;
		MenuList = new ArrayList<CLVRow>();

		
		customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
				getString(R.string.what_is_apgar), font, 1);
		CLVRow rowItem = new CLVRow(Drawable[i], customText);
		i++;
		MenuList.add(rowItem);
		customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
				getString(R.string.interpretation_of_score), font, 1);
		rowItem = new CLVRow(Drawable[i], customText);
		i++;
		MenuList.add(rowItem);
		customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
				getString(R.string.criteria), font, 1);
		rowItem = new CLVRow(Drawable[i], customText);
		i++;
		MenuList.add(rowItem);
		customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
				getString(R.string.calculate_apgar_score), font, 1);
		rowItem = new CLVRow(Drawable[i], customText);
		i++;
		MenuList.add(rowItem);
		customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
				getString(R.string.what_to_do), font, 1);
		rowItem = new CLVRow(Drawable[i], customText);
		i++;
		MenuList.add(rowItem);

		CLVAdapter adapter = new CLVAdapter(this, R.layout.clv_row, MenuList);
		Menu = (ListView) findViewById(R.id.Menu);
		Menu.setAdapter(adapter);
		Menu.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int pos, long id) {
		// TODO Auto-generated method stub
		if (pos == 0) {
			Intent intent = new Intent(getApplicationContext(),
					WhatIsApgar.class);
			startActivity(intent);
		}
		if (pos == 1) {
			Intent intent = new Intent(getApplicationContext(),
					InterpretationOfScore.class);
			startActivity(intent);
		}
		if (pos == 2) {
			Intent intent = new Intent(getApplicationContext(),
					CriteriaOfScore.class);
			startActivity(intent);
		}
		if (pos == 3) {
			Intent intent = new Intent(getApplicationContext(),
					CalculateScore.class);
			startActivity(intent);
		}
		if (pos == 4) {
			Intent intent = new Intent(getApplicationContext(), WhatToDo.class);
			startActivity(intent);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// TODO Auto-generated method stub
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		View menuItemView = findViewById(R.id.about);
		final View addView = getLayoutInflater().inflate(
				R.layout.courtesy_layout, null);
		Typeface font = Typeface.createFromAsset(getAssets(),
				"font/solaimanlipinormal.ttf");
		 
		
		TextView tvCourtesy;
		SpannableString customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(getString(
	        		R.string.details_courtesy), font, 1);
		tvCourtesy=(TextView)addView.findViewById(R.id.details_courtesy);
		tvCourtesy.setText(customText);
			
		AlertDialog.Builder builer=new AlertDialog.Builder(this);
		customText = AndroidCustomFontSupport
				.getCorrectedBengaliFormat(getString(R.string.app_name_bangla),
						font, 1);
		builer.setTitle(customText);
		builer.setInverseBackgroundForced(true);
		builer.setIcon(R.drawable.ic_launcher);
		builer.setView(addView);
		builer.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.cancel();
						//alert.dismiss();
					}
		});
		
		AlertDialog alert=builer.create();
		alert.show();
		
		return true;
	}
}


