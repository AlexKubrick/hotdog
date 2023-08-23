package ru.alexkubrick.hotdog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ru.alexkubrick.hotdog.databinding.FragmentSummaryBinding
import ru.alexkubrick.hotdog.model.HotdogOrderViewModel


class SummaryFragment : Fragment() {
    private var binding: FragmentSummaryBinding? = null
    private val sharedViewModel: HotdogOrderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            summaryFragment = this@SummaryFragment

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}