package cn.carveknife.carveknifewanandroid.ui.home

import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.carveknife.carveknifewanandroid.base.LazyBaseFragment
import cn.carveknife.carveknifewanandroid.databinding.FragmentHomeBinding
import cn.carveknife.carveknifewanandroid.http.HttpManager

class HomeFragment : LazyBaseFragment<FragmentHomeBinding>() {
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel by lazy {
        @Suppress("UNCHECKED_CAST")
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val homeRepository =
                    HomeRepository(
                        HttpManager.getInstance()
                    )
                return HomeViewModel(
                    homeRepository
                ) as T
            }

        }).get(HomeViewModel::class.java);
    }

    override fun initView() {
        mViewBinding = FragmentHomeBinding.inflate(LayoutInflater.from(activity))
    }

    override fun lazyInit() {
        viewModel.run {
            resResult.observe(viewLifecycleOwner, Observer {

            })
        }

    }
}