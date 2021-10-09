package com.example.aichatbot1.util

import android.view.textclassifier.ConversationActions
import com.example.aichatbot1.util.Constants.OPEN_GOOGLE
import com.example.aichatbot1.util.Constants.OPEN_SEARCH
import com.example.aichatbot1.util.Constants.OPEN_YOUTUBE
import java.lang.Exception

object BotResponse {
    fun basicResponse(message: String):String{

        val random = (0..2).random()
        val message = message.toLowerCase()

        return  when{

            //Hello
            message.contains("hello") -> {
                when(random){
                    0 -> "Hello there!!"
                    1 -> "Hello! How are you doing?"
                    2 -> "Wassup?"
                    else -> "Are you ok?"
                }
            }

            message.contains("how") && message.contains("to") -> {
                OPEN_GOOGLE
            }

            message.contains("flip") && message.contains("coin") -> {
                var r = (0..1).random()
                val result = if(r == 0){
                    "heads"
                }else{
                    "tails"
                }
                "I flipped the coin and the result was $result"
            }
            message.contains("stress") -> {
                when(random){
                    0-> "Stress is inevitable but it can be controlled in way such that it does not affect your health. Try meditating for instance. Choose a quiet and peaceful environment, close your eyes and concentrate on your breathing pattern for 10 mins. It helps a lot trust me!"
                    1-> "Many medical conditions can cause stress and vice-a-versa. Maintaining a healthy lifestyle can reduce stress which will then encourage you to focus on your health too. Try yoga every morning for 10 minutes. That's a start!"
                    2-> "Over-thinking may be the key reason of your stress if you are stressing right now. Relax and focus on yourself."
                    else -> "If I was unable in providing you with your desired result please try searching for it by using the keyword search or open google"
                }
            }

            message.contains("play") && message.contains("trap") -> {
                OPEN_YOUTUBE
            }

            message.contains("play") && message.contains("lofi") -> {
                        OPEN_YOUTUBE
            }

            message.contains("solve") -> {
                val equation: String? = message.substringAfter("solve")

                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    answer.toString()
                }catch (e: Exception ){
                    "Sorry, I cant solve that"
                }
            }

            message.contains("time") && message.contains("?") -> {
                Time.timeStamp()
            }

            message.contains("open") && message.contains("google")  -> {
                OPEN_GOOGLE
            }

            message.contains("search")  -> {
                OPEN_SEARCH
            }

            else -> {
                when(random){
                    0 -> "I am not sure what you want me to do :("
                    1-> "IDK"
                    2-> "That went over my head"
                    else -> "Error"
                }
            }
        }
    }
}