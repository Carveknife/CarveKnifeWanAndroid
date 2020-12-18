package cn.carveknife.carveknifewanandroid.base.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource


/**
 * description : 官方文档建议这么写，所以就这么写了！！！
 * created time: 2020/12/17 16:28
 * created by: cuibenguang
 */
abstract class BaseDataSourceFactory<T> : DataSource.Factory<Int, T>() {
    val sourceLiveData by lazy {
        MutableLiveData<BaseItemKeyedDataSource<T>>()
    }

    override fun create(): DataSource<Int, T> {
        val createDataStore = createDataStore();
        sourceLiveData.postValue(createDataStore)
        return createDataStore
    }

    abstract fun createDataStore(): BaseItemKeyedDataSource<T>
}