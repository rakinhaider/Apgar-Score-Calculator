package com.example.apgarscorecalculator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.dibosh.experiments.android.support.customfonthelper.AndroidCustomFontSupport;

public class InterpretationOfScore extends SherlockActivity {
	
	WebView wvDetailsInterpretation;
	ActionBar actionbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interpretation_of_score);
		
		actionbar=getSupportActionBar();
		Typeface font=Typeface.createFromAsset(getAssets(), "font/solaimanlipinormal.ttf");
        SpannableString customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(getString(R.string.app_name_bangla), font, 1);
        actionbar.setTitle(customText);
		actionbar.setDisplayHomeAsUpEnabled(true);
		
		wvDetailsInterpretation=(WebView)findViewById(R.id.detailsInterpretaion);
		wvDetailsInterpretation.getSettings().setSupportZoom(true);
		wvDetailsInterpretation.getSettings().setBuiltInZoomControls(true);

		
		try {
			String customHtml = getText();
			String url = "file:///android_asset/font/solaimanlipinormal.ttf";
			String head = "<head><style>@font-face {font-family: 'banglaFont';src: url("
					+ url + ");}body {font-family: 'banglaFont';background-color:#6f9ee2;}</style></head>";
			customText = AndroidCustomFontSupport.getCorrectedBengaliFormat(
					customHtml , font, 1);
			String htmlData = "<html>"
					+ head
					+ "<body>"
					+ customText
					+ "</body></html>";
		
			wvDetailsInterpretation.loadDataWithBaseURL("file:///android_asset/", htmlData,
					"text/html", "utf-8", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
			
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				return true;
		}
		return false;

	}
	
	
	public String getText() throws Exception {
		InputStream is = getAssets().open("Interpretation.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = "";
		String total = "";
		while ((line = br.readLine()) != null) {
			Log.d("line", line);
			total += line;
		}
		return total;
	}
}
