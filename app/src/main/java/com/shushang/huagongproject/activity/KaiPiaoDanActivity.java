package com.shushang.huagongproject.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KaiPiaoDanActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line0)
    View mLine0;
    @BindView(R.id.kehumingcheng_text)
    EditText mKehumingchengText;
    @BindView(R.id.kehumingcheng)
    RelativeLayout mKehumingcheng;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.xiadanriqi_text)
    TextView mXiadanriqiText;
    @BindView(R.id.xiadanriqi)
    RelativeLayout mXiadanriqi;
    @BindView(R.id.line_second)
    View mLineSecond;
    @BindView(R.id.dingdanhao_text)
    EditText mDingdanhaoText;
    @BindView(R.id.dingdanhao)
    RelativeLayout mDingdanhao;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.gukecaigoudanhao_text)
    EditText mGukecaigoudanhaoText;
    @BindView(R.id.gukecaigoudanhao)
    RelativeLayout mGukecaigoudanhao;
    @BindView(R.id.line_four)
    View mLineFour;
    @BindView(R.id.fahuoriqi_text)
    TextView mFahuoriqiText;
    @BindView(R.id.fahuoriqi)
    RelativeLayout mFahuoriqi;
    @BindView(R.id.shangpin)
    TextView mShangpin;
    @BindView(R.id.shangpin_title)
    LinearLayout mShangpinTitle;
    @BindView(R.id.line2)
    View mLine2;
    @BindView(R.id.dingdanshangpin)
    TextView mDingdanshangpin;
    @BindView(R.id.dingdanshangpin_text)
    TextView mDingdanshangpinText;
    @BindView(R.id.daitibaodingdan)
    RelativeLayout mDaitibaodingdan;
    @BindView(R.id.fahuo)
    TextView mFahuo;
    @BindView(R.id.fahuo_title)
    LinearLayout mFahuoTitle;
    @BindView(R.id.line4)
    View mLine4;
    @BindView(R.id.fahuodingdanshangpin)
    TextView mFahuodingdanshangpin;
    @BindView(R.id.fahuodingdanshangpin_text)
    TextView mFahuodingdanshangpinText;
    @BindView(R.id.fahuodingdan)
    RelativeLayout mFahuodingdan;
    @BindView(R.id.beizhu_text)
    TextView mBeizhuText;
    @BindView(R.id.beizhu_title)
    LinearLayout mBeizhuTitle;
    @BindView(R.id.line_beizhu)
    View mLineBeizhu;
    @BindView(R.id.beizhu_content)
    EditText mBeizhuContent;
    @BindView(R.id.beizhu)
    RelativeLayout mBeizhu;
    private int select_year, select_mounth, select_day;
    private int now_year, now_mounth, now_day;
    private boolean isData1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_kai_piao_dan;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.xiadanriqi)
    void Date() {
        isData1 = true;
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                KaiPiaoDanActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setAccentColor(getResources().getColor(R.color.colorPrimary));
        dpd.setAutoHighlight(true);
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }


    @OnClick(R.id.fahuoriqi)
    void Date2() {
        isData1 = false;
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                KaiPiaoDanActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setAccentColor(getResources().getColor(R.color.colorPrimary));
        dpd.setAutoHighlight(true);
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 退出activity的动画效果不起作用，要在java代码里写
     * 复写activity的finish方法，在overridePendingTransition中写入自己的动画效果
     */
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        select_year = year;
        select_mounth = monthOfYear + 1;
        select_day = dayOfMonth;
        Log.d("time", select_year + "---------" + select_mounth + "---------" + select_day);
        if (select_year < now_year) {
            ToastUtils.showLong("请选择当前时间以后的年份");
        } else if (select_year == now_year && select_mounth < now_mounth) {
            ToastUtils.showLong("请选择当前时间以后的月份");
        } else if (select_mounth == now_mounth && select_day < now_day) {
            ToastUtils.showLong("请选择当前时间以后的日期");
        } else {
            Calendar now = Calendar.getInstance();
            TimePickerDialog tpd = TimePickerDialog.newInstance(
                    KaiPiaoDanActivity.this,
                    now.get(Calendar.HOUR_OF_DAY),
                    now.get(Calendar.MINUTE),
                    false
            );
            tpd.setAccentColor(Color.parseColor("#2196F3"));
            tpd.setTabIndicators("", "");
            tpd.show(getFragmentManager(), "Timepickerdialog");
        }
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int hourOfDayEnd, int minuteEnd) {
        String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        String time = select_year + "-" + select_mounth + "-" + select_day + " " + hourString + ":" + minuteString + ":00";
        Date date = new Date(select_year - 1900, select_mounth - 1, select_day, hourOfDay, minute, 0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        Log.d("time", simpleDateFormat.format(date));
        if (isData1) {
            mXiadanriqiText.setText(simpleDateFormat.format(date));
        } else {
            mFahuoriqiText.setText(simpleDateFormat.format(date));
        }
    }
}
