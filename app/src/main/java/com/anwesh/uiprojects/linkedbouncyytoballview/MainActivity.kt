package com.anwesh.uiprojects.linkedbouncyytoballview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.bouncyytoballview.BouncyYToBallView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BouncyYToBallView.create(this)
    }
}
