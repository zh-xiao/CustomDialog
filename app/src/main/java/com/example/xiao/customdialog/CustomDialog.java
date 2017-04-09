package com.example.xiao.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xiao on 2017/3/1.
 */

public class CustomDialog extends Dialog {

    private TextView mTitle;
    private TextView mContent;
    private Button mCancel;
    private Button mConfirm;

    private int mLayoutId;
    private OnConfirmListener mConfirmListener;
    private OnCancleListener mCancelListener;
    private String mTitleString;
    private String mContentString;

    /**
     * 构造方法
     * @param context
     * @param layoutId 布局文件id
     * @param confirmListener 点击确定对应的监听器
     * @param cancelListener 点击取消对应的监听器
     */
    public CustomDialog(Context context,int layoutId,OnConfirmListener confirmListener,OnCancleListener cancelListener) {
        super(context, R.style.MyDialog);
        mConfirmListener=confirmListener;
        mCancelListener=cancelListener;
        mLayoutId=layoutId;
    }

    //点击确定对应的监听器
    public interface OnConfirmListener {
        void onConfirm();
    }

    //点击取消对应的监听器
    public interface OnCancleListener {
        void onCancle();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mLayoutId);
        mTitle= (TextView) findViewById(R.id.title);
        mContent= (TextView) findViewById(R.id.content);
        mCancel = (Button) findViewById(R.id.cancle);
        mConfirm= (Button) findViewById(R.id.confirm);
        mTitle.setText(mTitleString);
        mContent.setText(mContentString);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCancelListener.onCancle();
            }
        });
        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConfirmListener.onConfirm();
            }
        });
    }

    /**
     * 设置对话框标题
     * @param title
     * @return
     */
    public CustomDialog setTitle(String title){
        mTitleString=title;
        return this;
    }

    /**
     * 设置对话框内容
     * @param content
     * @return
     */
    public CustomDialog setContent(String content){
        mContentString=content;
        return this;
    }

}
