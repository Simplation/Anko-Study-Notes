package com.exampole.testanko.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.exampole.testanko.activity.dialog.DialogAndToastActivity
import com.exampole.testanko.activity.intent.IntentActivity
import com.exampole.testanko.activity.log.LogActivity
import com.exampole.testanko.activity.resources.ResourcesAndDimensionsActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * @作者: Sunnyit
 * @日期: 2019/7/10
 * @描述: Anko Commons
 */
class CommonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            button("Intent 的相关用法") {
                allCaps = false
                onClick {
                    startActivity<IntentActivity>()
                }
            }

            button("Dialogs and toasts 的相关用法") {
                allCaps = false
                onClick {
                    startActivity<DialogAndToastActivity>()
                }
            }

            button("Log 的相关用法") {
                allCaps = false
                onClick {
                    startActivity<LogActivity>()
                }
            }

            button("Resource and Dimensions 的相关用法") {
                allCaps = false
                onClick {
                    startActivity<ResourcesAndDimensionsActivity>()
                }
            }

        }
    }
}
