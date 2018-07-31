package com.example.gmamdin.contacts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ViewPageAdapter extends FragmentPagerAdapter {


    int noOfTabs;

    public ViewPageAdapter(FragmentManager fragmentManager,int noOfTabs) {
        super(fragmentManager);
        this.noOfTabs=noOfTabs;

    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                FragmentCall tab1=new FragmentCall();
                return tab1;
            case 1:
                FragmentContacts tab2=new FragmentContacts();
                return tab2;
            case 2:
                FragmentFav tab3=new FragmentFav();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return noOfTabs;
    }
}
