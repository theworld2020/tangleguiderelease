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

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import tanglemaster3D.tangle.guide.R;
import tanglemaster3D.tangle.guide.databinding.ActivityMainBinding;
import tanglemaster3D.tangle.guide.model.Post;
import tanglemaster3D.tangle.guide.model.User;
import tanglemaster3D.tangle.guide.utils.GridSpacingItemDecoration;

public class MainActivity extends AppCompatActivity implements PostsAdapter.PostsAdapterListener  {


    private MyClickHandlers handlers;
    private PostsAdapter mAdapter;
    private RecyclerView recyclerView;
    private ActivityMainBinding binding;
    private User user;
    private ImageView imageView;
    public ImageView imgClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
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
        //user.setProfileImage("file:///android_assets/tangle/profile.jpg");
        user.setProfileImage("https://i.postimg.cc/63zp9SVB/profile.png");
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
        for (int i = 0; i < 7; i++) {
            Post post = new Post();
            if (i == 1) {
                post.setImageUrl("https://i.postimg.cc/Z0kdt2FV/history.jpg");
                posts.add(post);
            }
            if (i == 2) {
                post.setImageUrl("https://i.postimg.cc/7hjgPfD1/how.jpg");
                posts.add(post);
            }
            if (i == 3) {
                post.setImageUrl("https://i.postimg.cc/QM6SGNBm/why.jpg");
                posts.add(post);
            }
            if (i == 4) {
                post.setImageUrl("https://i.postimg.cc/nhbv6j3p/feature.jpg");
                posts.add(post);
            }
            if (i == 5) {
                post.setImageUrl("https://i.postimg.cc/SRYMPk8n/future.jpg");
                posts.add(post);
            }
            if(i==6) {
                post.setImageUrl("https://i.postimg.cc/Gp3z5Tp9/limit.jpg");
                posts.add(post);
            }
        }
        return posts;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onPostClicked(Post post) {

        String url= post.getImageUrl();
            if (Objects.equals(url, "https://i.postimg.cc/Z0kdt2FV/history.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                startActivity(intent);
            }
            else if (Objects.equals(url, "https://i.postimg.cc/7hjgPfD1/how.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity2.class);
                startActivity(intent);
            }

            else if (Objects.equals(url, "https://i.postimg.cc/QM6SGNBm/why.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity3.class);
                startActivity(intent);
            }
            else if (Objects.equals(url, "https://i.postimg.cc/nhbv6j3p/feature.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity4.class);
                startActivity(intent);
            }
            else if (Objects.equals(url, "https://i.postimg.cc/SRYMPk8n/future.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity5.class);
                startActivity(intent);
              //  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +getPackageName())));
            }
            else if (Objects.equals(url, "https://i.postimg.cc/Gp3z5Tp9/limit.jpg"))
            {
                Intent intent = new Intent(this, WebViewActivity6.class);
                //Intent intent = new Intent(this, Support.class);
                startActivity(intent);
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

}
