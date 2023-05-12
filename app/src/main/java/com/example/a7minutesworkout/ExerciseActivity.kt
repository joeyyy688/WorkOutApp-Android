package com.example.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.a7minutesworkout.databinding.ActivityExerciseBinding
import com.example.a7minutesworkout.databinding.ActivityMainBinding

class ExerciseActivity : AppCompatActivity() {

    private var binding: ActivityExerciseBinding? = null
    private var countdownchecker: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Exercise AppBar Declaration
        setSupportActionBar(binding?.exerciseAppBar)

        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        // AppBar leading element onPress action
        binding?.exerciseAppBar?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding?.flProgressBar?.setOnClickListener {
            val timer = object: CountDownTimer(10000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    countdownchecker++

                    binding?.progressBar?.progress = countdownchecker
                    binding?.tvTimer?.text = countdownchecker.toString()
                }

                override fun onFinish() {
                    println("countdown finished")
                }
            }
            timer.start()
        }


    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}