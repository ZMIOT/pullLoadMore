package adapter;

import android.content.Context;
import android.view.LayoutInflater;

import com.example.a28903.adaptertest.R;

import java.util.List;

import bean.Itembean;

public class TestAdapter extends CommonAdapter<Itembean> {

    public TestAdapter(Context mContext, List<Itembean> mList, LayoutInflater mInflater, int mItemLayoutId) {
        super(mContext, mList, mInflater, mItemLayoutId);
    }

    @Override
    public void convert(ViewHolder helper, Itembean item) {
        helper.setText(R.id.baby_name,item.getTitle());
        /*helper.setImageBitmap(R.id.iv,item.getRightImg());
        helper.setImageBitmap(R.id.iv_head,item.getHeadImg());*/
    }
}
