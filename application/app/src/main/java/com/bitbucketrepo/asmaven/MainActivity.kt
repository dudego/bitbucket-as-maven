package com.bitbucketrepo.asmaven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitbucketrepo.asmaven.core.R
import com.bitbucketrepo.asmaven.corelibrary.CoreConstants
import com.bitbucketrepo.asmaven.uilibrary.UIConstants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = "Main application resolving constants \n ${CoreConstants.coreString} \n ${UIConstants.uiString}"
    }
}
