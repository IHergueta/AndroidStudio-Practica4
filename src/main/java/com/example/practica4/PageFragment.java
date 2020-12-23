package com.example.practica4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageFragment extends FragmentPagerAdapter {

    //asigno los nombres de las tabs
    private String tabTitles[] = new String[] { "Animales", "Musica", "Video","Pelota" };
    //y el numero de ellas
    int numOfTabs=4;

    //para enseñar los titulos de las tabs
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    //el constructor
    public PageFragment(FragmentManager fm, int behavior) {
        super(fm, behavior);
        numOfTabs=behavior;

    }


    //para elegir el fragment
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            case 3:
                return new Fragment4();
            default:
                return null;
        }
    }

    //para saber cuantas tabs hay
    @Override
    public int getCount() {
        return numOfTabs;
    }
}
