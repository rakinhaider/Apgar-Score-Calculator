package com.example.apgarscorecalculator;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.dibosh.experiments.android.support.customfonthelper.AndroidCustomFontSupport;

public class CalculateScore extends SherlockActivity implements android.view.View.OnClickListener{
	
	int score;
	Button button;
	ActionBar actionbar;
	TextView SelectActivity,SelectPulse,SelectAppearance,SelectGrimace,SelectRespEffort;
	RadioGroup rdgrpActivity,rdgrpPulse,rdgrpAppearance,rdgrpGrimace,rdgrpRespEffort;
	RadioButton option1,option2,option3;
	TextView ShowResult;
	Typeface font;
	SpannableString customText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculate_score);
		
		font=Typeface.createFromAsset(getAssets(), "font/solaimanlipinormal.ttf");
		
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.please_wait), font, 1);
		//ProgressDialog pd=ProgressDialog.show(getApplicationContext(), "", "");
		
		font=Typeface.createFromAsset(getAssets(), "font/solaimanlipinormal.ttf");
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.app_name_bangla), font, 1);
        actionbar=getSupportActionBar();
        actionbar.setTitle(customText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        
        ShowResult=(TextView) findViewById(R.id.result);
   
        
        SelectAppearance=(TextView)findViewById(R.id.select_appearance);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.select_appearance), font, 1);
        SelectAppearance.setText(customText);
        
        SelectPulse=(TextView)findViewById(R.id.select_pulse);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.select_pulse), font, 1);
        SelectPulse.setText(customText);
        
        SelectGrimace=(TextView)findViewById(R.id.select_grimace);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.select_grimace), font, 1);
        SelectGrimace.setText(customText);
        
        SelectActivity=(TextView)findViewById(R.id.select_activity_of_child);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.select_activity_of_child), font, 1);
        SelectActivity.setText(customText);
        
        SelectRespEffort=(TextView)findViewById(R.id.select_resp_effort);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.select_resp_effort), font, 1);
        SelectRespEffort.setText(customText);
        
        //radion group 1
        
        option1=(RadioButton)findViewById(R.id.blueish);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.blueish), font, 1);
        option1.setText(customText);
        option2=(RadioButton)findViewById(R.id.pink_at_extrimities);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.pink_at_extrimities), font, 1);
        option2.setText(customText);
        option3=(RadioButton)findViewById(R.id.all_pink);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.all_pink), font, 1);
        option3.setText(customText);
        rdgrpAppearance=(RadioGroup)findViewById(R.id.rdgrp_select_app);
        
        
      //radion group 2
        option1=(RadioButton)findViewById(R.id.no_pulse);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.pulse_absent), font, 1);
        option1.setText(customText);
        option2=(RadioButton)findViewById(R.id.less_than_hundred);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.less_than_hundred), font, 1);
        option2.setText(customText);
        option3=(RadioButton)findViewById(R.id.greater_than_hundred);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.greater_than_hundred), font, 1);
        option3.setText(customText);
        rdgrpPulse=(RadioGroup)findViewById(R.id.rdgrp_select_pul);
        
      //radion group 3
        option1=(RadioButton)findViewById(R.id.no_response);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.no_response), font, 1);
        option1.setText(customText);
        option2=(RadioButton)findViewById(R.id.feeble_cry);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.feeble_cry), font, 1);
        option2.setText(customText);
        option3=(RadioButton)findViewById(R.id.loud_cry);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.loud_cry), font, 1);
        option3.setText(customText);
        rdgrpGrimace=(RadioGroup)findViewById(R.id.rdgrp_select_grim);
        
      //radion group 4
        option1=(RadioButton)findViewById(R.id.no_activity);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.no_flexion), font, 1);
        option1.setText(customText);
        option2=(RadioButton)findViewById(R.id.some_flexion);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.some_flexion), font, 1);
        option2.setText(customText);
        option3=(RadioButton)findViewById(R.id.flexible);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.flexible), font, 1);
        option3.setText(customText);
        rdgrpActivity=(RadioGroup)findViewById(R.id.rdgrp_select_act);
        
        
      //radion group 5
        option1=(RadioButton)findViewById(R.id.no_resp);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.no_resp), font, 1);
        option1.setText(customText);
        option2=(RadioButton)findViewById(R.id.week_resp);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.week_resp), font, 1);
        option2.setText(customText);
        option3=(RadioButton)findViewById(R.id.strong_resp);
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.strong_resp), font, 1);
        option3.setText(customText);
        rdgrpRespEffort=(RadioGroup)findViewById(R.id.rdgrp_select_res_eff);
        
        
        customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
        		getString(R.string.calculate), font, 1);
        button=(Button)findViewById(R.id.calculate);
        button.setText(customText);
        
        button.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {

		Log.d("TAG", v.toString()+" "+button.toString());
		if(v.getId()==R.id.calculate)
		{
			score=0;
			if(rdgrpAppearance.getCheckedRadioButtonId()==R.id.blueish)score+=0;
			else if(rdgrpAppearance.getCheckedRadioButtonId()==R.id.pink_at_extrimities)score+=1;
			else if(rdgrpAppearance.getCheckedRadioButtonId()==R.id.all_pink)score+=2;
			
			if(rdgrpPulse.getCheckedRadioButtonId()==R.id.no_pulse)score+=0;
			else if(rdgrpPulse.getCheckedRadioButtonId()==R.id.less_than_hundred)score+=1;
			else if(rdgrpPulse.getCheckedRadioButtonId()==R.id.greater_than_hundred)score+=2;
			
			if(rdgrpGrimace.getCheckedRadioButtonId()==R.id.no_response)score+=0;
			else if(rdgrpGrimace.getCheckedRadioButtonId()==R.id.feeble_cry)score+=1;
			else if(rdgrpGrimace.getCheckedRadioButtonId()==R.id.loud_cry)score+=2;
			
			if(rdgrpActivity.getCheckedRadioButtonId()==R.id.no_activity)score+=0;
			else if(rdgrpActivity.getCheckedRadioButtonId()==R.id.some_flexion)score+=1;
			else if(rdgrpActivity.getCheckedRadioButtonId()==R.id.flexible)score+=2;

			if(rdgrpRespEffort.getCheckedRadioButtonId()==R.id.no_resp)score+=0;
			else if(rdgrpRespEffort.getCheckedRadioButtonId()==R.id.week_resp)score+=1;
			else if(rdgrpRespEffort.getCheckedRadioButtonId()==R.id.strong_resp)score+=2;

			String result=getString(R.string.result);
			
			switch(score)
			{
				case 0:
					result+=" "+getString(R.string.zero);
					break;
				case 1:
					result+=" "+getString(R.string.one);
					break;
				case 2:
					result+=" "+getString(R.string.two);
					break;
				case 3:
					result+=" "+getString(R.string.three);
					break;
				case 4:
					result+=" "+getString(R.string.four);
					break;
				case 5:
					result+=" "+getString(R.string.five);
					break;
				case 6:
					result+=" "+getString(R.string.six);
					break;
				case 7:
					result+=" "+getString(R.string.seven);
					break;
				case 8:
					result+=" "+getString(R.string.eight);
					break;
				case 9:
					result+=" "+getString(R.string.nine);
					break;
				case 10:
					result+=" "+getString(R.string.ten);
					break;
			}
			
			customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
	        		result, font, 1);
			ShowResult.setText(customText);
		}
		
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
