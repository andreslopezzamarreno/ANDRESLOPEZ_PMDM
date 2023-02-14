package com.example.fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings.LayoutAlgorithm
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.fragments.RecyclerAdapter
import com.example.fragments.Usuario
import com.example.fragments.databinding.FragmentTresBinding
import com.google.android.material.snackbar.Snackbar

class FragmentTres : Fragment() {

    private lateinit var binding: FragmentTresBinding
    private lateinit var usuario: Usuario
    private lateinit var adaptador: RecyclerAdapter

    companion object {
        fun newInstance(usuario: Usuario): FragmentTres {
            val args = Bundle()
            args.putSerializable("usuario", usuario)
            val fragment = FragmentTres()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        var listaUsuarios = ArrayList<Usuario>()
        adaptador = RecyclerAdapter(listaUsuarios,requireContext().applicationContext)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuario = this.arguments?.getSerializable("usuario") as Usuario

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.recyclerUsuarios.adapter = adaptador
        // linear (v h)
        // grid (v h,columns)
        // staggered (v h,columns)
        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        //binding.recyclerUsuarios.layoutManager = GridLayoutManager(requireContext(),2,LinearLayoutManager.VERTICAL,false)
        //binding.recyclerUsuarios.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        //Snackbar.make(binding.root, usuario.apellido, Snackbar.LENGTH_SHORT).show()
        adaptador.aniadirUsuario(usuario)
    }

}