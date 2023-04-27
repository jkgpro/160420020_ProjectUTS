package com.example.s160420020_projectuts.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.s160420020_projectuts.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun createNotifChannel(context: Context, importance:Int, showBadge:Boolean, name:String,
                       description: String) {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val channelID = "${context.packageName}-$name"
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = description
        channel.setShowBadge(showBadge)

        val manager = context.getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }
}
fun ImageView.loadImage(url:String?, progressBar: ProgressBar) {
    Picasso.get().load(url).resize(400, 480)
        .centerCrop().error(R.drawable.baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {

            }

        })
}
