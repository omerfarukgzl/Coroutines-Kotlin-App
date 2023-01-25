package com.example.coroutines_kotlin_app.notes

class GeneralNotes {
    /*


    Coroutines Nedir?
    Coroutines, bir iş parçacığının (thread) çalışmasını kontrol etmek için kullanılan bir yapıdır.

   Uzun süren işlemler için kullanılır.
   Main Threadi bloklamaz.
   Arka planda çalışır.


   öncelikle coroutine dependency eklenir.
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2'





*************************************************

    // Scope nedir ?(Kapsam)
    Scope, coroutine'ların çalıştığı bir yapıdır.
    Scope'lar 3 türü vardır.
    1- Global Scope
    2- Coroutine Scope
    3- Activity Scope


*************************************************



    1- Global Scope
    Global Scope nedir ?
    Global Scope, uygulama boyunca süren bir iş parçacığıdır.


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


*************************************************

    RunBlocking Nedir ?
    RunBlocking, coroutine'ların çalışmasını bekler.
    RunBlocking, Global Scope'dan farklı olarak, coroutine'ların çalışmasını bekler. Bloklar. Durduru.

        // runBlocking
        runBlocking { // coroutine'ların çalışmasını bekler.
            launch {
                delay(1000)
                println("run Blocking")
            }

        Aslında aradaki işlemler bitene kadar bekler. Bu yüzden 1 saniye sonra run Blocking yazdırır.


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

*************************************************

    CoroutineScope Nedir ?
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




*************************************************



    Dispatchers Nedir ?
    Dispatchers, coroutine'ların çalışacağı thread'i belirler.
    1- Dispatchers.Main
    2- Dispatchers.Default
    3- Dispatchers.IO
    4- Dispatchers.Unconfined

    1- Dispatchers.Main  --> UI işlemleri için kullanılır.
    Dispatchers.Main, coroutine'ların main thread'de çalışmasını sağlar.

    2- Dispatchers.Default ---> CPU yoğun işlemler için kullanılır.(Örneğin 100.000 kelime alfabetik sıralama) CPU intensive --> yoğun işlem
    Dispatchers.Default, coroutine'ların default thread'de çalışmasını sağlar.

    3- Dispatchers.IO --> Network, Database, File I/O işlemleri için kullanılır. ( internetten veri çekme)
    Dispatchers.IO, coroutine'ların IO thread'de çalışmasını sağlar.

    4- Dispatchers.Unconfined  --> ınherit the context and dispatcher from the caller.
    Dispatchers.Unconfined, coroutine'ların hangi thread'de miras alır.



    launch(Dispatchers.Main) {
        // Main Thread
    }

    launch(Dispatchers.Default) {
        // Default Thread
    }

    launch(Dispatchers.IO) {
        // IO Thread
    }

    launch(Dispatchers.Unconfined) {
        // Unconfined Thread
    }






*************************************************


Suspending Function Nedir ?

İçeriğinde coroutine'lar çalıştıran fonksiyonlardır.

suspend fun getNote(){
    // coroutine'lar çalıştırabilir.
    coroutineScope{
        launch{
            delay(1000)
            println("Coroutine Scope")
        }

    }


*************************************************

Coroutine Async Nedir ?

launch yerine async kullanılır.
launch, coroutine'ları çalıştırır.
async, coroutine'ları çalıştırır ve sonucu döndürür.

örneğin 2 tane coroutine çalıştırıyoruz. ve bu coroutine'ların sonucunu döndürmek istiyoruz.
launch yerine async kullanıyoruz.
iki gelen veriyi senkron bir şekilde kullanmak istiyoruz bunun için async kullanıyoruz.
eğer async kullanmasaydık,launch kullansaydık coroutine'lar çalıştırılır ama sonuç döndürülmezdi.
ve iki sonucu eş zamanda kullanamazdık.


    val job1 = async {
        delay(1000)
        println("Coroutine 1")
        10
    }

    val job2 = async {
        delay(2000)
        println("Coroutine 2")
        20
    }

    println("Toplam : ${job1.await() + job2.await()}")
    // Toplam : 30
















    * */
}