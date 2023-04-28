package com.jorgetranin.recursosnativosandroid.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events.*

import android.view.LayoutInflater
import com.jorgetranin.recursosnativosandroid.databinding.ActivityAgendaBinding

class AgendaActivity : AppCompatActivity() {
    lateinit var binding: ActivityAgendaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnSetEventCalendar.setOnClickListener {
            intentFindCalendar()
        }
    }

    fun intentFindCalendar(){
        //intenção de abrir o calendario
        val intent = Intent(Intent.ACTION_INSERT)
            .setData(CONTENT_URI)
            .putExtra(TITLE, "Bootcamp Santander")
            .putExtra(EVENT_LOCATION, "ONLINE")
                //set do horario pegando do sistema
            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis())
                //fala que o evento vai durar uma hora
            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis() + (60*60*1000))

        startActivity(intent)
    }
}