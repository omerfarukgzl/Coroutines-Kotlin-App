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


    // Scope nedir ?(Kapsam)
    Scope, coroutine'ların çalıştığı bir yapıdır.
    Scope'lar 3 türü vardır.
    1- Global Scope
    2- Coroutine Scope
    3- Activity Scope

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



    CoroutineScope Nedir ?


















    * */
}