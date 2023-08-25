package ru.alexkubrick.hotdog.data

import ru.alexkubrick.hotdog.R

class RecyclerData() {

    fun loadHotDog(): List<HotdogDataClass> {
        return listOf<HotdogDataClass>(
            HotdogDataClass(R.string.hotdog_ketchup,R.drawable.hotdogketchup),
            HotdogDataClass(R.string.hotdog_mustard,R.drawable.hotdogmustard),
            HotdogDataClass(R.string.hotdog_mayo, R.drawable.hotdogmayo)
        )
    }
}