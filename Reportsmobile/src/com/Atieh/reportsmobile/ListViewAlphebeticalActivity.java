package com.Atieh.reportsmobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import customlistadapter.ListAlphebeticaladapter;

import dataBase.database;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewAlphebeticalActivity extends Activity implements
		OnClickListener {

	TextView tv_title;
	ListView lv_person;
	String[] arrayID;
	String[] arraytitle;
	String[] arrayRelation;
	String[] arrayRole;
	String txtid;
	String txttitle;
	database db;
	Cursor c;
	ListAlphebeticaladapter as2;
	public static String selvaluefromalphebeticlist;
	Map<String, Integer> mapIndex;
	ListView alphebetList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview_alphebatical);

		db = new database(this);
		db.database();
		db.open();
		// گرفتن اطلاعات از دیتابیس xml
		if (frg_customer_forosh.sel == 1) {
			 c = db.GetCustomers();
		} else if (frg_customer_forosh.sel == 2) {
			  c = db.Getbazar();
		}

		arrayID = new String[c.getCount()];
		arraytitle = new String[c.getCount()];

		int i = 0;

		if (c.moveToFirst()) {

			do {

				try {

					arrayID[i] = c.getString(0); // 0 id
					arraytitle[i] = c.getString(1); // 1 title

					i++;

				} catch (Exception e) {

					e.printStackTrace();
				}

			} while (c.moveToNext());
		}

		db.close();

		// گرفتن اطلاعات از فایل xml
		// String[] customer = getResources().getStringArray(
		// R.array.customer_array);

		// ایجاد یک ارایه
		Arrays.asList(arraytitle);

		alphebetList = (ListView) findViewById(R.id.list_fruits);

		// alphebetList.setAdapter(new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, customer));

		getIndexList(arraytitle);

		displayIndex();

		as2 = new ListAlphebeticaladapter(ListViewAlphebeticalActivity.this,
				arrayID, arraytitle, getApplicationContext());
		alphebetList.setAdapter(as2);

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
				Toast.makeText(getApplicationContext(),
						txtid + "   " + txttitle, 1).show();
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
		Toast.makeText(getApplicationContext(), selectedIndex.getText(), 1)
				.show();

		alphebetList.setSelection(mapIndex.get(selectedIndex.getText()));
	}
}