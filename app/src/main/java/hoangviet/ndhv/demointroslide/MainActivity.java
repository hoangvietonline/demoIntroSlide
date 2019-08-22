package hoangviet.ndhv.demointroslide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mNavigationItemSelectedListener);
        toolbar.setTitle("Shop");
        initFragment(new FragmentA());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()){
                case R.id.shop:
                    toolbar.setTitle("Shop");
                    fragment = new FragmentA();
                    initFragment(fragment);
                    return true;
                case R.id.user:
                    toolbar.setTitle("Tài Khoản");
                    fragment = new FragmentB();
                    initFragment(fragment);
                    return true;
                case R.id.email:
                    toolbar.setTitle("Email");
                    fragment = new FragmentD();
                    initFragment(fragment);
                    return true;
                case R.id.thongBao:
                    toolbar.setTitle("Thông báo");
                    fragment = new FragmentC();
                    initFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void initFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
