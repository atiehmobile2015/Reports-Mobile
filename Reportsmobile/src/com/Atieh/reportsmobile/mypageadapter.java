package com.Atieh.reportsmobile;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class mypageadapter extends FragmentPagerAdapter {
	private List<Fragment> frgmnts;

	public mypageadapter(FragmentManager fm) {
		super(fm);
		this.frgmnts=new ArrayList<Fragment>();
//		frgmnts.add(new frg_customer_forosh);

	}

	@Override
	public Fragment getItem(int arg0) {

		return null;
	}

	@Override
	public int getCount() {

		return 0;
	}

}
