package com.xh.brush.voiceLibrary

import android.content.Context
import android.util.Log
import com.constraint.CoreProvideTypeEnum
import com.constraint.OffLineSourceEnum
import com.constraint.ResultBody
import com.xs.SingEngine
import com.xs.impl.AudioErrorCallback
import com.xs.impl.ResultListener
import org.json.JSONObject

/**
 * Desc: 语音识别封装管理 - 先声引擎
 * 参考官网：https://pt.singsound.com:10081/singsound-public/SingsoundGinger/-/wikis/Android-%E5%AF%B9%E6%8E%A5%E6%96%87%E6%A1%A3
 * Company: xuehai
 * Copyright: Copyright (c) 2020
 *
 * @author xhdjh
 * @since 2020/11/13 15/34
 */
class VoiceManger {

    companion object {

        val TAG: String = javaClass.simpleName

        lateinit var engine: SingEngine

        private var voiceEvent: VoiceEventCallBack? = null

        private var resultListener = object : ResultListener {
            override fun onReady() {
                //1.引擎初始化成功回调
                voiceEvent?.getEngineSuccess(VoiceManger())
            }

            override fun onBegin() {
                //2.录音开始回调
                Log.d(TAG, "onBegin")
            }

            /***
             * 实时返回用户录音的音量大小 录音过程中会不断的回调此方法，
             * 实时返回音量大小，volume取值范围为0~100。
             * 用户可以根据volume的大小来实现用户录音音量大小的动画效果。
             */
            override fun onUpdateVolume(volume: Int) {
                //3. 录音音量回调
                Log.d(TAG, "onUpdateVolume")
            }

            /***
             * 返回用户录音的数据 录音过程中会重复调用此方法，数据保存在data中。
             */
            override fun onRecordingBuffer(data: ByteArray?, i: Int) {
                //4. 录音数据回调
                Log.d(TAG, "onRecordingBuffer")
            }

            override fun onBackVadTimeOut() {
                //5. 录音后置超时回调
                Log.d(TAG, "onBackVadTimeOut")
            }

            override fun onFrontVadTimeOut() {
                //6. 录音前置超时回调
                Log.d(TAG, "onFrontVadTimeOut")
            }

            override fun onRecordStop() {
                //7.当录音停止并写入成功后回调
                Log.d(TAG, "onRecordStop")
            }

            override fun onRecordLengthOut() {
                //8.评测录音长度超时回调
                Log.d(TAG, "onRecordLengthOut")
            }

            override fun onResult(result: JSONObject?) {
                //9.评测结果回调 - 返回评测结果，评测结果为JSON格式
                Log.d(TAG, "onResult")
            }

            /***
             * 返回评测或初始化引擎失败原因，
             * resultBody.getCode() 等于 0 为正确返回，
             * 其他错误码见下错误码说明。
             */
            override fun onEnd(resultBody: ResultBody?) {
                //10.评测录音长度超时回调
                Log.d(TAG, "onEnd")
                if (resultBody?.code != 0) {
                    voiceEvent?.onEnd(resultBody?.code, resultBody?.message)
                }
            }

            /***
             * 客户可在该回调里做一些更新UI的操作。
             */
            override fun onPlayCompeleted() {
                //11. 播放录音完成回调
            }
        }

        fun initEngine(mContext: Context) {
            try {
                //获取引擎实例,设置测评监听对象
                engine = SingEngine.newInstance(mContext)
                engine.setListener(resultListener)
                engine.setAudioErrorCallback { i -> voiceEvent?.onAudioError(i) }
                engine.setServerAPI(VoiceConfig.SERVER_API)
                //设置引擎类型
                engine.setServerType(CoreProvideTypeEnum.AUTO)
                engine.setServerTimeout(5)
                engine.setConnectTimeout(5)
                engine.setOffLineSource(OffLineSourceEnum.SOURCE_BOTN)
                //开启在线失败自动切换离线
                engine.setEnableContonative(1)
                //设置离线引擎资源包
                engine.setNativeZip("resource.zip")
                //构建引擎初始化参数
                val cfgInit: JSONObject = engine.buildInitJson(
                    VoiceConfig.APP_KEY,
                    VoiceConfig.APP_SECRET
                )
                //设置引擎初始化参数
                engine.setNewCfg(cfgInit)
                engine.createEngine()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun setVoiceEventCallBack(voiceEventCallBack: VoiceEventCallBack) {
            voiceEvent = voiceEventCallBack
        }

        fun start() {
            engine.start()
        }

        fun stop() {
            engine.stop()
        }

        fun delete() {
            engine.delete()
            voiceEvent = null
        }


    }


    interface VoiceEventCallBack {

        fun getEngineSuccess(voiceManger: VoiceManger)

        /***
         * 评测结果回调 - 返回评测结果，评测结果为JSON格式
         */
        fun onResult(result: JSONObject?)

        /***
         * 返回评测或初始化引擎失败原因，
         * resultBody.getCode() 等于 0 为正确返回，
         * 其他错误码见下错误码说明。
         */
        fun onEnd(code: Int?, message: String?)

        fun onAudioError(code: Int)

    }
}