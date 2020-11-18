package cn.carveknife.carveknifewanandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import cn.carveknife.carveknifewanandroid.base.BaseActivity
import cn.carveknife.carveknifewanandroid.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode

class MainActivity : BaseActivity<ActivityMainBinding>() {
    companion object {
        private val BOTTOM_NAVIGATION_NAMES = arrayListOf<String>("首页", "公众号", "项目", "导航", "知识体系")
        public fun getCallingIntent(context: Context): Intent {
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
        mViewBinding.bottomNavigationView.labelVisibilityMode =
            LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        mViewBinding.bottomNavigationView.setOnNavigationItemSelectedListener(object :
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
        displayTitle(BOTTOM_NAVIGATION_NAMES[0])
    }

    private fun displayTitle(title: String?) {
        mViewBinding.appBar.toolbar.title = title
    }
}