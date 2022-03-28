package com.example.baithi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.item.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var sqlite: Sqlite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sqlite = Sqlite(this)
        add()
        getAllPerson()
        edit()
        delete()
    }
    fun add(){
        var btnAdd : Button = findViewById(R.id.btnAdd)
        var name = findViewById<TextView>(R.id.name)
        var phone = findViewById<TextView>(R.id.phone)
        var address = findViewById<TextView>(R.id.address)
        btnAdd.setOnClickListener {
            var person = person(name = name?.text.toString(),phone = phone?.text.toString(),address = address?.text.toString())
            sqlite.insertPerson(person)
            getAllPerson()
        }
    }

    fun edit(){
        var btnAdd : Button = findViewById(R.id.edit)
        var id = findViewById<TextView>(R.id.id)
        var name = findViewById<TextView>(R.id.name)
        var phone = findViewById<TextView>(R.id.phone)
        var address = findViewById<TextView>(R.id.address)

        btnAdd.setOnClickListener {
            var person = person(id = id?.text.toString().toInt(), name = name?.text.toString(),phone = phone?.text.toString(),address = address?.text.toString())
            sqlite.UpdatePerson(person)
            getAllPerson()
        }
    }

    fun delete(){
        var btnAdd : Button = findViewById(R.id.delete)
        var id = findViewById<TextView>(R.id.id)
        var name = findViewById<TextView>(R.id.name)
        var phone = findViewById<TextView>(R.id.phone)
        var address = findViewById<TextView>(R.id.address)

        btnAdd.setOnClickListener {
            sqlite.DeletePerson(id.text.toString().toInt())
            id.text = null
            name.text = null
            phone.text = null
            address.text = null
            getAllPerson()
        }
    }

    fun getDataEdit(person: person){
        var id = findViewById<TextView>(R.id.id)
        var name = findViewById<TextView>(R.id.name)
        var phone = findViewById<TextView>(R.id.phone)
        var address = findViewById<TextView>(R.id.address)

        id.text = person.id.toString()
        name.text = person.name
        phone.text = person.phone
        address.text = person.address

    }

    fun getAllPerson (){
        var person = sqlite.getAllPerson()
        var recyclerView : RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var adapter : adatper = adatper(this)
        adapter.getList(person)
        recyclerView.adapter = adapter
    }

}