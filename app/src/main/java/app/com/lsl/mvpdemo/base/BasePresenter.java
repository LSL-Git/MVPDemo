package app.com.lsl.mvpdemo.base;

import java.lang.ref.WeakReference;

/**
 * Created by M1308_000 on 2017/4/30.
 */

public abstract class BasePresenter<T> {

    /**
     * 当内存不足可释放内存
     */
    protected WeakReference<T> mViewRef;

    /**
     * 绑定 view 和 model
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    /**
     * 解除绑定
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    protected T getView() {
        return mViewRef.get();
    }

}
