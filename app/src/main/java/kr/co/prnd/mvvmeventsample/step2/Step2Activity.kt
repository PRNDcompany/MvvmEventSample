package kr.co.prnd.mvvmeventsample.step2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.co.prnd.mvvmeventsample.BaseActivity
import kr.co.prnd.mvvmeventsample.R
import kr.co.prnd.mvvmeventsample.databinding.ActivityStep2Binding

@AndroidEntryPoint
class Step2Activity :
    BaseActivity<ActivityStep2Binding, Step2ViewModel>(R.layout.activity_step2) {

    override val viewModel: Step2ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.showToastEvent.observe { text ->
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}
