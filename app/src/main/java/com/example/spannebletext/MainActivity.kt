package com.example.spannebletext

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.spannebletext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val a = "my-text    "
        val aList: List<String> = a.split("-")
        if (aList[1].length > 5) {
            val spannable = SpannableString(aList[0] +"\n"+ "Mal" + aList[1])
            spannable.setSpan(
                BackgroundColorSpan(Color.GREEN),
                aList[0].length,
                aList[0].length + 1,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.textView.text=spannable

        }else{
            binding.textView.text=aList[0]+"-"+ aList[1]
        }
    }
}