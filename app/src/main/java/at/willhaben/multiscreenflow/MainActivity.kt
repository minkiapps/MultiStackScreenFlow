package at.willhaben.multiscreenflow

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import at.willhaben.library.MultiStackScreenFlowActivity
import at.willhaben.library.Screen
import at.willhaben.multiscreenflow.commonextensions.color
import at.willhaben.multiscreenflow.databinding.ActivityMainBinding
import at.willhaben.multiscreenflow.screen.*

class MainActivity : MultiStackScreenFlowActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.menuFeedActivityMain.setOnClickListener {
            switchStack(HOME)
        }

        binding.menuSearchActivityMain.setOnClickListener {
            switchStack(SEARCH)
        }

        binding.menuAzaActivityMain.setOnClickListener {
            switchStack(AZA)
        }

        binding.menuChatActivityMain.setOnClickListener {
            switchStack(MESSAGING)
        }

        binding.menuProfileActivityMain.setOnClickListener {
            switchStack(PROFILE)
        }

        onStackChanged(getCurrentStack())
    }

    override fun onStackChanged(stackId: Int) {
        when(stackId) {
            HOME -> selectMenu(binding.menuFeedActivityMain)
            SEARCH -> selectMenu(binding.menuSearchActivityMain)
            AZA -> selectMenu(binding.menuAzaActivityMain)
            MESSAGING -> selectMenu(binding.menuChatActivityMain)
            PROFILE -> selectMenu(binding.menuProfileActivityMain)
        }
        binding.stackVisualizerMainActivity.stacksCounts = getStackCounts()
    }

    override fun goToScreen(screen: Screen, saveToStack: Boolean) {
        super.goToScreen(screen, saveToStack)
        binding.stackVisualizerMainActivity.stacksCounts = getStackCounts()
    }

    private fun selectMenu(view : View) {
        binding.menuFeedActivityMain.setColorFilter(Color.BLACK)
        binding.menuSearchActivityMain.setColorFilter(Color.BLACK)
        binding.menuAzaActivityMain.setColorFilter(Color.BLACK)
        binding.menuChatActivityMain.setColorFilter(Color.BLACK)
        binding.menuProfileActivityMain.setColorFilter(Color.BLACK)
        (view as ImageView).setColorFilter(color(R.color.colorPrimary))
    }

    override fun initiateContentViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun provideContentFrameForScreenFlow(): FrameLayout {
        return binding.contentActivityMain
    }

    override fun provideStackConfigurator(): StackConfigurator = StackConfiguratorImpl()

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "On MainActivity Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "On MainActivity Paused")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "On MainActivity Started")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "On MainActivity Stoped")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "On Activity Result")
    }

    companion object {
        const val HOME = 0
        const val SEARCH = 1
        const val AZA = 2
        const val MESSAGING = 3
        const val PROFILE = 4

        const val TAG = "MainActivity"
    }
}

private class StackConfiguratorImpl : MultiStackScreenFlowActivity.StackConfigurator {

    override fun size(): Int = 5

    override fun rootScreenFactory(): MultiStackScreenFlowActivity.RootScreenFactory {
        return RootScreenFactoryImpl()
    }

    private class RootScreenFactoryImpl : MultiStackScreenFlowActivity.RootScreenFactory {

        override fun provideRootScreen(flowStack: Int): Class<out Screen> {
            return when(flowStack) {
                0 -> FeedScreen::class.java
                1 -> SearchScreen::class.java
                2 -> AzaScreen::class.java
                3 -> MessagingScreen::class.java
                4 -> ProfileScreen::class.java
                else -> FeedScreen::class.java
            }
        }
    }
}