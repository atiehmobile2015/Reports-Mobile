package com.Atieh.reportsmobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dataBase.database;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewAlphebeticalActivity extends Activity implements
		OnClickListener {
	public Utils utils = Utils.getInstance();

	TextView tv_title;
	ListView lv_person;
	String[] arrayID;
	String[] arraytitle;
	String[] arrayRelation;
	String[] arrayRole;
	ImageButton selall;
	public static String txtid;
	public static String txttitle;
	LinearLayout side_index;
	database db;
	Cursor c;
	Boolean sidepicker = true;
	Boolean searchable = true;
	ListAlphebeticaladapter mArrayadapter;// برای مقداردهی لیست ما
	public static String selvaluefromalphebeticlist;
	public static String selidfromalphebeticlist;
	ArrayAdapter<String> s;
	Map<String, Integer> mapIndex;
	ListView alphebetList;
	AlertDialog alertDialog;
	EditText et_search;
	String[] rownumber;
	String NewArraytitle[];
	String NewArrayId[];
	String NewArrayrownumber[];

	private boolean _doubleBackToExitPressedOnce = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview_alphebatical);
		alertDialog = new AlertDialog.Builder(this).create();
		/**
		 * If we've received a touch notification that the user has touched //
		 * outside the app, DO NOT finish the activity.
		 **/
		this.setFinishOnTouchOutside(false);

		side_index = (LinearLayout) findViewById(R.id.side_index);
		selall = (ImageButton) findViewById(R.id.imgbtn_SelAll);

		et_search = (EditText) findViewById(R.id.et_searchlist);

		// arraytitle va arrayID bayad meghdardehi shavand
		// arraytitle =new String[SelectDomainActivity.domaintitleArray.size()];
		// arrayID =new String[SelectDomainActivity.domaintitleArray.size()];;
		arraytitle = getIntent().getExtras().getStringArray(
				"arrayttitlefromjson");

		arrayID = getIntent().getExtras().getStringArray("arrayidfromjson");

		sidepicker = getIntent().getExtras().getBoolean("side");
		searchable = getIntent().getExtras().getBoolean("search");

		// Toast.makeText(getApplicationContext(), arraytitle.length + "", 1)
		// .show();

		rownumber = new String[arraytitle.length];

		for (int i = 0; i < arraytitle.length; i++) {

			rownumber[i] = Integer.toString(i);
		}

		if (sidepicker == false) {
			side_index.setVisibility(View.GONE);
			selall.setVisibility(View.GONE);
		} else {
			side_index.setVisibility(View.VISIBLE);
			selall.setVisibility(View.VISIBLE);
		}
		if (searchable == false) {
			et_search.setVisibility(View.GONE);
			et_search.setVisibility(View.GONE);
		} else {
			et_search.setVisibility(View.VISIBLE);
			et_search.setVisibility(View.VISIBLE);
		}
		// arraytitle=(String[])
		// SelectDomainActivity.domaintitleArray.toArray(new String
		// [SelectDomainActivity.domaintitleArray.size()]);
		// arrayID=(String[]) SelectDomainActivity.domainidArray.toArray(new
		// String [SelectDomainActivity.domaintitleArray.size()]);
		// for(int i = 0 ; i < SelectDomainActivity.domaintitleArray.size() ;
		// i++ ){
		//
		// arraytitle[i]=SelectDomainActivity.domaintitleArray.get(i);
		//
		// arrayID[i] =SelectDomainActivity.domainidArray.get(i);
		// }

		// ==================================== from db
		// db = new database(this);
		// db.database();
		// db.open();
		// // گرفتن اطلاعات از دیتابیس xml
		// if (frg_customer_forosh.sel == 1) {
		// c = db.GetCustomers();
		// } else if (frg_customer_forosh.sel == 2) {
		// c = db.Getbazar();
		// }
		//
		// arrayID = new String[c.getCount()];
		// arraytitle = new String[c.getCount()];
		//
		// int i = 0;
		//
		// if (c.moveToFirst()) {
		//
		// do {
		//
		// try {
		//
		// arrayID[i] = c.getString(0); // 0 id
		// arraytitle[i] = c.getString(1); // 1 title
		//
		// i++;
		//
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		// }
		//
		// } while (c.moveToNext());
		// }
		//
		// db.close();
		// ===================================================
		// گرفتن اطلاعات از فایل xml
		// String[] customer = getResources().getStringArray(
		// R.array.customer_array);
		et_search.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
