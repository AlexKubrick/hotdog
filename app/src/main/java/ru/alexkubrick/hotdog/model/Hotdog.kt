package ru.alexkubrick.hotdog.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hotdog(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
