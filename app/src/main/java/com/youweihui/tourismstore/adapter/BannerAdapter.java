package com.youweihui.tourismstore.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.List;

public class BannerAdapter extends PagerAdapter {

	private List<View> pagerView;

	private OnItemClick onItemClick;

	public void setmOnItemClick(OnItemClick mOnItemClick) {
		this.onItemClick = mOnItemClick;
	}

	public BannerAdapter(List<View> pagerView) {
		this.pagerView = pagerView;
	}

	public int getCount() {
		return pagerView.size();
	}

	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	public void destroyItem(View v, int position, Object object) {
		((ViewPager) v).removeView(pagerView.get(position));
	}

	public void finishUpdate(View container) {

	}

	public Object instantiateItem(View v, final int position) {
		((ViewPager) v).addView(pagerView.get(position));
		pagerView.get(position).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (onItemClick != null){
					onItemClick.onItemClick(position);
				}
			}
		});
		return pagerView.get(position);
	}

	public interface OnItemClick{
		void onItemClick(int position);
	}
}
