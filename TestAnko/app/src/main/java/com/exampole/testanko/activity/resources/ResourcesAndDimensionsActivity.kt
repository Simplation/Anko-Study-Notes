package com.exampole.testanko.activity.resources

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.style

class ResourcesAndDimensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            textView {
                text = "文本内容"
                padding = dip(10)
                textColor = 0xff0000.opaque
                textSize = 18f

            }

            editText {
                hint = "Name"
                allCaps = false
            }.lparams {
                width = matchParent
                height = wrapContent
                leftPadding = dip(3)
                leftMargin = dip(10)
                rightMargin = dip(10)
            }

            editText {
                hint = "Password"
            }

        }
    }
}
