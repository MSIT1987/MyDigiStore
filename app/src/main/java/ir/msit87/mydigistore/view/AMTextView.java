package ir.msit87.mydigistore.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import ir.msit87.mydigistore.R;
import ir.msit87.mydigistore.helper.FontHelper;

/**
 * AMTextView Class Created by Mohammad Soltanmohammadi on 7/15/2017.
 */

@SuppressLint("AppCompatCustomView")
public class AMTextView extends TextView {

    String mStyle = "";

    public AMTextView(Context context) {
        super(context);
        setUp(context, null);
    }

    public AMTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUp(context, attrs);
    }

    public AMTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUp(context, attrs);
    }

    @TargetApi(21)
    public AMTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setUp(context, attrs);
    }

    private void setUp(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AMTextView, 0, 0);

        this.mStyle = typedArray.getString(R.styleable.AMTextView_fontStyle);
        if (this.mStyle == null) {
            this.mStyle = "regular";
        }

        typedArray.recycle();
        setFontStyle(this.mStyle);
    }

    public String text() {
        return getText().toString();
    }

    public void setFontStyle(String style) {
        this.mStyle = style;
        setTypeface(FontHelper.get(this.mStyle.equals("bold") ? FontHelper.IRANSansMOBILE_BOLD : FontHelper.IRANSansMOBILE_REGULAR, getContext()));
    }
}
