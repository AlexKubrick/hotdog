package ru.alexkubrick.hotdog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.alexkubrick.hotdog.adapter.ItemAdapter
import ru.alexkubrick.hotdog.data.Data
import ru.alexkubrick.hotdog.databinding.FragmentFlavorBinding
import ru.alexkubrick.hotdog.model.Hotdog


class FlavorFragment : Fragment() {
    private var binding: FragmentFlavorBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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

        val hotdogList = Data().loadHotDog()
        val itemAdapter = ItemAdapter(requireContext(), hotdogList)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycleView) // возможно ли переписать эту строку через binding?
        recyclerView.layoutManager = LinearLayoutManager(context)
        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.adapter = itemAdapter

        itemAdapter.setOnClickListener(object : ItemAdapter.OnClickListener {
            override fun onClick(position: Int, model: Hotdog) {
                // Navigate to the next screen (fragment)
                findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
            }
        })
    }
}