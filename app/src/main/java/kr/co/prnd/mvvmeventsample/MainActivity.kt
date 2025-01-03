package kr.co.prnd.mvvmeventsample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kr.co.prnd.mvvmeventsample.step1.Step1Activity
import kr.co.prnd.mvvmeventsample.step2.Step2Activity
import kr.co.prnd.mvvmeventsample.step3.Step3Activity
import kr.co.prnd.mvvmeventsample.step4.Step4Activity
import kr.co.prnd.mvvmeventsample.step5.Step5Activity
import kr.co.prnd.mvvmeventsample.step6.Step6Activity
import kr.co.prnd.mvvmeventsample.step7.Step7Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_step1).setOnClickListener {
            startActivity(Step1Activity::class.java)
        }
        findViewById<Button>(R.id.btn_step2).setOnClickListener {
            startActivity(Step2Activity::class.java)
        }
        findViewById<Button>(R.id.btn_step3).setOnClickListener {
            startActivity(Step3Activity::class.java)
        }
        findViewById<Button>(R.id.btn_step4).setOnClickListener {
            startActivity(Step4Activity::class.java)
        }
        findViewById<Button>(R.id.btn_step5).setOnClickListener {
            startActivity(Step5Activity::class.java)
        }
        findViewById<Button>(R.id.btn_step6).setOnClickListener {
            startActivity(Step6Activity::class.java)
        }
        findViewById<Button>(R.id.btn_step7).setOnClickListener {
            startActivity(Step7Activity::class.java)
        }
    }

    private fun <T> startActivity(clazz: Class<T>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}
