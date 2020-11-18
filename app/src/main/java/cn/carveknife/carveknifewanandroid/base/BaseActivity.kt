package cn.carveknife.carveknifewanandroid.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * description :
 * created time: 2020/11/18 11:48
 * created by: cuibenguang
 */
abstract class BaseActivity<V : ViewBinding> : AppCompatActivity() {
    protected lateinit var mViewBinding: V;
    override fun onCreate(savedInstanceState: Bundle?) {
        setOrientataion();
        super.onCreate(savedInstanceState)
        initViewBinding();
        setContentView(mViewBinding?.root)
    }

    private fun setOrientataion() {
        if (isLandscapeOrientation()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    protected fun isLandscapeOrientation(): Boolean = true

    abstract fun initViewBinding()

    protected fun getContext(): Context = this

}