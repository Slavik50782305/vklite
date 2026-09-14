package com.vklite

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val content = findViewById<TextView>(R.id.content)

        findViewById<Button>(R.id.feedBtn).setOnClickListener {
            content.text = feed()
        }

        findViewById<Button>(R.id.chatsBtn).setOnClickListener {
            content.text = chats()
        }

        findViewById<Button>(R.id.profileBtn).setOnClickListener {
            content.text = profile()
        }

        content.text = feed()
    }

    private fun feed() = """
📰 Лента

Иван Иванов
Первый тестовый пост

────────────

Новости VKLite
Версия 0.4
""".trimIndent()

    private fun chats() = """
💬 Сообщения

Алексей
Привет!

────────────

VKLite Bot
Система работает
""".trimIndent()

    private fun profile() = """
👤 Профиль

Пользователь

Версия 0.4
""".trimIndent()
}
