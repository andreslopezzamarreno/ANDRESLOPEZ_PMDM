package com.example.rapaso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rapaso.databinding.FragmentFirst2Binding
import com.google.firebase.database.FirebaseDatabase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment2 : Fragment() {

    private var _binding: FragmentFirst2Binding? = null
    private lateinit var db: FirebaseDatabase
    private lateinit var nombre: String
    private var precio: Int = 0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        db = FirebaseDatabase.getInstance("https://fir-ces-alz-default-rtdb.firebaseio.com/")
        _binding = FragmentFirst2Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonAniadir2f.setOnClickListener {
            nombre = binding.nombreProducto.text.toString()
            precio = binding.precioProducto.text.toString().toInt()
            db.getReference("productos").child(nombre).child("nombre").setValue(nombre)
            db.getReference("productos").child(nombre).child("precio").setValue(precio)
        }

        binding.buttonProducto2f.setOnClickListener {
            findNavController().navigate(R.id.action_First2Fragment_to_Second2Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}