package com.backdropeasy.matrixdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.backdropeasy.matrixdev.databinding.ActivityBackdropListBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;

public class BackdropListActivity extends AppCompatActivity {

    private ActivityBackdropListBinding binding;
    private BottomSheetBehavior<LinearLayout> sheetBehavior;
    private boolean isOpened = false;
    private FragmentSwitcher fragmentSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setTheme(R.style.LibTheme);
        binding = (ActivityBackdropListBinding) DataBindingUtil.setContentView(this, R.layout.activity_backdrop_list);

        initUI();
    }

    private void initUI() {
        setSupportActionBar(binding.toolbar);

        setStatusBarColor(getResources().getColor(R.color.back_layer_color));

        fragmentSwitcher = new FragmentSwitcher(getSupportFragmentManager(),this);

        sheetBehavior = BottomSheetBehavior.from(binding.contentLayout);
        sheetBehavior.setFitToContents(false);
        sheetBehavior.setHideable(false);//prevents the boottom sheet from completely hiding off the screen
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);//initially state to fully expanded

        binding.navigationView.inflateMenu(getMenu());
        setInitialItem();


        setListeners();
    }

    private void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(color);
        }
    }

    private void setInitialItem() {
        MenuItem firstItem = binding.navigationView.getMenu().getItem(0);
        binding.toolbarTitle.setText(firstItem.getTitle());
        binding.navigationView.setCheckedItem(firstItem.getItemId());
        fragmentSwitcher.changeFragment(getFragment(firstItem));
    }

    private void setListeners() {
        binding.filterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSheet();
            }
        });

        binding.menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSheet();
            }
        });

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                fragmentSwitcher.changeFragment(getFragment(menuItem));
                binding.toolbarTitle.setText(menuItem.getTitle());
                menuItem.setChecked(true);
                toggleSheet();
                return false;
            }
        });

    }

    private void toggleSheet() {
        ObjectAnimator.ofFloat(binding.menuButton, "rotation", isOpened ? 360f : 0f, isOpened ? 0f : 360f).setDuration(400).start();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isOpened) {
                    binding.menuButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_menu_grey_700_24dp));
                    binding.filterIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more_black_24dp));
                    isOpened = false;
                } else {
                    binding.menuButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_close_grey_700_24dp));
                    binding.filterIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less_black_24dp));
                    isOpened = true;
                }
            }
        }, 200);


        int newHeight = getWindow().getDecorView().getHeight() - binding.backLayout.getHeight();
        Log.d("-----", "" + getWindow().getDecorView().getHeight());
        Log.d("-----", "" + binding.backLayout.getHeight());
        Log.d("-----", "" + newHeight);
        sheetBehavior.setPeekHeight(binding.backLayout.getHeight() - binding.navigationView.getHeight());
        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    public ActivityBackdropListBinding getBinding(){
        return binding;
    }

    public int getMenu() {
        return R.menu.backdrop_menu;
    }

    public Fragment getFragment(MenuItem item){
        if (item.getItemId() == R.id.a) {
            return BlankFragment.newInstance("A", "");
        }else if (item.getItemId() == R.id.b) {
            return BlankFragment.newInstance("B", "");
        }else if (item.getItemId() == R.id.c) {
            return BlankFragment.newInstance("C", "");
        }else if (item.getItemId() == R.id.d) {
            return BlankFragment.newInstance("D", "");
        }else if (item.getItemId() == R.id.e) {
            return BlankFragment.newInstance("E", "");
        }else{
            return null;
        }
    }

}
