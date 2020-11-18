package cn.carveknife.carveknifewanandroid.module

import android.content.Context
import cn.carveknife.carveknifewanandroid.MainActivity

/**
 * description :
 * created time: 2020/11/18 16:04
 * created by: cuibenguang
 */
object Router {
    public fun routeToMain(context: Context) {
        val callingIntent = MainActivity.getCallingIntent(context)
        context.startActivity(callingIntent)
    }
}