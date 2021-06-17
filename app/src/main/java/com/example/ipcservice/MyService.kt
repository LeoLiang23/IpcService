package com.example.ipcservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("ServiceLog", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ServiceLog", "onDestroy")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("ServiceLog", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder {
        Log.d("ServiceLog", "onBind")
        return MyBinder()
    }

    class MyBinder : IMyAidlInterface.Stub() {
        override fun getName() = "My Name is Leonardo Dicaprio"

        override fun getAge() = 40

        override fun sayHi(content: String?) {
            Log.d("ServiceLog", "say Hi : $content")
        }

        override fun getStudentList(): MutableList<People> {
            val list = mutableListOf<People>()
            for (i in 1..10) {
                val people = People()
                people.age = i
                people.name = "lily${i}"
                list.add(people)
            }
            return list
        }

        override fun who(): People {
            val people = People()
            people.age = 18
            people.name = "lily"
            return people
        }
    }

}
