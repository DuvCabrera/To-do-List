package com.duv.lista_de_tarefas.task

import android.os.Bundle
import android.view.View
import com.duv.lista_de_tarefas.R
import com.duv.lista_de_tarefas.application.TaskApplication
import com.duv.lista_de_tarefas.bases.BaseActivity
import com.duv.lista_de_tarefas.modelo.TaskMo
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.android.synthetic.main.activity_task.toolBar

class TaskActivity : BaseActivity() {

    private var idTask = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        setupToolBar(toolBar,"Tarefas", true)
        btn_Salvar_Task.setOnClickListener { onClickSalvarTask() }

    }

    private fun setupTask() {
        idTask = intent.getIntExtra("index", -1)
        if(idTask == -1){
            return
        }


    }

    private fun onClickSalvarTask(){
        val taskTitle = et_Task.text.toString()
        val task = TaskMo(
            idTask,
            taskTitle
        )
        progress.visibility = View.VISIBLE
        Thread(Runnable {
            Thread.sleep(100)
            if(idTask == -1) {
                TaskApplication.instance.helperDB?.saveTask(task)
            }else{
                TaskApplication.instance.helperDB?.updateTask(task)
            }
            runOnUiThread {
                progress.visibility = View.GONE
                finish()
            }
        }).start()
    }
}