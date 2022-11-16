package com.example.mya

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import java.util.*


class signup : Fragment() {


    var rName: EditText? = null
    var rEmail: EditText? = null
    var rMobileNo: EditText? = null
    var rPassword: EditText? = null
    var rConfirmPassword: EditText? = null
    var register: Button? = null
    var sharedPreferences: SharedPreferences? = null
    var newUser: String? = null
    var newMail: String? = null
    var newPassword: String? = null
    var newPhNo: String? = null
    var newCnFrmPass: String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        val view = inflater.inflate(R.layout.fragment_signup, container, false)




    rName = view?.findViewById(R.id.tv_name)
    rEmail =  view?.findViewById(R.id.tv_mail)
    rMobileNo =  view?.findViewById(R.id.tv_mob)
    rPassword = view?. findViewById(R.id.tv_pwd)
    rConfirmPassword =  view?.findViewById(R.id.tv_cnfpwd)
    register =  view?.findViewById(R.id.button)



        sharedPreferences = requireActivity().applicationContext.getSharedPreferences("MyPREFERENCES",   Context.MODE_PRIVATE) // kotlin

    val editor = sharedPreferences?.edit()
    if (!sharedPreferences?.getString("phoneKey", "")!!.isEmpty()) {
        // startActivity(Intent(this, LoginActivity::class.java))
    }


        register?.setOnClickListener(View.OnClickListener {
            newUser = Objects.requireNonNull(rName?.getText()).toString()
            newMail = Objects.requireNonNull(rEmail?.getText()).toString()
            newPassword = Objects.requireNonNull(rPassword?.getText()).toString()
            newCnFrmPass = Objects.requireNonNull(rConfirmPassword?.getText()).toString()
            newPhNo = Objects.requireNonNull(rMobileNo?.getText()).toString()
            checkDataEntered()
            editor?.putString(Name, newUser)
            editor?.putString(email, newMail)
            editor?.putString(Password, newPassword)
            editor?.putString(ConfirmPassword, newCnFrmPass)
            editor?.putString(Phone, newPhNo)
            val commit = editor?.commit()
        })


    return view


    }


    fun isEmpty(text: EditText?): Boolean {
        val str: CharSequence = text!!.text.toString()
        return TextUtils.isEmpty(str)
    }

    fun isEmail(text: EditText?): Boolean {
        val email: CharSequence = text!!.text.toString()
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun isPhone(text: EditText?):Boolean {
        var newPhNo: CharSequence = text!!.text.toString()
        return !TextUtils.isEmpty(newPhNo) && Patterns.PHONE.matcher(newPhNo).matches()

    }


    fun checkDataEntered() {
        if (isEmpty(rName)) {
            rName!!.error = "Name is required"
        } else if (!isEmail(rEmail)) {
            rEmail!!.error = "Enter valid email!"
        } else if (isPhone(rMobileNo)) {
            rMobileNo!!.error = "phNo is required"
        } else if (isEmpty(rPassword)) {
            rPassword!!.error = "Password is required"
        } else if (isEmpty(rConfirmPassword)) {
            rConfirmPassword!!.error = "ConfirmPassword is required"
        } else if (rConfirmPassword!!.text.toString() != rPassword!!.text.toString()) {
            rConfirmPassword!!.error = " Password does not matching"
        } else {
            Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_signup_to_optionFragment)

            /*val transaction = activity?.supportFragmentManager?.beginTransaction()
            //transaction?.replace(R.id.frame_signup, Signin())
            transaction?.replace(R.id.frame_signup, Signin())
            transaction?.disallowAddToBackStack()

            transaction?.commit()*/
        }
    }

    companion object {
        const val MyPREFERENCES = "MyPREFERENCES"
        const val Name = "Name"
        const val email = "Email"
        const val Phone = "Phone"
        const val Password = "PassWord"
        const val ConfirmPassword = "ConfirmPassword"
    }
}







    /*fun isEmail(text: TextInputEditText?): Boolean {
        val newMail: CharSequence = Objects.requireNonNull(text!!.text).toString()
        return !TextUtils.isEmpty(newMail) && Patterns.EMAIL_ADDRESS.matcher(newMail).matches()
    }

    fun isPhone(text: TextInputEditText?):Boolean {
        var newPhNo: CharSequence = Objects.requireNonNull(text!!.text).toString()
        return !TextUtils.isEmpty(newPhNo) && Patterns.PHONE.matcher(newPhNo).matches()

    }

    fun isEmpty(text: TextInputEditText?): Boolean {
        val str: CharSequence = Objects.requireNonNull(text!!.text).toString()
        return TextUtils.isEmpty(str)
    }





    private fun checkDataEntered() {
        if (newUser!!.isEmpty()) {
            name!!.error = "Enter your name in the field"
        } else if (isEmpty(mail as TextInputEditText?)) {
            mail!!.error = "It should not be empty"
        } else if (!isEmail(mail as TextInputEditText?)) {
            mail!!.error = "Enter valid email"
        } else if (isEmpty(mobileNo)) {
            mobileNo!!.error = "Enter your Phone number"
        } else if (!isPhone(mobileNo)){
            mobileNo!!.error = "Enter valid number "
        }
        else if (isEmpty(password)) {
            password!!.error = "This field required password"
        } else if (isEmpty(confirmPassword)) {
            confirmPassword!!.error = "Enter your confirm password"
        } else if (confirmPassword!!.text.toString() != password!!.text.toString()) {
            confirmPassword!!.error = "Your password does not matching"
        } else {
            Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show()
           *//* val intent = Intent(this@MainActivity, LoginActivity::class.java)
            ContextCompat.startActivity(intent)*//*
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_signup, Signin())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
    }



    companion object {
        const val MyPREFERENCES = "myPreferences"
        const val Name = "nameKey"
        const val email = "mailKey"
        const val phone = "phoneKey"
        const val Password = "passWordKey"
        const val ConfirmPassword = "confirmPassKey"
    }
}
*/