package app.com.lsl.mvpdemo.presenter;

import app.com.lsl.mvpdemo.model.DataModelV2;
import app.com.lsl.mvpdemo.model.Model;
import app.com.lsl.mvpdemo.view.View;

/** data presenter 中间者
 * Created by M1308_000 on 2017/4/30.
 */

public class DataPresenterV2 {

    // view
    View mView;

    // model
    Model mModel = new DataModelV2();

    /**
     * 通过构造方法实例化 mView
     * @param mView
     */
    public DataPresenterV2(View mView) {
        super();
        this.mView = mView;
    }

    /**
     * 绑定 view 和 model
     */
    public void fetch() {
        // 显示进度条
        mView.showLoading();
        // 让model 加载数据
        if (mModel != null) {
            mModel.loadData(new Model.DataOnLoadListener() {
                @Override
                public void onComplete(String str) {
                    // 将数据返回view显示
                    mView.showData(str);
                }
            });
        }
    }
}
