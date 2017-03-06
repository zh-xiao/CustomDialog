package com.example.xiao.customdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomDialog(MainActivity.this, R.layout.dialog_custom, new CustomDialog.OnConfirmListener() {
                    @Override
                    public void onConfirm() {
                        Toast.makeText(MainActivity.this, "confirm", Toast.LENGTH_SHORT).show();
                    }
                }, new CustomDialog.OnCancleListener() {
                    @Override
                    public void onCancle() {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                        .setTitle("this is Title")
                        .setContent("this is Content! this is Content!")
                        .show();
            }
        });
    }
}
