package com.audamob.doit.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.audamob.doit.R;
import com.audamob.doit.view.activity.FollowingFragmentActivity;
import com.audamob.doit.view.activity.SettingsFragmentActivity;
import com.audamob.doit.view.activity.StreamFragmentActivity;
import com.audamob.doit.view.activity.SwipeyTabFragmentActivity;
import com.audamob.doit.view.uiComponent.SwipeyTabs;

public class SwipeyTabsPagerAdapter extends FragmentStatePagerAdapter implements
		SwipeyTabsAdapter {
	private String[] TabTitles;
	private final Context mContext;
	private ViewPager mViewPager;
	private int fragmentType;

	public SwipeyTabsPagerAdapter(Context context, FragmentManager fm,
			String[] tabs, ViewPager mviewPager, int classFragment) {
		super(fm);
		this.TabTitles = tabs;
		this.mContext = context;
		this.mViewPager = mviewPager;
		this.fragmentType = classFragment;

	}

	@Override
	public Fragment getItem(int position) {
		return CreateSwipeyTab(TabTitles[position], position, fragmentType);

	}

	/**
	 * Creation Tab
	 * 
	 * @param NameTab
	 * @return
	 */
	public Fragment CreateSwipeyTab(String NameTab, int position,
			int NameFragmentCalss) {

		Fragment f = GetClassFragment(NameFragmentCalss, position);

		Bundle args = new Bundle();
		args.putString("title", NameTab);
		f.setArguments(args);
		return f;

	}

	public Fragment GetClassFragment(int NameFragmentCalss, int position) {

		switch (NameFragmentCalss) {
		case 1:
			return new StreamFragmentActivity();
		case 2:
			return new SwipeyTabFragmentActivity();
		case 3:
			return new SwipeyTabFragmentActivity();
		case 5:
			return new SettingsFragmentActivity();
		case 6:
			switch (position) {
			case 0:
				return new FollowingFragmentActivity();
			default:
				return new FollowingFragmentActivity();
			}

		default:
			return new SwipeyTabFragmentActivity();

		}
	}

	@Override
	public int getCount() {
		return TabTitles.length;
	}

	public TextView getTab(final int position, SwipeyTabs root) {
		TextView view = (TextView) LayoutInflater.from(mContext).inflate(
				R.layout.swipeytab_indicator, root, false);
		view.setText(TabTitles[position]);
		view.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mViewPager.setCurrentItem(position);
			}
		});

		return view;
	}

}
