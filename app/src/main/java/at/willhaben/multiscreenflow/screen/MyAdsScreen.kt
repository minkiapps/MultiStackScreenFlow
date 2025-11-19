package at.willhaben.multiscreenflow.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.willhaben.library.Screen
import at.willhaben.library.ScreenFlow
import at.willhaben.multiscreenflow.R
import at.willhaben.multiscreenflow.databinding.ScreenMyadsBinding
import at.willhaben.multiscreenflow.deeplink.modifiers.MyAdsModifier.Companion.EXTRA_FROM_DEEPLINK

class MyAdsScreen(screenFlow: ScreenFlow) : Screen(screenFlow) {

    private var buttonPushed by state(0)
    private var fromDeepLink by state(false)

    override fun inflateView(inflater: LayoutInflater, parent: ViewGroup): View {
        return inflater.inflate(R.layout.screen_myads, parent, false)
    }

    override fun afterInflate(initBundle: Bundle?) {
        ScreenMyadsBinding.bind(view).run {
            tvMyAdsScreenPushed.text = "Pushed: $buttonPushed"
            btnMyAdsScreenPush.setOnClickListener {
                buttonPushed++
                tvMyAdsScreenPushed.text = "Pushed: $buttonPushed"
            }

            btnMyAdsScreenAddetail.setOnClickListener {
                screenFlow.goToScreen(AdDetailScreen(screenFlow))
            }

            if(initBundle != null)
                fromDeepLink = initBundle.getBoolean(EXTRA_FROM_DEEPLINK, false)

            if(fromDeepLink) {
                tvScreenMyAdsTitle.text = "MyAds (from Deeplink)"
            }
        }
    }
}