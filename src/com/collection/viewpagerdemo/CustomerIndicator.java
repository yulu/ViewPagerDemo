package com.collection.viewpagerdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomerIndicator extends IndicatorView{

	public CustomerIndicator(Context context) {
		super(context);
	}
	
    public CustomerIndicator(Context context, AttributeSet attrs) {
    	super(context, attrs, 0);
    }

    public CustomerIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    
    @Override
    protected void setIndicatorStyle(ImageView imgView, int style){
		imgView.setImageResource(R.drawable.page_indicator_cus_selector);
		imgView.setEnabled(false);
    }

}
