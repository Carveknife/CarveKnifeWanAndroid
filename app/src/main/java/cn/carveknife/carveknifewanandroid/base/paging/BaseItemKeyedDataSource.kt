package cn.carveknife.carveknifewanandroid.base.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.ItemKeyedDataSource
import cn.carveknife.carveknifewanandroid.util.ExecutorUtils
import cn.carveknife.carveknifewanandroid.base.RequestState

/**
 * description :
 * created time: 2020/12/17 16:31
 * created by: cuibenguang
 */
abstract class BaseItemKeyedDataSource<T> : ItemKeyedDataSource<Int, T>() {
    private var retry: (() -> Any)? = null

    private val retryExecutor = ExecutorUtils.NETWORK_IO

    val loadMoreStatus by lazy {
        MutableLiveData<RequestState<Boolean>>()
    }

    val refreshStatus by lazy {
        MutableLiveData<RequestState<Boolean>>()
    }

    fun retryFailed() {
        val preRetry = retry;
        retry = null
        preRetry.let {
            retryExecutor.execute {
                it?.invoke()
            }
        }
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<T>) {
        refreshStatus.postValue(RequestState.loading())
        onLoadIntial(params, callback)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<T>) {
        loadMoreStatus.postValue(RequestState.loading())
        onLoadAfter(params, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<T>) {
    }

    override fun getKey(item: T) = setKey(item)

    abstract fun setKey(item: T): Int

    abstract fun onLoadAfter(params: LoadParams<Int>, callback: LoadCallback<T>)

    abstract fun onLoadIntial(params: LoadInitialParams<Int>, callback: LoadCallback<T>)

    /**
     * 刷新成功
     */
    fun refreshSuccess(isDataEmpty: Boolean = false) {
        refreshStatus.postValue(RequestState.success(isDataEmpty))
        retry = null
    }

    /**
     * 刷新失败
     */
    fun refreshFailed(msg: String?, params: LoadInitialParams<Int>, callback: LoadInitialCallback<T>) {
        refreshStatus.postValue(RequestState.error())
        retry = {
            loadInitial(params, callback)
        }
    }

    /**
     * 加载更多成功
     */
    fun loadMoreSuccess() {
        retry = null
        loadMoreStatus.postValue(RequestState.success())
    }

    /**
     * 加载更多失败
     */
    fun loadMoreFailed(msg: String?, params: LoadParams<Int>, callback: LoadCallback<T>) {
        loadMoreStatus.postValue(RequestState.error())
        retry = {
            loadAfter(params, callback)
        }
    }
}