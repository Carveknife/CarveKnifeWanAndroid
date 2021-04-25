package cn.carveknife.carveknifewanandroid.ui.wechat

import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.carveknife.carveknifewanandroid.base.LazyBaseFragment
import cn.carveknife.carveknifewanandroid.databinding.FragmentWechatBinding
import cn.carveknife.carveknifewanandroid.http.HttpManager
import cn.carveknife.carveknifewanandroid.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * description :90
 * created time: 2020/11/23 17:36
 * created by: cuibenguang
 */
class WechatFragment:LazyBaseFragment<FragmentWechatBinding>() {

    private val viewModel by lazy {
        @Suppress("UNCHECKED_CAST")
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val weChatRepository = WeChatRespository(
                        HttpManager.getInstance()
                    )
                return WeChatModel(
                    weChatRepository
                ) as T
            }

        }).get(WeChatModel::class.java);
    }

    override fun initView() {
        mViewBinding = FragmentWechatBinding.inflate(LayoutInflater.from(activity))
    }

    override fun lazyInit() {

    }
}