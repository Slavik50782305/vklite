package com.vklite

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Post(
    val author: String,
    val text: String
)

class MainActivity : AppCompatActivity() {

    private val posts = listOf(
        Post("Иван Иванов", "Первый тестовый пост"),
        Post("Новости VKLite", "Версия 0.6 вышла"),
        Post("Разработка", "Теперь используется RecyclerView"),
        Post("VKLite", "Следующий шаг — карточки постов")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recycler =
            findViewById<RecyclerView>(R.id.feedRecycler)

        recycler.layoutManager =
            LinearLayoutManager(this)

        recycler.adapter =
            FeedAdapter(posts)

        findViewById<Button>(R.id.feedBtn)
            .setOnClickListener {
                recycler.adapter =
                    FeedAdapter(posts)
            }

        findViewById<Button>(R.id.chatsBtn)
            .setOnClickListener {
                recycler.adapter =
                    FeedAdapter(
                        listOf(
                            Post("Алексей", "Привет!"),
                            Post("VKLite Bot", "Система работает"),
                            Post("Тестовый чат", "Последнее сообщение...")
                        )
                    )
            }

        findViewById<Button>(R.id.profileBtn)
            .setOnClickListener {
                recycler.adapter =
                    FeedAdapter(
                        listOf(
                            Post("Пользователь", "Версия 0.6"),
                            Post("Статус", "Онлайн"),
                            Post("VKLite", "Готов к VK API")
                        )
                    )
            }
    }
}
