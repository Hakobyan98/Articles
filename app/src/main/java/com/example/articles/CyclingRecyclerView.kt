package com.example.articles

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CyclingRecyclerView(context: Context,
                          attrs: AttributeSet?
) : RecyclerView(context, attrs){
    private val onScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            // The total number of items in our RecyclerView
            val itemCount = adapter?.itemCount ?: 0

            // Only continue if there are more than 1 item, otherwise, instantly return
            if (itemCount <= 1) return

            // Once the scroll state is idle, check what position we are in and scroll instantly without animation
            if (newState == SCROLL_STATE_IDLE) {
                // Get the current position
                val pos = (layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()

                // If our current position is 0,
                if (pos == 0) {
                    Log.d("AutoScrollingRV", "Current position is 0, moving to ${itemCount - 1} when item count is $itemCount")
                    scrollToPosition(itemCount - 2)
                } else if (pos == itemCount - 1) {
                    Log.d("AutoScrollingRV", "Current position is ${itemCount - 1}, moving to 1 when item count is $itemCount")
                    scrollToPosition(1)
                } else {
                    Log.d("AutoScrollingRV", "Curren position is $pos")
                }
            }
        }
    }

    init {
        addOnScrollListener(onScrollListener)
    }

}