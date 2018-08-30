package view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TestScrollView extends ListView{
    private Context mContext;
    private int mMaxOverDistance =50;
    public TestScrollView(Context context) {
        super(context);
        mContext=context;
        initView();
    }

    public TestScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int mViewGroupWidth  = getMeasuredWidth();  //当前ViewGroup的总宽度

        int mPainterPosX = left;  //当前绘图光标横坐标位置
        int mPainterPosY = top;  //当前绘图光标纵坐标位置

        int childCount = getChildCount();
        for ( int i = 0; i < childCount; i++ ) {

            View childView = getChildAt(i);

            int width  = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();

            //如果剩余的空间不够，则移到下一行开始位置
            if( mPainterPosX + width > mViewGroupWidth ) {
                mPainterPosX = left;
                mPainterPosY += height;
            }

            //执行ChildView的绘制
            childView.layout(mPainterPosX,mPainterPosY,mPainterPosX+width, mPainterPosY+height);

            //记录当前已经绘制到的横坐标位置
            mPainterPosX += width;
        }
    }



    public void initView(){
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        float density= metrics.density;
        mMaxOverDistance = (int)(density*mMaxOverDistance);
    }
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverDistance, isTouchEvent);
    }
}
