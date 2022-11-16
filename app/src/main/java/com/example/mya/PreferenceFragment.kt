package com.example.mya

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController


class PreferenceFragment : Fragment() {
    var txtinOne = ""
    var txtinTwo = ""
    var txtinThree = ""

    lateinit var cityone: TextView

    lateinit var citytwo: TextView

    lateinit var cityThree: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_preference, container, false)


        cityone = view.findViewById(R.id.tv_firstp)

        citytwo = view.findViewById(R.id.tv_secondp)

        cityThree = view.findViewById(R.id.tv_thirdp)




        city()
        cityone.setOnClickListener {
            txtinOne = cityone.text as String

            if (txtinOne == "Bangalore") {

                val bundle= bundleOf("cityname" to txtinOne)

                view.findNavController().navigate(R.id.action_preferenceFragment_to_finalFragment,bundle)


//                intent = Intent(this, TempActivity::class.java)
//                intent.putExtra("cityname", txtinOne)
//                startActivity(intent)

            } else if (txtinOne == "Kerala") {
                /* val url = "https://www.javatpoint.com/kotlin-android-textview-and-edittext"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
                /*intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinOne)
                startActivity(intent)*/
                val bundle= bundleOf("cityname" to txtinOne)

                view.findNavController().navigate(R.id.action_preferenceFragment_to_finalFragment,bundle)
            } else if (txtinOne == "Mysore") {
                /* val url = "https://www.javatpoint.com/kotlin-android-textview-and-edittext"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
              /*  intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinOne)
                startActivity(intent)*/
                val bundle= bundleOf("cityname" to txtinOne)

                view.findNavController().navigate(R.id.action_preferenceFragment_to_finalFragment,bundle)

            } else {
                Toast.makeText(getActivity(),
                    "Does not match",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }
        citytwo.setOnClickListener {

            txtinTwo = citytwo.text as String



            if (txtinTwo == "Chennai") {
                /*  val url = "http://www.google.com"
                  intent = Intent(Intent.ACTION_VIEW)
                  intent.data = Uri.parse(url)
                  startActivity(intent)*/
              /*  intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinTwo)
                startActivity(intent)*/
                val bundle= bundleOf("cityname" to txtinTwo)

                view.findNavController().navigate(R.id.action_preferenceFragment_to_finalFragment,bundle)

            } else if (txtinTwo == "Hyderabad") {
                /*  val url = "http://www.google.com"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
                /*intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinTwo)
                startActivity(intent)*/
                val bundle= bundleOf("cityname" to txtinTwo)

                view.findNavController().navigate(R.id.action_preferenceFragment_to_finalFragment,bundle)

            } else if (txtinTwo == "Pune") {
                /*  val url = "http://www.google.com"
              intent = Intent(Intent.ACTION_VIEW)
              intent.data = Uri.parse(url)
              startActivity(intent)*/
               /* intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinTwo)
                startActivity(intent)*/
                val bundle= bundleOf("cityname" to txtinTwo)

                view.findNavController().navigate(R.id.action_preferenceFragment_to_finalFragment,bundle)


            } else {
                Toast.makeText(
                    getActivity(),
                    "Does not match",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        cityThree.setOnClickListener {
            txtinThree = cityThree.text as String
            if (txtinThree == "Mumbai") {
                /*  val url = "http://www.google.com"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
                /*intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinThree)
                startActivity(intent)*/
                val bundle= bundleOf("cityname" to txtinTwo)

                view.findNavController().navigate(R.id.action_preferenceFragment_to_finalFragment,bundle)

            } else if (txtinThree == "Coimbatore") {
                /*  val url = "http://www.google.com"
               intent = Intent(Intent.ACTION_VIEW)
               intent.data = Uri.parse(url)
               startActivity(intent)*/
              /*  intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinThree)
                startActivity(intent)*/
                val bundle= bundleOf("cityname" to txtinThree)

                view.findNavController().navigate(R.id.action_preferenceFragment_to_finalFragment,bundle)

            } else if (txtinThree == "Belgaum") {
                /*  val url = "http://www.google.com"
                 intent = Intent(Intent.ACTION_VIEW)
                 intent.data = Uri.parse(url)
                 startActivity(intent)*/
              /*  intent = Intent(this, TempActivity::class.java)
                intent.putExtra("cityname", txtinThree)
                startActivity(intent)*/
                val bundle= bundleOf("cityname" to txtinThree)

                view.findNavController().navigate(R.id.action_preferenceFragment_to_finalFragment,bundle)


            } else {
                Toast.makeText(getActivity(),
                    "Does not match",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        return view
    }





    fun city(){


        var id=arguments?.getInt("id_value")





        Log.d("hjj","hh"+id)




        //val bundle:Bundle?=view.findViewById<TextView>(R.id.)
        /*val bundle: Bundle? = intent.extras
        var id = bundle?.get("cityname") as Int*/
        Log.d("hjj","hh"+id)
        Log.d("MainActivity","onCreate() method finished"+"  "+id)



        if (id != null) {
            if(id>3) {

                Log.d("jj","hh"+id)

                cityone.setText("Bangalore").toString()
                citytwo.setText("Chennai").toString()
                cityThree.setText("Mumbai").toString()


                /*
                            Log.d("one", "helo" + print("chennai"))
                            Log.d("one", "helo" + print("bamg"))
                            Log.d("one", "helo" + print("cmbt"))*/
            } else if(id==3){
                cityone.setText("Kerala").toString()
                citytwo.setText("Hyderabad").toString()
                cityThree.setText("Coimbatore").toString()
                /*Log.d("on", "helo" + print("chennai"))
                            Log.d("oe", "helo" + print("bamg"))
                            Log.d("ne", "helo" + print("cmbt"))
                */
            } else {
                cityone.setText("Mysore").toString()
                citytwo.setText("Pune").toString()
                cityThree.setText("Belgaum").toString()
                /*  Log.d("o", "helo" + print("chennai"))
                              Log.d("ne", "helo" + print("bamg"))
                              Log.d("ne", "helo" + print("cmbt"))*/
            }
        }
        }
}












