package app.com.lsl.mvpdemo.model;

import android.os.Handler;
import android.os.Message;

/** 第一种数据加载方式
 * Created by M1308_000 on 2017/4/30.
 */

public class DataModelV1 implements Model {

    private String[] data;

    @Override
    public void loadData(final DataOnLoadListener listener) {
        data = new String[]{"DataModel 第一种加载数据方式"};

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    // 模拟线程耗时为3秒
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 数据处理
                data[0] += " V1";

                Message msg = new Message();
                msg.obj = listener;
                handler.sendMessage(msg);
            }
        }).start();

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            DataOnLoadListener listener = (DataOnLoadListener) msg.obj;
            // 回调数据结果
            listener.onComplete(data[0]);
        }
    };

}
