package cn.carveknife.carveknifewanandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.RecyclerView
import cn.carveknife.carveknifewanandroid.base.BaseActivity
import cn.carveknife.carveknifewanandroid.databinding.ActivityMainBinding
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var lastExitTime: Long = 0L

    companion object {
        private val BOTTOM_NAVIGATION_NAMES = arrayListOf<String>("首页", "公众号", "项目", "导航", "知识体系")
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
    }

    private fun initView() {
        setSupportActionBar(mViewBinding.appBar.toolbar)
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
                        R.id.home -> displayTitle(BOTTOM_NAVIGATION_NAMES[0])
                        R.id.wechat -> displayTitle(BOTTOM_NAVIGATION_NAMES[1])
                        R.id.project -> displayTitle(BOTTOM_NAVIGATION_NAMES[2])
                        R.id.navigation -> displayTitle(BOTTOM_NAVIGATION_NAMES[3])
                        R.id.knowledge_tree -> displayTitle(BOTTOM_NAVIGATION_NAMES[4])
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

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastExitTime > 1500) {
                ToastUtils.showShort(R.string.exit_hint)
                lastExitTime = currentTime
                return true
            } else {
                finish()
                AppUtils.exitApp()
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}