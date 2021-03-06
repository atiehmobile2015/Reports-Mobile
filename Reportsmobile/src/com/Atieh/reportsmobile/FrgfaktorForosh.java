package com.Atieh.reportsmobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class FrgfaktorForosh extends Fragment {
	public Utils utils = Utils.getInstance();
	ImageButton datefromcustomer;
	ImageButton todateustomer;
	ImageButton selcustomer, selbazar, selForoshande;
	ImageButton btnshow;

	TextView et_fromdate, et_todate, et_customer, et_bazar, et_foroshande;

	int flgbackforResume = 0;
	int intfromdate, inttodate;
	public static int sel = 0;
	String[] St_titleArray, St_idArray, St_personcodeArray;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_forosh_faktor, container,
				false);
		// hideSoftKeyboard(getActivity());

		// =====================ImageButton
		datefromcustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_fromdate_faktor_frosh);
		todateustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_todate_faktor_forosh);
		btnshow = (ImageButton) view
				.findViewById(R.id.imgbtn_namayesh__faktor_forosh);
		selcustomer = (ImageButton) view
				.findViewById(R.id.imgbtn_customer_faktor_forosh);
		selbazar = (ImageButton) view
				.findViewById(R.id.imgbtn_bazaryab_faktor_forosh);
		selForoshande = (ImageButton) view
				.findViewById(R.id.imgbtn_foroshande_faktor_forosh);

		// =================textview

		et_fromdate = (TextView) view.findViewById(R.id.et_fromdate_faktor);
		et_todate = (TextView) view.findViewById(R.id.et_todate_faktor_forosh);
		et_customer = (TextView) view
				.findViewById(R.id.et_customer_faktor_forosh);
		et_bazar = (TextView) view.findViewById(R.id.et_bazarya_faktor_forosh);
		et_foroshande = (TextView) view
				.findViewById(R.id.et_foroshande_faktor_forosh);

		 datefromcustomer.setOnClickListener(new OnClickListener() {
		 @Override
		 public void onClick(View v) {
		 startActivity(new Intent(getActivity(),
		 DatepickerActivity.class));
		 flgbackforResume = 1;
		 // do something
		
		 // final InputMethodManager imm = (InputMethodManager)
		 // getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
		 // imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
		
		 }
		 });
		todateustomer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),
						DatepickerActivity.class));
				flgbackforResume = 2;

			}
		});
		selcustomer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sel = 1;
				// startActivity(new Intent(getActivity(),
				// ListViewAlphebeticalActivity.class));

				St_titleArray = (String[]) HomeActivity.mostarititleArray
						.toArray(new String[HomeActivity.mostarititleArray
								.size()]);
				St_idArray = (String[]) HomeActivity.moshtariidArray
						.toArray(new String[HomeActivity.moshtariidArray.size()]);
				St_personcodeArray = (String[]) HomeActivity.mostaripersoncodeArray
						.toArray(new String[HomeActivity.mostaripersoncodeArray
								.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_titleArray);
				intent.putExtra("arrayidfromjson", St_idArray);
			intent.putExtra("side", true);intent.putExtra("search", true);

				startActivity(intent);

				flgbackforResume = 3;

			}
		});
		selbazar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sel = 2;
				St_titleArray = (String[]) HomeActivity.bazaryabtitleArray
						.toArray(new String[HomeActivity.bazaryabtitleArray
								.size()]);
				St_idArray = (String[]) HomeActivity.bazaryabidArray
						.toArray(new String[HomeActivity.bazaryabidArray.size()]);
				St_personcodeArray = (String[]) HomeActivity.bazaryabpersoncodeArray
						.toArray(new String[HomeActivity.bazaryabpersoncodeArray
								.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_titleArray);
				intent.putExtra("arrayidfromjson", St_idArray);
			intent.putExtra("side", true);intent.putExtra("search", true);
				startActivity(intent);

				flgbackforResume = 4;

			}
		});
		selForoshande.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// sel = 4;

				St_titleArray = (String[]) HomeActivity.sellertitleArray
						.toArray(new String[HomeActivity.sellertitleArray
								.size()]);
				St_idArray = (String[]) HomeActivity.selleridArray
						.toArray(new String[HomeActivity.selleridArray.size()]);
				St_personcodeArray = (String[]) HomeActivity.sellerpersoncodeArray
						.toArray(new String[HomeActivity.sellerpersoncodeArray
								.size()]);

				Intent intent = new Intent();
				intent.setClass(getActivity(),
						ListViewAlphebeticalActivity.class);
				intent.putExtra("arrayttitlefromjson", St_titleArray);
				intent.putExtra("arrayidfromjson", St_idArray);
			intent.putExtra("side", true);intent.putExtra("search", true);
				startActivity(intent);

				flgbackforResume = 5;

			}
		});

		btnshow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final InputMethodManager imm = (InputMethodManager) getActivity()
						.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(arg0.getWindowToken(), 0);
				if (et_fromdate.getText().equals("")) {
					showMessage("لطفا تاریخ ابتدا را وارد نمایید");
				} else if (et_todate.getText().equals("")) {
					showMessage("لطفا تاریخ انتها را وارد نمایید");
				} else if (et_customer.getText().equals("")) {
					showMessage("لطفا مشتری  را وارد نمایید");
				} else if (et_bazar.getText().equals("")) {
					showMessage("لطفا  بازاریاب  را وارد نمایید");
				} else if (et_foroshande.getText().equals("")) {
					showMessage("لطفا  فروشنده را وارد نمایید");
				} else {
					if (checkdate(intfromdate, inttodate) == 0) {
						Intent report = new Intent();
						report.putExtra("gozaresh", "customer");
						report.setClass(getActivity(),
								ShowreportsActivity.class);
						startActivity(report);
					} else if (checkdate(intfromdate, inttodate) == 1) {
						showMessage("تاریخ انتها کوچکتر از تاریخ ابتدا می باشد");
					} else if (checkdate(intfromdate, inttodate) == 2) {
						showMessage("تاریخ ابتدا و انتها برابر است");
					}

				}
			}
		});

		return view;
	}

	private void showMessage(String message) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());
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

	public int checkdate(int fromdate, int todate) {
		int flgcheck = 0;
		if (todate - fromdate > 0) {
			flgcheck = 0;
			// "halate dorost hamine
		} else if (todate - fromdate < 0) {
			flgcheck = 1;
			// "tarikhe dovom kochaktarast"

		} else if (todate - fromdate == 0) {
			flgcheck = 2;
			// "tarikhe aval va dovom barabar"

		}
		return flgcheck;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		if (flgbackforResume == 1) {
			intfromdate = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);

			et_fromdate.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);

		} else if (flgbackforResume == 2) {
			inttodate = Integer.parseInt(DatepickerActivity.myDay
					+ DatepickerActivity.myMonth + DatepickerActivity.myYear);
			et_todate.setText(DatepickerActivity.myDay + "/"
					+ DatepickerActivity.myMonth + "/"
					+ DatepickerActivity.myYear);
		}

		else if (flgbackforResume == 3) {
			et_customer
					.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		} else if (flgbackforResume == 4) {
			et_bazar.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		} else if (flgbackforResume == 5) {
			et_foroshande
					.setText(ListViewAlphebeticalActivity.selvaluefromalphebeticlist);
		}

		// Toast.makeText(getActivity(), "1", 1).show();
	}

	public static void hideSoftKeyboard(Activity activity) {
		InputMethodManager inputMethodManager = (InputMethodManager) activity
				.getSystemService(Activity.INPUT_METHOD_SERVICE);
		inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus()
				.getWindowToken(), 0);
	}
}
