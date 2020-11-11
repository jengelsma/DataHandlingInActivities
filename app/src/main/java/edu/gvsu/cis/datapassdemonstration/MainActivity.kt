package edu.gvsu.cis.datapassdemonstration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        val VICE_SELECTION = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, ViceSelectionActivity::class.java)
            startActivityForResult(intent, VICE_SELECTION)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == VICE_SELECTION) {
            val tv = findViewById<TextView>(R.id.message)
            tv.text = "Your vice is: " + (data?.getStringExtra("vice") ?: "Steak" )
        }
    }
}