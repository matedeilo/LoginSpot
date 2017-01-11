package com.mate.registerspotify;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.img_intro_gif)
    ImageView introImageView;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.radio_group_dots)
    RadioGroup radioGroupDots;

    @BindView(R.id.button_register)
    Button buttonRegister;

    Timer timer;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        Glide.with(this)
                .load(R.drawable.intro_animation)
                .asGif()
                .into(introImageView);

        viewPager.setAdapter(new SimpleViewPagerAdapter(this));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                radioGroupDots.check(radioGroupDots.getChildAt(position).getId());
                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        setupDotsLayout();
        pageSwitcher(5);
    }

    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
        // in
        // milliseconds
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 3) { // In my case the number of pages are 5
//                        timer.cancel();
                        page = 0;
                    }
                    viewPager.setCurrentItem(page++);
                }
            });

        }
    }

    @OnClick(R.id.button_register) void callRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        this.startActivity(intent);
    }

}
