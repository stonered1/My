package my2017.my.uitl;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Stone on 17/3/6.
 */

public class CustomImg extends ViewGroup {


    public CustomImg(Context context) {
        super(context);
    }

    public CustomImg(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    ListView list;


    public CustomImg(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int cCount = getChildCount();
        int cWidth = 0;
        int cHeight = 0;
        MarginLayoutParams cParams = null;
        /**
         * 遍历所有childView根据其宽和高，以及margin进行布局
         */
        for (int i = 0; i < cCount; i++)
        {
            View childView = getChildAt(i);
            cWidth = childView.getMeasuredWidth();
            cHeight = childView.getMeasuredHeight();
            cParams = (MarginLayoutParams) childView.getLayoutParams();

            int cl = 0, ct = 0, cr = 0, cb = 0;

            switch (i)
            {
                case 0:
                    cl = cParams.leftMargin;
                    ct = cParams.topMargin;
                    break;
                case 1:
                    cl = getWidth() - cWidth - cParams.leftMargin
                            - cParams.rightMargin;
                    ct = cParams.topMargin;

                    break;
                case 2:
                    cl = cParams.leftMargin;
                    ct = getHeight() - cHeight - cParams.bottomMargin;
                    break;
                case 3:
                    cl = getWidth() - cWidth - cParams.leftMargin
                            - cParams.rightMargin;
                    ct = getHeight() - cHeight - cParams.bottomMargin;
                    break;

            }
            cr = cl + cWidth;
            cb = cHeight + ct;
            childView.layout(cl, ct, cr, cb);
        }
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        //计算出所有子view的高和宽
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        //记录如果是wrap_content的宽和高

        int width = 0;
        int height = 0;

        int childCount = getChildCount();
        int childWidth = 0;
        int childHeigth = 0;

        MarginLayoutParams childParam = null;

        //用于计算左边两个child的高度
        int leftHeight = 0;
        //用于计算右边连个child的高度
        int rightHeight = 0;

        //用于计算上面两个child的宽度
        int topWidth = 0;
        //用于计算下面两个child的宽度
        int bottomWidth = 0;

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);

            childWidth = childView.getWidth();
            childHeigth = childView.getHeight();
            childParam = (MarginLayoutParams) childView.getLayoutParams();

            if (i == 0 || i == 1){
                topWidth += childWidth + childParam.leftMargin + childParam.rightMargin;

            }

            if (i == 2 || i == 3){
                bottomWidth += childWidth + childParam.leftMargin + childParam.rightMargin;
            }

            if (i == 0 || i == 2){
                leftHeight += childHeigth + childParam.topMargin + childParam.bottomMargin;
            }

            if (i == 1 || i == 3){
                rightHeight += childHeigth + childParam.topMargin + childParam.bottomMargin;
            }

            width = Math.max(topWidth, bottomWidth);
            height = Math.max(leftHeight, rightHeight);

            /**
             * 如果是wrap_content设置为我们计算的值
             * 否则：直接设置为父容器计算的值
             */
            setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth
                    : width, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight
                    : height);


        }


    }
}
