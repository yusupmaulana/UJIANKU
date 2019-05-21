package ujianku.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ujianku.com.adapter.MyViewPagerAdapter;
import ujianku.com.fragment.Fragment1;
import ujianku.com.fragment.Fragment2;
import ujianku.com.fragment.Fragment3;
import ujianku.com.view.MainWelcome;


/*
 * Nim : 10116093
 * Nama : Yusup Maulanadireja
 * Kelas : IF-3/AKB-3
 * Tanggal Pengerjaan : 19 Mei 2019
 * */

public class WelcomeScreen extends AppCompatActivity  {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_skip)
    Button btnSkip;
    @BindView(R.id.layoutDots)
    LinearLayout dotsLayout;

    private MyViewPagerAdapter pagerAdapter;
    private Fragment[] pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        ButterKnife.bind(this);

        pages = new Fragment[]{
                new Fragment1(),
                new Fragment2(),
                new Fragment3()

        };
        pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), pages);
        viewPager.setAdapter(pagerAdapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeScreen.this, MainActivity.class));
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }


}
