package cn.carveknife.carveknifewanandroid.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * description :
 * created time: 2020/12/10 11:49
 * created by: cuibenguang
 */
class HomeViewModel(respository: HomeDataRepository) : ViewModel() {
    val articleValue: MutableLiveData<Article> = MutableLiveData()
    private val size: Int = 0

    init {
        viewModelScope.launch {
            val article = withContext(Dispatchers.IO) {
                respository.getArticleData(size)
            }
            articleValue.postValue(article)
        }
    }

}