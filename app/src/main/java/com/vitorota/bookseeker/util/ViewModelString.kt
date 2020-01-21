package com.vitorota.bookseeker.util

import android.content.Context
import androidx.annotation.StringRes

class ViewModelString {

    private var string: String? = null
    private var resource: Int? = null
    private var arguments: Array<out Any>? = null

    constructor(@StringRes value: Int) {
        resource = value
    }

    constructor(value: String) {
        string = value
    }

    fun setValue(@StringRes value: Int) {
        string = null
        resource = value
    }

    fun setValue(value: String, vararg args: Any) {
        resource = null
        string = value
        arguments = args
    }

    fun getValue(context: Context): String {
        return if (string != null) {
            string!!
        } else {
            if (arguments != null && arguments?.isNotEmpty() == true) {
                context.getString(resource!!, arguments)
            } else {
                context.getString(resource!!)
            }
        }
    }
}