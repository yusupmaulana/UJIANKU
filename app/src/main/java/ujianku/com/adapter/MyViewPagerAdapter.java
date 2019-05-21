package ujianku.com.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import ujianku.com.fragment.Fragment1;

/*
 * Nim : 10116093
 * Nama : Yusup Maulanadireja
 * Kelas : IF-3/AKB-3
 * Tanggal Pengerjaan : 19 Mei 2019
 * */

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] pages;

    public MyViewPagerAdapter(FragmentManager fm, Fragment[] pages) {
        super(fm);
        this.pages = pages;
    }

    @Override
    public Fragment getItem(int position) {
        return pages[position];
    }

    @Override
    public int getCount() {
        return pages.length;
    }
}
