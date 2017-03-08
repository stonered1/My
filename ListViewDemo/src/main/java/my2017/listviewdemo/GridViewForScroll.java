package my2017.listviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Stone on 17/3/7.
 */

public class GridViewForScroll extends GridView{

    public GridViewForScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        //0x7fffffff
        int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, mExpandSpec);
    }

}


