package cn.carveknife.carveknifewanandroid.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.carveknife.carveknifewanandroid.data.BaseViewModel
import cn.carveknife.carveknifewanandroid.data.CraveKnifeNetRequestException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * description :
 * created time: 2020/12/10 11:49
 * created by: cuibenguang
 */
class HomeViewModel(respository: HomeDataRepository) : BaseViewModel() {
    private var mRespository: HomeDataRepository
    val articleValue: MutableLiveData<Article> = MutableLiveData()
    val size: MutableLiveData<Int> = MutableLiveData()


    init {
        this.mRespository = respository
        requesArticleDatas()
    }

    fun requesArticleDatas() {
        mRespository.getArticleData(size.value ?: 0, object : NetResponseCallback<Article> {
            override fun loadSuccess(t: Article?) {
                Log.i("shuangji",t?.curPage.toString())
                articleValue.postValue(t)
            }

            override fun loadError(craveKnifeNetRequestException: CraveKnifeNetRequestException) {
                mCraveKnifeNetRequestException.postValue(craveKnifeNetRequestException)
            }
        })
    }

}