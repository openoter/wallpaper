package openoter.asus.baiduimageui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import openoter.asus.baiduimageui.R;

import static android.graphics.Color.*;

/**
 * 自定义实现tab
 */
public class MyBottomLayout extends LinearLayout{
    private RelativeLayout homeLayout;
    private RelativeLayout selectLayout;
    private RelativeLayout searchLayout;
    private RelativeLayout localtionLayout;
    private RelativeLayout settingLayout;

    private LayoutInflater inflater; //布局管理器
    public MyBottomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.layout_tab_bottom, this);

        findView(view);
        initData();
        setOnClick();
    }

    private void initData() {
        homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home_down);
        TextView tv001 = (TextView) homeLayout.findViewById(R.id.tabText);
        tv001.setText("首页");
        tv001.setTextColor(Color.BLUE);

        selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
        TextView tv002 = (TextView) selectLayout.findViewById(R.id.tabText);
        tv002.setText("精选");
//        tv002.setTextColor(Color.BLUE);

        selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
        TextView tv003 = (TextView) selectLayout.findViewById(R.id.tabText);
        tv003.setText("搜素");
//        tv003.setTextColor(Color.BLUE);

        localtionLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
        TextView tv004 = (TextView) localtionLayout.findViewById(R.id.tabText);
        tv004.setText("本地");
//        tv004.setTextColor(Color.BLUE);

        settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
        TextView tv005 = (TextView) settingLayout.findViewById(R.id.tabText);
        tv005.setText("设置");
//        tv005.setTextColor(Color.BLUE);
    }

    //设置点击事件
    private void setOnClick() {
        homeLayout.setOnClickListener(new Listener());
        selectLayout.setOnClickListener(new Listener());
        searchLayout.setOnClickListener(new Listener());
        localtionLayout.setOnClickListener(new Listener());
        settingLayout.setOnClickListener(new Listener());
    }
    public interface ICallbackListener{
        //确定到底点击的是哪个按钮
        public void click(int id);
    }
    ICallbackListener callbackListener = null;

    public void setOnCallbackListener( ICallbackListener callbackListener){
        this.callbackListener = callbackListener;
    }
    /**
     * tab点击事件的处理
     */
    class Listener implements OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.homeLayout:
                    //1. 点击了之后更改图标
                        initPic(0);
                    //2. 实现页面的切换

                    break;
                case R.id.selectLayout:
                    initPic(1);
                    break;
                case R.id.searchLayout:
                    initPic(2);
                    break;
                case R.id.localtionLayout:
                    initPic(3);
                    break;
                case R.id.settingLayout:
                    initPic(4);
                    break;
            }

            callbackListener.click(v.getId());
        }
    }

    /**
     *
     * @param i 切换卡的位置
     */
    public void initPic(int i) {
        switch (i){
            case 0:
                //把以第一个切换卡设置为点击后状态
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home_down);
                TextView tv001 = (TextView) homeLayout.findViewById(R.id.tabText);
                tv001.setTextColor(Color.BLUE);
                //把其他的切换卡设置成未点击的状态
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
                TextView tv002 = (TextView) selectLayout.findViewById(R.id.tabText);
                tv002.setTextColor(Color.WHITE);

                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
                TextView tv003 = (TextView) searchLayout.findViewById(R.id.tabText);
                tv003.setTextColor(Color.WHITE);

                localtionLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
                TextView tv004 = (TextView) localtionLayout.findViewById(R.id.tabText);
                tv004.setTextColor(Color.WHITE);

                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
                TextView tv005 = (TextView) settingLayout.findViewById(R.id.tabText);
                tv005.setTextColor(Color.WHITE);
                break;
            case 1:
                //把以第一个切换卡设置为点击后状态
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home);
                TextView tv021 = (TextView) homeLayout.findViewById(R.id.tabText);
                tv021.setTextColor(Color.WHITE);
                //把其他的切换卡设置成未点击的状态
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find_down);
                TextView tv022 = (TextView) selectLayout.findViewById(R.id.tabText);
                tv022.setTextColor(Color.BLUE);

                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
                TextView tv023 = (TextView) searchLayout.findViewById(R.id.tabText);
                tv023.setTextColor(Color.WHITE);

                localtionLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
                TextView tv024 = (TextView) localtionLayout.findViewById(R.id.tabText);
                tv024.setTextColor(Color.WHITE);

                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
                TextView tv025 = (TextView) settingLayout.findViewById(R.id.tabText);
                tv025.setTextColor(Color.WHITE);
                break;
            case 2:
                //把以第一个切换卡设置为点击后状态
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home);
                TextView tv006 = (TextView) homeLayout.findViewById(R.id.tabText);
                tv006.setTextColor(Color.WHITE);
                //把其他的切换卡设置成未点击的状态
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
                TextView tv007 = (TextView) selectLayout.findViewById(R.id.tabText);
                tv007.setTextColor(Color.WHITE);

                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search_down);
                TextView tv008 = (TextView) searchLayout.findViewById(R.id.tabText);
                tv008.setTextColor(Color.BLUE);

                localtionLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
                TextView tv009 = (TextView) localtionLayout.findViewById(R.id.tabText);
                tv009.setTextColor(Color.WHITE);

                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
                TextView tv010 = (TextView) settingLayout.findViewById(R.id.tabText);
                tv010.setTextColor(Color.WHITE);
                break;
            case 3:
                //把以第一个切换卡设置为点击后状态
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home);
                TextView tv011 = (TextView) homeLayout.findViewById(R.id.tabText);
                tv011.setTextColor(Color.WHITE);
                //把其他的切换卡设置成未点击的状态
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
                TextView tv012 = (TextView) selectLayout.findViewById(R.id.tabText);
                tv012.setTextColor(Color.WHITE);

                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
                TextView tv013 = (TextView) searchLayout.findViewById(R.id.tabText);
                tv013.setTextColor(Color.WHITE);

                localtionLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage_down);
                TextView tv014 = (TextView) localtionLayout.findViewById(R.id.tabText);
                tv014.setTextColor(Color.BLUE);

                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
                TextView tv015 = (TextView) settingLayout.findViewById(R.id.tabText);
                tv015.setTextColor(Color.WHITE);
                break;
            case 4:
                //把以第一个切换卡设置为点击后状态
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home);
                TextView tv016 = (TextView) homeLayout.findViewById(R.id.tabText);
                tv016.setTextColor(Color.WHITE);
                //把其他的切换卡设置成未点击的状态
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
                TextView tv017 = (TextView) selectLayout.findViewById(R.id.tabText);
                tv017.setTextColor(Color.WHITE);

                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
                TextView tv018 = (TextView) searchLayout.findViewById(R.id.tabText);
                tv018.setTextColor(Color.WHITE);

                localtionLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
                TextView tv019 = (TextView) localtionLayout.findViewById(R.id.tabText);
                tv019.setTextColor(Color.WHITE);

                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more_down);
                TextView tv020 = (TextView) settingLayout.findViewById(R.id.tabText);
                tv020.setTextColor(Color.BLUE);
                break;

        }
    }

    /**
     * 寻找控件
     * @param view
     */
    private void findView(View view) {
        homeLayout = (RelativeLayout) view.findViewById(R.id.homeLayout);
        selectLayout = (RelativeLayout) view.findViewById(R.id.selectLayout);
        searchLayout = (RelativeLayout) view.findViewById(R.id.searchLayout);
        localtionLayout = (RelativeLayout) view.findViewById(R.id.localtionLayout);
        settingLayout = (RelativeLayout) view.findViewById(R.id.settingLayout);
    }


}
