package com.example.reminderapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reminderapp.data.task

class adapter(private val mList: List<task>):RecyclerView.Adapter<adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_layout, parent, false)
        return ViewHolder(view)
    }
    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.textView1.setText(ItemsViewModel.title)
        holder.textView2.setText(ItemsViewModel.date)
        }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val textView1: TextView = itemView.findViewById(R.id.textViewTitle)
        val textView2: TextView = itemView.findViewById(R.id.textTimeDate)
    }
}
