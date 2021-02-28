package com.maxsaeta.pesocinta.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.maxsaeta.pesocinta.databinding.FragmentDashboardBinding
import domain.Velocidad
import kotlinx.coroutines.launch


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDashboard.text = it

        })


        dashboardViewModel.velocidad.observe(viewLifecycleOwner, Observer {
            binding.tvspeed.text = it.toString() + " m/s"
            System.setProperty("speed", it.toString())
        })
        binding.botonVelocidad.setOnClickListener {
            lifecycleScope.launch {
                dashboardViewModel.setSpeed(Velocidad(
                        binding.diametro.text.toString().toFloat(),
                        binding.vueltas.text.toString().toFloat()
                ))
            }
        }
        return binding.root
    }
}