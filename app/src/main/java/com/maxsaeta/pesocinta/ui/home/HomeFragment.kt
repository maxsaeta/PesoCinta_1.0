package com.maxsaeta.pesocinta.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.maxsaeta.pesocinta.databinding.FragmentHomeBinding
import com.maxsaeta.pesocinta.ui.dashboard.DashboardViewModel
import domain.Peso
import domain.Velocidad

class HomeFragment : Fragment() {

  private lateinit var homeViewModel: HomeViewModel
  private lateinit var binding : FragmentHomeBinding
  private lateinit var velocidad : DashboardViewModel

  override fun onResume() {
    super.onResume()
    //binding.speed.setText(System.getProperty("speed"))

  }
  override fun onCreateView(
          inflater: LayoutInflater,
          container: ViewGroup?,
          savedInstanceState: Bundle?
  ): View? {
    binding = FragmentHomeBinding.inflate(inflater, container,false)
    homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
    velocidad =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

    binding.speed.setText(System.getProperty("speed"))
    homeViewModel.pesoteorico.observe(viewLifecycleOwner, Observer{
      binding.tvtnh. text = it.toString() + " TN/h"
      binding.tvkgs. text = (it/3.6f).toString() + " kg/s"
    })

    velocidad.velocidad.observe(viewLifecycleOwner, Observer {
      binding.speed.setText(it.toString())
    })
    binding.boton.setOnClickListener {
      homeViewModel.setPesoTeorico(Peso(
              binding.weightTest.text.toString().toFloat(),
              binding.lenght.text.toString().toFloat(),
              binding.speed.text.toString().toFloat()
      ))
    }
    return binding.root
  }
}