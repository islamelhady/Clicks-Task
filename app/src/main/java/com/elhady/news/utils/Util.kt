package com.elhady.news.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.makeToast(message: String) { Toast.makeText(context, message, Toast.LENGTH_LONG).show() }

fun View.show() { visibility = View.VISIBLE }

fun show(vararg views: View) { views.forEach { it.show() } }

fun View.hide() { visibility = View.GONE }

fun hide(vararg views: View) { views.forEach { it.hide() } }

fun View.invisible() { visibility = View.INVISIBLE }

fun EditText.clear() { text.clear() }


fun isNetworkAvailable(context: Context): Boolean? {
    var isConnected: Boolean? = false // Initial Value
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}