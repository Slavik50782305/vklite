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
        root.setPadding(32, 32, 32, 32)

        val title = TextView(this)
        title.text = "VKLite"
        title.textSize = 30f

        val content = TextView(this)
        content.text = feedScreen()
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
            content.text = feedScreen()
        }

        chatsBtn.setOnClickListener {
            content.text = chatsScreen()
        }

        profileBtn.setOnClickListener {
            content.text = profileScreen()
        }

        nav.addView(feedBtn)
        nav.addView(chatsBtn)
        nav.addView(profileBtn)

        root.addView(title)
        root.addView(content)
        root.addView(nav)

        setContentView(root)
    }

    private fun feedScreen(): String {
        return """
📰 Лента

━━━━━━━━━━━━

🔥 Первый пост

Добро пожаловать в VKLite.

━━━━━━━━━━━━

📱 Второй пост

Приложение собрано прямо с телефона.

━━━━━━━━━━━━

🚀 Третий пост

Следующий шаг — авторизация VK.
        """.trimIndent()
    }

    private fun chatsScreen(): String {
        return """
💬 Сообщения

━━━━━━━━━━━━

Алексей
Привет!

━━━━━━━━━━━━

VKLite Bot
Система работает.

━━━━━━━━━━━━

Тестовый чат
Последнее сообщение...
        """.trimIndent()
    }

    private fun profileScreen(): String {
        return """
👤 Профиль

Имя: Пользователь

Статус: Онлайн

Версия: 0.3

Устройство: Android
        """.trimIndent()
    }
}
