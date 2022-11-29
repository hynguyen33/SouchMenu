package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_take_picture -> Toast.makeText(this,"Taking Picture", Toast.LENGTH_SHORT).show()
            R.id.action_help -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu")))
            R.id.action_delete_picture -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirmation")
                    .setMessage("DAre you sure you want to delete? this action cannot be undo.")
                    .setPositiveButton("Yes"){
                            _,_ -> Toast.makeText(this,"deleting picture", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Never Mind"){dialog,_ -> dialog.cancel()}
                    .create()
                    .show()
            }
            else -> return false
        }
        return true
    }
}