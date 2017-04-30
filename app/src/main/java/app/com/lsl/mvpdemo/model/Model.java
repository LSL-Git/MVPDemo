package app.com.lsl.mvpdemo.model;

/** model 接口 用来加载数据
 * Created by M1308_000 on 2017/4/30.
 */

public interface Model {

    /**
     * 加载数据
     */
    void loadData(DataOnLoadListener listener);

    /**
     * 用于监听数据加载情况，加载完成则回调
     */
    interface DataOnLoadListener {
        // 回调方法，数据类型看情况而定
        void onComplete(String str);
    }
}
