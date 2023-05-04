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

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.lang.reflect.Method;

public class WebViewActivity extends AppCompatActivity {
	boolean pageLoaded = false;
	EditText edit;
	WebView wb;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewlayout);
		MobileAds.initialize(this, new OnInitializationCompleteListener() {
			@Override
			public void onInitializationComplete(InitializationStatus initializationStatus) {
				//  Toast.makeText(this, " successful ", Toast.LENGTH_SHORT).show();
			}
		});

		AdView mAdView;
		mAdView = findViewById(R.id.adView1);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
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
		wb.loadUrl("file:///android_asset/tangle/History.html");

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
}
