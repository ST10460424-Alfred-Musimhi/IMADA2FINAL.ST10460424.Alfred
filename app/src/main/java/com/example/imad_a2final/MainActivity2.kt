package com.example.imad_a2final

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity2 : AppCompatActivity() {

    // Pet status variables
    var happy = 0
    var feed = 0
    var clean = 0
    private lateinit var petImageView: ImageView
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize views
        petImageView = findViewById(R.id.imageView)

        // Initialize handler
        handler = Handler(Looper.getMainLooper())

        // Set initial status values on UI
        updateStatus()

        // Set up main game screen button click listeners
        val feedButton: Button = findViewById(R.id.feedButton)
        feedButton.setOnClickListener {
            feedPet()
            updatePetImage("feed")
        }

        val cleanButton: Button = findViewById(R.id.cleanButton)
        cleanButton.setOnClickListener {
            cleanPet()
            updatePetImage("clean")
        }

        val playButton: Button = findViewById(R.id.happyButton)
        playButton.setOnClickListener {
            happyWithPet()
            updatePetImage("play")
        }

        // Start timer to decrease status every minute
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                decreaseStatus()
                updatePetImage(null) // Update image without specific button click
            }
        }, 60000, 60000)

        // Update pet's image initially
        updatePetImage(null)
    }

    private fun feedPet() {
        // Update pet's image and status values for feeding action
        feed += 10
        if (feed > 100) feed = 100
        updateStatus()
    }

    private fun cleanPet() {
        // Update pet's image and status values for cleaning action
        clean += 10
        if (clean > 100) clean = 100
        updateStatus()
    }

    private fun happyWithPet() {
        // Update pet's image and status values for playing action
        happy += 10
        if (happy > 100) happy = 100
        updateStatus()
    }

    fun decreaseStatus() {
        // Decrease health, hunger, and cleanliness every minute
        happy -= 10
        feed -= 10
        clean -= 10
        if (happy < 0) happy = 0
        if (feed < 0) feed = 0
        if (clean < 0) clean = 0
        updateStatus()
    }

    private fun updatePetImage(buttonClicked: String?) {
        // Check which button was clicked
        val drawableId = when (buttonClicked) {
            "feed" -> {
                if (feed < 100) R.drawable.scoobyeating2
                else R.drawable.img_0927__1__removebg_preview__2_
            }

            "clean" -> {
                if (clean < 100) R.drawable.scoobybatting
                else R.drawable.img_0927__1__removebg_preview__2_
            }

            "play" -> {
                if (happy < 100) R.drawable.scoobyhappy_removebg_preview
                else R.drawable.img_0927__1__removebg_preview__2_
            }

            else -> {
                // Check if all statuses are at maximum level
                if (feed == 100 && clean == 100 && happy == 100)
                    R.drawable.img_0927__1__removebg_preview__2_
                else
                    R.drawable.img_0927__1__removebg_preview__2_ // Default image if no button clicked
            }
        }
        petImageView.setImageResource(drawableId)
    }


    private fun updateStatus() {
        // Update status values displayed on the UI
        handler.post {
            val feedTextView: TextView = findViewById(R.id.textViewFeed)
            val happyTextView: TextView = findViewById(R.id.textViewHappy)
            val cleanTextView: TextView = findViewById(R.id.textViewClean)

            feedTextView.text = "Feed: $feed"
            happyTextView.text = "Happy: $happy"
            cleanTextView.text = "Clean: $clean"
        }
    }
}
