package com.xh.brush.voice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.xh.brush.voiceLibrary.VoiceManger
import com.xh.brush.voiceLibrary.VoiceType
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(), VoiceManger.VoiceEventCallBack {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        VoiceManger.initEngine(this)
        VoiceManger.setVoiceEventCallBack(this)

        startRecord.setOnClickListener {
            run {
                val word = edit_word.text.toString()
                VoiceManger.startEvaluate("", word, VoiceType.WORD)
            }
        }

        stopRecord.setOnClickListener {
            run {
                VoiceManger.stop()
            }
        }
    }


    override fun getEngineSuccess(voiceManger: VoiceManger?) {
    }

    /***
     * 评测结果回调 - 返回评测结果，评测结果为JSON格式
     */
    override fun onResult(result: JSONObject?) {
        Log.d("result", result.toString())
    }

    /***
     * 返回评测或初始化引擎失败原因，
     * resultBody.getCode() 等于 0 为正确返回，
     * 其他错误码见下错误码说明。
     */
    override fun onEnd(code: Int?, message: String?) {
    }

    override fun onAudioError(code: Int) {
    }
}