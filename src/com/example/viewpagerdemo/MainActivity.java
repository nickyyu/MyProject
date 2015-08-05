package com.example.viewpagerdemo;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	ViewPager pager = null;
    PagerTabStrip tabStrip = null;
    ArrayList<View> viewContainter = new ArrayList<View>();
    ArrayList<String> titleContainer = new ArrayList<String>();
    public String TAG = "tag";
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        pager = (ViewPager) this.findViewById(R.id.viewpager);
        tabStrip = (PagerTabStrip) this.findViewById(R.id.tabstrip);
        //ȡ��tab����ĳ�����
        tabStrip.setDrawFullUnderline(false);
        //����tab�ı���ɫ
        tabStrip.setBackgroundColor(Color.WHITE);
        //���õ�ǰtabҳǩ���»�����ɫ
        tabStrip.setTabIndicatorColor(Color.RED);
        tabStrip.setTextSpacing(200);
         
        
       GridView grid=new GridView(this);
       LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
       grid.setLayoutParams(params);
       grid.setNumColumns(GridView.AUTO_FIT);
        TextView view1=new TextView(this);
        view1.setText("��������");
        TextView view2=new TextView(this);
        view2.setText("��������");
        TextView view3=new TextView(this);
        view3.setText("���ײƾ�");
        TextView view4=new TextView(this);
        view4.setText("����Ů��");
        
      //viewpager��ʼ���view
        viewContainter.add(view1);
        viewContainter.add(view2);
        viewContainter.add(view3);
        viewContainter.add(view4);
      //ҳǩ��
        titleContainer.add("��������");
        titleContainer.add("��������");
        titleContainer.add("���ײƾ�");
        titleContainer.add("����Ů��");
 
        pager.setAdapter(new PagerAdapter() {
 
            //viewpager�е��������
            @Override
            public int getCount() {
                return viewContainter.size();
            }
          //�����л���ʱ�����ٵ�ǰ�����
            @Override
            public void destroyItem(ViewGroup container, int position,
                    Object object) {
                ((ViewPager) container).removeView(viewContainter.get(position));
            }
          //ÿ�λ�����ʱ�����ɵ����
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager) container).addView(viewContainter.get(position));
                return viewContainter.get(position);
            }
 
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }
 
            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }
 
            @Override
            public CharSequence getPageTitle(int position) {
                return titleContainer.get(position);
            }
        });
 
        pager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
                Log.d(TAG, "--------changed:" + arg0);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                Log.d(TAG, "-------scrolled arg0:" + arg0);
                Log.d(TAG, "-------scrolled arg1:" + arg1);
                Log.d(TAG, "-------scrolled arg2:" + arg2);
            }
 
            @Override
            public void onPageSelected(int arg0) {
                Log.d(TAG, "------selected:" + arg0);
            }
        });
 
    }
}
