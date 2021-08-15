package com.duv.lista_de_tarefas.application

import android.app.Application
import com.duv.lista_de_tarefas.database.TaskDatabaseHelper

class TaskApplication : Application() {

    var helperDB: TaskDatabaseHelper? = null

    companion object {
        lateinit var instance: TaskApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        helperDB = TaskDatabaseHelper(this)
    }
}