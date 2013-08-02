package com.example.apgarscorecalculator;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.dibosh.experiments.android.support.customfonthelper.AndroidCustomFontSupport;

public class CriteriaOfScore extends SherlockFragmentActivity {
	
	ActionBar actionbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.criteria_main);
        
		actionbar=getSupportActionBar();
        Typeface font=Typeface.createFromAsset(getAssets(), "font/solaimanlipinormal.ttf");
        SpannableString customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(getString(R.string.app_name_bangla), font, 1);
        actionbar.setTitle(customText);
        actionbar.setDisplayHomeAsUpEnabled(true);
		
        /** Getting a reference to the ViewPager defined the layout file */        
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        
        /** Getting fragment manager */
        FragmentManager fm = getSupportFragmentManager();
        
        /** Instantiating FragmentPagerAdapter */
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(fm);
        
        /** Setting the pagerAdapter to the pager object */
        pager.setAdapter(pagerAdapter);
		
	}
	
	/*@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// TODO Auto-generated method stub
		getSupportMenuInflater().inflate(R.menu.main,menu);
		return true;
	}*/
	
	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		// TODO Auto-generated method stub
		/*if(item.getItemId()==R.id.back)
		{
			Intent intent=new Intent(getApplicationContext(), MainActivity.class);
			startActivity(intent);
		}
		return true;*/
		
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				return true;
		}
		return false;

	}

}
