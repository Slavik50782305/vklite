package com.vklite

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL

        val title = TextView(this)
        title.text = "VKLite"
        title.textSize = 28f

        val content = TextView(this)
        content.text = "Лента новостей\n\nПост №1\nПост №2\nПост №3"
        content.textSize = 18f

        val nav = LinearLayout(this)
        nav.orientation = LinearLayout.HORIZONTAL

        val feedBtn = Button(this)
        feedBtn.text = "Лента"

        val chatsBtn = Button(this)
        chatsBtn.text = "Чаты"

        val profileBtn = Button(this)
        profileBtn.text = "Профиль"

        feedBtn.setOnClickListener {
            content.text = "Лента новостей\n\nПост №1\nПост №2\nПост №3"
        }

        chatsBtn.setOnClickListener {
            content.text = "Сообщения\n\nДиалог 1\nДиалог 2\nДиалог 3"
        }

        profileBtn.setOnClickListener {
            content.text = "Профиль\n\nИмя: Пользователь\nСтатус: Онлайн"
        }

        nav.addView(feedBtn)
        nav.addView(chatsBtn)
        nav.addView(profileBtn)

        root.addView(title)
        root.addView(content)
        root.addView(nav)

        setContentView(root)
    }
}
