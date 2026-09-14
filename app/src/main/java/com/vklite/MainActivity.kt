package com.vklite

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Post(
    val author: String,
    val text: String
)

data class Chat(
    val name: String,
    val lastMessage: String
)

class MainActivity : AppCompatActivity() {

    private val posts = listOf(
        Post("Иван Иванов", "Первый тестовый пост"),
        Post("Новости VKLite", "Версия 0.5 вышла"),
        Post("Разработка", "Следующий шаг — VK API")
    )

    private val chats = listOf(
        Chat("Алексей", "Привет!"),
        Chat("VKLite Bot", "Система работает"),
        Chat("Тестовый чат", "Последнее сообщение...")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val content = findViewById<TextView>(R.id.content)

        findViewById<Button>(R.id.feedBtn).setOnClickListener {
            content.text = buildFeed()
        }

        findViewById<Button>(R.id.chatsBtn).setOnClickListener {
            content.text = buildChats()
        }

        findViewById<Button>(R.id.profileBtn).setOnClickListener {
            content.text = buildProfile()
        }

        content.text = buildFeed()
    }

    private fun buildFeed(): String {
        val sb = StringBuilder()
        sb.append("📰 Лента\n\n")

        for (post in posts) {
            sb.append(post.author)
            sb.append("\n")
            sb.append(post.text)
            sb.append("\n\n────────────\n\n")
        }

        return sb.toString()
    }

    private fun buildChats(): String {
        val sb = StringBuilder()
        sb.append("💬 Сообщения\n\n")

        for (chat in chats) {
            sb.append(chat.name)
            sb.append("\n")
            sb.append(chat.lastMessage)
            sb.append("\n\n────────────\n\n")
        }

        return sb.toString()
    }

    private fun buildProfile(): String {
        return """
👤 Профиль

Пользователь

Версия: 0.5

Устройство готово к подключению VK API
        """.trimIndent()
    }
}
