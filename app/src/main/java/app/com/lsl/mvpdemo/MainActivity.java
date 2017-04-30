package app.com.lsl.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app.com.lsl.mvpdemo.presenter.DataPresenterV1;
import app.com.lsl.mvpdemo.presenter.DataPresenterV2;
import app.com.lsl.mvpdemo.view.View;

public class MainActivity extends AppCompatActivity implements View, android.view.View.OnClickListener{

    private TextView tvShow;
    private Button button2;
    private Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button1 = (Button) findViewById(R.id.but_v1);
        button2 = (Button) findViewById(R.id.but_v2);
        tvShow = (TextView) findViewById(R.id.tv_show);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "正在拼命加载中...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(String str) {
        Log.e("MainActivity","回调结果：" + str);
        tvShow.setText(str);
        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(android.view.View view) {
        switch (view.getId()) {
            case R.id.but_v1:
                tvShow.setText("");
                // 中间者
                new DataPresenterV1(this).fetch();

                break;
            case R.id.but_v2:
                tvShow.setText("");
                // 中间者
                new DataPresenterV2(this).fetch();
                break;
        }
    }
}
