package com.xh.brush.voiceLibrary

import androidx.annotation.IntDef
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Desc:朗读类型
 * Company: xuehai
 * Copyright: Copyright (c) 2021
 *
 * @author xhdjh
 * @since 2021/01/14 13/50
 */
@IntDef(VoiceType.SENT, VoiceType.PRED, VoiceType.PCHA, VoiceType.WORD)
@Retention(RetentionPolicy.CLASS)
annotation
class VoiceType {
    companion object {
        const val SENT = 0 // 常规
        const val PRED = 1 // 朗读(长句子)
        const val PCHA = 2 // 多答案
        const val WORD = 3 // 单词
    }
}