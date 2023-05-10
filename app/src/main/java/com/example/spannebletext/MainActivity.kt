package com.example.spannebletext

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.Toast
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
            val spannable = SpannableString(aList[0] + "\n" + "Mal" + aList[1])
            spannable.setSpan(
                BackgroundColorSpan(Color.GREEN),
                aList[0].length,
                aList[0].length + 1,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.textView.text = spannable

        } else {
            binding.textView.text = aList[0] + "-" + aList[1]
        }


        textOneSpan()
        textTwoSpan()
        textThreeSpan()
    }

    private fun textThreeSpan() {
        val spannableString = SpannableString("Нажми на текст")

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(p0: View) {
                Toast.makeText(this@MainActivity, "молодец", Toast.LENGTH_SHORT).show()
            }
        }
        spannableString.setSpan(clickableSpan, 0, 14, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        binding.textView3.text = spannableString
        binding.textView3.movementMethod = LinkMovementMethod.getInstance()

    }

    private fun textTwoSpan() {
        val spannableStringBuilder = SpannableStringBuilder("Это пример номер 2")

        val fColor = ForegroundColorSpan(Color.RED)
        spannableStringBuilder.setSpan(fColor, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        val bColor = BackgroundColorSpan(Color.GREEN)
        spannableStringBuilder.setSpan(bColor, 4, 18, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        spannableStringBuilder.append(" я добавил этот текст")
        binding.textView2.text = spannableStringBuilder
    }

    private fun textOneSpan() {
        val spannableString = SpannableString("Это пример номер 1")

        val sizeSpan = RelativeSizeSpan(5f)
        spannableString.setSpan(sizeSpan, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        val styleSpan = StyleSpan(Typeface.BOLD)
        spannableString.setSpan(styleSpan, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        val underlineSpan = UnderlineSpan() //это нижнее подчеркивание
        spannableString.setSpan(underlineSpan, 8, 15, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        binding.textView1.text = spannableString
    }
}