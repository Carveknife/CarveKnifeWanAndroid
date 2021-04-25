package cn.carveknife.carveknifewanandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import cn.carveknife.carveknifewanandroid.base.BaseActivity
import cn.carveknife.carveknifewanandroid.databinding.ActivityMainBinding
import cn.carveknife.carveknifewanandroid.ui.home.HomeFragment
import cn.carveknife.carveknifewanandroid.ui.knowledge.KnowledgeFragment
import cn.carveknife.carveknifewanandroid.ui.navigation.NavigationFragment
import cn.carveknife.carveknifewanandroid.ui.project.ProjectFragment
import cn.carveknife.carveknifewanandroid.ui.wechat.WechatFragment
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var lastExitTime: Long = 0L
    private val mFragments by lazy {
        listOf(
            HomeFragment(),
            WechatFragment(),
            ProjectFragment(),
            NavigationFragment(),
            KnowledgeFragment()
        )
    }

    companion object {
        private val BOTTOM_NAVIGATION_NAMES = arrayListOf("首页", "公众号", "项目", "导航", "知识体系")
        private val HOME_PAGE: Int = 0
        private val WECHAT_PAGE: Int = 1
        private val PROJECT_PAGE: Int = 2
        private val NAVIGATION_PAGE: Int = 3
        private val KNOWLEDAGE_PAGE: Int = 4

        internal fun getCallingIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun initViewBinding() {
        mViewBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView();
        displayCurrentFragment(HOME_PAGE)
    }

    private fun initView() {
        val appBar = mViewBinding.appBar
        setSupportActionBar(appBar.toolbar)
        initBottomNavigation();
    }

    private fun initBottomNavigation() {
        mViewBinding.bottomNavigationView.let {
            it.labelVisibilityMode =
                LabelVisibilityMode.LABEL_VISIBILITY_LABELED
            it.setOnNavigationItemSelectedListener(object :
                BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.home -> {
                            displayTitle(BOTTOM_NAVIGATION_NAMES[0])
                            displayCurrentFragment(HOME_PAGE)
                        }
                        R.id.wechat -> {
                            displayTitle(BOTTOM_NAVIGATION_NAMES[1])
                            displayCurrentFragment(WECHAT_PAGE)
                        }
                        R.id.project -> {
                            displayTitle(BOTTOM_NAVIGATION_NAMES[2])
                            displayCurrentFragment(PROJECT_PAGE)
                        }
                        R.id.navigation -> {
                            displayTitle(BOTTOM_NAVIGATION_NAMES[3])
                            displayCurrentFragment(NAVIGATION_PAGE)
                        }
                        R.id.knowledge_tree -> {
                            displayTitle(BOTTOM_NAVIGATION_NAMES[4])
                            displayCurrentFragment(KNOWLEDAGE_PAGE)
                        }
                    }
                    return true
                }
            })
        }

        displayTitle(BOTTOM_NAVIGATION_NAMES[0])
    }

    private fun displayTitle(title: String?) {
        supportActionBar?.setTitle(title)
    }

    private fun displayCurrentFragment(showPosition: Int) {
        supportFragmentManager.beginTransaction().apply {
            for (index in mFragments.indices) {
                val fragment = mFragments[index]
                replace(R.id.fragment, fragment, fragment.javaClass.name)
                if (showPosition == index) {
                    setMaxLifecycle(fragment, Lifecycle.State.RESUMED)
                } else {
                    hide(fragment)
                    setMaxLifecycle(fragment, Lifecycle.State.STARTED)
                }
            }
        }.commit()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastExitTime > 1500) {
                ToastUtils.showShort(R.string.exit_hint)
                lastExitTime = currentTime
                return true
            } else {
                finish()
                ActivityUtils.finishAllActivities()
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}
