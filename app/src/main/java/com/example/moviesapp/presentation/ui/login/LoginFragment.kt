package com.example.moviesapp.presentation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        initListener()
        initObservers()
        return binding.root
    }

    private fun initListener() {
        binding.iFlCard.apply {
            bClSignIn.setOnClickListener {
                viewModel.validateUser(etClUser.text.toString(), etClPassword.text.toString())
            }
        }
    }

    private fun initObservers() {
        viewModel.error.observe(viewLifecycleOwner){
            if (it){
                findNavController().navigate(R.id.action_login_to_movie)
            } else{
                binding.tvFlAlert.visibility = View.VISIBLE
            }
        }
    }

}