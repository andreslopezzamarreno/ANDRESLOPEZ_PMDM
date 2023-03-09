package com.example.andreslopez_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andreslopez_final.databinding.FragmentSecondBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var listaProducto: ArrayList<Producto>
    private lateinit var adaptador :AdaptadorProductos
    private lateinit var db: FirebaseDatabase
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listaProducto = ArrayList()
        adaptador = AdaptadorProductos(requireContext(),listaProducto)
        db = FirebaseDatabase.getInstance("https://fir-ces-alz-default-rtdb.firebaseio.com/")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var id = arguments?.getString("uid")
        var num = arguments?.getInt("numLog")

        //println("numero 2f: ${num}")

        db.getReference("usuarios").child(id.toString())
            .child("logOnCount").setValue(num)

        db.getReference("productos").addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (i in snapshot.children){
                        var producto = i.getValue(Producto::class.java)
                        adaptador.aniadirProducto(producto as Producto)
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // TODO("Not yet implemented")
            }
        })
        binding.recyclerF2.adapter = adaptador
        binding.recyclerF2.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}