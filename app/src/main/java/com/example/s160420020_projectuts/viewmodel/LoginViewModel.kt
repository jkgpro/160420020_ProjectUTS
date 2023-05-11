package com.example.s160420020_projectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.s160420020_projectuts.model.Login

class LoginViewModel(application: Application): AndroidViewModel(application) {
    val loginsLD = MutableLiveData<ArrayList<Login>>()
    val loginLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"

    private var queue:RequestQueue? = null

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

    fun refreshLogin() {
        loadingLD.value = true
        loginLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())

        loginsLD.value = arrayListOf(
            Login("1001", "Jeremy", "123", "Rungkut"),
            Login("1002", "Kenneth", "321", "Tenggilis"),
            Login("1003", "Gunawan", "135", "Mayjend"),
            Login("1004", "Jer", "531", "Sungkono"),
            Login("1005", "Ken", "151", "Soekarno")
        )
        loginLoadErrorLD.value = false
        loadingLD.value = false
    }

}