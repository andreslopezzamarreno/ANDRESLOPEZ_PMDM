package com.example.rapaso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rapaso.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.nombreFirstf.text.toString(),
                binding.contraseniaFirstf.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    Snackbar.make(binding.root,"Ya existe un usuario",Snackbar.LENGTH_LONG).setAction("¿Login?",
                        View.OnClickListener {
                            println("tu vieja")

                            var buldle = Bundle()
                            buldle.putSerializable("usuario",Usuario(binding.nombreFirstf.text.toString(),binding.contraseniaFirstf.text.toString(),auth.currentUser?.uid.toString()))
                            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,buldle)
                        }).show()

                } else {
                    if (!binding.nombreFirstf.text.isEmpty() || !binding.contraseniaFirstf.text.isEmpty() || !binding.edadFirstf.text.isEmpty()) {
                        auth.createUserWithEmailAndPassword(
                            binding.nombreFirstf.text.toString(),
                            binding.contraseniaFirstf.text.toString()
                        ).addOnCompleteListener {
                            if (it.isSuccessful){
                                println("Usuario creado correctamente")
                                var buldle = Bundle()
                                buldle.putSerializable("usuario",Usuario(binding.nombreFirstf.text.toString(),binding.contraseniaFirstf.text.toString(),auth.currentUser?.uid.toString()))
                                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,buldle)
                            }
                        }
                    }else{
                        println("Algun campo vacio")
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}