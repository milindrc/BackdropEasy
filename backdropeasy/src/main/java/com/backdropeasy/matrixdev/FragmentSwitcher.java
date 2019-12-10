package com.backdropeasy.matrixdev;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentSwitcher {

    FragmentManager fragmentManager;
    Activity activity;

    public FragmentSwitcher(FragmentManager fragmentManager, Activity activity) {
        this.fragmentManager = fragmentManager;
        this.activity = activity;
    }

    public void changeFragment(Fragment fragment){
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.contentLayout,fragment,fragment.getClass().getName());
//        ft.addToBackStack(fragment.getClass().getName());
        ft.commitAllowingStateLoss();
    }
}
