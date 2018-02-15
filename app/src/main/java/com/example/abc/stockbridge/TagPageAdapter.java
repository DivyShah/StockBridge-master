package com.example.abc.stockbridge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by divyshah on 1/2/18.
 */

public class TagPageAdapter extends FragmentStatePagerAdapter {


    public TagPageAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);

    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new DefineFragment();
            case 1:
                return new ChartFragment();
            case 2:
                return new DetailsFragment();

            case 3:
                return new ExchangeFragment();


        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
