package test.example.com.kotlinrecylerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterActivity.ItemClickListener {

    lateinit var arrayList: ArrayList<Model>
    lateinit var adapterModel: AdapterActivity

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        arrayList = ArrayList<Model>()

        arrayList.add(Model("irfan", "35"))
        arrayList.add(Model("samiullah", "30"))

        arrayList.add(Model("irfan", "35"))
        arrayList.add(Model("samiullah", "30"))

        arrayList.add(Model("irfan", "35"))
        arrayList.add(Model("samiullah", "30"))

        arrayList.add(Model("irfan", "35"))
        arrayList.add(Model("samiullah", "30"))

        arrayList.add(Model("irfan", "35"))
        arrayList.add(Model("samiullah", "30"))

        arrayList.add(Model("irfan", "35"))
        arrayList.add(Model("samiullah", "30"))

        arrayList.add(Model("irfan", "35"))
        arrayList.add(Model("samiullah", "30"))

        adapterModel = AdapterActivity(applicationContext, arrayList, this)
        recyclerView.adapter = adapterModel
    }

    override fun onItemClick(name: String, position: Int) {
        Toast.makeText(applicationContext, name + " " + position, Toast.LENGTH_SHORT).show()
    }

    override fun onCardClick(str: String, position: Int) {
        Toast.makeText(applicationContext, str + " " + position, Toast.LENGTH_SHORT).show()

    }
}
