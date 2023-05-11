package com.example.s160420020_projectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.s160420020_projectuts.model.Book

class BookDetailViewModel(application: Application): AndroidViewModel(application) {
    val bookLD = MutableLiveData<Book>()
    val bookLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

    fun take(id:String) {
        loadingLD.value = true
        bookLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())

        if (id == "101")
        {
            bookLD.value =
                Book("101", "Doraemon", "4", "Doraemon adalah kartun yang digemari oleh anak-anak", "https://upload.wikimedia.org/wikipedia/id/c/c8/Doraemon_volume_1_cover.jpg")
        }
        else if (id == "102")
        {
            bookLD.value =
                Book("102", "Upin-Ipin", "5", "Upin-Ipin kartun dengan pribadi yang kembar", "https://www.bukukita.com/babacms/displaybuku/41585_f.jpg")
        }
        else if (id == "103")
        {
            bookLD.value =
                Book("103", "Naruto", "4.5", "Naruto yang bercita-cita menjadi hokage sejak semasa kecilnya", "https://serambi.net/wp-content/uploads/2021/03/Nonton-Naruto.jpg")
        }
        else if (id == "104")
        {
            bookLD.value =
                Book("104", "Tom&Jerry", "4", "Tom and Jerry merupakan kartun yang dimana kedua pemeran ini tidak pernah damai dalam kondisi apapun", "https://i.pinimg.com/236x/f9/d4/57/f9d457495cf345dc66f3e4aa0fde3fee.jpg")
        }
        else if (id == "105")
        {
            bookLD.value =
                Book("105", "Spiderman", "5", "Spiderman merupakan tokoh yang menggambarkan laba-laba", "https://cdn.marvel.com/u/prod/marvel/i/mg/f/10/598363848588e/detail.jpg")
        }
        else if (id == "106")
        {
            bookLD.value =
                Book("106", "Spiderman 2", "4.5", "Spiderman 2 dimana Peter belum melupakan janjinya pada Ayah Gwen yang tewas akibat serangan The Lizard", "https://cdn.marvel.com/u/prod/marvel/i/mg/f/10/598363848588e/detail.jpg")
        }
        else if (id == "107")
        {
            bookLD.value =
                Book("107", "Mr.Bean", "4", "Mr. bean merupakan sosok aktris yang memiliki sifat lucu sehingga disukai oleh banyak kalangan masyarakat", "https://cdn-2.tstatic.net/bangka/foto/bank/images/mr-bean_20160909_053220.jpg")
        }
        else if (id == "108")
        {
            bookLD.value =
                Book("108", "Bernard Bear", "4", "Kartun ini menceritakan seorang beruang yang bernama Bernard yang selalu sial di setiap apa yang dia ingin lakukan", "http://1.bp.blogspot.com/_PjKhx8tzVLI/TKBe7Ll2pMI/AAAAAAAACSs/7UQYdPVhf2Q/s200/bernard.jpg")
        }
        bookLoadErrorLD.value = false
        loadingLD.value = false




    }

}