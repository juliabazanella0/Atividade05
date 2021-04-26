package com.example.atividade05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_chooser_recipient.view.*
import kotlinx.android.synthetic.main.fragment_specify_amount.view.*
import kotlinx.android.synthetic.main.fragment_specify_amount.view.cancel_btn

class SpecifyAmountFragment : Fragment() {
    var navController: NavController? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.next_btn.setOnClickListener {
            navController!!.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment)
        }
        view.cancel_btn.setOnClickListener {
            activity?.onBackPressed()
        }
    }

}