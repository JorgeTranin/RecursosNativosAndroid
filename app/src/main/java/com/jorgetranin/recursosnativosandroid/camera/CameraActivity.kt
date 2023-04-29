package com.jorgetranin.recursosnativosandroid.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jorgetranin.recursosnativosandroid.databinding.ActivityCameraBinding
import com.jorgetranin.recursosnativosandroid.databinding.ActivityFotosBinding

class CameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding

    private val imagePicker = ImagePicker.with(this){ uri ->
        if (uri != null) {
            binding.selectedImage.setImageURI(uri)
        } else {
            Toast.makeText(
                this,
                "Something went wrong!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityCameraBinding.inflate(LayoutInflater.from(this))
            setContentView(binding.root)

        binding.btnPickPhoto.setOnClickListener {
            imagePicker.getImage(this)
        }
    }


}