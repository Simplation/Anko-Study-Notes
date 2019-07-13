package com.exampole.testanko.activity.log

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class LogActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {

            button("logging") {
                allCaps = false
                onClick {
                    info("test logging info.")
                    debug("test logging debug.")
                    debug(5) // .toString() method will be executed
                    warn("test logging warn") // "null" will be printed
                    // warn("null") // "null" will be printed
                    error("test logging error.")
                    verbose("test logging verbose.")

                }
            }
        }
    }
}
