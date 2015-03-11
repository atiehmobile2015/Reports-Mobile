package com.Atieh.reportsmobile;

import pageradapter.mypageadapter;
import pageradapter.pageradapterkala;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class KalaActivity extends FragmentActivity {

	ImageButton menu;
	ImageButton underlinemojodi;
	ImageButton underlineroali;
	ImageButton underlineforokhte;
	ImageButton forosh;
	ImageButton hesabdari;

	LinearLayout linearmenu;
	ViewPager pagerkala;
	Button mojodi;
	Button riali;
	 

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_kala);
		underlinemojodi = (ImageButton) findViewById(R.id.imgbtn_underline_mojodi_kala);
		underlineroali = (ImageButton) findViewById(R.id.imgbtn_underline_riali_kala);
		
		linearmenu = (LinearLayout) findViewById(R.id.linearmenu_kala);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_kala);
		hesabdari= (ImageButton) findViewById(R.id.imgbtn_hesabdari_kala);
		pagerkala = (ViewPager) findViewById(R.id.pagerkala);
		mojodi = (Button) findViewById(R.id.tabbtn_mojodi_kala);
		riali = (Button) findViewById(R.id.tabbtn_riali_kala);
		 

	}

	public void showmenu(View v) {
		if (linearmenu.getVisibility() == View.GONE) {
			linearmenu.setVisibility(View.VISIBLE);

		} else {
			linearmenu.setVisibility(View.GONE);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kala);
		initview();
		
		
		forosh.setVisibility(View.GONE);
		final pageradapterkala pageadapter = new pageradapterkala(
				getSupportFragmentManager());
		pagerkala.setAdapter(pageadapter);
		pagerkala.setCurrentItem(1);
		underlineroali.setVisibility(View.INVISIBLE);
		underlinemojodi.setVisibility(View.VISIBLE);

		
		linearmenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showmenu(v);
				
			}
		});
		pagerkala.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				  if (pagerkala.getCurrentItem() == 1) {
					underlineroali.setVisibility(View.INVISIBLE);
					underlinemojodi.setVisibility(View.VISIBLE);
					
				} else if (pagerkala.getCurrentItem() == 0) {
					
					underlineroali.setVisibility(View.VISIBLE);
					underlinemojodi.setVisibility(View.INVISIBLE);
				}

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		

		mojodi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkala.setCurrentItem(1);

			}
		});
		
		hesabdari.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KalaActivity.this,
						HesabdariActivity.class));
			}
		});
		riali.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkala.setCurrentItem(0);

			}
		});

		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showmenu(v);
//				Toast.makeText(getApplicationContext(), "", 1).show();

			}
		});
	}

}
