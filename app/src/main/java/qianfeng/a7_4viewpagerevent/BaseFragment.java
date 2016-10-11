package qianfeng.a7_4viewpagerevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class BaseFragment extends Fragment {

    private List<String> list;

    private int[] imgs = new int[]{R.drawable.p001,R.drawable.p002,R.drawable.p003,R.drawable.p004,R.drawable.p005};

    public static BaseFragment getInstance(String name,int position)
    {
        BaseFragment baseFragment = new BaseFragment();
// Fragment和Fragment之间的通信，也包括本Fragment和本Fragment之间的通信，在创建出来的Fragment里携带信息。

        Bundle args = new Bundle();//表明这个Fragment被创建出来是携带信息的
        args.putString("name",name);
        args.putInt("position",position);
        baseFragment.setArguments(args);//表明这个Fragment被创建出来是携带信息的
        // baseFragment.setAraguments表明这个Fragment被创建出来是携带信息的
        return baseFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // 每次new Fragment都会执行这个方法，即每次调用工厂方法new出Framgent时
        View view = inflater.inflate(R.layout.fg_layout, container, false); // 只有最外层的Fragment的布局需要用到这个container,false，因为它是Fragment直接依赖生成自身的
                                                                            // 如果是Fragment里面动态添加的Viewpager，那么它的Inflater的第二个参数直接给个null就好了，因为它不是依赖container生成的

        ListView lv = (ListView) view.findViewById(R.id.lv);


        initData();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);


        int position = getArguments().getInt("position");
        if(position == 0)
        {
            // 给ListView添加一个头布局
            View view1 = inflater.inflate(R.layout.lv_header, null);  // 记住这里给个null，因为它不是在Fragment中，它是在Listview中的

            final ViewPager vp = (ViewPager) view1.findViewById(R.id.vp);


            VpAdapter adapter1 = new VpAdapter(getActivity(), imgs);
            vp.setAdapter(adapter1);

            // 处理事件冲突最核心的代码！！！, 还有一种方式是用自定义View继承自ViewPager，然后重写里面的onTouchEvent(),在里面添加一行代码即可
            vp.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // 禁止父容器拦截当前控件的触摸事件
                    vp.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
            lv.addHeaderView(view1);

        }

        lv.setAdapter(adapter);

        return view;
    }

    private void initData() {
        String name = getArguments().getString("name");

        list = new ArrayList<>();

        for(int i = 0; i < 30;i++)
        {
            list.add(new String(name + "--李四--:" + i));
        }



    }
}
