package com.example.email

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import com.example.email.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSend.setOnClickListener {
            emailSend()
        }

    }

    private fun emailSend() {

    /*    val i =Intent(Intent.ACTION_SEND)
        i.putExtra(Intent.EXTRA_EMAIL,binding.txtTo.text.toString())
        i.putExtra(Intent.EXTRA_SUBJECT,binding.txtSub.text.toString())
        i.putExtra(Intent.EXTRA_TEXT,binding.txtMsg.text)
        i.setType("message/rfc822")
        startActivity(Intent.createChooser(i,"Choose Mail App")*/
        try {
            var smsManager=SmsManager.getDefault()
            smsManager.sendTextMessage(binding.mblTxt.text.toString(),null,binding.msgTxt.text.toString(),null,null)
            Toast.makeText(this,"SMS Sent Succesfully",Toast.LENGTH_LONG).show()

        }
        catch ( e:java.lang.Exception)
        {
            Toast.makeText(this,"Sms Failed to send ,Please try again later",Toast.LENGTH_LONG).show()
        }
    }


    }

