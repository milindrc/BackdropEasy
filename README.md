[![](https://jitpack.io/v/milindrc/BackdropEasy.svg)](https://jitpack.io/#milindrc/BackdropEasy)

# BackdropEasy
A simple implementation of material design backdrop.


Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.milindrc:BackdropEasy:v0.1'
	}

# Usage

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

Menu example: 

	<?xml version="1.0" encoding="utf-8"?>
	<menu xmlns:android="http://schemas.android.com/apk/res/android">


	    <group
		android:id="@+id/group"
		android:checkableBehavior="single"
		>
		<item
		    android:checkable="true"
		    android:id="@+id/a"
		    android:title="A" />
		<item
		    android:checkable="true"
		    android:id="@+id/b"
		    android:title="B" />
		<item
		    android:id="@+id/c"
		    android:checkable="true"
		    android:title="C" />
		<item
		    android:id="@+id/d"
		    android:checkable="true"
		    android:title="D" />
		<item
		    android:checkable="true"
		    android:id="@+id/e"
		    android:title="E" />
	    </group>

	</menu>
	
# Styling

For styling add these to your theme

    <color name="back_layer_color">#4527A0</color>
    <color name="front_layer_color">#ffffff</color>
    
# Click Control

For custom action on item click and preventing frament change refer this example
   
   
   `//ovveride this function in your activity`
    
    public boolean onClickMenuItem(MenuItem item){
        if(item.getItemId()==R.id.sign_out){
            signOut();
            return true;
        }
        return false;
    }

