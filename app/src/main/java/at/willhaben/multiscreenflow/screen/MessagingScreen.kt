package at.willhaben.multiscreenflow.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.willhaben.library.Screen
import at.willhaben.library.ScreenFlow
import at.willhaben.multiscreenflow.R
import at.willhaben.multiscreenflow.databinding.ScreenChatBinding

class MessagingScreen(screenFlow: ScreenFlow) : Screen(screenFlow) {

    private var buttonPushed by state(0)

    override fun inflateView(inflater: LayoutInflater, parent: ViewGroup): View {
        return inflater.inflate(R.layout.screen_chat, parent, false)
    }

    override fun afterInflate(initBundle: Bundle?) {
        ScreenChatBinding.bind(view).run {
            tvChatScreenPushed.text = "Pushed: $buttonPushed"
            btnChatScreenPush.setOnClickListener {
                buttonPushed++
                tvChatScreenPushed.text = "Pushed: $buttonPushed"
            }
        }
    }
}