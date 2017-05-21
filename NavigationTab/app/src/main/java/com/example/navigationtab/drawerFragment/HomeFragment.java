package com.example.navigationtab.drawerFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.navigationtab.R;
import com.example.navigationtab.Utils.IFragmentCommunicator;
import com.example.navigationtab.Utils.IViewpagerCommunicator;

/**
 * Created by subratkumar on 20/5/17.
 */
public class HomeFragment extends Fragment{


    private SliderLayout imageSlider;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Fragment fragment=null;
    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageSlider=(SliderLayout)view.findViewById(R.id.slider);
        tabLayout=(TabLayout)view.findViewById(R.id.tab_layout);
        viewPager=(ViewPager) view.findViewById(R.id.viewpager);

        HashMap<String,Integer> file_maps = new HashMap<String,Integer>();
        file_maps.put("Big Bang Theory new album 2016",R.drawable.bigbang);
        file_maps.put("House of Cards new album 2016",R.drawable.house);
        file_maps.put("Game of bird new album 2016", R.drawable.bird);
        file_maps.put("Paris new album 2016", R.drawable.paris);
        file_maps.put("Throll new album 2016", R.drawable.trolltunga);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
//                    .setOnSliderClickListener(getContext());
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);
            imageSlider.addSlider(textSliderView);
        }
        imageSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        imageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        imageSlider.setCustomAnimation(new DescriptionAnimation());
        imageSlider.setDuration(4000);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Note that we are passing childFragmentManager, not FragmentManager
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getSelectedTabPosition();
        setupTabIcons();
    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabOne.setText("Video");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.selector_video, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);


        TextView tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Image");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.selector_image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabThree.setText("Milestone");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.selector_milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    fragment= new VideoFragment();
                    return fragment;
                case 1:
                    fragment=new ImageFragment();
                    return fragment;
                case 2:
                    fragment= new MileStoneFragment();
                    return fragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
            case 0:
            return "Video";
            case 1:
            return "Image";
            case 3:
            return "MileStone";
        }

            return null;
        }
    }
}
