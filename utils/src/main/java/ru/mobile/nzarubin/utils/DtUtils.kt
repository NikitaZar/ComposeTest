package ru.mobile.nzarubin.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toStringDate(): String = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(date)