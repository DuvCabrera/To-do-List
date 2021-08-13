package com.duv.lista_de_tarefas.task

import android.os.Bundle
import com.duv.lista_de_tarefas.R
import com.duv.lista_de_tarefas.bases.BaseActivity
import kotlinx.android.synthetic.main.activity_task.*

class TaskActivity : BaseActivity() {

    private var idTask = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        setupToolBar(toolBar,"Tarefas", true)


    }
}