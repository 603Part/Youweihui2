package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.EndFragment1Adapter;
import com.youweihui.tourismstore.adapter.EndFragment1BottomAdapter;
import com.youweihui.tourismstore.adapter.EndFragment2Adapter;
import com.youweihui.tourismstore.adapter.EndFragment3Adapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.EndFragment1Entity;
import com.youweihui.tourismstore.bean.ForumEntity;
import com.youweihui.tourismstore.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${范泽宁} on 2018/12/11.
 */

@SuppressLint("ValidFragment")
public class EndDetailTab3Fragment extends BaseFragment {

    @BindView(R.id.end_detail_tab3_recycle)
    RecyclerView recyclerView;

    private EndFragment3Adapter fragment3Adapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_end_detail_tab3;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        fragment3Adapter = new EndFragment3Adapter(new ArrayList<ForumEntity>());
        recyclerView.setAdapter(fragment3Adapter);

        List<ForumEntity> list = new ArrayList<>();

        ForumEntity entity1 = new ForumEntity();
        ForumEntity entity2 = new ForumEntity();
        ForumEntity entity3 = new ForumEntity();
        ForumEntity entity4 = new ForumEntity();
        ForumEntity entity5 = new ForumEntity();
        ForumEntity entity6 = new ForumEntity();
        ForumEntity entity7 = new ForumEntity();
        ForumEntity entity8 = new ForumEntity();

        entity1.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity8.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity2.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
        entity7.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity3.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity4.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity6.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity5.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        list.add(entity7);
        list.add(entity8);

        fragment3Adapter.setData(list);
    }
}
