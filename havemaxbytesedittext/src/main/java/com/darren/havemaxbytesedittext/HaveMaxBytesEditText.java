package com.darren.havemaxbytesedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Darren on 2017/6/30.
 */

public class HaveMaxBytesEditText extends EditText implements TextWatcher {
    private static final String TAG = "HaveMaxBytesEditText";
    int mMaxBytes;

    public HaveMaxBytesEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        context.getSharedPreferences().edit().apply();

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HaveMaxBytesEditText);

        int count = a.getIndexCount();
        for (int i=0; i<count; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.HaveMaxBytesEditText_maxBytes) {
                mMaxBytes = a.getInt(attr, -1);
            }
        }
        a.recycle();

        this.addTextChangedListener(this);
    }

    public HaveMaxBytesEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    public int getMaxBytes() {
        return mMaxBytes;
    }

    public void setMaxBytes(int maxBytes) {
        this.mMaxBytes = maxBytes;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (getMaxBytes() <= 0) {
            return;
        }
        int length = s.toString().getBytes().length;
        if (length == getMaxBytes() + 1) {
            Log.d(TAG, "onTextChanged: out of bound");
        }
        if (length > getMaxBytes()) {
            getText().replace(0,s.length(), s, 0, s.length()-1);
            setSelection(start + count > s.length() ? s.length() : start + count);

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
