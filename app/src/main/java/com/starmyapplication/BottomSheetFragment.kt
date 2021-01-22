package com.starmyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bottem_sheet_dialog, container, false)
        val linear:LinearLayout = view.findViewById(R.id.linear1)
        linear.setOnClickListener {
            Toast.makeText(context,"Clicked!",Toast.LENGTH_SHORT).show()
        }

        return view
    }


}