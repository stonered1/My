package my2017.listviewdemo.util;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import my2017.listviewdemo.R;

/**
 * Created by Stone on 17/3/8.
 */

public class GridItem extends RelativeLayout implements Checkable{

    private Context mContext;
    private boolean mChecked;
    private ImageView mImageView, mSelectImgeView;

    public GridItem(Context context) {
        this(context, null, 0);
    }

    public GridItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.grid_item, this);
        mImageView = (ImageView) findViewById(R.id.img_view);
        mSelectImgeView = (ImageView) findViewById(R.id.img_select);
    }

    @Override
    public void setChecked(boolean checked) {
        mChecked = checked;
        setBackgroundDrawable(checked ? getResources().getDrawable(R.drawable.background) : null);
        mSelectImgeView.setVisibility(checked ? View.VISIBLE : View.GONE);
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }


    public void setImgResId(@DrawableRes int resId){
        if (mImageView != null){
            mImageView.setImageResource(resId);
        }
    }

}
