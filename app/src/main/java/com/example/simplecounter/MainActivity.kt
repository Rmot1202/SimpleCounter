package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private var increment = 1
    private var nextGoal = 100
    private var hasUpgraded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val upgradeBtn = findViewById<Button>(R.id.upgradeBtn)

        // initial UI state
        textView.text = counter.toString()
        textView2.text = "Next Goal: $nextGoal"
        upgradeBtn.visibility = View.GONE

        // set the upgrade once; just show/hide it when needed
        upgradeBtn.setOnClickListener {
            if (!hasUpgraded) {
                hasUpgraded = true
                increment = 2
                button.text = getString(R.string.plus2)
                upgradeBtn.visibility = View.GONE
                Toast.makeText(this, "Upgrade applied (+2 per click)", Toast.LENGTH_SHORT).show()
            }
        }

        button.setOnClickListener {
            // increment counter
            counter += increment
            textView.text = counter.toString()
            Toast.makeText(this, "Clicked Button", Toast.LENGTH_SHORT).show()

            // show upgrade button exactly once (at 100+)
            if (!hasUpgraded && counter >= 100) {
                upgradeBtn.visibility = View.VISIBLE
            }
            // handle goals on every click
            if (counter == nextGoal) {
                // choose your goal progression; doubling is common
                nextGoal *= 2
                textView2.text = "Next Goal: $nextGoal"
                textView2.visibility = View.VISIBLE
            } else {
                textView2.visibility = View.GONE
            }
        }
    }
}
