package com.example.postapp_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omer.retrofitapp.R
import com.omer.retrofitapp.adapter.PostRecyclerAdapter
import com.omer.retrofitapp.databinding.ActivityMainBinding
import com.omer.retrofitapp.model.PostModel
import com.omer.retrofitapp.service.PostApi
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var postModels: ArrayList<PostModel>? = null

    // Main Activty Binding
    private var binding: ActivityMainBinding ? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PostRecyclerAdapter

    private var job : Job? = null

    // Rxjava için
        // Disposable
        private var compositeDisposable: CompositeDisposable?=null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Rxjava disposable
            compositeDisposable = CompositeDisposable()

            recyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            loadData()
            // layout adapter'ı tanımladık
            //adapter ile bağlama

        }

    // retrofit ile verileri çekiyoruz
    private fun loadData() {


        // Coroutines ile istek yapacağımız fonksiyonumuzu oluşturuyoruz.
        // Bu fonksiyonumuzda Retrofit ile istek yapacağız.

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)

        job = CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.getData()
            //arkada io threadinde veriler çekiliyor ve  main thread e geçiyor
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        postModels = ArrayList(it)

                        adapter = PostRecyclerAdapter(postModels!!)
                        recyclerView.adapter = adapter
                    }
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}