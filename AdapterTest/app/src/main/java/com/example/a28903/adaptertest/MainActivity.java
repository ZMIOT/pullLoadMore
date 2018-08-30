package com.example.a28903.adaptertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.TestAdapter;
import bean.Itembean;
import view.TestScrollView;

public class MainActivity extends AppCompatActivity {

    private TestScrollView listView;
    private LayoutInflater layoutInflater;
    private TestAdapter testAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (TestScrollView) findViewById(R.id.listview);
        testAdapter = new TestAdapter(this,getData(),layoutInflater,R.layout.item_test);
        /*setHeight();*/
        listView.setAdapter(testAdapter);
       /* listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int y=(int)motionEvent.getY();
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });*/
    }

    private List<Itembean> getData() {
        String title[] = {"华为应用列表页", "游戏中心", "其他"};
       /* int img[]={R.mipmap.right_in1,R.mipmap.right_in1,R.mipmap.right_in1};
        int headImg[]={R.mipmap.tx,R.mipmap.person,R.mipmap.person};*/

        List<Itembean> mList = new ArrayList<>();
        Itembean itembean = new Itembean();
        itembean.setTitle(title[0]);
        mList.add(itembean);

        Itembean itembean2 = new Itembean();
        itembean2.setTitle(title[1]);
        mList.add(itembean2);

        Itembean itembean3 = new Itembean();
        itembean3.setTitle(title[2]);
        mList.add(itembean3);

        return mList;
    }

    public void setHeight() {
        int height = 0;
        int count = testAdapter.getCount();
        for(int i=0;i<count;i++){
            View temp = testAdapter.getView(i,null,listView);
            temp.measure(0,0);
            height += temp.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = this.listView.getLayoutParams();
        params.width = ViewGroup.LayoutParams.FILL_PARENT;
        params.height = height;
        listView.setLayoutParams(params); }
}
