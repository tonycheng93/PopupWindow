package com.tony.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

    private Button mShowPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowPopupWindow = (Button) findViewById(R.id.btn_click);
        mShowPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow();
            }
        });
    }

    private void showPopupWindow() {
//        View parent = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
        View parent = this.getWindow().getDecorView();
        View popView = View.inflate(this, R.layout.camera_pop_menu, null);
        Button btnCamera = (Button) popView.findViewById(R.id.btn_camera_pop_camera);
        Button btnAlbum = (Button) popView.findViewById(R.id.btn_camera_pop_album);
        Button btnCancle = (Button) popView.findViewById(R.id.btn_camera_pop_cancle);

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        final PopupWindow popupWindow = new PopupWindow(popView, width, height);
        popupWindow.setAnimationStyle(R.style.AnimBottom);
        ColorDrawable dw = new ColorDrawable(0x30000000);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);//设置允许在外点击消失
        popupWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_camera_pop_camera:
                        break;
                    case R.id.btn_camera_pop_album:
                        break;
                    case R.id.btn_camera_pop_cancle:
                        popupWindow.dismiss();
                        break;
                    default:
                        break;
                }
            }
        };
        btnCamera.setOnClickListener(listener);
        btnAlbum.setOnClickListener(listener);
        btnCancle.setOnClickListener(listener);
    }


}
