package com.Atieh.reportsmobile;

import pageradapter.mypageadapter;
import pageradapter.pageradapterkhazane;
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

public class KhazaneActivity extends FragmentActivity {

	ImageButton menu;
	ImageButton underlinedaryafti;
	ImageButton underlinevaziatdaryafti;
	ImageButton underlinepardakhti;
	ImageButton underlinevaziatpardakhti;
	ImageButton forosh;
	ImageButton khazane;
	ImageButton hesabdari;
	ImageButton kala;
	ImageButton domain;

	LinearLayout linearmenu;
	ViewPager pagerkhazane;
	Button daryafti;
	Button vaziatdaryafti;
	Button pardakhti;
	Button vaziatpardakhti;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_khazane);
		underlinedaryafti = (ImageButton) findViewById(R.id.imgbtn_underline_asnaddaryafti_khazane);
		underlinevaziatdaryafti = (ImageButton) findViewById(R.id.imgbtn_underline_vaziatasnaddaryafti_khazane);
		underlinepardakhti = (ImageButton) findViewById(R.id.imgbtn_underline_asnadpardakhti_khazane);
		underlinevaziatpardakhti = (ImageButton) findViewById(R.id.imgbtn_underline_vaziatasnadpardakhti_khazane);

		linearmenu = (LinearLayout) findViewById(R.id.linearmenu_khazane);

		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_khazane);
		khazane = (ImageButton) findViewById(R.id.imgbtn_khazane_khazane);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_khazane);
		kala = (ImageButton) findViewById(R.id.imgbtn_kala_khazane);
		domain = (ImageButton) findViewById(R.id.imgbtn_domain_khazane);
		
		pagerkhazane = (ViewPager) findViewById(R.id.pagerkhazane);
		
		 daryafti = (Button) findViewById(R.id.tabbtn_asnaddaryafti_khazane);
		 vaziatdaryafti = (Button) findViewById(R.id.tabbtn_vaziatasnaddaryafti_khazane);
		 pardakhti = (Button) findViewById(R.id.tabbtn_asnadpardakhti_khazane);
		 vaziatpardakhti = (Button) findViewById(R.id.tabbtn_vaziatasnadpardakhti_khazane);

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
		setContentView(R.layout.activity_khazane);
		initview();

		khazane.setVisibility(View.GONE);

		final pageradapterkhazane pageadapter = new pageradapterkhazane(
				getSupportFragmentManager());
		pagerkhazane.setAdapter(pageadapter);

		pagerkhazane.setCurrentItem(3);

		underlinevaziatdaryafti.setVisibility(View.INVISIBLE);
		underlinepardakhti.setVisibility(View.INVISIBLE);
		underlinevaziatpardakhti.setVisibility(View.INVISIBLE);

		linearmenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showmenu(v);

			}
		});
		pagerkhazane.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			// underlinedaryafti = (ImageButton)
			// findViewById(R.id.imgbtn_underline_asnaddaryafti_khazane);
			// underlinevaziatdaryafti = (ImageButton)
			// findViewById(R.id.imgbtn_underline_vaziatasnaddaryafti_khazane);
			// underlinepardakhti = (ImageButton)
			// findViewById(R.id.imgbtn_underline_asnadpardakhti_khazane);
			// underlinevaziatpardakhti = (ImageButton)
			// findViewById(R.id.imgbtn_underline_vaziatasnadpardakhti_khazane);

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				if (pagerkhazane.getCurrentItem() == 3) {
					underlinedaryafti.setVisibility(View.VISIBLE);
					underlinevaziatdaryafti.setVisibility(View.INVISIBLE);
					underlinepardakhti.setVisibility(View.INVISIBLE);
					underlinevaziatpardakhti.setVisibility(View.INVISIBLE);
				} else if (pagerkhazane.getCurrentItem() == 2) {
					underlinedaryafti.setVisibility(View.INVISIBLE);
					underlinevaziatdaryafti.setVisibility(View.VISIBLE);
					underlinepardakhti.setVisibility(View.INVISIBLE);
					underlinevaziatpardakhti.setVisibility(View.INVISIBLE);

				} else if (pagerkhazane.getCurrentItem() == 1) {
					underlinedaryafti.setVisibility(View.INVISIBLE);
					underlinevaziatdaryafti.setVisibility(View.INVISIBLE);
					underlinepardakhti.setVisibility(View.VISIBLE);
					underlinevaziatpardakhti.setVisibility(View.INVISIBLE);
				} else if (pagerkhazane.getCurrentItem() == 0) {
					underlinedaryafti.setVisibility(View.INVISIBLE);
					underlinevaziatdaryafti.setVisibility(View.INVISIBLE);
					underlinepardakhti.setVisibility(View.INVISIBLE);
					underlinevaziatpardakhti.setVisibility(View.VISIBLE);
				}

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		daryafti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkhazane.setCurrentItem(3);

			}
		});

		vaziatdaryafti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkhazane.setCurrentItem(2);

			}
		});
		pardakhti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkhazane.setCurrentItem(1);

			}
		});

		vaziatpardakhti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagerkhazane.setCurrentItem(0);

			}
		});
		hesabdari.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KhazaneActivity.this,
						HesabdariActivity.class));
			}
		});
		forosh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KhazaneActivity.this,
						ForoshActivity.class));
			}
		});
		kala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KhazaneActivity.this,
						KalaActivity.class));
			}
		});
		
		domain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(KhazaneActivity.this,
						SelectDomainActivity.class));
			}
		});

		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showmenu(v);
				// Toast.makeText(getApplicationContext(), "", 1).show();

			}
		});
	}

}
