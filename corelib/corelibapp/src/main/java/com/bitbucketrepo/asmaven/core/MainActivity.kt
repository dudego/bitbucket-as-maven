package com.bitbucketrepo.asmaven.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitbucketrepo.asmaven.corelibrary.CoreConstants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = CoreConstants.coreString
    }
}
