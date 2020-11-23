package cn.carveknife.carveknifewanandroid.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.carveknife.carveknifewanandroid.R
import cn.carveknife.carveknifewanandroid.base.LazyBaseFragment
import cn.carveknife.carveknifewanandroid.databinding.FragmentHomeBinding

class HomeFragment : LazyBaseFragment<FragmentHomeBinding>() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun lazyInit() {

    }

    override fun initView() {
        mViewBinding = FragmentHomeBinding.inflate(LayoutInflater.from(activity))
    }
}