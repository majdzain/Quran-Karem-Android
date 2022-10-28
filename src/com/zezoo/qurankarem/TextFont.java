package com.zezoo.qurankarem;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextFont extends TextView {

	public TextFont(Context context) {
		super(context);
		init();
	}

	private void init() {
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
				"Zokrofi.TTF");
		setTypeface(tf);
	}

	public TextFont(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public TextFont(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

}
