package cn.carveknife.carveknifewanandroid.ui.wechat

import android.app.DownloadManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cn.carveknife.carveknifewanandroid.base.RequestState
import cn.carveknife.carveknifewanandroid.http.HttpManager
import cn.carveknife.carveknifewanandroid.http.asyncSubscribe

/**
 * description :
 * created time: 2020/12/18 11:42
 * created by: cuibenguang
 */
class WeChatRespository(private val httpManager: HttpManager) {
    fun getWXChapters(): LiveData<RequestState<List<Chapter>>> {
        val liveData = MutableLiveData<RequestState<List<Chapter>>>()
        httpManager.wanApi.getWXChapters()
            .asyncSubscribe({
                liveData.postValue(RequestState.success(it.data))
            }, {
                liveData.postValue(RequestState.error(it.message))
            })
        return liveData
    }
}