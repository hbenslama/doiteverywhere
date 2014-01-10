package com.audamob.doit.activity;

import java.io.IOException;
import java.util.ArrayList;

import com.audamob.doit.R;
import com.audamob.doit.activity.SlidingMenu.ActivityBase;
import com.audamob.doit.activity.SlidingMenu.SlidingMenuBuilderConcrete;
import com.audamob.doit.adapter.GridActivtiesProfileAdapter;
import com.audamob.doit.model.Account;
import com.audamob.doit.model.DoItActivity;
import com.audamob.doit.utils.CacheReadWriteUtil;
import com.audamob.doit.utils.ImageLoaderUtil;
import com.audamob.doit.utils.LayoutResizerUtil;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends ActivityBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_activity);

		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(
				R.color.withe)));
		
		ImageView im = (ImageView)findViewById(
				R.id.profile_picture);

		Account ac = null;
		try {
			ac = CacheReadWriteUtil.restoreAccount(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		im.getLayoutParams().height = LayoutResizerUtil.getpercent(LayoutResizerUtil.getDisplayHightInPx( this),
				60, this);
		im.requestLayout();
		
		UrlImageViewHelper.setUrlDrawableCustom(
				im.getLayoutParams().width,
				im.getLayoutParams().height,im,
				ac.getImageUrl());
		Typeface TODO = Typeface.createFromAsset(getAssets(), "DinDisplayProThin.otf");
		TextView AccountName, AccountAge,AccountLocation;
		AccountName=(TextView)findViewById(R.id.profile_name_p);
		AccountAge=(TextView)findViewById(R.id.profile_age_p);
		AccountLocation=(TextView)findViewById(R.id.profile_location_p);
		
		AccountName.setText(ac.getProfileName()+",");
		AccountAge.setText(ac.getProfileBirthday());
		AccountLocation.setText(ac.getProfileLocation());
		
		AccountAge.setTypeface(TODO);
		AccountLocation.setTypeface(TODO);
		AccountName.setTypeface(TODO);
		GridView GridActivities=(GridView)findViewById(R.id.GridView_DoneActivity);
		ArrayList<DoItActivity> ListDoneActivities=new ArrayList<DoItActivity>();
		ListDoneActivities.add(new DoItActivity("Surfing", "http://www.funfix.com/images/icons/icon_black_locations.png"));
		ListDoneActivities.add(new DoItActivity("SkyDiving", "http://hotspottagger.com/images/markers/surfing_icon.png"));
		GridActivtiesProfileAdapter AdapterGrid=new GridActivtiesProfileAdapter(this, ListDoneActivities);
		GridActivities.setAdapter(AdapterGrid);
}

	@Override
	public boolean enableHomeIconActionSlidingMenu() {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int itemId = item.getItemId();
		switch (itemId) {
		case android.R.id.home:
			this.finish();
		}

		return true;
	}

}
