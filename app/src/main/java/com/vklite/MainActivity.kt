package com.vklite

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val title = TextView(this)
        title.text = "VK Lite"
        title.textSize = 28f

        val feed = TextView(this)
        feed.text = "\nЛента новостей\n\nПост №1\nПост №2\nПост №3"
        feed.textSize = 18f

        layout.addView(title)
        layout.addView(feed)

        setContentView(layout)
    }
}