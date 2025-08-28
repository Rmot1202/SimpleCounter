package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        button.setOnClickListener {
            counter++
            textView.text = counter.toString()
            Toast.makeText(this, "Clicked Button", Toast.LENGTH_SHORT).show()
        }

        val textView2 = findViewById<TextView>(R.id.textView2)
        var goal = 100
        var counter1 = 2
        textView2.text = "Next Goal: 100"
        if (counter >= goal) {
            // Show the upgrade button and set its click listener
            textView2.visibility = View.VISIBLE
            goal = goal.toDouble().pow(counter1).toInt()
            textView2.text = "Next Goal: $goal"
            counter1++
        }
        textView2.visibility = View.INVISIBLE
        val upgradeBtn = findViewById<Button>(R.id.upgradeBtn)
        button.setOnClickListener {
            counter++
            textView.text = counter.toString()

            if (counter >= 100) {
                // Show the upgrade button and set its click listener
                upgradeBtn.visibility = View.VISIBLE
                upgradeBtn.setOnClickListener {
                    button.text = getString(R.string.plus2)

                    // Update the button click listener to add 2 instead of 1
                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }
                    // Hide the upgrade button again
                    upgradeBtn.visibility = View.INVISIBLE
                    Toast.makeText(this, "Upgrade Button Clicked", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}