package me.kaminsky.karumitest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.kaminsky.karumitest.dialog.MyBottomSheetDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        open_bottom_sheet.setOnClickListener {
            MyBottomSheetDialog(this).show()
        }
    }

    fun changeText() {
        textView.text = "1"
    }
}
