package kr.co.prnd.mvvmeventsample

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import kr.co.prnd.mvvmeventsample.step2.SingleLiveData

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel>(
    @LayoutRes
    private val layoutId: Int,
) : AppCompatActivity() {

    abstract val viewModel: VM
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        with(binding) {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.vm, viewModel)
        }
    }

    protected infix fun <T> SingleLiveData<T>.observe(action: (T) -> Unit) {
        observe(this@BaseActivity, action)
    }
}
