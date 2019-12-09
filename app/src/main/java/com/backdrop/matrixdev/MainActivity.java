package com.backdrop.matrixdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior<LinearLayout> sheetBehavior;
    private View backLayout;
    private NavigationView navView;
    private AppBarLayout appbar;
    private Toolbar toolbar;
    private ImageView menuButton;
    private boolean isOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appbar = findViewById(R.id.appbar);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navView = findViewById(R.id.navigation_view);
        backLayout = findViewById(R.id.back_layout);
        View filterIcon = findViewById(R.id.filterIcon);
        menuButton = (ImageView)findViewById(R.id.menu_button);
        LinearLayout contentLayout = findViewById(R.id.contentLayout);

        sheetBehavior = BottomSheetBehavior.from(contentLayout);
        sheetBehavior.setFitToContents(false);
        sheetBehavior.setHideable(false);//prevents the boottom sheet from completely hiding off the screen
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);//initially state to fully expanded

        filterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFilters();
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(menuButton, "rotation", isOpened?360f:0f, isOpened?0f:360f).setDuration(400).start();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (isOpened){
                            menuButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_menu_grey_700_24dp));
                            isOpened = false;
                        } else {
                            menuButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_close_grey_700_24dp));
                            isOpened = true;
                        }
                    }
                }, 200);
                toggleFilters();
            }
        });

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                return false;
            }
        });

        Intent intent = new Intent(this,TestActivity.class);
        startActivity(intent);
    }


    private void toggleFilters(){
        int newHeight = getWindow().getDecorView().getHeight() - backLayout.getHeight();
        Log.d("-----",""+getWindow().getDecorView().getHeight());
        Log.d("-----",""+backLayout.getHeight());
        Log.d("-----",""+newHeight);
        sheetBehavior.setPeekHeight(backLayout.getHeight()-navView.getHeight());
        if(sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
        else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}
