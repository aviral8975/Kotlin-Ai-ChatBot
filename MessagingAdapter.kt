package com.example.aichatbot1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aichatbot1.R
import com.example.aichatbot1.data.Message
import com.example.aichatbot1.util.Constants.RECEIVE_ID
import com.example.aichatbot1.util.Constants.SEND_ID
import kotlinx.android.synthetic.main.mssg_item.view.*

class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessagingViewHolder>() {

    var messageList = mutableListOf<Message>()
    inner class MessagingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                messageList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagingViewHolder {
        return MessagingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.mssg_item, parent, false))
    }

    override fun onBindViewHolder(holder: MessagingViewHolder, position: Int) {
        val currentMessage = messageList[position]

        when(currentMessage.id){
            SEND_ID -> {
                holder.itemView.tv_mssg.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE

                }
                holder.itemView.tv_bot.visibility = View.GONE
            }
            RECEIVE_ID -> {
                holder.itemView.tv_bot.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_mssg.visibility = View.GONE
            }
            }
        }


    override fun getItemCount(): Int {
        return messageList.size
    }

    fun insertMessage(message: Message){
        this.messageList.add(message)
        notifyItemInserted(messageList.size)
    }
}