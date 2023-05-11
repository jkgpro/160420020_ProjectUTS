package com.example.s160420020_projectuts.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.s160420020_projectuts.model.Login

class LoginDetailViewModel(application: Application): AndroidViewModel(application) {
    val loginLD = MutableLiveData<Login>()
    val loginLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

    fun takeLogin(username:String) {
        loadingLD.value = true
        loginLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())

        if (username == "Jeremy")
        {
            loginLD.value = Login("1001", "Jeremy", "123", "Rungkut")
        }
        else if (username == "Kenneth")
        {
            loginLD.value =  Login("1002", "Kenneth", "321", "Tenggilis")

        }
        else if (username == "Gunawan")
        {
            loginLD.value = Login("1003", "Gunawan", "135", "Mayjend")

        }
        else if (username == "Jer")
        {
            loginLD.value = Login("1004", "Jer", "531", "Sungkono")

        }
        else if (username == "Ken")
        {
            loginLD.value = Login("1005", "Ken", "151", "Soekarno")
        }
        loginLoadErrorLD.value = false
        loadingLD.value = false
    }

}