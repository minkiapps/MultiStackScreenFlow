package at.willhaben.multiscreenflow.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.willhaben.library.Screen
import at.willhaben.library.ScreenFlow
import at.willhaben.multiscreenflow.R
import at.willhaben.multiscreenflow.databinding.ScreenProfileBinding
import at.willhaben.multiscreenflow.logOut

class ProfileScreen(screenFlow: ScreenFlow) : Screen(screenFlow) {
    private var buttonPushed by state(0)

    override fun inflateView(inflater: LayoutInflater, parent: ViewGroup): View {
        return inflater.inflate(R.layout.screen_profile, parent, false)
    }

    override fun afterInflate(initBundle: Bundle?) {
        ScreenProfileBinding.bind(view).run {
            tvProfileScreenPushed.text = "Pushed: $buttonPushed"
            btnProfileScreenPush.setOnClickListener {
                buttonPushed++
                tvProfileScreenPushed.text = "Pushed: $buttonPushed"
            }

            btnProfileScreenMyAds.setOnClickListener {
                screenFlow.goToScreen(MyAdsScreen(screenFlow))
            }

            btnProfileScreenLogout.setOnClickListener {
                logOut()
                screenFlow.reset()
            }
        }
    }
}