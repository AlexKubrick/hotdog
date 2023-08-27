package ru.alexkubrick.hotdog.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.alexkubrick.hotdog.R
import ru.alexkubrick.hotdog.adapter.FlavorAdapter
import ru.alexkubrick.hotdog.data.HotdogDataClass
import ru.alexkubrick.hotdog.data.RecyclerData
import ru.alexkubrick.hotdog.databinding.FragmentFlavorBinding
import ru.alexkubrick.hotdog.model.HotdogOrderViewModel


class FlavorFragment : Fragment() {
    private var binding: FragmentFlavorBinding? = null
    private val sharedViewModel: HotdogOrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val fragmentBinding = FragmentFlavorBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hotdogList = RecyclerData().loadHotDog()
        val onClick = { flavor: String ->
            sharedViewModel.setFlavor(flavor)
            findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
        }
        val itemAdapter = FlavorAdapter(requireContext(), hotdogList, onClick)


        binding?.recycleView?.apply { 
            layoutManager = LinearLayoutManager(context)
            adapter = itemAdapter
        }
    }
}