package com.axel.dependancyinjectionkoin

class Student(private  val course:Course, private val friend:Friend){
    fun doWork():String =
        course.study()+"\n"+ friend.play()
}

class Friend{
    fun play():String ="I am Playing with my friend "
}

class Course{
    fun study():String = "I am Studying"
}