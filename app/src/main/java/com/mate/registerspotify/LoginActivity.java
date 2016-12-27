package com.mate.registerspotify;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.img_intro_gif)
    ImageView introImageView;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.radio_group_dots)
    RadioGroup radioGroupDots;

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
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        setupDotsLayout();
    }

    private void setupDotsLayout(){
        for (int i = 0; i < 4; i++){
            RadioButton rb = new RadioButton(this);
            rb.setLayoutParams(new FrameLayout.LayoutParams(10,10));
            rb.setBackground(ContextCompat.getDrawable(this, R.drawable.intro_button_selector));
            rb.setButtonDrawable(null);
            radioGroupDots.addView(rb);
        }
    }
}
