package kr.co.prnd.mvvmeventsample.step4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kr.co.prnd.mvvmeventsample.BaseActivity
import kr.co.prnd.mvvmeventsample.R
import kr.co.prnd.mvvmeventsample.databinding.ActivityStep4Binding
import kr.co.prnd.mvvmeventsample.step4.Step4ViewModel.Event

@AndroidEntryPoint
class Step4Activity :
    BaseActivity<ActivityStep4Binding, Step4ViewModel>(R.layout.activity_step4) {

    override val viewModel: Step4ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: Event) = when (event) {
        is Event.ShowToast -> Toast.makeText(this, event.text, Toast.LENGTH_SHORT).show()
        is Event.Aaa -> Toast.makeText(this, "aaa event: ${event.value}", Toast.LENGTH_SHORT).show()
        is Event.Bbb -> Toast.makeText(this, "bbb event: ${event.value}", Toast.LENGTH_SHORT).show()
    }
}
