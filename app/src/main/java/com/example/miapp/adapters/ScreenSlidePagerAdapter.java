package com.example.miapp.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.miapp.fragment.ScreenSlidePageFragment;
//import com.example.miapp.root_fragment;
import com.example.miapp.tab1;
import com.example.miapp.Blogs_view;
import com.example.miapp.tab3;
import com.example.miapp.tab4;
import com.example.miapp.tab5;

import java.util.List;


/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<ScreenSlidePageFragment> fragmentList;

    public ScreenSlidePagerAdapter(List<ScreenSlidePageFragment> fragmentList, FragmentManager fm) {
        super(fm);
        this.fragmentList = fragmentList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position >= 0 && position < fragmentList.size()) {

            switch (position){
                case 0:
                    tab1 tb1 = new tab1();
                    return tb1;

                case 1:
                    Blogs_view tb2 = new Blogs_view();
                    return new tab3();

                case 2:
                    return new Blogs_view();

                case 3:
                    tab4 tb4 = new tab4();
                    return tb4;
                case 4:
                    tab5 tb5 = new tab5();
                    return tb5;



            }

            return fragmentList.get(position);

        }

        return new ScreenSlidePageFragment();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}