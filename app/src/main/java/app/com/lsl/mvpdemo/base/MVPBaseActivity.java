package app.com.lsl.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by M1308_000 on 2017/4/30.
 */

public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends Activity {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建presenter
        mPresenter = createPresenter();
        // 内存泄漏
        // 关联view
        mPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解除关联
        mPresenter.detachView();
    }

    /**
     * 创建 presenter
     * @return
     */
    protected abstract T createPresenter();
}
