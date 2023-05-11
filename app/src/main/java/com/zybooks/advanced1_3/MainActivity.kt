package com.zybooks.advanced1_3
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up notification channel
        createNotificationChannel()

        val button = findViewById<Button>(R.id.button)
        val image = findViewById<ImageView>(R.id.image)

        button.setOnClickListener {
            // Show notification
            val notification = NotificationCompat.Builder(this, "my_channel_id")
                .setContentTitle("My Notification")
                .setContentText("This is my notification.")
                .setSmallIcon(R.drawable.my_notification_icon)
                .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            NotificationManagerCompat.from(this).notify(1, notification)

            // Animate image
            val anim = ObjectAnimator.ofFloat(image, "rotation", 0f, 360f)
            anim.duration = 1000
            anim.start()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "My Channel"
            val descriptionText = "My Notification Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("my_channel_id", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}