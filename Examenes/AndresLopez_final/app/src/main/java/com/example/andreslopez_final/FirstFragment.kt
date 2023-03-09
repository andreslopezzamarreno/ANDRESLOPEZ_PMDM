package com.example.andreslopez_final

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.andreslopez_final.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseDatabase
    private var numero = 1

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        db = FirebaseDatabase.getInstance("https://fir-ces-alz-default-rtdb.firebaseio.com/")
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.editUsuarioF1.text.toString(),
                binding.editPassF1.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {

                    db.getReference("usuarios").child(auth.currentUser?.uid.toString())
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {
                                    for (i in snapshot.children) {
                                        println("valor: " + i)
                                        numero = i.value.toString().toInt() + 1
                                        Log.v("num",numero.toString())
                                    }
                                }
                            }
                            override fun onCancelled(error: DatabaseError) {
                                // TODO("Not yet implemented")
                            }
                        })
                    /*db.getReference("usuarios").child(auth.currentUser?.uid.toString())
                        .child("logOnCount")
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                for (i in snapshot.children) {
                                    numero = i.value.toString().toInt()
                                }
                                println(snapshot.value)
                            }

                            override fun onCancelled(error: DatabaseError) {
                                TODO("Not yet implemented")
                            }
                        })*/

                    var bundle = Bundle()
                    bundle.putString("uid", auth.currentUser?.uid.toString())
                    bundle.putInt("numLog", numero)

                    findNavController().navigate(
                        R.id.action_FirstFragment_to_SecondFragment,
                        bundle
                    )

                } else {
                    Snackbar.make(binding.buttonFirst, "Error al hacar login", Snackbar.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}