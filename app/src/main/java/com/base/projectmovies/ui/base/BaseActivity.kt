package com.base.projectmovies.base


import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.util.*


open class BaseActivity : AppCompatActivity() {



    protected fun showSnackbar(
        view: View?,
        @StringRes message: Int,
        rtl: Boolean
    ) {
        showSnackbar(view, getString(message), rtl)
    }

    protected fun showSnackbar(
        view: View?,
        message: String?,
        rtl: Boolean
    ) {
        Snackbar.make(view!!, message!!, Snackbar.LENGTH_LONG).show()
    }





}