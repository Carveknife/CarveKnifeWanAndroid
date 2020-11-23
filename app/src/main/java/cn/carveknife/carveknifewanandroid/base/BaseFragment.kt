package cn.carveknife.carveknifewanandroid.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * description :
 * created time: 2020/11/23 16:49
 * created by: cuibenguang
 */
open abstract class BaseFragment<V : ViewBinding> : Fragment() {
    protected lateinit var mViewBinding: V;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initView();
        val root = mViewBinding.root
        return root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun initView()
}