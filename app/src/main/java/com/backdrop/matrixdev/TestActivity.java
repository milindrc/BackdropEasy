package com.backdrop.matrixdev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.backdropeasy.matrixdev.BackdropListActivity;
import com.backdropeasy.matrixdev.BlankFragment;

public class TestActivity extends BackdropListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarSearchEnabled(true);
    }

    @Override
    public int getMenu() {
        return R.menu.main;
    }


    @Override
    public Fragment getFragment(MenuItem item) {
        switch (item.getItemId()){
            case R.id.a: getBinding().headerTitle.setText("Category A"); return BlankFragment.newInstance("A","");
            case R.id.b: getBinding().headerTitle.setText("Category B"); return BlankFragment.newInstance("B", "");
            case R.id.c: getBinding().headerTitle.setText("Category C"); return BlankFragment.newInstance("C", "");
            case R.id.d: getBinding().headerTitle.setText("Category D"); return BlankFragment.newInstance("D", "");
            case R.id.e: getBinding().headerTitle.setText("Category E"); return BlankFragment.newInstance("E", "");
            case R.id.f: getBinding().headerTitle.setText("Category F"); return BlankFragment.newInstance("F", "");
            case R.id.g: getBinding().headerTitle.setText("Category G"); return BlankFragment.newInstance("G", "");
            default: return null;
        }
    }


}
