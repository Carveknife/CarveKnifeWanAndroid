package cn.carveknife.carveknifewanandroid.base

import androidx.viewbinding.ViewBinding

/**
 * description :
 * created time: 2020/11/23 16:54
 * created by: cuibenguang
 */
abstract class LazyBaseFragment<V : ViewBinding> : BaseFragment<V>() {
    private var isLoaded = false;
    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            lazyInit();
            isLoaded = true
        }
    }

    abstract fun lazyInit();
}