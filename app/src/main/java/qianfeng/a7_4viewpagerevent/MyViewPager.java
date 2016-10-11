package qianfeng.a7_4viewpagerevent;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

// 事件冲突处理方式之二:
public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // 因为我本身就是在vp里面，所以前面不需要带vp.  就可以直接调用它里面的获取父容器的方法getParent(),然后禁止掉父容器的拦截当前控件的点击事件。
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(ev);
    }
}
