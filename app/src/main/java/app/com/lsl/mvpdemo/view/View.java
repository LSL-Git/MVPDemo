package app.com.lsl.mvpdemo.view;

/** view 接口，用于显示结果
 * Created by M1308_000 on 2017/4/30.
 */

public interface View {

    /**
     * 显示进度条
     */
    void showLoading();

    /**
     * 显示数据
     * @param str
     */
    void showData(String str);
}
