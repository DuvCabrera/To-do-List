package com.duv.lista_de_tarefas.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID
import java.net.IDN

class TaskDatabaseHelper(
    context: Context
): SQLiteOpenHelper(context, "databaseTarefas", null, 1 ) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_TASK (" +
        "$_ID INTERGER NOT NULL PRIMARY KEY, " +
        "$TASK_TODO TEXT NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object{
        const val TABLE_TASK :String = "tarefas"
        const val TASK_TODO :String = "task"
    }


}