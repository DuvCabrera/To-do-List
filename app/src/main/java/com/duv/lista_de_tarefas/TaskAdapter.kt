package com.duv.lista_de_tarefas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duv.lista_de_tarefas.modelo.TaskMo

class TaskAdapter(private val context: Context,
                  private val list: List<TaskMo>
): RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = list[position]
        holder.taskTitle.text = task.task
        holder.checkBox.isChecked = false
    }

    override fun getItemCount(): Int = list.size

}


class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val taskTitle = itemView.findViewById(R.id.task_txt) as TextView
    val checkBox = itemView.findViewById(R.id.check_button) as CheckBox
}