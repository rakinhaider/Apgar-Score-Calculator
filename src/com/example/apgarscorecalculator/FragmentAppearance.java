package com.example.apgarscorecalculator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.dibosh.experiments.android.support.customfonthelper.AndroidCustomFontSupport;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class FragmentAppearance extends Fragment {
	
	WebView wvDetailsAppearance;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.frag_appearance, null, false);
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"font/solaimanlipinormal.ttf");
		SpannableString customText = AndroidCustomFontSupport
				.getCorrectedBengaliFormat(getString(R.string.app_name_bangla),
						font, (float)1.2);
		wvDetailsAppearance= (WebView)view.findViewById(R.id.details_appearance);
		wvDetailsAppearance.getSettings().setSupportZoom(true);
		wvDetailsAppearance.getSettings().setBuiltInZoomControls(true);

		
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
		
			wvDetailsAppearance.loadDataWithBaseURL("file:///android_asset/", htmlData,
					"text/html", "utf-8", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return view;
	}
	public String getText() throws Exception {
		InputStream is = getActivity().getAssets().open("DetailsAppearance.txt");
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

