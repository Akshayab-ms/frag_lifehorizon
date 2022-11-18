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
import android.widget.SpinnerAdapter
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
        val view = inflater.inflate(R.layout.fragment_option, container, false)






        climate = view.findViewById(R.id.sp_climate) as Spinner
        cost = view.findViewById(R.id.sp_cost) as Spinner
        med = view.findViewById(R.id.sp_med) as Spinner
        night = view.findViewById(R.id.sp_night) as Spinner
        job = view.findViewById(R.id.sp_job) as Spinner
        apply = view.findViewById(R.id.button) as Button
        //result=findViewById(R.id.tv_result) as TextView

        var list = ArrayList<String>()
        list.add("1")
        list.add("2")
        list.add("3")
        list.add("4")
        list.add("5")

        climate.adapter =ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,list)

        /*climate.adapter =
            activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, options) }*/
       climate.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                a = list[position].toInt()


            }

        }
        med.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, list)
        med.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // result.text="pls"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                b = list[position].toInt()

            }

        }
        night.adapter =ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, list)
        night.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                c = list[position].toInt()
            }

        }
        job.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, list)
        job.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                d = list[position].toInt()
            }

        }


        cost.adapter =
         ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, list)
        cost.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                e = list[position].toInt()
            }

        }






        apply.setOnClickListener {
            calc()
            val bundle = bundleOf("id_value" to avg)
            Log.d("MainActivity", "onCreate() method finished" + "  " + avg)

            view.findNavController()
                .navigate(R.id.action_optionFragment_to_preferenceFragment, bundle)


        }
        return view


    }


    fun calc() {

        val list = listOf(a, b, c, d, e)
        avg = list.average().toInt()


    }
}

