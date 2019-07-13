package com.exampole.testanko

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.exampole.testanko.activity.CommonsActivity
import com.exampole.testanko.activity.CoroutinesActivity
import com.exampole.testanko.activity.LayoutsActivity
import com.exampole.testanko.activity.SQLiteActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalLayout {
            // Anko Commons
            button("Anko Commons") {
                allCaps = false   // 转换英文字符，不添加的话字母全部显示大写
                onClick {
                    startActivity<CommonsActivity>()
                }
            }

            // Anko Layouts
            button("Anko Layouts") {
                allCaps = false
                onClick {
                    startActivity<LayoutsActivity>()
                }
            }

            // Anko SQLite
            button("Anko SQLite") {
                allCaps = false
                onClick {
                    startActivity<SQLiteActivity>()
                }
            }

            // Anko Coroutines
            button("Anko Coroutines") {
                allCaps = false
                onClick {
                    startActivity<CoroutinesActivity>()
                }
            }
        }
    }
}

