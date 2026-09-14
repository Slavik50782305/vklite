package com.vklite

import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class Post(
    val author: String,
    val text: String
)

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView

    private val feedPosts = mutableListOf<Post>()

    private val chats = listOf(
        Post("Алексей", "Привет!"),
        Post("VKLite Bot", "Система работает"),
        Post("Тестовый чат", "Последнее сообщение")
    )

    private val profile = listOf(
        Post("Пользователь", "Версия 1.0"),
        Post("Статус", "Онлайн"),
        Post("VKLite", "Данные читаются из JSON")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        feedPosts.addAll(loadPosts())

        recycler = findViewById(R.id.feedRecycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = FeedAdapter(feedPosts)

        val bottomNav =
            findViewById<BottomNavigationView>(R.id.bottomNav)
        val addPostBtn =
    findViewById<Button>(R.id.addPostBtn)

addPostBtn.setOnClickListener {

    val input = EditText(this)

    AlertDialog.Builder(this)
        .setTitle("Новый пост")
        .setView(input)
        .setPositiveButton("Опубликовать") { _, _ ->

            val text = input.text.toString()

            if (text.isNotBlank()) {

                feedPosts.add(
                    0,
                    Post(
                        "Пользователь",
                        text
                    )
                )

                recycler.adapter =
                    FeedAdapter(feedPosts)
            }
        }
        .setNegativeButton("Отмена", null)
        .show()
}
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

    private fun loadPosts(): List<Post> {

        val json =
            assets.open("posts.json")
                .bufferedReader()
                .use { it.readText() }

        val type =
            object : TypeToken<List<Post>>() {}.type

        return Gson().fromJson(json, type)
    }
}
