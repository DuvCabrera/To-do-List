package com.duv.lista_de_tarefas

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duv.lista_de_tarefas.application.TaskApplication
import com.duv.lista_de_tarefas.bases.BaseActivity
import com.duv.lista_de_tarefas.modelo.TaskMo
import com.duv.lista_de_tarefas.task.TaskActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : BaseActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var addButton: FloatingActionButton
    lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolBar(toolBar, "Lista de Tarefas", false)


        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener { val intent = Intent(
            this, TaskActivity::class.java)
            startActivity(intent)}
        setList()
    }

    private fun setList() {
        var taskList: List<TaskMo> = mutableListOf()
        try{
            taskList = TaskApplication.instance.helperDB?.setDb() ?: mutableListOf()
        }catch (ex: Exception){
            ex.printStackTrace()
        }
        adapter = TaskAdapter(this, taskList)
        recyclerView.adapter = adapter
    }
}