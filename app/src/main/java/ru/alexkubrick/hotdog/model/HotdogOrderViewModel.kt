package ru.alexkubrick.hotdog.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Calendar

private const val PRICE_PER_HOTDOG = 150.00

class HotdogOrderViewModel: ViewModel() {
    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String> = _flavor

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    //https://proandroiddev.com/livedata-transformations-4f120ac046fc
    //https://stackoverflow.com/questions/46930335/what-is-difference-between-mediatorlivedata-and-mutablelivedata-in-mvvm
    //https://stackoverflow.com/questions/75465435/unresolved-reference-transformations-after-upgrading-lifecycle-dependency

    private val _price = MutableLiveData<Double>()
    val price = MediatorLiveData<String>().apply {
        addSource(_price) {
            value = NumberFormat.getCurrencyInstance().format(it)
        }
    }

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
        updatePrice()
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }

    val dateOptions = getPickupDate()

//    fun handleItemClick(item: Hotdog) { // не знаю как из айтема ресайклра взять информацию о нажатом айтеме
//
//    }

    private fun updatePrice() {
        _price.value = (quantity.value ?: 0) * PRICE_PER_HOTDOG

    }

    private fun getPickupDate(): List<String> {
        val date = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()

        repeat(4) {
            date.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }

        return date
    }

    init {
        resetOrder()
    }

    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }


}