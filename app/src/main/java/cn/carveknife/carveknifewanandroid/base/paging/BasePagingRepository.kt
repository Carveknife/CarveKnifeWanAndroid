package cn.carveknife.carveknifewanandroid.base.paging

import androidx.lifecycle.Transformations
import androidx.paging.Config
import androidx.paging.toLiveData

/**
 * description :
 * created time: 2020/12/17 16:47
 * created by: cuibenguang
 */
abstract class BasePagingRepository<T> {
    fun getData(pageSize: Int): Listing<T> {
        val factory = createDataBaseFactory()
        val pageListLiveData = factory.toLiveData(
            config = Config(
                pageSize = pageSize,
                enablePlaceholders = false,
                initialLoadSizeHint = pageSize * 2
            )
        )

        val refreshState = Transformations.switchMap(factory.sourceLiveData) {
            it.refreshStatus
        }
        val networkStatus = Transformations.switchMap(factory.sourceLiveData) {
            it.loadMoreStatus
        }

        return Listing(
            pageListLiveData,
            networkStatus,
            refreshState,
            refresh = {
                factory.sourceLiveData.value?.invalidate()
            },
            retry = {
                factory.sourceLiveData.value?.retryFailed()
            })
    }

    abstract fun createDataBaseFactory(): BaseDataSourceFactory<T>
}