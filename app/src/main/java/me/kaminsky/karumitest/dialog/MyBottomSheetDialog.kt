package me.kaminsky.karumitest.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import me.kaminsky.karumitest.R

class MyBottomSheetDialog(context: Context) : BottomSheetDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet, null)
        setContentView(view)
    }
}
