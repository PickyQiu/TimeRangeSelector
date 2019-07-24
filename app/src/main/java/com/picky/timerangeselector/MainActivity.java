package com.picky.timerangeselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = findViewById(R.id.textView);
    }

    public void selector(View view) {
        TimeRangeSelectorDialog dialog = new TimeRangeSelectorDialog(MainActivity.this, tvTime.getText().toString(), "00:00", "23:59", new TimeRangeSelectorDialog.ConfirmAction() {
            @Override
            public void onLeftClick() {
            }

            @Override
            public void onRightClick(String startTime, String endTime) {
                tvTime.setText(String.format("%s-%s", startTime, endTime));
            }
        });
        dialog.show();
    }
}
