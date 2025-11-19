package at.willhaben.multiscreenflow.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.willhaben.library.Screen
import at.willhaben.library.ScreenFlow
import at.willhaben.multiscreenflow.R
import at.willhaben.multiscreenflow.databinding.ScreenFeedBinding

class FeedScreen(screenFlow: ScreenFlow) : Screen(screenFlow) {

    private var buttonPushed by state(0)

    override fun inflateView(inflater: LayoutInflater, parent: ViewGroup): View {
        return inflater.inflate(R.layout.screen_feed, parent, false)
    }

    override fun afterInflate(initBundle: Bundle?) {
        ScreenFeedBinding.bind(view).run {
            tvFeedScreenPushed.text = "Pushed: $buttonPushed"
            btnFeedScreenPush.setOnClickListener {
                buttonPushed++
                tvFeedScreenPushed.text = "Pushed: $buttonPushed"
            }

            btnFeedScreenAddetail.setOnClickListener {
                screenFlow.goToScreen(AdDetailScreen(screenFlow))
            }

            btnFeedScreenMyAds.setOnClickListener {
                activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("willhaben://multi-screenflow/myAds")))
            }

            btnFeedScreenSearch.setOnClickListener {
                activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("willhaben://multi-screenflow/search/immo")))
            }
        }
    }
}