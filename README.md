## Anko 库

### 1. Anko 的简单介绍

Anko 是 Kotlin 的伴生库，目前已经迭代很多版本。 下面将为大家全方位熟悉 Anko 库的使用。

Anko库总共有四个核心库：

- Anko Commons：主要是通用功能的封装（intent、dialog and toasts、logging、resources 、dimensions 等）。
- Anko Layouts: 主要是编写动态 Android 布局的快速且类型安全的方法。
- Anko SQLite：Android SQLite 的查询 DSL 和解析器集合。
- Anko Coroutines：基于kotlinx.coroutines 库的实用程序。

### 2. 四大核心库的用法

声明 anko 的版本号，然后添加 dependencies 依赖，最后同步即可。经过简单的配置以后，项目便依赖 Commons、Layouts、SQLite，当然如果需要，也可以进行单独的配置。

```java
// 声明在 project 的 build.gradle 文件中
ext.anko_version='0.10.8'

dependencies {
    implementation "org.jetbrains.anko:anko:$anko_version"

    // Anko Commons
    implementation "org.jetbrains.anko:anko-commons:$anko_version"

    // Anko Layouts
    implementation "org.jetbrains.anko:anko-sdk27:$anko_version" // sdk15, sdk19, sdk21, sdk23 are also available
    implementation "org.jetbrains.anko:anko-appcompat-v7:$anko_version"

    // Coroutine listeners for Anko Layouts
    implementation "org.jetbrains.anko:anko-sdk25-coroutines:$anko_version"
    implementation "org.jetbrains.anko:anko-appcompat-v7-coroutines:$anko_version"

    // Anko SQLite
    implementation "org.jetbrains.anko:anko-sqlite:$anko_version"


    // Appcompat-v7 (only Anko Commons)
    implementation "org.jetbrains.anko:anko-appcompat-v7-commons:$anko_version"

    // Appcompat-v7 (Anko Layouts)
    implementation "org.jetbrains.anko:anko-appcompat-v7:$anko_version"
    implementation "org.jetbrains.anko:anko-coroutines:$anko_version"

    // CardView-v7
    implementation "org.jetbrains.anko:anko-cardview-v7:$anko_version"

    // Design
    implementation "org.jetbrains.anko:anko-design:$anko_version"
    implementation "org.jetbrains.anko:anko-design-coroutines:$anko_version"

    // GridLayout-v7
    implementation "org.jetbrains.anko:anko-gridlayout-v7:$anko_version"

    // Percent
    implementation "org.jetbrains.anko:anko-percent:$anko_version"

    // RecyclerView-v7
    implementation "org.jetbrains.anko:anko-recyclerview-v7:$anko_version"
    implementation "org.jetbrains.anko:anko-recyclerview-v7-coroutines:$anko_version"

    // Support-v4 (only Anko Commons)
    implementation "org.jetbrains.anko:anko-support-v4-commons:$anko_version"

    // Support-v4 (Anko Layouts)
    implementation "org.jetbrains.anko:anko-support-v4:$anko_version"

    // ConstraintLayout
    implementation "org.jetbrains.anko:anko-constraint-layout:$anko_version"
}
```

#### 2.1. Ando Commons 用法

1. 添加  Ando Commons 依赖
2. 常见用法
   - intent 用法：跳转 activity 并传递参数、打电话、发短信等。
   
     ```kotlin
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
     ```
   
   - dialog、toast用法：弹出框显示和吐司
   
     ```kotlin
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
                         val countries = listOf("China", "USA", "Japan", "Europe")
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
     ```
   
   - logging 用法：增强 log 输出，目前发现的最大好处是支持 list 和 map，整数，空，自定义数据类等类型的打印。
   
     ```kotlin
     首先需要在使用 log 的类中继承 AnkoLogger
     
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
     ```
   
   - resource and dimensions 用法：使用 res 文件中的资源文件
   
     ```kotlin
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
     ```

#### 2.2. Anko Layouts 用法（DSL）

1. 添加  Ando Layouts 依赖	

   添加依赖就不在这里赘述了！

2. 常见用法：可以在源码中直接编写页面的布局，可以保证类型安全，不会出现转换异常的问题。

   ```kotlin
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
   ```

#### 2.3. Anko SQLite 用法

1. 添加  Ando SQLite 依赖

   添加依赖就不在这里赘述了！

2. 常见用法

    待完善

#### 2.4. Anko Coroutines 用法

1. 添加  Ando Coroutines 依赖		

   添加依赖就不在这里赘述了！

2. 常见用法

    待完善
