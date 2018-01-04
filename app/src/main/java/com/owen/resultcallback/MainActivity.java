package com.owen.resultcallback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.owen.result.AvoidOnResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.trigger_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AvoidOnResult(MainActivity.this).startForResult(FetchDateActivity.class, 10, new AvoidOnResult.Callback() {
                    @Override
                    public void onActivityResult(int requestCode, int resultCode, Intent data) {
                        Toast.makeText(MainActivity.this, "result:" + data.getStringExtra("result"), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String text = data.getStringExtra("result");
        Toast.makeText(this, "result:" + text, Toast.LENGTH_LONG).show();
    }
}
