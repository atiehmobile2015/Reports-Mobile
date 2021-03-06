package com.Atieh.reportsmobile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ShowreportsActivity extends Activity {
	public Utils utils = Utils.getInstance();
	private WebView webview;
	private static final String TAG = "Main";
	private ProgressDialog progressBar1;
	private ProgressDialog progressBar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_showreports);

		this.webview = (WebView) findViewById(R.id.wv_showresult);

		WebSettings settings = webview.getSettings();
		settings.setJavaScriptEnabled(true);
		webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

		webview.getSettings().setBuiltInZoomControls(true);
		progressBar1 = ProgressDialog.show(ShowreportsActivity.this,
				".....گزارش در حال بارگزاری می باشد", "لطفا منتظر باشید...");

		webview.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				Log.i(TAG, "Processing webview url click...");
				view.loadUrl(url);
				return true;
			}

			public void onPageFinished(WebView view, String url) {
				Log.i(TAG, "Finished loading URL: " + url);
				if (progressBar1.isShowing()) {
					progressBar1.dismiss();
				}
			}

		});

		asyncTask as = new asyncTask(); // checking network

		as.execute("P");

		if (progressBar.isShowing()) {
			progressBar.dismiss();
		}

	}// on create

	public int netStatus(String url) {

		int resCode;
		if (isNetworkAvailable()) {

			HttpGet httpRequest = null;
			try {
				httpRequest = new HttpGet(new URI(url));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response = null;

			try {
				response = httpclient.execute(httpRequest);

			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			resCode = response.getStatusLine().getStatusCode();
		}

		else {
			resCode = 1000; // our code for no network connected or connecting
		}

		return resCode;
	}

	public String httpRequestMessage(int responseCode) {
		String message = "";
		switch (responseCode) {
		case 200:
			message = "";
			break;
		case 401:
			message = "عدم دسترسی لازم جهت اتصال به سرور";
			break;
		case 503:
			message = "پاسخی از سرور دریافت نشد لطفا در زمانی دیگر تلاش نمایید";
			break;
		case 400:
			message = "خطا در برقرای ارتباط. لطفا مجددا تلاش نمایید";
			break;

		case 404:
			message = "وب سایت پذیرنده در دسترس نمی باشد. لطفا در زمانی دیگر تلاش نمایید.";
			break;

		case 403:
			message = "دسترسی غیر مجاز.";
			break;
		case 1000: // our code for no network connected or connecting
			message = "لطفا از روشن بودن دیتای موبایل و یا وایرلس خود و اتصال به اینترنت اطمینان حاصل نمایید.";
			break;

		default:
			message = "خطای ناشناخته شماره :" + Integer.toString(responseCode)
					+ " مجددا تلاش نمایید ";
		}

		return message;
	}

	private boolean isNetworkAvailable() {

		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		} else {
			return false;
		}

	}

	public class asyncTask extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {

			progressBar = ProgressDialog.show(ShowreportsActivity.this,
					".گزارش در حال بارگزاری می باشد", " ،لطفا منتظر باشید...");

		}

		@Override
		protected String doInBackground(String... arg0) {

			return httpRequestMessage(netStatus("http://atiehpardaz.com/default.aspx?lng=fa"));
		}

		@Override
		protected void onPostExecute(String result) {

			if (progressBar.isShowing()) {
				progressBar.dismiss();
			}
			if (result != "") {
				webview.loadUrl("file:///android_asset/myerrorpage.html");
				showdialog(result);
			} else {
				// Toast.makeText(ShowreportsActivity.this,
				// "عملیات با موفقیت در حال انجام است ،لطفا منتظر بمانید ....",
				// Toast.LENGTH_SHORT).show();

				// forosh tabs
				if (getIntent().getStringExtra("gozaresh").equals(
						"faktoreforosh")) {

					setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

					webview.loadUrl("http://demo.atiehpardaz.com/reports/CustomerByInvoice.aspx");
				} else if (getIntent().getStringExtra("gozaresh").equals(
						"customer")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/Report.aspx");
				} else if (getIntent().getStringExtra("gozaresh").equals(
						"kalaforokhte")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/SaleInvoice/SaleInvoice.aspx");
				}// hesabdari tabs
				else if (getIntent().getStringExtra("gozaresh").equals(
						"gardeshhesabdari")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/Accounting/AccountingTafsil.aspx");
				} else if (getIntent().getStringExtra("gozaresh").equals(
						"tarkibihesabdari")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/Accounting/AccountingTwoTafsil.aspx");
				}// khazane tabs
				else if (getIntent().getStringExtra("gozaresh").equals(
						"daryaftikhazane")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/Document/GetDocument.aspx");
				} else if (getIntent().getStringExtra("gozaresh").equals(
						"pardakhtikhazane")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/Document/PayDocument.aspx");
				} else if (getIntent().getStringExtra("gozaresh").equals(
						"vaziatdaryafti")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/Document/GetDocumentStatus.aspx");
				} else if (getIntent().getStringExtra("gozaresh").equals(
						"vaziatpardakhti")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/Document/PayDocumentStatus.aspx");
				}// kala va anbar tabs
				else if (getIntent().getStringExtra("gozaresh").equals(
						"rialianbar")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/WareHouse/WareHouseRials.aspx");
				} else if (getIntent().getStringExtra("gozaresh").equals(
						"rialianbartajmiiy")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/WareHouse/WareHouseAgreagateRials.aspx");
				} else if (getIntent().getStringExtra("gozaresh").equals(
						"mojodikala")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/WareHouse/WareHouse.aspx");
				} else if (getIntent().getStringExtra("gozaresh").equals(
						"mojodikalatajmiiy")) {
					webview.loadUrl("http://demo.atiehpardaz.com/reports/WareHouse/WareHouseAgreagate.aspx");
				}

			}
		}
	}

	public void showdialog(String message) {
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