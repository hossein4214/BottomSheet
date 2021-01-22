package com.starmyapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val btnBottomSheet: Button = view.findViewById(R.id.btn_bottom_sheet)
        val layoutBottomSheet: LinearLayout = view.findViewById(R.id.bottom_sheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(layoutBottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        Log.e("Hossein", "Hidden")
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        Log.e("Hossein", "Dragging")
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        Log.e("Hossein", "Settling")
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        btnBottomSheet.text = "Close Sheet"
                        Log.e("Hossein", "Expand")
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        btnBottomSheet.text = "Expand Sheet"
                        Log.e("Hossein", "Collapsed")
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }


        })


        btnBottomSheet.setOnClickListener {
            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                btnBottomSheet.text = "Close Sheet"
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                btnBottomSheet.text = "Expand Sheet"
            }
        }


        // Codes In BottomSheetFragment
        val btnBottomSheetDialog: Button = view.findViewById(R.id.btn_bottom_sheet_dialog_fragment)
        btnBottomSheetDialog.setOnClickListener {
            val btmSheetDialogFragment = BottomSheetFragment()
            btmSheetDialogFragment.show(
                activity?.supportFragmentManager!!,
                btmSheetDialogFragment.tag
            )
        }


        // Codes In MainFragment
        val btn: Button = view.findViewById(R.id.btn_bottom_sheet_dialog)
        btn.setOnClickListener {
            val v: View = layoutInflater.inflate(R.layout.fragment_bottem_sheet_dialog, null)
            val dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(v)
            val linearLayout:LinearLayout = v.findViewById(R.id.linear1)
            linearLayout.setOnClickListener {
                Toast.makeText(context,"Clicked!",Toast.LENGTH_SHORT).show()
            }
            dialog.show()
        }
        return view
    }

}