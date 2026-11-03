package edu.temple.workingwithservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.annotation.Discouraged
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class MyTimerService : LifecycleService() {

    override fun onBind(intent: Intent): IBinder? {
        return super.onBind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.run {
            getIntExtra(TIMER_KEY, 10).let { startValue ->
                CoroutineScope(Dispatchers.Default).launch {
                    for (i in startValue downTo 0){
                        Log.d("countdown", i.toString())
                     delay(300.milliseconds)
                    }
                }

                //startTimer(startValue)
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

//    fun startTimer (int tartValue: StartValue) {
//
//        lifecycleScope.launch {
//            for (i in startValue downTo 0) {
//                Log.d("countdown", i.toString())
//                delay(300.milliseconds)
//            }
//        }
//        Log.d("Countdown", "Stopping Service...")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("Countdown", "Service Destroyed")
//    }
}