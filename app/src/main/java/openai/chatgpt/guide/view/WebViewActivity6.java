package openai.chatgpt.guide.view;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.lang.reflect.Method;

public class WebViewActivity6 extends AppCompatActivity {
	boolean pageLoaded = false;
	EditText edit;
	WebView wb;
	private AdView mAdView;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewlayout);
		mAdView = (AdView) findViewById(R.id.adView1);
		AdRequest adRequest = new AdRequest.Builder()
				.build();
		mAdView.loadAd(adRequest);
		if (Utils.isNetworkAvailable(WebViewActivity6.this)) {

//			showAds();

		} else {
			LinearLayout layoutid = (LinearLayout) findViewById(R.id.adView);

			layoutid.setVisibility(View.GONE);

		}

		//String fileName = getIntent().getExtras().getString("url");
		wb = (WebView) findViewById(R.id.webView1);
		wb.getSettings().setJavaScriptEnabled(true);

		wb.setWebViewClient(new WebViewClient() {

			public void onPageFinished(WebView view, String url) {
				pageLoaded = true;
			}

		});
		try {
			Method m = WebView.class.getMethod("setFindIsUp", Boolean.TYPE);
			m.invoke(wb, true);
		} catch (Throwable ignored) {
		}
		/*edit = (EditText) findViewById(R.id.search);

		edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {

			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				// TODO Auto-generated method stub
				search(null);
				return true;
			}
		});*/

		wb.getSettings().setBuiltInZoomControls(true);
		wb.getSettings().setLoadsImagesAutomatically(true);
		/*String folderPath = "file:android_asset/";
		Toast.makeText(getApplicationContext(), "here " + folderPath, Toast.LENGTH_SHORT).show();*/
		wb.loadUrl("file:///android_asset/tangle/Limitations.html");

	}

	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		wb = null;
		edit = null;
		if (mAdView != null) {
			mAdView.destroy();
		}
	}

	public void search(View v) {
		if (pageLoaded) {
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD)
				wb.findAllAsync(edit.getText().toString());
			else
				wb.findAll(edit.getText().toString());
		}

	}
	public static class Utils {

		public static boolean isNetworkAvailable(Activity activity) {
			ConnectivityManager connectivity = (ConnectivityManager) activity
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity == null) {
				return false;
			} else {
				NetworkInfo[] info = connectivity.getAllNetworkInfo();
				if (info != null) {
					for (int i = 0; i < info.length; i++) {
						if (info[i].getState() == NetworkInfo.State.CONNECTED) {
							return true;
						}
					}
				}
			}
			return false;
		}
	}
	@Override
	public void onPause() {
		if (mAdView != null) {
			mAdView.pause();
		}
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		if (mAdView != null) {
			mAdView.resume();
		}
	}
}
