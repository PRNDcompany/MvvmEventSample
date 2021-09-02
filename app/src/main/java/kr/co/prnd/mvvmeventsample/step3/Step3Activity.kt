package kr.co.prnd.mvvmeventsample.step3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kr.co.prnd.mvvmeventsample.BaseActivity
import kr.co.prnd.mvvmeventsample.R
import kr.co.prnd.mvvmeventsample.databinding.ActivityStep3Binding

@AndroidEntryPoint
class Step3Activity :
    BaseActivity<ActivityStep3Binding, Step3ViewModel>(R.layout.activity_step3) {

    override val viewModel: Step3ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            launch {
                viewModel.showToastEvent.collect { text ->
                    Toast.makeText(this@Step3Activity, text, Toast.LENGTH_SHORT).show()
                }
            }
            launch {
                viewModel.aaaEvent.collect { value ->
                    Toast.makeText(this@Step3Activity, "aaa event: $value", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            launch {
                viewModel.bbbEvent.collect { value ->
                    Toast.makeText(this@Step3Activity, "bbb event: $value", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}
