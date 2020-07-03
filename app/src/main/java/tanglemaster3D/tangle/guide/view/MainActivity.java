package tanglemaster3D.tangle.guide.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import tanglemaster3D.tangle.guide.R;
import tanglemaster3D.tangle.guide.databinding.ActivityMainBinding;
import tanglemaster3D.tangle.guide.model.Post;
import tanglemaster3D.tangle.guide.model.User;
import tanglemaster3D.tangle.guide.utils.GridSpacingItemDecoration;

public class MainActivity extends Admob implements PostsAdapter.PostsAdapterListener  {


    private MyClickHandlers handlers;
    private PostsAdapter mAdapter;
    private RecyclerView recyclerView;
    private ActivityMainBinding binding;
    private User user;
    private ImageView imageView;
    public ImageView imgClick;

    // This is an ad unit ID for a test ad. Replace with your own banner ad unit ID.
  //  private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/9214589741";
    //Original
    private static final String AD_UNIT_ID = "ca-app-pub-9916013140756269/2810055735";
    private FrameLayout adContainerView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        startGame();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adContainerView = findViewById(R.id.ad_view_container);

        adContainerView.post(new Runnable() {
            @Override
            public void run() {
                loadBanner();
            }
        });

        handlers = new MyClickHandlers(this);

        initRecyclerView();

        renderProfile();
        imgClick = (ImageView)findViewById(R.id.playprotect);


        imgClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.protect.guide")));

            }
        });
    }

    /**
     * Renders RecyclerView with Grid Images in 3 columns
     */
    private void initRecyclerView() {
        recyclerView = binding.content.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        mAdapter = new PostsAdapter(getPosts(), this);
        recyclerView.setAdapter(mAdapter);
    }

    /**
     * Renders user profile data
     */
    private void renderProfile() {
        user = new User();
        user.setName("Fresh Air Apps");
        user.setEmail("david@natgeo.com");
        user.setProfileImage("https://thinnaikathai.com/apps/tangle/profile.jpg");
        user.setAbout("Presents");


        // ObservableField doesn't have setter method, instead
        // be called using set() method
        user.numberOfPosts.set(3400L);
        user.numberOfFollowers.set(3050890L);
        user.numberOfFollowing.set(150L);


        // display user
        binding.setUser(user);

        // assign click handlers
        binding.content.setHandlers(handlers);
    }

    private ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            Post post = new Post();
            post.setImageUrl("https://thinnaikathai.com/apps/tangle/" + i + ".jpg");
            posts.add(post);

        }

        return posts;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onPostClicked(Post post) {

        String url= post.getImageUrl();
            if (Objects.equals(url, "https://thinnaikathai.com/apps/tangle/1.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                startActivity(intent);
                showInterstitial();
            }
            else if (Objects.equals(url, "https://thinnaikathai.com/apps/tangle/2.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity2.class);
                startActivity(intent);
                showInterstitial();
            }

            else if (Objects.equals(url, "https://thinnaikathai.com/apps/tangle/3.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity3.class);
                startActivity(intent);
                showInterstitial();
            }
            else if (Objects.equals(url, "https://thinnaikathai.com/apps/tangle/4.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity4.class);
                startActivity(intent);
                showInterstitial();
            }
            else if (Objects.equals(url, "https://thinnaikathai.com/apps/tangle/5.jpg"))
            {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +getPackageName())));
            }
            else if (Objects.equals(url, "https://thinnaikathai.com/apps/tangle/6.jpg"))
            {
                Intent intent = new Intent(this, Support.class);
                startActivity(intent);
                showInterstitial();
            }
    }


    public class MyClickHandlers {

        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        /**
         * Demonstrating updating bind data
         * Profile name, number of posts and profile image
         * will be updated on Fab click
         */
        public void onProfileFabClicked(View view) {
            user.setName("Sir David Attenborough");
            user.setProfileImage("https://api.androidhive.info/images/nature/david1.jpg");

            // updating ObservableField
            user.numberOfPosts.set(5500L);
            user.numberOfFollowers.set(5050890L);
            user.numberOfFollowing.set(180L);
        }

        public boolean onProfileImageLongPressed(View view) {
            Toast.makeText(getApplicationContext(), "Profile image long pressed!", Toast.LENGTH_LONG).show();
            return false;
        }


        public void onFollowersClicked(View view) {
            Toast.makeText(context, "Followers is clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onFollowingClicked(View view) {
            Toast.makeText(context, "Following is clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onPostsClicked(View view) {
           // Toast.makeText(context, "Posts is clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    void loadBanner() {
        // Create an ad request.
        adView = new AdView(this);
        adView.setAdUnitId(AD_UNIT_ID);
        adContainerView.removeAllViews();
        adContainerView.addView(adView);

        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);

        AdRequest adRequest = new AdRequest.Builder().build();

        // Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        // Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = outMetrics.density;

        float adWidthPixels = adContainerView.getWidth();

        // If the ad hasn't been laid out, default to the full screen width.
        if (adWidthPixels == 0) {
            adWidthPixels = outMetrics.widthPixels;
        }

        int adWidth = (int) (adWidthPixels / density);

        return AdSize.getCurrentOrientationBannerAdSizeWithWidth(this, adWidth);
    }
}
