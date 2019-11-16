package com.anwesh.uiprojects.bouncyytoballview

/**
 * Created by anweshmishra on 16/11/19.
 */

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color

val nodes : Int = 5
val lines : Int = 3
val scGap : Float = 0.02f
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#2196F3")
val backColor : Int = Color.parseColor("#BDBDBD")
val rFactor : Float = 2.4f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawBouncyYToBall(scale : Float, size : Float, paint : Paint) {
    val sf : Float = scale.divideScale(0, 2).sinify()
    val sc2 : Float = scale.divideScale(1, 2).sinify()
    val r : Float = size / rFactor
    for (j in 0..(lines - 1)) {
        save()
        rotate((360f / lines) * j)
        drawLine(0f, 0f, 0f, size, paint)
        restore()
    }
    drawCircle(0f, 0f, r * sc2, paint)
}

fun Canvas.drawBYBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(gap * (i + 1), h / 2)
    drawBouncyYToBall(scale, size, paint)
    restore()
}
