package com.ckt.test.customerdraw.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ckt.test.customerdraw.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mDrawCircleButton;
    private Button mButton1_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawCircleButton = (Button) findViewById(R.id.btn_drawCircle);
        mDrawCircleButton.setOnClickListener(this);
        mButton1_2 = (Button) findViewById(R.id.btn_1_2);
        mButton1_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_drawCircle:
                startActivity(new Intent(this, DrawCircleActivity.class));
                break;
            case R.id.btn_1_2:
                startActivity(new Intent(this, CustomerView_1_2.class));
                break;
        }
    }
}
