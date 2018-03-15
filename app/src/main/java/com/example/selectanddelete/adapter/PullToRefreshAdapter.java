package com.example.selectanddelete.adapter;



import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.selectanddelete.R;
import com.example.selectanddelete.entity.ResultListBean;
import com.example.selectanddelete.util.Util;
import com.example.selectanddelete.view.SlideRelativeLayout;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qxs
 */
public class PullToRefreshAdapter extends BaseQuickAdapter<ResultListBean, PullToRefreshAdapter.MovieViewHolder> {

    public static final int NORMAL = 1000;
    public static final int SLIDE = 2000;
    private int mState = NORMAL;
    private Context context;

    private List<MovieViewHolder> mSlideViewHolders = new ArrayList<>();

    public PullToRefreshAdapter(Context context, List<ResultListBean> resultList) {
        super(R.layout.layout_animation, resultList);
        this.context = context;
    }

    public void openItemAnimation() {
        mState = SLIDE;
        for (MovieViewHolder holder : mSlideViewHolders) {
            holder.openItemAnimation();
        }
    }



    public void closeItemAnimation() {
        mState = NORMAL;
        for (MovieViewHolder holder : mSlideViewHolders) {
            holder.closeItemAnimation();
        }
    }
    @Override
    protected void convert(MovieViewHolder helper, ResultListBean item) {
        helper.setText(R.id.tweetText,item.getCp());

        helper.setText(R.id.tweetDate, String.valueOf(item.getSeq_id()));
        helper.setText(R.id.tweetName,item.getTitle());
        helper.setText(R.id.online, Util.onLineText(item.getDown_status()));
        helper.bind(item);
        mSlideViewHolders.add(helper);

    }

    public class MovieViewHolder extends BaseViewHolder {

        SlideRelativeLayout relativeLayout;
        CheckBox checkBox;

        private ResultListBean mItemBean;
        public MovieViewHolder(View itemView) {
            super(itemView);

            relativeLayout = getView(R.id.item_root);


            checkBox = getView(R.id.item_checkbox);

            addOnClickListener(R.id.item_checkbox);
        }

        public void bind(ResultListBean item) {
            mItemBean = item;
            checkBox.setChecked(mItemBean.isChecked());
            switch (mState) {
                case NORMAL:
                    checkBox.setVisibility(View.GONE);
                    relativeLayout.close();
                    break;

                case SLIDE:
                    checkBox.setVisibility(View.VISIBLE);
                    relativeLayout.open();

                    break;
                default:
                    break;
            }
        }
        public void openItemAnimation() {
            relativeLayout.openAnimation();
            checkBox.setVisibility(View.VISIBLE);
        }

        public void closeItemAnimation() {
                    checkBox.setVisibility(View.GONE);
            relativeLayout.closeAnimation();

        }

    }
}