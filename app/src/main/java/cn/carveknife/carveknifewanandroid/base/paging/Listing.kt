package cn.carveknife.carveknifewanandroid.base.paging

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import cn.carveknife.carveknifewanandroid.base.RequestState

/**
 * description :
 * created time: 2020/12/17 16:48
 * created by: cuibenguang
 */
data class Listing<T>(
    val pagedList: LiveData<PagedList<T>>,
    val networkState: LiveData<RequestState<Boolean>>,
    val refeshState: LiveData<RequestState<Boolean>>,
    val refresh: () -> Unit,
    val retry: () -> Unit
) {
}