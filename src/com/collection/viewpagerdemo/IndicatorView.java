package com.collection.viewpagerdemo;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class IndicatorView extends LinearLayout{
	public static final int STYLE_DOT = 0;
	public static final int STYLE_BAR = 1;
	
	protected int numOfIndicator;
	protected ArrayList<ImageView> indicators;
	
    public IndicatorView(Context context) {
        super(context);
    }

    public IndicatorView(Context context, AttributeSet attrs) {
    	super(context, attrs, 0);
    }

    public IndicatorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    
	
	public void initView(Context context, int num, Integer...style) {
		assert style.length > 1;
		
		numOfIndicator = num;
		
		indicators = new ArrayList<ImageView>();
		
		for(int i = 0; i < num; i++){
			ImageView img = new ImageView(context);
			if(style.length > 0)
				setIndicatorStyle(img, style[0]);
			else
				setIndicatorStyle(img, STYLE_DOT);
			indicators.add(img);
			
			addView(img);
		}
		
		//default the first page as selected
		pageChanged(0);
		
	}
	
	protected void setIndicatorStyle(ImageView imgView, int style){
		switch(style){
			case STYLE_DOT:
				imgView.setImageResource(R.drawable.page_indicator_selector);
				imgView.setEnabled(false);
				break;
			case STYLE_BAR:
				imgView.setImageResource(R.drawable.page_indicator_bar_selector);
				imgView.setEnabled(false);
				break;
			default:
				imgView.setImageResource(R.drawable.page_indicator_selector);
				imgView.setEnabled(false);
				break;
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
