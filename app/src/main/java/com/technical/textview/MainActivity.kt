package com.technical.textview

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var showToast : Button
    lateinit var showSnackbar: Button
    lateinit var myLayout : ConstraintLayout
    lateinit var showDialog : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showToast = findViewById(R.id.buttonShowToast)
        showSnackbar = findViewById(R.id.buttonShowSnackbar)
        myLayout = findViewById(R.id.myLayout)
        showDialog = findViewById(R.id.buttonShowDialog)

        showToast.setOnClickListener{

            Toast.makeText(applicationContext,"This is a Toast Message",Toast.LENGTH_LONG).show()
        }
        showSnackbar.setOnClickListener {
            Snackbar.make(myLayout, "This is a snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Close", View.OnClickListener {

                }).show()
        }
        showDialog.setOnClickListener {

        }
        fun showAlert()
        {
               var alertDialog = AlertDialog.Builder(this@MainActivity)
                alertDialog.setTitle("Change")
                    .setMessage("Do you want to change the text of the button?")
                    .setIcon(R.drawable.warning)
                    .setCancelable(false)
                    .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface,
                                                                               which-> dialogInterface.cancel()
                          })
                    .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface,
                                                                                which ->
                        showDialog.text = "Alert Dialog"
                    })
            alertDialog.create().show()

            
        }
    }
}