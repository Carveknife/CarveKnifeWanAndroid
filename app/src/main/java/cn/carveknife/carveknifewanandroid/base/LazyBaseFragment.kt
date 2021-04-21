package cn.carveknife.carveknifewanandroid.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
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

    fun <T> handleData(requestState: LiveData<RequestState<T>>?, action: (T) -> Unit) {
        requestState?.observe(this, Observer {
            if (it.isLoading()) {

            } else if (it.isSuccess()) {
                if (it?.data != null) {
                    action(it.data)
                } else {

                }
            } else if (it.isError()) {

            }
        })
    }
}