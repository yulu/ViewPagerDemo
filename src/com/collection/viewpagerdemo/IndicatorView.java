package com.collection.viewpagerdemo;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class IndicatorView extends LinearLayout{
	private int numOfIndicator;
	private ArrayList<ImageView> indicators;
	
    public IndicatorView(Context context) {
        super(context);
    }

    public IndicatorView(Context context, AttributeSet attrs) {
    	super(context, attrs, 0);
    }

    public IndicatorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    
	
	public void initView(Context context, int num) {
		numOfIndicator = num;
		//setOrientation(LinearLayout.HORIZONTAL);
		//setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//setGravity(Gravity.CENTER_HORIZONTAL);
		
		indicators = new ArrayList<ImageView>();
		
		for(int i = 0; i < num; i++){
			ImageView img = new ImageView(context);
			img.setImageResource(R.drawable.page_indicator_selector);
			img.setEnabled(false);
			indicators.add(img);
			
			addView(img);
		}
		
	}
	
	public void pageChanged(int currentPage){
		for(int i = 0; i < numOfIndicator; i++){
			if(currentPage == i){
				indicators.get(i).setEnabled(true);
			}else{
				indicators.get(i).setEnabled(false);
			}
		}
	}

}
