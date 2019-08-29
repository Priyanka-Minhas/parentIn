package com.sdei.parentIn.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.sdei.parentIn.R;
import com.sdei.parentIn.model.SurveysModel;

import java.util.ArrayList;

public class SurveysViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<SurveysModel.DataBean> mData;

    public SurveysViewPagerAdapter(Context context, ArrayList<SurveysModel.DataBean> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.dialog_teacher_add_child, collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

}
