package qianfeng.a7_4viewpagerevent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> baseFragmentList;
    private String[] titles;

    public MyFragmentAdapter(FragmentManager fm, List<BaseFragment> baseFragmentList, String[] titles) {
        super(fm);
        this.baseFragmentList = baseFragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return baseFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return baseFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
