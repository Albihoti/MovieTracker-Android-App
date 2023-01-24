package com.cacttuseducation.projekt2_travel_advisor.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cacttuseducation.projekt2_travel_advisor.R

import com.cacttuseducation.projekt2_travel_advisor.databinding.FragmentLoginBinding
import com.cacttuseducation.projekt2_travel_advisor.helpers.SingletonHelperObject
import com.cacttuseducation.projekt2_travel_advisor.ui.model.LoginRequestModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)

//    val textView: TextView = binding.loginEmail
//    galleryViewModel.text.observe(viewLifecycleOwner) {
//      textView.text = it

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToRegisterFragment()
        makeApiCall()
    }

    private fun makeApiCall() {
        binding.btnLogin.setOnClickListener {
            val email = binding.loginEmail.text.toString()
            val password = binding.loginPassword.text.toString()


            if (!email.isEmpty() && !password.isEmpty()) {
                val newUser = LoginRequestModel(email, password)

                val resultOfUserLogged =
                    SingletonHelperObject.provideRetrofitInstanceForAuthentication().login(newUser)


                resultOfUserLogged.enqueue(object : Callback<LoginRequestModel> {
                    override fun onResponse(
                        call: Call<LoginRequestModel>,
                        response: Response<LoginRequestModel>
                    ) {
                        val isLogged = SingletonHelperObject.putBooleanOnSharedPrefs(
                            requireContext(),
                            "isLoggedIn", true
                        )
                        if (isLogged.equals(true)) {
                            findNavController().navigate(R.id.action_nav_login_to_nav_movies)
                        }
                    }

                    override fun onFailure(call: Call<LoginRequestModel>, t: Throwable) {
                        Log.d("Log", t.message.toString())
                    }

                }
                )

            }
        }
    }

    private fun goToRegisterFragment() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_nav_login_to_nav_register)
        }
    }


}