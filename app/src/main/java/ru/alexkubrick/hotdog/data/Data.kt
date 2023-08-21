package ru.alexkubrick.hotdog.data

import ru.alexkubrick.hotdog.R
import ru.alexkubrick.hotdog.model.Hotdog

class Data() {

    fun loadHotDog(): List<Hotdog> {
        return listOf<Hotdog>(
            Hotdog(R.string.hotdog_ketchup,R.drawable.hotdogketchup),
            Hotdog(R.string.hotdog_mustard,R.drawable.hotdogmustard),
            Hotdog(R.string.hotdog_mayo, R.drawable.hotdogmayo)
        )
    }
}