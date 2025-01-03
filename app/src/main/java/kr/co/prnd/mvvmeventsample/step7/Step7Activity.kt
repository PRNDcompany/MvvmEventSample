package kr.co.prnd.mvvmeventsample.step7

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.co.prnd.mvvmeventsample.BaseActivity
import kr.co.prnd.mvvmeventsample.R
import kr.co.prnd.mvvmeventsample.databinding.ActivityStep6Binding
import kr.co.prnd.mvvmeventsample.step5.repeatOnStarted
import kr.co.prnd.mvvmeventsample.step7.Step7ViewModel.Event

@AndroidEntryPoint
class Step7Activity :
    BaseActivity<ActivityStep6Binding, Step7ViewModel>(R.layout.activity_step7) {

    override val viewModel: Step7ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: Event) = when (event) {
        is Event.ShowToast -> Toast.makeText(this, event.text, Toast.LENGTH_SHORT).show()
        is Event.Aaa -> Toast.makeText(this, "aaa event: ${event.value}", Toast.LENGTH_SHORT).show()
        is Event.Bbb -> Toast.makeText(this, "bbb event: ${event.value}", Toast.LENGTH_SHORT).show()
    }
}
