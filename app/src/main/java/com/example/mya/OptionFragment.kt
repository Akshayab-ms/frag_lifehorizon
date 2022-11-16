package com.example.mya

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class OptionFragment : Fragment() {


    lateinit var climate: Spinner
    lateinit var job: Spinner
    lateinit var night: Spinner
    lateinit var med: Spinner
    lateinit var cost: Spinner
    lateinit var apply: Button
    var a: Int = 0
    var b: Int = 0
    var c: Int = 0
    var d: Int = 0
    var e: Int = 0
    var sum: Int = 0
    var avg: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val  view= inflater.inflate(R.layout.fragment_option, container, false)






        climate = view.findViewById(R.id.sp_climate) as Spinner
        cost = view.findViewById(R.id.sp_cost) as Spinner
        med = view.findViewById(R.id.sp_med) as Spinner
        night = view.findViewById(R.id.sp_night) as Spinner
        job = view.findViewById(R.id.sp_job) as Spinner
        apply =view. findViewById(R.id.button) as Button
        //result=findViewById(R.id.tv_result) as TextView
        val options = arrayOf("1", "2", "3", "4", "5")
        climate.adapter =
            activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, options) }
        climate.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                a = options.get(position).toInt()


            }

        }
        med.adapter =
            activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, options) }
        med.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                b = options.get(position).toInt()

            }

        }
        night.adapter =
            activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, options) }
        night.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                c = options.get(position).toInt()
            }

        }
        job.adapter =
            activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, options) }
        job.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                //result.text="pls"
            }

            override fun onItemSelected(parent: AdapterView<*>,
                view: View?, position: Int, id: Long
            ) {
                d = options.get(position).toInt()
            }

        }
        cost.adapter =
            activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, options) }
        cost.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                e = options.get(position).toInt()
            }

        }
        apply.setOnClickListener {
            calc()
            val bundle= bundleOf("id_value" to avg)
            Log.d("MainActivity","onCreate() method finished"+"  "+avg)

            view.findNavController().navigate(R.id.action_optionFragment_to_preferenceFragment,bundle)

           // view.findNavController().navigate(R.id.confirmationAction, bundle)
            //intent.putExtra("id_value", avg)
            //startActivity(intent)
        }
        return view


    }




    fun calc() {

        val list = listOf(a, b, c, d, e)
        avg = list.average().toInt()

        /* if(avg>=2) {


            Log.d("one", "helo" + print("chennai"))
            Log.d("one", "helo" + print("bamg"))
            Log.d("one", "helo" + print("cmbt"))
        }
        else if(avg>=4){
            Log.d("on", "helo" + print("chennai"))
            Log.d("oe", "helo" + print("bamg"))
            Log.d("ne", "helo" + print("cmbt"))

        }
        else{
            Log.d("o", "helo" + print("chennai"))
            Log.d("ne", "helo" + print("bamg"))
            Log.d("ne", "helo" + print("cmbt"))
        }



    }*/
    }
}

