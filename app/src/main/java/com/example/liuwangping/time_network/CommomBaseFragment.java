package com.example.liuwangping.time_network;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public abstract class CommomBaseFragment extends Fragment
{

    private View mRootview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        /**
         * 加载布局
         * viewpager和fragment一起使用, fragment切换时, fragment的生命周期会在 onCreateView --> onDestroyView 之间调用
         * 这样会造成布局重绘, 无法保持Fagment原有的状态, 所以需要如下操作
         */
        if (null == mRootview)
        {
            mRootview = inflater.inflate(getLayoutID(), container, false);
        }
        ViewGroup mViewGroup = (ViewGroup) mRootview.getParent();
        if (mViewGroup != null) {
            mViewGroup.removeView(mRootview);
        }

        return mRootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
//        ButterKnife.bind(this, mRootview);
        //初始化操作
        initView(mRootview);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View rootview);

    protected abstract int getLayoutID();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);

    }

    private OnClickListener reloadClickListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            initData();
        }
    };

    public void finish()
    {
        getActivity().finish();
    }

}
