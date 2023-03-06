package com.example.rapaso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rapaso.databinding.FragmentSecond2Binding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.runInterruptible
import kotlin.math.log

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment2 : Fragment() {

    private var _binding: FragmentSecond2Binding? = null
    private lateinit var db: FirebaseDatabase
    private lateinit var productos: ArrayList<Producto>
    private lateinit var adaptador: AdaptadorProductos
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        db = FirebaseDatabase.getInstance("https://fir-ces-alz-default-rtdb.firebaseio.com/")
        productos = ArrayList()
        adaptador = AdaptadorProductos(requireContext(),productos)

        _binding = FragmentSecond2Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerProductos.adapter = adaptador
        binding.recyclerProductos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        db.getReference("productos").child("").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                productos.clear()
                for (i in snapshot.children){
                    val nombre = i.key.toString()
                    val precio = i.child("precio").value.toString()

                    var producto = Producto(nombre,precio)
                    println(precio)
                    productos.add(producto)
                }
                adaptador.actualizarLista(productos)
               }
            override fun onCancelled(error: DatabaseError) {
                // error en la comunicacion
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}