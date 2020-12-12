package com.xh.brush.voice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xh.brush.voiceLibrary.VoiceManger
import org.json.JSONObject

class MainActivity : AppCompatActivity(), VoiceManger.VoiceEventCallBack {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        VoiceManger.initEngine(this)
        VoiceManger.setVoiceEventCallBack(object : VoiceManger.VoiceEventCallBack {
            override fun getEngineSuccess(voiceManger: VoiceManger) {

            }

            /***
             * 评测结果回调 - 返回评测结果，评测结果为JSON格式
             */
            override fun onResult(result: JSONObject?) {
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
        })

    }


    override fun getEngineSuccess(voiceManger: VoiceManger) {
    }

    /***
     * 评测结果回调 - 返回评测结果，评测结果为JSON格式
     */
    override fun onResult(result: JSONObject?) {

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