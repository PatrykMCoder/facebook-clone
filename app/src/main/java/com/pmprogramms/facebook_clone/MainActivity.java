package com.pmprogramms.facebook_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;;import com.google.android.material.tabs.TabLayout;
import com.pmprogramms.facebook_clone.fragments.FriendsFragment;
import com.pmprogramms.facebook_clone.fragments.HomePageFragment;
import com.pmprogramms.facebook_clone.fragments.MenuFragment;
import com.pmprogramms.facebook_clone.fragments.NotificationFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private View view; // for included view
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private final int[] icons = {
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_people_24,
            R.drawable.ic_baseline_notifications_24,
            R.drawable.ic_baseline_menu_24
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.included_app_bar);
        toolbar = view.findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab_layout);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++)
            tabLayout.getTabAt(i).setIcon(icons[i]);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            if (position == 0)
                fragment = new HomePageFragment();
            else if (position == 1)
                fragment = new FriendsFragment();
            else if (position == 2)
                fragment = new NotificationFragment();
            else
                fragment = new MenuFragment();

            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}