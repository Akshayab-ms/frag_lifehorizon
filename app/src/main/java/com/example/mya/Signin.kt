package com.example.mya

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build.VERSION_CODES.M
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class Signin : Fragment() {

    var lphno: EditText? = null
    var lpassword: EditText? = null
    var lbutton: Button? = null
    var sharedPreferences: SharedPreferences? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_signin, container, false)

         sharedPreferences = requireActivity().applicationContext.getSharedPreferences("MyPREFERENCES",   Context.MODE_PRIVATE) // kotlin

        //sharedPreferences = getSharedPreferences(MyPREFERENCES, AppCompatActivity.MODE_PRIVATE)
        lphno = view.findViewById(R.id.mobile)
        lpassword = view.findViewById(R.id.password)
        lbutton = view.findViewById(R.id.button_signin)
        lbutton?.setOnClickListener(View.OnClickListener { checkLoginDetails()

           // findNavController().navigate(R.id.action_signin2_to_optionFragment)


         /* val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_signin, Fragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()*/
        })




        return view

    }





    private fun checkLoginDetails() {
        val phoneNo = lphno!!.getText().toString()
        val password = lpassword!!.getText().toString()
        val sharedPhone = sharedPreferences!!.getString("Phone", "")
        val sharedPassword = sharedPreferences!!.getString("ConfirmPassword", "")
        if (TextUtils.isEmpty(phoneNo)) {
            lphno!!.setError("phone number is required to login")
        } else if (TextUtils.isEmpty(password)) {
            lpassword!!.setError("password is required to login")
        } else if (phoneNo == sharedPhone && password == sharedPassword) {
            Toast.makeText(getActivity(), "welcome", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_signin2_to_optionFragment)


        } else {
            Toast.makeText(getActivity(), "invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }
}

