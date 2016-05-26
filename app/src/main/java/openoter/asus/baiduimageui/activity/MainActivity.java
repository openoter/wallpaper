package openoter.asus.baiduimageui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import openoter.asus.baiduimageui.R;
import openoter.asus.baiduimageui.fragment.HomeFragment;
import openoter.asus.baiduimageui.fragment.LocaltionFragment;
import openoter.asus.baiduimageui.fragment.SearchFragment;
import openoter.asus.baiduimageui.fragment.SelectFragment;
import openoter.asus.baiduimageui.fragment.SettingFragment;
import openoter.asus.baiduimageui.view.MyBottomLayout;

public class MainActivity extends FragmentActivity {
    MyBottomLayout myBottomLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    /**
     * 页面的初始化
     */
    private void init() {
        //initPageContent(new HomeFragment());
        viewPager = (ViewPager) findViewById(R.id.myViewPage);
        //添加適配器
        viewPager.setAdapter(new MyFragmentAdapater(getSupportFragmentManager()));
        findView();
        setOnClick();
        viewPager.setOnPageChangeListener(new PageChangeListener());
    }
    private class PageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            myBottomLayout.initPic(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    /**
     * 动态切换页面
     * @param fragment 需要切换的Fragment对象
     */
    /*private void initPageContent(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.myContent, fragment);
        ft.commit();
    }*/

    /**
     * 设置点击事件
     */
    private void setOnClick() {
        myBottomLayout.setOnCallbackListener(new MyCallbackListener());
    }
    private class MyCallbackListener implements MyBottomLayout.ICallbackListener{

        @Override
        public void click(int id) {
            switch (id){
                case R.id.homeLayout:
                    //initPageContent(new HomeFragment());
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.selectLayout:
                    //initPageContent(new SelectFragment());
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.searchLayout:
                   // initPageContent(new SearchFragment());
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.localtionLayout:
                   // initPageContent(new LocaltionFragment());
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.settingLayout:
                    //initPageContent(new SettingFragment());
                    viewPager.setCurrentItem(4);
                    break;
            }
        }
    }
    private void findView() {
        myBottomLayout = (MyBottomLayout) findViewById(R.id.myBottomLayout);

    }

    private class MyFragmentAdapater extends FragmentPagerAdapter{

        public MyFragmentAdapater(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new HomeFragment();
                case 1:
                    return new SelectFragment();
                case 2:
                    return new SearchFragment();
                case 3:
                    return new LocaltionFragment();
                case 4:
                    return new SettingFragment();
            }
            return null;
        }

        /**
         * 當前頁面的數量
         * @return
         */
        @Override
        public int getCount() {
            return 5;
        }
    }

}
