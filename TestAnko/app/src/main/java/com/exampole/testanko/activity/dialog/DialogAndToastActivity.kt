package com.exampole.testanko.activity.dialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.exampole.testanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk27.coroutines.onClick

class DialogAndToastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            button("toast String") {
                allCaps = false
                onClick {
                    toast("toast string.")
                }
            }
            button("toast string.xml") {
                allCaps = false
                onClick {
                    val txt = R.string.message
                    toast("toast string.xml $txt")
                }
            }
            button("long toast") {
                allCaps = false
                onClick {
                    longToast("Wow, long toast!")
                }
            }
            button("snackbar") {
                allCaps = false
                onClick {
                    this@verticalLayout.snackbar("snake bar in there!")
                }
            }
            button("dialog") {
                allCaps = false
                onClick {
                    alert("Hi, This is dialog", "show dialog?") {
                        yesButton { toast("Ok…") }
                        noButton { toast("Cancel") }
                    }.show()
                }
            }
            button("Checkbox") {
                allCaps = false
                onClick {
                    val countries = listOf("China", "USA", "Japan", "Australia")
                    selector("Where are you from?", countries) { _, i ->
                        toast("So you're living in ${countries[i]}, right?")
                    }
                }
            }
            button("progress bar") {
                allCaps = false
                onClick {
                    val dialog = progressDialog(message = "Please wait a minute.", title = "downloading...") {
                        isIndeterminate = true
                    }
                    dialog.show()
                }
            }
        }
    }
}
