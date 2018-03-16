package com.example.selectanddelete.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Html;
import android.text.Layout;
import android.transition.TransitionManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import com.example.selectanddelete.MainActivity;
import com.example.selectanddelete.R;
import com.example.selectanddelete.adapter.PullToRefreshAdapter;
import com.example.selectanddelete.entity.BaseResponse;
import com.example.selectanddelete.entity.ResultListBean;
import com.example.selectanddelete.entity.SimpleResponse;
import com.example.selectanddelete.util.StringTool;
import com.example.selectanddelete.util.TLiveConfig;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author qxs
 */
public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener{
    private static final String ARG_POSITION = "position";


    @BindView(R.id.dummyfrag_scrollableview)
    RecyclerView recyclerView;

    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;


    @BindView(R.id.progress_layout)
    FrameLayout mFrameLayout;

    @BindView(R.id.select)
    Button select;

    @BindView(R.id.delete)
    Button delete;

    @BindView(R.id.cancel)
    Button cancel;

    @BindView(R.id.ll_slide)
    LinearLayout mLayoutSlide;

    @BindView(R.id.audit_btn)
    Button mBtnAudit;

    private int position;

    private PullToRefreshAdapter recyclerAdapter;

    private int delayMillis = 300;


    private int pegNum = TLiveConfig.COMMON_PAGE_NUM;

    private int startIndex = TLiveConfig.COMMON_PAGE_START;

    private boolean isRefresh;
    private boolean isLoadMore;


    private boolean isItemSelected;

    private boolean mLoadMoreEndGone = true;


    private boolean isOpen;

    private List<ResultListBean> resultListBeen = new ArrayList<>();

    private List<ResultListBean>  listCheck = new ArrayList<>();

    private int totalCounter = 0;

    String json = "{\n" +
            "\t\"resultCode\": 1,\n" +
            "\t\"resultMsg\": \"读取成功\",\n" +
            "\t\"ResultTotal\": \"121\",\n" +
            "\t\"resultList\": [{\n" +
            "\t\t\"media_id\": \"176411\",\n" +
            "\t\t\"title\": \"3456789674688677943\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"4\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180109184071,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}, {\n" +
            "\t\t\"media_id\": \"176411\",\n" +
            "\t\t\"title\": \"3456789674688677943\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"4\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180109184071,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}, {\n" +
            "\t\t\"media_id\": \"175876\",\n" +
            "\t\t\"title\": \"企业视频674688841363\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"93\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180105183508,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}, {\n" +
            "\t\t\"media_id\": \"175876\",\n" +
            "\t\t\"title\": \"企业视频674688841363\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"93\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180105183508,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}, {\n" +
            "\t\t\"media_id\": \"175492\",\n" +
            "\t\t\"title\": \"大连理工大学船舶研发部674688173875\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"15\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180103183119,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}, {\n" +
            "\t\t\"media_id\": \"175492\",\n" +
            "\t\t\"title\": \"大连理工大学船舶研发部674688173875\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"15\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180103183119,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}, {\n" +
            "\t\t\"media_id\": \"175491\",\n" +
            "\t\t\"title\": \"哈尔滨工业大学航天研发中心674688613575\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"15\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180103183118,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}, {\n" +
            "\t\t\"media_id\": \"175491\",\n" +
            "\t\t\"title\": \"哈尔滨工业大学航天研发中心674688613575\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"15\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180103183118,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}, {\n" +
            "\t\t\"media_id\": \"175490\",\n" +
            "\t\t\"title\": \"企业视频图片hhhh674688902240\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"93\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180103183117,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}, {\n" +
            "\t\t\"media_id\": \"175490\",\n" +
            "\t\t\"title\": \"企业视频图片hhhh674688902240\",\n" +
            "\t\t\"vtype\": \"0\",\n" +
            "\t\t\"duration\": \"93\",\n" +
            "\t\t\"make_user_id\": \"小明\",\n" +
            "\t\t\"cp\": \"开发\",\n" +
            "\t\t\"seq_id\": 20180103183117,\n" +
            "\t\t\"check_status\": \"0\",\n" +
            "\t\t\"check_user_id\": \"\",\n" +
            "\t\t\"check_memo\": \"\",\n" +
            "\t\t\"down_status\": \"3\"\n" +
            "\t}]\n" +
            "}";

    public static HomeFragment newInstance(int position) {
        HomeFragment f = new HomeFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
        Log.d("TAG", "onCreate: " + position);
//        0 待审核 1审核通过2审核拒绝
    }


    @Override
    protected void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);


    }

    @Override
    protected View getLoadingTargetView() {
        return mFrameLayout;
    }

    @Override
    protected void initData() {
        initAdapter();
        onAutoRefresh();

    }

    @Override
    protected void OnClick(View v) {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new PullToRefreshAdapter(getActivity(),resultListBeen);
        recyclerAdapter.openLoadAnimation();
        recyclerAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

        recyclerAdapter.setOnLoadMoreListener(this, recyclerView);
//        recyclerAdapter.setLoadMoreView(new CustomLoadMoreView());
        recyclerView.setAdapter(recyclerAdapter);
//        自定义loading 样式
        mSwipeRefreshLayout.setOnRefreshListener(this);

        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<ResultListBean>  resultListBeen = adapter.getData();
                if (StringTool.isListValidate(resultListBeen)){
                    if (isOpen){
                        return;
                    }
//                    ResultListBean resultBean = resultListBeen.get(position);
//                    startActivityForResult("media_id",resultBean.getMedia_id(),
//                            "check_status",resultBean.getCheck_status(),
//                            TLiveConfig.ACTION_NAME,MainActivity.class);
                }
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

                if (!isOpen){
                    isOpen = true;
                    recyclerAdapter.openItemAnimation();
                    setSlide(mLayoutSlide);

                    setNumberText();
                }
            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                List<ResultListBean>  resultListBeen = adapter.getData();
                ResultListBean resultBean = resultListBeen.get(position);
                CheckBox checkbox = view.findViewById(R.id.item_checkbox);
                if (!checkbox.isChecked()){
                    resultBean.setChecked(true);
                    listCheck.add(resultBean);
                }else {
                    resultBean.setChecked(false);
                    listCheck.remove(resultBean);
                }
                setNumberText();
            }

        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){
                    List<ResultListBean> resultList  = recyclerAdapter.getData();
                    int length=resultList.size();
                    for (int i = length-1; i>=0; i--) {
                        ResultListBean resultListBean = resultList.get(i);
                        if (resultListBean.isChecked()) {
                            listCheck.remove(resultListBean);
                            resultList.remove(i);
                            recyclerAdapter.notifyItemRemoved(i);
                            recyclerAdapter.notifyItemRangeChanged(0, resultList.size());
                        }
                    }
                    setNumberText();
                    recyclerAdapter.notifyDataSetChanged();
                }


            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){
                    isOpen = false;
                    recyclerAdapter.closeItemAnimation();
                    setSlide(mLayoutSlide);
                }
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    List<ResultListBean>  resultListBeen  = recyclerAdapter.getData();
                    listCheck.clear();
                    for (int i = 0; i < recyclerAdapter.getData().size(); i++) {
                        ResultListBean resultBean = resultListBeen.get(i);
                        resultBean.setChecked(true);
                        listCheck.add(resultBean);
                    }
                    setNumberText();
                    recyclerAdapter.notifyDataSetChanged();
                }

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {

            case TLiveConfig.ACTION_NAME:
                onAutoRefresh();
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void setNumberText(){
        mBtnAudit.setText("审核"+"(已选"+listCheck.size()+")");
    }



    public void onNext(BaseResponse baseResponse) {
        if (baseResponse instanceof SimpleResponse){
            Gson gson = new Gson();
            SimpleResponse  mDiscoverResponse = gson.fromJson(json,SimpleResponse.class);
            totalCounter = Integer.parseInt(mDiscoverResponse.getResultTotal());

            List<ResultListBean> nodeList = mDiscoverResponse.getResultList();
            if (isItemSelected) {
                listCheck.clear();
                resultListBeen.clear();
                isItemSelected = false;
                recyclerAdapter.notifyDataSetChanged();
                if (StringTool.isListValidate(nodeList)){
                    recyclerAdapter.setNewData(nodeList);
                }
                setNumberText();
            }else{
                if (isRefresh) {
                    listCheck.clear();
                    resultListBeen.clear();
                    isRefresh = false;
                    recyclerAdapter.notifyDataSetChanged();
                    if (StringTool.isListValidate(nodeList)){
                        recyclerAdapter.setNewData(nodeList);
                    }else{
                        recyclerAdapter.setEmptyView(getActivity().
                        getLayoutInflater().inflate(R.layout.empty_view,
                        (ViewGroup) recyclerView.getParent(), false));
                     }
                    setNumberText();
                    mSwipeRefreshLayout.setRefreshing(false);
                }else{
                    if (StringTool.isListValidate(nodeList)) {
                        recyclerAdapter.addData(nodeList);
                    } else if (!isLoadMore) {
                        recyclerAdapter.setEmptyView(getActivity().
                                getLayoutInflater().inflate(R.layout.empty_view,
                                (ViewGroup) recyclerView.getParent(), false));
                    }
                }
            }

            mSwipeRefreshLayout.setRefreshing(false);

        }

    }

    @Override
    public void onRefresh() {

        recyclerAdapter.setEnableLoadMore(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isRefresh = true;
                startIndex = TLiveConfig.COMMON_PAGE_START;
                 onNext(new SimpleResponse());
                recyclerAdapter.setEnableLoadMore(true);
            }
        }, delayMillis);
    }

    private void onAutoRefresh(){
        mSwipeRefreshLayout.setRefreshing(true);
        onRefresh();
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (startIndex >= totalCounter) {
//                    pullToRefreshAdapter.loadMoreEnd();//default visible
                    recyclerAdapter.loadMoreEnd(mLoadMoreEndGone);//true is gone,false is visible
                } else {

                    startIndex += pegNum;
                    isLoadMore = true;
                      onNext(new SimpleResponse());
                    //加载完成
                    recyclerAdapter.loadMoreComplete();
                }
                mSwipeRefreshLayout.setEnabled(true);
            }

        }, delayMillis);
    }



    private void setSlide(LinearLayout linearLayout){
        int finalState = linearLayout.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE;

        if (Build.VERSION.SDK_INT < 21) {
            linearLayout.setVisibility(finalState);
        } else {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.BOTTOM);

            final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getActivity()
                    .findViewById(android.R.id.content)).getChildAt(0);
            TransitionManager.beginDelayedTransition(viewGroup, slide);

            linearLayout.setVisibility(finalState);
        }
    }

}