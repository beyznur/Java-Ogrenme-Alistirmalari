package com.example.navigationviewkullanm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private NavigationView mMav;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private ProfileFragment profileFragment;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer=findViewById(R.id.main_activity_drawerLayout);
        mMav=findViewById(R.id.main_activity_navigationView);
        mToolbar=findViewById(R.id.main_activity_toolBar);

        homeFragment=new HomeFragment();
        searchFragment=new SearchFragment();
        profileFragment=new ProfileFragment();

        setSupportActionBar(mToolbar);//toolbarın özelliklerini ekledi.
        //mMav.getMenu().getItem(0).setChecked(true);//home fragment ile başlatıyor
        mMav.getMenu().findItem(R.id.nav_menu_fragent1).setChecked(true);//üsttekiyle aynı işi yapar ama daha güvenilir.

        mMav.setItemIconTintList(null);//icondaki default renk ayarını yok sayar

        mToggle = new ActionBarDrawerToggle(this,mDrawer,mToolbar,R.string.nav_open,R.string.nav_close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();

        mMav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_menu_fragent1:
                        setFragment(homeFragment);
                        Toast.makeText(getApplicationContext(),"Fragment 1",Toast.LENGTH_SHORT).show();
                        mDrawer.closeDrawer(GravityCompat.START);//seçildikten sonra drawer kapanır
                        return true;
                    case R.id.nav_menu_fragent2:
                        setFragment(searchFragment);
                        mMav.getMenu().findItem(R.id.nav_menu_fragent1).setChecked(false);
                        Toast.makeText(getApplicationContext(),"Fragment 2",Toast.LENGTH_SHORT).show();
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.nav_menu_fragent3:
                        setFragment(profileFragment);
                        Toast.makeText(getApplicationContext(),"Fragment 3",Toast.LENGTH_SHORT).show();
                        mMav.getMenu().findItem(R.id.nav_menu_fragent1).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.nav_menu_fragent4:
                        Toast.makeText(getApplicationContext(),"Fragment 4",Toast.LENGTH_SHORT).show();
                        mMav.getMenu().findItem(R.id.nav_menu_fragent1).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.nav_menu_fragent5:
                        Toast.makeText(getApplicationContext(),"Fragment 5",Toast.LENGTH_SHORT).show();
                        mMav.getMenu().findItem(R.id.nav_menu_fragent1).setChecked(false);
                        mDrawer.closeDrawer(GravityCompat.START);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
    private  void setFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_activity_frameLayout,fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        //geri tuşu basılınca tetiklenen fonksiyon
        if(mDrawer.isDrawerOpen(GravityCompat.START)){
            mDrawer.closeDrawer(GravityCompat.START);
        }
    }
}