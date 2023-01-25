package com.example.coroutines_kotlin_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Light weightness of coroutines

        // 100000 tane println işlemi yapılıyor.
        // Global Scope
        // Global Scope, uygulama boyunca süren bir iş parçacığıdır.
        GlobalScope.launch {
            repeat(100000) {
                println("Ömerrrr $it")
            }
        }


        println("Global Scope Start")
        GlobalScope.launch {
                delay(100000)
                println("Global Scope")
        }
        println("Global Scope End")
        // Global Scope start ile Global Scope çalışır. arkada thread de 5 sn bekler ve print yazdırı
        // Sırası ile
        // Global Scope Start
        // Global Scope End
        // Global Scope(5 sn sonra)


        // runBlocking
        println("runBlocking Start")
        runBlocking { // coroutine'ların çalışmasını bekler.
            launch {
                delay(1000)
                println("run Blocking")
            }
        }
        println("runBlocking End")
        // runBlocking start ile runBlocking end arasında 1 saniye bekler. ve print eder. yani bloklar.
        // Sırası ile
        // runBlocking Start
        // runBlocking(1 sn sonra)
        // runBlocking End



        // CoroutineScope
        // ya içinde coroutine'lar da çalıştırıyor ya da suspend function'larda çalıştırıyor.

        //örneğin
        // runBlocking{
        // ..
        // coroutineScope{
        //      launch{
        //          delay(1000)
        //          println("Coroutine Scope")
        //      }


        // CoroutineScope hangi thread'de çalıştırılırsa, o thread'de çalışır.
        // CoroutineScope, Global Scope'dan farklı olarak CoroutineScope thread de GlobalScope uygulamada çalışır.
        println("Coroutine Scope Start")
        CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            println("Coroutine Scope")
        }
        println("Coroutine Scope End")
        // Sırası ile
        // Coroutine Scope Start
        // Coroutine Scope End
        // Coroutine Scope(5 sn sonra)






    }
}