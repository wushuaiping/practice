package io.wooo.practice.studyplan.netty.protocol;

import io.netty.buffer.ByteBuf;

/**
 * @author wushuaiping
 * @date 2020/7/6 10:33 上午
 */
public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;

}

