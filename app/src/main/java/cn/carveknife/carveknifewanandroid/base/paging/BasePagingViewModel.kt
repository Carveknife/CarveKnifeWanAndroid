package cn.carveknife.carveknifewanandroid.base.paging

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * description :
 * created time: 2020/12/17 17:06
 * created by: cuibenguang
 */
open class BasePagingViewModel<T>(respository: BasePagingRepository<T>) : ViewModel() {
    private val pageSize = MutableLiveData<Int>()

    private val repoResult = Transformations.map(pageSize) {
        respository.getData(it)
    }

    val pageList = Transformations.switchMap(repoResult) {
        it.pagedList
    }

    val networkState = Transformations.switchMap(repoResult) {
        it.networkState
    }

    val result = Transformations.switchMap(repoResult) {
        it.refeshState
    }

    fun refresh() {
        repoResult.value?.refresh?.invoke()
    }

    fun initLoad(newSize: Int = 10): Boolean {
        if (pageSize.value == newSize) {
            return false
        }
        pageSize.value = newSize
        return true
    }

    fun retry() {
        repoResult.value?.retry?.invoke()
    }
}