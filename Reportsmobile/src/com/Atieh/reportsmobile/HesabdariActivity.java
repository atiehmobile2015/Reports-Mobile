package com.Atieh.reportsmobile;

import pageradapter.pageradapterhesabdari;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HesabdariActivity extends FragmentActivity {
	public Utils utils = Utils.getInstance();
	ImageButton menu;
	ImageButton underlinetarkibi;
	ImageButton underlinefgardesh;
	 
	ImageButton forosh;
	ImageButton hesabdari;
	ImageButton khazane;
	ImageButton kala;
	ImageButton domain;
	ImageButton logout;
	LinearLayout linearmenu;
	LinearLayout lmenu;
	ViewPager pagehesabdari;
	Button gardesh;
	Button tarkibi;
	TextView title;
	public static Animation animbounce;

	public void initview() {
		menu = (ImageButton) findViewById(R.id.imgbtn_menu_hesabdari);
		underlinetarkibi = (ImageButton) findViewById(R.id.imgbtn_underline_tarkibi_hesabdari);
		underlinefgardesh = (ImageButton) findViewById(R.id.imgbtn_underline_gardesh_hesabdari);
		 linearmenu = (LinearLayout) findViewById(R.id.linearmenu_hesabdari);
		 lmenu = (LinearLayout) findViewById(R.id.submenu_hesabdari);
		forosh = (ImageButton) findViewById(R.id.imgbtn_forosh_hesabdari);
		hesabdari = (ImageButton) findViewById(R.id.imgbtn_hesabdari_hesabdari);
		
		khazane = (ImageButton) findViewById(R.id.imgbtn_khazane_hesabdari);
		kala = (ImageButton) findViewById(R.id.imgbtn_kala_hesabdari);
		domain = (ImageButton) findViewById(R.id.imgbtn_domain_hesabdari);
		logout = (ImageButton) findViewById(R.id.imgbtn_logout_hesabdari);
		pagehesabdari = (ViewPager) findViewById(R.id.pagerhesabdari);
		gardesh = (Button) findViewById(R.id.tabbtn_gardesh_hesabdari);
		tarkibi = (Button) findViewById(R.id.tabbtn_tarkibi_hesabdari);
		 
		title = (TextView) findViewById(R.id.title_hesabdari);

	}
public void permissiontoreport() {
		
		forosh.setVisibility(View.GONE);
		khazane.setVisibility(View.GONE);
		hesabdari.setVisibility(View.GONE);
		kala.setVisibility(View.GONE);
		for (int k = 1; k <= 4; k++) {
			if (HomeActivity.mypermission[k] == 1) {
				forosh.setVisibility(View.VISIBLE);
			} else if (HomeActivity.mypermission[k] == 2) {
				khazane.setVisibility(View.VISIBLE);
			} else if (HomeActivity.mypermission[k] == 3) {
				hesabdari.setVisibility(View.VISIBLE);
			} else if (HomeActivity.mypermission[k] == 4) {
				kala.setVisibility(View.VISIBLE);
			}
		}

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
		setContentView(R.layout.activity_hesabdari);
		initview();
		permissiontoreport();
		animbounce = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.bounce);
		title.setTypeface(MainActivity.titr);
		hesabdari.setVisibility(View.GONE);
		final pageradapterhesabdari pageadapter = new pageradapterhesabdari(
				getSupportFragmentManager());
		pagehesabdari.setAdapter(pageadapter);
		pagehesabdari.setCurrentItem(1);
		underlinetarkibi.setVisibility(View.INVISIBLE);
		

		
		linearmenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showmenu(v);
				
			}
		});
		pagehesabdari.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				if (pagehesabdari.getCurrentItem() == 1) {
					underlinefgardesh.setVisibility(View.VISIBLE);
					underlinetarkibi.setVisibility(View.INVISIBLE);
					
				} else if (pagehesabdari.getCurrentItem() == 0) {
					underlinetarkibi.setVisibility(View.VISIBLE);
					underlinefgardesh.setVisibility(View.INVISIBLE);
					 
				} 

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		gardesh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagehesabdari.setCurrentItem(1);

			}
		});

		tarkibi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pagehesabdari.setCurrentItem(0);

			}
		});
		
		forosh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HesabdariActivity.this,
						ForoshActivity.class));
			}
		});
		khazane.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HesabdariActivity.this,
						KhazaneActivity.class));
			}
		});
		
		kala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HesabdariActivity.this,
						KalaActivity.class));
			}
		});
		domain.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(HesabdariActivity.this,
						SelectDomainActivity.class));
			}
		});
		

		menu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				lmenu.startAnimation(animbounce);
				showmenu(v);
//				Toast.makeText(getApplicationContext(), "", 1).show();

			}
		});
	logout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("EXIT", true);
				startActivity(intent);
				
			}
		});
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		 
		Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}

}
