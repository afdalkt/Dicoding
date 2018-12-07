package com.dicoding.hellokotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.dicoding.hellokotlin.Item
import com.dicoding.hellokotlin.R
import com.dicoding.hellokotlin.adapter.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items)
        {
            clubClick(it)
        }
    }

    private fun clubClick(items: Item) {
        startActivity<DetailActivity>(DetailActivity.aName to items.name,
                DetailActivity.aImage to items.image,
                DetailActivity.aInfo to items.info)
    }

    private var items: MutableList<Item> = mutableListOf()
    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val info = resources.getStringArray(R.array.club_info)
        items.clear()
        for (i in name.indices){
            items.add(Item(name[i],
                    image.getResourceId(i, 0),
                    info[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
}