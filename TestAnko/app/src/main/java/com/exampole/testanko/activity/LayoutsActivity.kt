package com.exampole.testanko.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.exampole.testanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * @作者: Sunnyit
 * @日期: 2019/7/10
 * @描述: Anko Layouts
 */
class LayoutsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            verticalLayout {
                backgroundResource = R.color.white
                gravity = Gravity.CENTER_HORIZONTAL
                imageView {
                    backgroundResource = R.color.white
                }.lparams(width = wrapContent, height = wrapContent) {
                    topMargin = dip(114)
                }

                textView {
                    text = "标题"
                    textSize = 14f
                    textColor = R.color.colorAccent
                }.lparams(width = wrapContent, height = wrapContent) {
                    topMargin = dip(9)
                    bottomMargin = dip(186)
                }

                verticalLayout {
                    gravity = Gravity.CENTER_HORIZONTAL
                    textView {
                        text = "文本展示_01"
                        textSize = 14f
                        backgroundResource = R.color.white
                        textColor = R.color.colorAccent
                        gravity = Gravity.CENTER

                        onClick {
                            toast("文本展示01被点击")
                        }
                    }.lparams(width = dip(127), height = dip(36)) {
                        bottomMargin = dip(20)
                    }
                    textView {
                        text = "文本展示_02"
                        hint = "请输入文本信息"
                        textSize = 14f
                        backgroundResource = R.color.white
                        textColor = R.color.colorAccent
                        gravity = Gravity.CENTER

                        onClick {
                            toast("文本展示02被点击")
                        }
                    }.lparams(width = dip(127), height = dip(36)) {
                    }

                    view().lparams(width = wrapContent, height = 0, weight = 1.0f)

                    textView {
                        text = "取消"
                        textColor = R.color.colorAccent
                        onClick {
                            toast("点击了取消...")
                        }
                    }.lparams(width = wrapContent, height = wrapContent) {
                        bottomMargin = dip(20)
                    }
                }
            }
        }
    }
}
