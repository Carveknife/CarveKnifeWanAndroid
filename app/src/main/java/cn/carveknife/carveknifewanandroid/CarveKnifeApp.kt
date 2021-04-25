package cn.carveknife.carveknifewanandroid

import android.app.Application
import com.blankj.utilcode.util.Utils
import dagger.hilt.android.HiltAndroidApp

/**
 * description :
 * created time: 2020/11/18 16:12
 * created by: cuibenguang
 */
class CarveKnifeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initUtils();
    }

    private fun initUtils() {
        Utils.init(this)
    }
}