package com.example.apgarscorecalculator;


import com.dibosh.experiments.android.support.customfonthelper.AndroidCustomFontSupport;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.view.View;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	int PAGE_COUNT=5;
	
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int pos) {
		
		if(pos==0)
		{
			FragmentAppearance FragAppearance = new FragmentAppearance();
			Bundle data = new Bundle();
			data.putInt("current_page", pos+1);
			FragAppearance.setArguments(data);
			return FragAppearance;
		}
		else if(pos==1)
		{
			FragmentPulse FragPulse = new FragmentPulse();
			Bundle data = new Bundle();
			data.putInt("current_page", pos+1);
			FragPulse.setArguments(data);
			return FragPulse;
		}
		else if(pos==2)
		{
			FragmentGrimace FragGrim = new FragmentGrimace();
			Bundle data = new Bundle();
			data.putInt("current_page", pos+1);
			FragGrim.setArguments(data);
			return FragGrim;
		}
		else if(pos==3)
		{
			FragmentActivityOfChild FragAct = new FragmentActivityOfChild();
			Bundle data = new Bundle();
			data.putInt("current_page", pos+1);
			FragAct.setArguments(data);
			return FragAct;
		}
		else if(pos==4)
		{
			FragmentRespiratoryEffort FragResp = new FragmentRespiratoryEffort();
			Bundle data = new Bundle();
			data.putInt("current_page", pos+1);
			FragResp.setArguments(data);
			return FragResp;
		}
		else return null;
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}
	@Override
	public CharSequence getPageTitle(int position) {
		return "Page #" + ( position + 1 );
	}
}
