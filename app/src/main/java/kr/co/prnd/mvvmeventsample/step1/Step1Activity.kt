package kr.co.prnd.mvvmeventsample.step1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.co.prnd.mvvmeventsample.BaseActivity
import kr.co.prnd.mvvmeventsample.R
import kr.co.prnd.mvvmeventsample.databinding.ActivityStep1Binding

@AndroidEntryPoint
class Step1Activity :
    BaseActivity<ActivityStep1Binding, Step1ViewModel>(R.layout.activity_step1) {

    override val viewModel: Step1ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.showToastEvent.observe(this, { event ->
            event.getContentIfNotHandled()?.let { text ->
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
