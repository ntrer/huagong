package com.shushang.huagongproject.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.shushang.huagongproject.Bean.Image;
import com.shushang.huagongproject.Bean.KeHu;
import com.shushang.huagongproject.Bean.XinZengRenYuan;
import com.shushang.huagongproject.LoginActivity;
import com.shushang.huagongproject.R;
import com.shushang.huagongproject.base.BaseActivity;
import com.shushang.huagongproject.base.BaseUrl;
import com.shushang.huagongproject.base.MessageEvent;
import com.shushang.huagongproject.ui.ActionSheetDialog;
import com.shushang.huagongproject.ui.ExtAlertDialog;
import com.shushang.huagongproject.utils.Json.JSONUtil;
import com.shushang.huagongproject.utils.OkhttpUtils.CallBackUtil;
import com.shushang.huagongproject.utils.OkhttpUtils.OkhttpUtil;
import com.shushang.huagongproject.utils.SharePreferences.PreferencesUtils;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;

import org.greenrobot.eventbus.EventBus;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EditKeHuXinXiActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jichuxinxi)
    TextView mJichuxinxi;
    @BindView(R.id.jichuxinxi_title)
    LinearLayout mJichuxinxiTitle;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.mingcheng_text)
    TextView mMingchengText;
    @BindView(R.id.mingcheng)
    RelativeLayout mMingcheng;
    @BindView(R.id.line_third)
    View mLineThird;
    @BindView(R.id.lianxiren_text)
    TextView mLianxirenText;
    @BindView(R.id.lianxiren)
    RelativeLayout mLianxiren;
    @BindView(R.id.line_four)
    View mLineFour;
    @BindView(R.id.lianxirendianhua_text)
    TextView mLianxirendianhuaText;
    @BindView(R.id.lianxirendianhua)
    RelativeLayout mLianxirendianhua;
    @BindView(R.id.line_seven)
    View mLineSeven;
    @BindView(R.id.address_text)
    TextView mAddressText;
    @BindView(R.id.address)
    RelativeLayout mAddress;
    @BindView(R.id.line_eight)
    View mLineEight;
    @BindView(R.id.picture_text)
    TextView mPictureText;
    @BindView(R.id.picture)
    RelativeLayout mPicture;
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
    @BindView(R.id.submit)
    Button mSubmit;
    @BindView(R.id.line_nine)
    View mLineNine;
    @BindView(R.id.isStart)
    Switch mIsStart;
    @BindView(R.id.qiyong)
    RelativeLayout mQiyong;


    private Image mImage;
    private Dialog mRequestDialog;
    private ArrayList<AlbumFile> mAlbumFiles = new ArrayList<>();
    private ImageView mImageView, mImageView2;
    private Uri fileUri = null;
    private File imgFile;
    private Bitmap mBitmap;
    private Bitmap newBitmap;
    private List<Bitmap> mapList = new ArrayList<>();
    private List<Bitmap> NewmapList = new ArrayList<>();
    private List<File> mapFile = new ArrayList<>();
    private ArrayList<String> img = new ArrayList<>();
    private String imgIds = "";
    private KeHu.DataBean mDataBean;
    private String BuyerTitle, Address, AddressMobile, AddressRealName, Note,BuyerId;
    private String Active="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        //设置支持toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRequestDialog = ExtAlertDialog.creatRequestDialog(this, getString(R.string.submit));
        mRequestDialog.setCancelable(false);
        try {
            mDataBean = (KeHu.DataBean) getIntent().getSerializableExtra("data");
            mMingchengText.setText(mDataBean.getBuyerTitle());
            mAddressText.setText(mDataBean.getAddress());
            mLianxirendianhuaText.setText(mDataBean.getAddressMobile());
            mLianxirenText.setText(mDataBean.getAddressRealName());
            BuyerId=mDataBean.getBuyerId();
            if(mDataBean.isActive()){
                Active="1";
                mIsStart.setChecked(true);
            }
            else {
                Active="0";
                mIsStart.setChecked(false);
            }
            if (mDataBean.getBusinessLicenceImage() != null) {
                img.clear();
                imgIds = mDataBean.getBusinessLicenceImage();
                img.add(imgIds);
            } else {
                mPictureText.setText("暂无图片上传");
            }
            if (mDataBean.getNote() != null) {
                mBeizhuContent.setText(mDataBean.getNote().toString());
            }
        } catch (Exception e) {
            ToastUtils.showLong(e.toString());
        }

        mIsStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Active="1";
                }
                else {
                    Active="0";
                }
            }
        });
    }

    @Override
    public int setLayout() {
        return R.layout.activity_edit_ke_hu_xin_xi;
    }

    @Override
    public void init() {

    }


    @OnClick(R.id.picture)
    void Picture() {
        if (mPictureText.getText().equals("暂无图片上传")) {
            mAlbumFiles.clear();
            Album.image(EditKeHuXinXiActivity.this) // Image selection.
                    .multipleChoice()
                    .camera(true)
                    .columnCount(3)
                    .selectCount(1)
                    .checkedList(mAlbumFiles)
                    .onResult(new Action<ArrayList<AlbumFile>>() {
                        @Override
                        public void onAction(@NonNull ArrayList<AlbumFile> result) {
                            mAlbumFiles = result;
                            getBitmap(mAlbumFiles);
                            mPictureText.setText("已选择" + mAlbumFiles.size() + "张图片");
                        }
                    })
                    .onCancel(new Action<String>() {
                        @Override
                        public void onAction(@NonNull String result) {
                        }
                    })
                    .start();
        } else {
            new ActionSheetDialog(EditKeHuXinXiActivity.this)
                    .builder()
                    .setCancelable(false)
                    .setCanceledOnTouchOutside(true)
                    .addSheetItem("查看", ActionSheetDialog.SheetItemColor.Blue,
                            new ActionSheetDialog.OnSheetItemClickListener() {
                                @Override
                                public void onClick(int which) {
                                    Intent intent = new Intent(EditKeHuXinXiActivity.this, PhotoViewActivity.class);
                                    intent.putStringArrayListExtra("showphoto", img);
                                    startActivity(intent);
                                }
                            })
                    .addSheetItem("重新上传", ActionSheetDialog.SheetItemColor.Blue,
                            new ActionSheetDialog.OnSheetItemClickListener() {
                                @Override
                                public void onClick(int which) {
                                    mAlbumFiles.clear();
                                    Album.image(EditKeHuXinXiActivity.this) // Image selection.
                                            .multipleChoice()
                                            .camera(true)
                                            .columnCount(3)
                                            .selectCount(1)
                                            .checkedList(mAlbumFiles)
                                            .onResult(new Action<ArrayList<AlbumFile>>() {
                                                @Override
                                                public void onAction(@NonNull ArrayList<AlbumFile> result) {
                                                    mAlbumFiles = result;
                                                    getBitmap(mAlbumFiles);
                                                    mPictureText.setText("已选择" + mAlbumFiles.size() + "张图片");
                                                }
                                            })
                                            .onCancel(new Action<String>() {
                                                @Override
                                                public void onAction(@NonNull String result) {
                                                }
                                            })
                                            .start();
                                }
                            })
                    .show();
        }

    }


    @OnClick(R.id.mingcheng_text)
    void EditName() {
        ExtAlertDialog.showEditDlg(EditKeHuXinXiActivity.this, "修改名字", "修改", false, new ExtAlertDialog.IExtDlgClick2() {
            @Override
            public void Oclick(int result, Editable text) {
                if (result == 1) {
                    if (text == null) {
                        mMingchengText.setText("");
                    } else {
                        mMingchengText.setText(text);
                    }
                }
            }
        });
    }

    @OnClick(R.id.lianxirendianhua_text)
    void EditLianxirenDianHua() {
        ExtAlertDialog.showEditDlg(EditKeHuXinXiActivity.this, "修改联系人电话", "修改", false, new ExtAlertDialog.IExtDlgClick2() {
            @Override
            public void Oclick(int result, Editable text) {
                if (result == 1) {
                    if (text == null) {
                        mLianxirendianhuaText.setText("");
                    } else {
                        mLianxirendianhuaText.setText(text);
                    }
                }
            }
        });
    }


    @OnClick(R.id.lianxiren_text)
    void EditLianxiren() {
        ExtAlertDialog.showEditDlg(EditKeHuXinXiActivity.this, "修改联系人", "修改", false, new ExtAlertDialog.IExtDlgClick2() {
            @Override
            public void Oclick(int result, Editable text) {
                if (result == 1) {
                    if (text == null) {
                        mLianxirenText.setText("");
                    } else {
                        mLianxirenText.setText(text);
                    }
                }
            }
        });
    }

    @OnClick(R.id.address_text)
    void EditAddress() {
        ExtAlertDialog.showEditDlg(EditKeHuXinXiActivity.this, "修改收货地址", "修改", false, new ExtAlertDialog.IExtDlgClick2() {
            @Override
            public void Oclick(int result, Editable text) {
                if (result == 1) {
                    if (text == null) {
                        mAddressText.setText("");
                    } else {
                        mAddressText.setText(text);
                    }
                }
            }
        });
    }


    @OnClick(R.id.qiyong)
    void EditQiyong() {
        if(Active.equals("0")){
            mIsStart.setChecked(true);
        }
        else {
            mIsStart.setChecked(false);
        }
    }


    private void getBitmap(ArrayList<AlbumFile> albumFiles) {
        try {
            NewmapList.clear();
            mapFile.clear();
            for (int i = 0; i < albumFiles.size(); i++) {
                mBitmap = getSmallBitmap(albumFiles.get(i).getPath());
                int bitmapDegree = getBitmapDegree(albumFiles.get(i).getPath());
                newBitmap = rotateBitmapByDegree(mBitmap, bitmapDegree);
                NewmapList.add(newBitmap);
            }

            for (int j = 0; j < NewmapList.size(); j++) {
                File file = getFile(NewmapList.get(j));
                mapFile.add(file);
            }
            upLoadImg(mapFile);
        } catch (Exception e) {
            ToastUtils.showLong("" + e);
        }
    }


    private void upLoadImg(List<File> mapFile) {
        imgIds = "";
        Log.d("mapFile", mapFile.size() + "");
        String url = BaseUrl.BASE_URL + "Upload/Image";
        OkHttpClient client = new OkHttpClient();
        // form 表单形式上传
        for (int i = 0; i < mapFile.size(); i++) {
            Log.d("上传", mapFile.get(i).getName());
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            builder.addFormDataPart("zhaopian", mapFile.get(i).getName(), RequestBody.create(MediaType.parse("image/*"), mapFile.get(i)));
            RequestBody body = builder.build();
            final Request request = new Request.Builder().url(url).post(body).build();
            try {
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        mImage = JSONUtil.fromJson(response.body().string(), Image.class);
                        if (mImage.getCode() == 0) {
                            if (mRequestDialog != null && mRequestDialog.isShowing()) {
                                mRequestDialog.dismiss();
                            }
                            imgIds = mImage.getData().get(0);
                            img.clear();
                            img.add(imgIds);
                        } else if (mImage.getCode() == 101) {
                            if (mRequestDialog != null && mRequestDialog.isShowing()) {
                                mRequestDialog.dismiss();
                            }
                            ToastUtils.showLong(mImage.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call call, IOException e) {
                        if (mRequestDialog != null && mRequestDialog.isShowing()) {
                            mRequestDialog.dismiss();
                        }
                        Log.d("上传失败", e.toString());
                    }
                });
            } catch (Exception e) {
                if (mRequestDialog != null && mRequestDialog.isShowing()) {
                    mRequestDialog.dismiss();
                }
                ToastUtils.showLong("上传失败");
            }

        }

    }


    public static Bitmap getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;//只解析图片边沿，获取宽高
        BitmapFactory.decodeFile(filePath, options);
        // 计算缩放比
        options.inSampleSize = calculateInSampleSize(options, 480, 800);
        // 完整解析图片返回bitmap
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }


    /**
     * 获取图片的旋转角度
     *
     * @param path 图片绝对路径
     * @return 图片的旋转角度
     */
    public static int getBitmapDegree(String path) {
        int degree = 0;
        try {
            // 从指定路径下读取图片，并获取其EXIF信息
            ExifInterface exifInterface = new ExifInterface(path);
            // 获取图片的旋转信息
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 将图片按照指定的角度进行旋转
     *
     * @param bitmap 需要旋转的图片
     * @param degree 指定的旋转角度
     * @return 旋转后的图片
     */
    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int degree) {
        if (bitmap != null) {
            // 根据旋转角度，生成旋转矩阵
            Matrix matrix = new Matrix();
            matrix.postRotate(degree);
            // 将原始图片按照旋转矩阵进行旋转，并得到新的图片
            Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
//        if (bitmap != null & !bitmap.isRecycled()) {
//            bitmap.recycle();
//        }
            return newBitmap;
        } else {
            return null;
        }

    }


    private File getFile(Bitmap bitmap) {
        String pictureDir = "";
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ByteArrayOutputStream baos = null;
        File file = null;
        try {
            baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] byteArray = baos.toByteArray();
            String saveDir = Environment.getExternalStorageDirectory()
                    + "/dreamtownImage";
            File dir = new File(saveDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            file = new File(saveDir, "photo.jpg");
            file.delete();
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(byteArray);
            pictureDir = file.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        return file;
    }


    @OnClick(R.id.submit)
    void Submit() {
        BuyerTitle = mMingchengText.getText().toString();
        Address = mAddressText.getText().toString();
        AddressMobile = mLianxirendianhuaText.getText().toString();
        AddressRealName = mLianxirenText.getText().toString();
        Note = mBeizhuContent.getText().toString();
        if (!isMobileNO(AddressMobile)) {
            ToastUtils.showLong("手机号不合法");
            return;
        } else if (BuyerTitle.equals("") || Address.equals("") || AddressMobile.equals("") || AddressRealName.equals("")) {
            Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show();
            return;
        }
        mRequestDialog.show();
        postData();
    }

    private void postData() {
        String url = BaseUrl.BASE_URL + "Buyer/EditBuyer?tid=" + BaseUrl.TOKEN;
        Log.d("创建活动", url);
        Map<String, String> params = new HashMap<>();
        params.put("BuyerId", BuyerId);
        params.put("BuyerTitle", BuyerTitle);
        params.put("Address", Address);
        params.put("AddressMobile",AddressMobile);
        params.put("AddressRealName",AddressRealName);
        if(imgIds!=null){
            params.put("BusinessLicenceImage",imgIds);
        }
        else {
            params.put("BusinessLicenceImage","");
        }
        if(Note!=null){
            params.put("Note", Note);
        }
        else {
            params.put("Note", "");
        }
        if(Active.equals("1")){
            params.put("Active","True");
        }
        else {
            params.put("Active","False");
        }

        OkhttpUtil.okHttpPost(url, params, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                if (mRequestDialog != null && mRequestDialog.isShowing()) {
                    mRequestDialog.dismiss();
                }
                ToastUtils.showLong(e.toString());
            }

            @Override
            public void onResponse(String response) {
                Log.d("创建活动", response);
                if (response != null) {
                    try {
                        XinZengRenYuan response1 = JSONUtil.fromJson(response, XinZengRenYuan.class);
                        if (response1.getCode() == 0) {
                            if (mRequestDialog != null && mRequestDialog.isShowing()) {
                                mRequestDialog.dismiss();
                            }
                            EventBus.getDefault().post(new MessageEvent("客户"));
                            finish();
                        } else if (response1.getCode() == -5) {
                            if (mRequestDialog != null && mRequestDialog.isShowing()) {
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(EditKeHuXinXiActivity.this, "" + response1.getMessage(), Toast.LENGTH_SHORT).show();
                        } else if (response1.getCode() == 101) {
                            Toast.makeText(EditKeHuXinXiActivity.this, "" + response1.getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            PreferencesUtils.putString(EditKeHuXinXiActivity.this, "token_id", null);
                            startActivity(new Intent(EditKeHuXinXiActivity.this, LoginActivity.class));
                            finish();
                        } else {
                            if (mRequestDialog != null && mRequestDialog.isShowing()) {
                                mRequestDialog.dismiss();
                            }
                            Toast.makeText(EditKeHuXinXiActivity.this, "" + response1.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        ToastUtils.showLong(e.toString());
                    }

                }

            }
        });
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


    public static boolean isMobileNO(String mobiles) {
        /*
        移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
        联通：130、131、132、152、155、156、185、186
        电信：133、153、180、189、（1349卫通）
        总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
        */
        String telRegex = "[1][123456789]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }
}