//				if (et_search.getText().equals(null)) {
//					mArrayadapter = new ListAlphebeticaladapter(
//							ListViewAlphebeticalActivity.this, arrayID,
//							arraytitle, rownumber, getApplicationContext());
//					alphebetList.setAdapter(mArrayadapter);
//
//				} else {
					for (int i = 0; i < arraytitle.length; i++) {

						if (arraytitle[i].contains((et_search.getText()
								.toString()))) {
							// if
							// (arraytitle[i].equals((et_search.getText().toString())))
							// {

							
							 alphebetList.setSelection(Integer
							 .parseInt((rownumber[i])));

							// Toast.makeText(getApplicationContext(),
							// "rownum= "+i,
							// 1).show();
//							NewArraytitle = new String[arraytitle[i].length()];
//							NewArrayId = new String[arraytitle[i].length()];
//							NewArrayrownumber = new String[arraytitle[i]
//									.length()];
//
//							NewArraytitle[i] = arraytitle[i];
//							NewArrayId[i] = arrayID[i];
//							NewArrayrownumber[i] = rownumber[i];
//
//							// alphebetList.findViewsWithText(null, text, flags)
//
//							mArrayadapter = new ListAlphebeticaladapter(
//									ListViewAlphebeticalActivity.this,
//									NewArrayId, NewArraytitle,
//									NewArrayrownumber, getApplicationContext());
//							alphebetList.setAdapter(mArrayadapter);

						}

					}
//				}
			}

		});

		selall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				selvaluefromalphebeticlist = "همه";
				finish();
			}
		});

		// ایجاد یک ارایه
		Arrays.asList(arraytitle);

		alphebetList = (ListView) findViewById(R.id.list_fruits);

		// alphebetList.setAdapter(new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, customer));

		getIndexList(arraytitle);

		displayIndex();

		mArrayadapter = new ListAlphebeticaladapter(
				ListViewAlphebeticalActivity.this, arrayID, arraytitle,
				rownumber, getApplicationContext());
		alphebetList.setAdapter(mArrayadapter);

		alphebetList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView tvtitle = (TextView) arg1
						.findViewById(R.id.tv_title_alphebetic);
				txttitle = tvtitle.getText().toString();
				TextView tvid = (TextView) arg1
						.findViewById(R.id.tv_id_alohebetic);
				txtid = tvid.getText().toString();
				selvaluefromalphebeticlist = txttitle;
				selidfromalphebeticlist = txtid;
				// Toast.makeText(getApplicationContext(),
				// txtid + "   " + txttitle, 1).show();
				finish();

			}
		});

	}

	// با استفاده از hashmap کلید ها و حروف ها رو به صورت لیست نمایش میدیم
	private void getIndexList(String[] fruits) {
		mapIndex = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < fruits.length; i++) {
			String fruit = fruits[i];
			String index = fruit.substring(0, 1);

			if (mapIndex.get(index) == null)
				mapIndex.put(index, i);
		}
	}

	// نمایش حروف الفبا
	private void displayIndex() {
		LinearLayout indexLayout = (LinearLayout) findViewById(R.id.side_index);

		TextView textView;
		List<String> indexList = new ArrayList<String>(mapIndex.keySet());
		for (String index : indexList) {
			textView = (TextView) getLayoutInflater().inflate(
					R.layout.side_index_item, null);
			textView.setText(index);
			textView.setTextSize(20);
			textView.setOnClickListener(this);
			indexLayout.addView(textView);
		}
	}

	public void onClick(View view) {

		TextView selectedIndex = (TextView) view;
		Toast.makeText(getApplicationContext(), selectedIndex.getText(),
				Toast.LENGTH_LONG).show();

		alphebetList.setSelection(mapIndex.get(selectedIndex.getText()));
	}

	@Override
	public void onBackPressed() {

		// Log.i(TAG, "onBackPressed--");
		if (_doubleBackToExitPressedOnce) {
			super.onBackPressed();

			Intent intent = new Intent(getApplicationContext(),
					MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("EXIT", true);
			startActivity(intent);

			return;
		}

		showdialog("لطفا یک گزینه را انتخاب نمایید");
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				_doubleBackToExitPressedOnce = false;
			}
		}, 2000);
	}

	public void showdialog(String message) {
		this._doubleBackToExitPressedOnce = true;
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setMessage(message);
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);
		alertDialogBuilder.setTitle("خطا");
		alertDialogBuilder.setPositiveButton("تایید",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
					}
				});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}
}
