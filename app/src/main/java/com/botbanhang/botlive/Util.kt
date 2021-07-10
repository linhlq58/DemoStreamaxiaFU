package com.botbanhang.botlive

import com.streamaxia.android.streamer.StreamaxiaStreamer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Util {
    companion object {
        fun sendVideoFrame(streamer: StreamaxiaStreamer, frame: ByteArray) {
            GlobalScope.launch {
                streamer.sendVideoFrames(frame)
            }
        }
    }
}