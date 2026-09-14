package com.vklite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

data class Post(
    val author: String,
    val text: String
)

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView

    private val feedPosts = listOf(
        Post("Иван Иванов", "Первый тестовый пост"),
        Post("Новости VKLite", "Версия 0.9"),
        Post("Разработка", "Добавлена нижняя навигация"),
        Post("VKLite", "Скоро подключим интернет")
    )

    private val chats = listOf(
        Post("Алексей", "Привет!"),
        Post("VKLite Bot", "Система работает"),
        Post("Тестовый чат", "Последнее сообщение")
    )

    private val profile = listOf(
        Post("Пользователь", "Версия 0.9"),
        Post("Статус", "Онлайн"),
        Post("VKLite", "Готов к следующему обновлению")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.feedRecycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = FeedAdapter(feedPosts)

        val bottomNav =
            findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_feed -> {
                    recycler.adapter = FeedAdapter(feedPosts)
                    true
                }

                R.id.nav_chats -> {
                    recycler.adapter = FeedAdapter(chats)
                    true
                }

                R.id.nav_profile -> {
                    recycler.adapter = FeedAdapter(profile)
                    true
                }

                else -> false
            }
        }
    }
}
