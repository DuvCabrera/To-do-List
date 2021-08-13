package com.duv.lista_de_tarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duv.lista_de_tarefas.bases.BaseActivity
import com.duv.lista_de_tarefas.task.TaskActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var addButton: FloatingActionButton

    private var adapter: TaskAdapter? = null

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

    }




}