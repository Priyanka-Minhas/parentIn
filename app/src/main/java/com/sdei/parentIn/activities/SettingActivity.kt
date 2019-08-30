package com.sdei.parentIn.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sdei.parentIn.R
import com.sdei.parentIn.utils.logOut
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        btnLogOut.setOnClickListener {
            logOut()
        }

    }
}
