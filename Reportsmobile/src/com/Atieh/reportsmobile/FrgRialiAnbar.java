package com.Atieh.reportsmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class FrgRialiAnbar extends Fragment {

	ImageButton datefromcustomer;
	EditText fromdate;
int a=0;
	

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedinstancState) {
		View view = inflater.inflate(R.layout.frg_kala_riali, container,
				false);
//		datefromcustomer = (ImageButton) view
//				.findViewById(R.id.imgbtn_fromdatecustomer_frosh_);
//
//		fromdate=(EditText) view.findViewById(R.id.et_fromdate_forosh);
//		datefromcustomer.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				startActivity(new Intent(getActivity(),
//						DatepickerActivity.class));
//				a=1;
//				// do something
//
//			}
//		});

		return view;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		
//		if(a==1){
//			fromdate.setText(DatepickerActivity.myDay+"/"+DatepickerActivity.myMonth+"/"+DatepickerActivity.myYear);
//		}
		
		
//		Toast.makeText(getActivity(), "1", 1).show();
	}

}
