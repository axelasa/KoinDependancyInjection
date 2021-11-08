package com.axel.dependancyinjectionkoin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.axel.dependancyinjectionkoin.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//how to start Koin in app level activity
        startKoin {
            androidLogger(level=Level.ERROR)
            //declareUsedAndroidContext
            androidContext(this@MainActivity)
            modules(appModule)
        }

        //the code below uses koin
        val student:Student by inject()

        //the code below did not use koin
//        val course =Course()
//        val friend = Friend()
//        val student = Student(course, friend)

        binding.textView.text = student.doWork()
    }
}