package cn.carveknife.carveknifewanandroid.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * description :
 * created time: 2020/12/10 11:49
 * created by: cuibenguang
 */
class HomeViewModel(respository: HomeDataRepository) : ViewModel() {
    private val pageSize = MutableLiveData<Int>()
//    private val repoResult = Transformations.map() {
//        respository.getArticleData()
//    }
}