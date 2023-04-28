package com.jorgetranin.recursosnativosandroid.contatos

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.jorgetranin.recursosnativosandroid.Manifest
import com.jorgetranin.recursosnativosandroid.databinding.ActivityContatosBinding

class ContatosActivity : AppCompatActivity() {
    private val REQUEST_CONTACT = 1
    lateinit var binding: ActivityContatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContatosBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),
            REQUEST_CONTACT)
        }else{

        }


        val recyclerView: RecyclerView = binding.rvContatos
        recyclerView.adapter = recyclerView.adapter
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CONTACT) setContacts()
    }

    private fun setContacts() {

        val contatoList: ArrayList<Contato> = ArrayList()
        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,null,null,null)
        if (cursor != null){
            while (cursor.moveToNext()){
                contatoList.add(Contato(cursor.getString(cursor.getColumnIndex
                    (ContactsContract.CommonDataKinds.Phone))))
            }
        }
    }
}