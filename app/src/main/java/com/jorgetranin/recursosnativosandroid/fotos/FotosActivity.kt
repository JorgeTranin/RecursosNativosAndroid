package com.jorgetranin.recursosnativosandroid.fotos

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.jorgetranin.recursosnativosandroid.databinding.ActivityFotosBinding

class FotosActivity : AppCompatActivity() {

    lateinit var binding: ActivityFotosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotosBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnSetImage.setOnClickListener {
            //Verifica se o usuario ja deu a permissao para acesso
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                //coloca na variavel permission o array da permissao
                val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                requestPermissions(permission, PERMISSION_CODE)
            }
            else{
                pickImageFromGalery()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    pickImageFromGalery()
                }
                else{
                    Toast.makeText(this, "Permissao negada", Toast.LENGTH_LONG).show()

                }

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun pickImageFromGalery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "imagem/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            binding.ivImagemUsuario.setImageURI(data?.data)
        }
    }

    companion object{
        private val PERMISSION_CODE = 1000
        private val IMAGE_PICK_CODE = 1001
    }
}