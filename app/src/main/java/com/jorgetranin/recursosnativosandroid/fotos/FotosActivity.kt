package com.jorgetranin.recursosnativosandroid.fotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.jorgetranin.recursosnativosandroid.R
import com.jorgetranin.recursosnativosandroid.databinding.ActivityFotosBinding

class FotosActivity : AppCompatActivity() {
    lateinit var binding: ActivityFotosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotosBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}