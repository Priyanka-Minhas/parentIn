package com.sdei.parentIn.fragments.supervisor


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sdei.parentIn.R

/**
 * A simple [Fragment] subclass.
 */
class SupervisorMessagesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_supervisor_messages, container, false)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: SupervisorMessagesFragment

        fun newInstance(): SupervisorMessagesFragment {
            instance = SupervisorMessagesFragment()
            return instance
        }
    }
}
