package qianfeng.a7_4viewpagerevent;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] titles = new String[]{"养生","健康","男性","女性","呼吸道"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        List<BaseFragment> list = new ArrayList<>();

        for(int i = 0; i < titles.length; i++)
        {
            list.add(BaseFragment.getInstance(titles[i],i));
        }

        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), list, titles);

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);// 关联TabLayout和Viewpager



    }
}
