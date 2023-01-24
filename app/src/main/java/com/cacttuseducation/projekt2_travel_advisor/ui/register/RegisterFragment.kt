package com.cacttuseducation.projekt2_travel_advisor.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cacttuseducation.projekt2_travel_advisor.R
import com.cacttuseducation.projekt2_travel_advisor.databinding.FragmentRegisterBinding
import com.cacttuseducation.projekt2_travel_advisor.helpers.SingletonHelperObject
import com.cacttuseducation.projekt2_travel_advisor.ui.model.RegisterRequestModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToLogIn()
        makeApiCall()
    }

    private fun makeApiCall() {
        var name = binding.etRegisterName.text.toString()

        var email = binding.etRegisterMail.text.toString()
        var password = binding.etRegisterPassword.text.toString()
        if (!email.isEmpty() && !name.isEmpty() && !password.isEmpty()) {
            val registeredUser = RegisterRequestModel(email, name, password)
            val resultOfUserAdded =
                SingletonHelperObject.provideRetrofitInstanceForAuthentication().register(registeredUser)


            resultOfUserAdded.enqueue( object : Callback<RegisterRequestModel> {
                override fun onResponse(
                    call: Call<RegisterRequestModel>,
                    response: Response<RegisterRequestModel>
                ) {
                    Toast.makeText(
                        context,
                        "User registered succesfully",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    findNavController().navigate(R.id.action_nav_register_to_nav_login)
                }

                override fun onFailure(call: Call<RegisterRequestModel>, t: Throwable) {
                    Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
                }

            })

        }
    }

    private fun goToLogIn() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_nav_register_to_nav_login)
        }
    }


}


