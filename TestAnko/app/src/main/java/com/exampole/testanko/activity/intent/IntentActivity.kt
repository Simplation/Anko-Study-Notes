package com.exampole.testanko.activity.intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.exampole.testanko.HomeActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * @作者: Sunnyit
 * @日期: 2019/7/10
 * @描述: Intent
 */
class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            val name = editText()
            button("获取文本框输入的值") {
                allCaps = false
                onClick {
                    toast("Hello, ${name.text}!")
                }
            }

            button("打电话给10086") {
                allCaps = false
                onClick {
                    makeCall("10086")
                }
            }

            button("发短信给10086") {
                allCaps = false
                onClick {
                    sendSMS("10086", "我已经收到话费账单")
                }
            }

            button("打开移动端百度网页") {
                allCaps = false
                onClick {
                    browse("http://m.baidu.com")
                }
            }

            button("Intent 跳转传递数据") {
                allCaps = false
                onClick {
                    // 正常页面跳转(不携带参数)
                    // startActivity<HomeActivity>()

                    // 携带参数跳转
                    startActivity<HomeActivity>("name" to "Simplation.WANG", "age" to 18)

                    // A页面跳到B页面,再跳到C页面,再跳到A页面时,要求清空B,C页面退出,并且不重走A的生命周期
                    // startActivity(intentFor<MainActivity>().singleTop().clearTop())

                    // A页面跳到B页面,再跳到C页面,再跳到A页面时,要求清空B,C页面退出,并且重走A的生命周期
                    // startActivity(intentFor<MainActivity>().clearTask().newTask())

                    // A页面->B页面->C页面->D页面时,销毁A.B.C这三个页面,整个栈中就D页面
                    // startActivity(intentFor<MainActivity>().newTask().clearTask())
                }
            }

            button("分享") {
                allCaps = false
                onClick {
                    share("分享内容")
                }
            }

            button("发邮件") {
                allCaps = false
                onClick {
                    email("908462564@qq.com", "Title", "This is content.")
                }
            }
        }
    }
}
