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

    }

    @Override
    public int getMenu() {
        return R.menu.main;
    }

    @Override
    public Fragment getFragment(MenuItem item) {
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
        }else if (item.getItemId() == R.id.f) {
            return BlankFragment.newInstance("F", "");
        }else if (item.getItemId() == R.id.g) {
            return BlankFragment.newInstance("G", "");
        }else{
            return null;
        }
    }
}
