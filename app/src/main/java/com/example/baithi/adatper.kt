package com.example.baithi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class adatper(private var context: Context) : RecyclerView.Adapter<adatper.viewHolder>() {

    private lateinit var  list : ArrayList<person>



    fun getList(  list : ArrayList<person>){
        this.list = list
        notifyDataSetChanged()
    }

    class viewHolder(view: View): RecyclerView.ViewHolder(view){
        var id = view.findViewById<TextView>(R.id.id)
        var name = view.findViewById<TextView>(R.id.name)
        var phone = view.findViewById<TextView>(R.id.phone)
        var address = view.findViewById<TextView>(R.id.address)
        var linear = view.findViewById<LinearLayout>(R.id.a)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var p = list[position]

        holder.name.text = p.name
        holder.phone.text = p.phone
        holder.address.text = p.address
        holder.linear.setOnClickListener {
            (context as MainActivity).getDataEdit(p)
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

}