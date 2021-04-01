package com.amrutmak.codingwithcompose.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amrutmak.codingwithcompose.R
import com.amrutmak.codingwithcompose.presentation.BaseApplication
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    
    @Inject
    lateinit var app: BaseApplication

    @Inject
    lateinit var randomString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("onCreate: the app context: ${app}")
        println("onCreate: ${randomString}")

    }


}






















