package com.example.proyectologin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.proyectologin.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FLogin : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private lateinit var auth: FirebaseAuth

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext())
            .load("https://ps.w.org/login-customizer/assets/icon-256x256.png?rev=2455454").into(
                binding.imageLoginFragment
            )
        binding.buttonLogin.setOnClickListener {
            if (!binding.editUsuarioLogin.text.isEmpty() && !binding.editPassLogin.text.isEmpty()) {
                auth.signInWithEmailAndPassword(
                    binding.editUsuarioLogin.text.toString(),
                    binding.editPassLogin.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val bundle =Bundle()
                        bundle.putString("nombre",binding.editUsuarioLogin.text.toString())
                        bundle.putString("uid",auth.currentUser!!.uid)
                        findNavController().navigate(R.id.action_FLogin_to_SecondActivity,bundle)
                    } else {
                        Snackbar.make(
                            binding.root,
                            "Alguno de los datos es incorrecto",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            }


        }
        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}