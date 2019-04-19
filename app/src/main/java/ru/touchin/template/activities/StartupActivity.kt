package ru.touchin.template.activities

import android.os.Bundle
import com.touchin.template.R
import ru.touchin.templates.TouchinActivity

class StartupActivity : TouchinActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_activity)
    }

}
