package com.collection.viewpagerdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends FragmentActivity{
	/**
     * The number of page
     */
    private static final int NUM_PAGES = 5;
    
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private IndicatorView mIndicator;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
               
        mIndicator = (IndicatorView)findViewById(R.id.indicator_view);
        mIndicator.initView(getApplicationContext(), NUM_PAGES);
        mIndicator.pageChanged(0);
        
        mPager.setOnPageChangeListener(new OnPageChangeListener() {

            public void onPageScrollStateChanged(int arg0) {
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageSelected(int currentPage) {
            	mIndicator.pageChanged(currentPage);
            }

        });
        
        //Instantiate a indicator view
        //mIndicator = new IndicatorView(getApplicationContext(), NUM_PAGES);
        //RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_layout);
        //add to the current view
        //layout.addView(mIndicator, 0);

        
	}
	
	@Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
	
	/**
     * A simple pager adapter that represents NUM_PAGES ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
            
        }

        @Override
        public Fragment getItem(int position) {  
        	
        	return new SampleFragment(position);

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
    
    /**
     * sample fragment
     */
    @SuppressLint("ValidFragment")
	private class SampleFragment extends Fragment{
    	private int fragId;
    	
    	public SampleFragment(int i){
    		super();
    		fragId = i;
    	}
    	
    	@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
    		
            ImageView imgView = new ImageView(getActivity());
            
            imgView.setImageResource(R.drawable.sample_image);

            return imgView;
        }
    }

}
