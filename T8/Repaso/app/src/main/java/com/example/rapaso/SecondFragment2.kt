package com.example.rapaso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rapaso.databinding.FragmentSecond2Binding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

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

        val adapter = ArrayAdapter.createFromResource(requireContext(),R.array.precios,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFiltro.setAdapter(adapter)

        binding.recyclerProductos.adapter = adaptador
        binding.recyclerProductos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        db.getReference("productos").addValueEventListener(object : ValueEventListener {
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

        binding.spinnerFiltro.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                db.getReference("productos").addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        productos.clear()
                        for (i in snapshot.children){
                            val nombre = i.key.toString()
                            val precio = i.child("precio").value.toString()

                            if (precio.toInt()<p0?.selectedItem.toString().toInt()){
                                var producto = Producto(nombre,precio)
                                println(precio)
                                productos.add(producto)
                            }
                        }
                        adaptador.actualizarLista(productos)
                    }
                    override fun onCancelled(error: DatabaseError) {
                        // error en la comunicacion
                    }
                })
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}