package ujianku.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ujianku.com.fragment.FragmentContact;
import ujianku.com.fragment.FragmentFriends;
import ujianku.com.fragment.FragmentProfile;

/*
 * Nim : 10116093
 * Nama : Yusup Maulanadireja
 * Kelas : IF-3/AKB-3
 * Tanggal Pengerjaan : 19 Mei 2019
 * */

public class MainActivity extends AppCompatActivity implements ujianku.com.view.MainActivity {

    @BindView(R.id.navigationBottom)
    BottomNavigationView navigationBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadFragment(new FragmentProfile());
        setBottomNavigasi();
    }

    @Override
    public void setBottomNavigasi() {
        navigationBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.navigation_profile:
                        fragment = new FragmentProfile();
                        break;
                    case R.id.navigation_contact:
                        fragment = new FragmentContact();
                        break;
                    case R.id.navigation_listfriends:
                        fragment = new FragmentFriends();
                        break;
                }
                return loadFragment(fragment);
            }
        });
    }

    @Override
    public boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
