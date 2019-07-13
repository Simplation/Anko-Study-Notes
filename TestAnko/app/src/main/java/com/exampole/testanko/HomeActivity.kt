package com.exampole.testanko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.textView
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        verticalLayout{
            val txt = textView()

            val name = intent.extras.getString("name")
            val age = intent.extras.getInt("age")

            txt.text = "姓名：$name, 年龄：$age"

            toast("name is:$name, age is:$age")
        }
    }
}
