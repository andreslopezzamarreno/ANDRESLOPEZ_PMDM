package com.example.rapaso


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rapaso.databinding.FragmentSecondBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var usuario: Usuario
    private lateinit var db: FirebaseDatabase
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        db = FirebaseDatabase.getInstance("https://fir-ces-alz-default-rtdb.firebaseio.com/")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usuario = arguments?.getSerializable("usuario") as Usuario

        println(usuario.nombre)

        binding.usuarioSecondF.setText(usuario.nombre)
        binding.contraseniaSecondF.setText(usuario.pass)

        binding.buttonSecond.setOnClickListener {
            db.getReference("usuarios").child(usuario.uid).child("nombre").setValue(usuario.nombre)
            var buldle = Bundle()
            buldle.putSerializable("usuario",usuario)
            findNavController().navigate(R.id.action_SecondFragment_to_SecondActivity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}