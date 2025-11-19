package at.willhaben.multiscreenflow.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.willhaben.library.Screen
import at.willhaben.library.ScreenFlow
import at.willhaben.multiscreenflow.R
import at.willhaben.multiscreenflow.databinding.ScreenSearchlistBinding

class SearchListScreen(screenFlow: ScreenFlow) : Screen(screenFlow) {

    private var buttonPushed by state(0)

    override fun inflateView(inflater: LayoutInflater, parent: ViewGroup): View {
        return inflater.inflate(R.layout.screen_searchlist, parent, false)
    }

    override fun afterInflate(initBundle: Bundle?) {
        ScreenSearchlistBinding.bind(view).run {
            tvSearchListScreenPushed.text = "Pushed: $buttonPushed"
            btnSearchListScreenPush.setOnClickListener {
                buttonPushed++
                tvSearchListScreenPushed.text = "Pushed: $buttonPushed"
            }

            btnSearchListScreenAddetail.setOnClickListener {
                screenFlow.goToScreen(AdDetailScreen(screenFlow))
            }
        }
    }
}