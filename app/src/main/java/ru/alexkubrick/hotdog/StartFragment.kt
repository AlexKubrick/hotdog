package ru.alexkubrick.hotdog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.alexkubrick.hotdog.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private var binding: FragmentStartBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding?.startFragment = this // не работает

        binding?.apply {
            // Set up the button click listeners
            orderOneHotdog.setOnClickListener { orderHotdog() }
            orderSixHotdog.setOnClickListener { orderHotdog() }
            orderTwelveHotdog.setOnClickListener { orderHotdog() }
        }
    }

    fun orderHotdog() {
        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)

    }
}

