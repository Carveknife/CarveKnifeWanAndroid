package cn.carveknife.carveknifewanandroid.ui.wechat

import androidx.lifecycle.ViewModel
import cn.carveknife.carveknifewanandroid.http.HttpManager

/**
 * description :
 * created time: 2020/12/18 11:46
 * created by: cuibenguang
 */
class WeChatModel(private val weChatRespository: WeChatRespository) : ViewModel() {
    val wxChapter = weChatRespository.getWXChapters()
}