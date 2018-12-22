package test.example.com.kotlinrecylerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_adpater.view.*


public class AdapterActivity() : RecyclerView.Adapter<AdapterActivity.ViewHolder>() {

    lateinit var arrayList: ArrayList<Model>
    lateinit var context: Context
    var onItemClickListener: ItemClickListener? = null


    constructor(context: Context, arrayList: ArrayList<Model>, onItemClickListener: ItemClickListener) : this() {
        this.context = context
        this.arrayList = arrayList
        this.onItemClickListener = onItemClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the custom view from xml layout file
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.row_adpater, parent, false)
        // Return the view holder
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.name?.text = arrayList.get(position).name

        holder?.button.setOnClickListener { view ->
            onItemClickListener?.onItemClick(arrayList.get(position).name, position)

        }

        holder?.parent.setOnClickListener { view ->
            onItemClickListener?.onCardClick("card click", position)

        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.txtview
        val button = itemView.btn
        val parent = itemView.relativeparent


//        init {
//            itemView.btn.setOnClickListener(this)
//
//        }

//        fun bindItems(items: Model) {
//            itemView.txtview.text = items.name
//            // itemView.tvNumber.text = items.number
//        }


        //  val  textViewNameDesc;
//        constructor(itemView: View) : super(itemView) {
//            itemView.setOnClickListener(this)
//            itemView.btn.setOnClickListener(this)
//            // textViewNameDesc = itemView.findViewById(R.id.txtview) as TextView
//        }

//        fun ViewHolder(itemView: View) {
//            itemView.setOnClickListener(this)
//            itemView.btn.setOnClickListener { this }
//            //itemView.findViewById(R.id.btn).setOnClickListener(this)
//
//
//        }


//        override fun onClick(v: View?) {
//            when (v?.id) {
//
//                R.id.btn -> {
//                    // Toast.makeText(, "Its toast!", Toast.LENGTH_SHORT).show()
//
//                    // AdapterActivity.ItemClickListener onItemClick(adapterPosition)
//
//                    // Log.d("onlcikebtn", "dfdf")
//                    //onItemClickListener.onItemClick(arrayList, adapterPosition)
//                }
//            }
//        }


//        init {
//            itemView.setOnClickListener {
//                this
//            }
//        }
    }


    // This two methods useful for avoiding duplicate item
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface ItemClickListener {
        fun onItemClick(name: String, position: Int)
        fun onCardClick(str: String, position: Int)
    }

}