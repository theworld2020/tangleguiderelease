package tanglemaster3D.tangle.guide.view;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class Admob extends Activity {
    //private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";
    private static final String AD_UNIT_ID = "ca-app-pub-9916013140756269/4821975556";

    private InterstitialAd interstitialAd;
    private boolean gameIsInProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        // Create the InterstitialAd and set the adUnitId.
        interstitialAd = new InterstitialAd(this);
        // Defined in res/values/strings.xml
        interstitialAd.setAdUnitId(AD_UNIT_ID);
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
              //  Toast.makeText(Admob.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAdFailedToLoad(int errorCode) {
                //Toast.makeText(Admob.this, "onAdFailedToLoad() with error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAdClosed() {
                startGame();
            }
        });
    }
    @Override
    public void onResume() {
        // Start or resume the game.
        super.onResume();
    }
    @Override
    public void onPause() {
        // Cancel the timer if the game is paused.
      //  countDownTimer.cancel();
        super.onPause();
    }
    protected void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
          //  Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
            startGame();
        }
    }
    protected void startGame() {
        // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
        if (!interstitialAd.isLoading() && !interstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest);
        }
    }
    private void resumeGame(long milliseconds) {

        gameIsInProgress = true;
    }
   }