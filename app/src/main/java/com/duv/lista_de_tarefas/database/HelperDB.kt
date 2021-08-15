package com.duv.lista_de_tarefas.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID
import com.duv.lista_de_tarefas.modelo.TaskMo

class TaskDatabaseHelper(
    context: Context
): SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO_ATUAL ) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    companion object{
        const val NOME_BANCO = "Tarefas"
        const val VERSAO_ATUAL = 1
    }

    val TABLE_TASK = "tarefas"
    val COLLUMNS_ID = "id"
    val TASK_TODO = "task"
    val CREATE_TABLE = "CREATE TABLE $TABLE_TASK (" +
            "$COLLUMNS_ID INTEGER NOT NULL," +
            "$TASK_TODO TEXT NOT NULL," +
            "" +
            "PRIMARY KEY($COLLUMNS_ID AUTOINCREMENT)" +
            ")"



    fun saveTask(task: TaskMo) {
        val db = writableDatabase ?: return
        var content = ContentValues()
        content.put(TASK_TODO, task.task)
        db.insert(TABLE_TASK, null, content)
        db.close()
    }

    fun deleteTask(id: Int) {
        val db = writableDatabase ?: return
        val sql = "DELETE FROM $TABLE_TASK WHERE $_ID = ?"
        val arg = arrayOf("$id")
        db.execSQL(sql, arg)
        db.close()
    }

    fun updateTask(task: TaskMo) {
        val db= writableDatabase ?: return
        val sql = "UPDATE $TABLE_TASK SET $TASK_TODO = ? WHERE $_ID = ?"
        val arg = arrayOf(task.task, task.id)
        db.execSQL(sql,arg)
        db.close()
    }

    fun setDb() : List<TaskMo> {
        val db = readableDatabase ?: return mutableListOf()
        var lista = mutableListOf<TaskMo>()
        var where: String? = null
        var args: Array<String> = arrayOf()
        var cursor = db.query(TABLE_TASK, null, where, args, null, null, null)
        if (cursor == null){
            db.close()
            return mutableListOf()
        }
        while (cursor.moveToNext()) {
            var task = TaskMo (
                cursor.getInt(cursor.getColumnIndex(COLLUMNS_ID)),
                cursor.getString(cursor.getColumnIndex(TASK_TODO))
            )
            lista.add(task)
        }
        db.close()
        return lista
    }
}