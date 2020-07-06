package io.wooo.practice.studyplan.netty.protocol;

import lombok.Data;

/**
 * 协议抽象
 *
 * @author wushuaiping
 * @date 2020/7/6 10:29 上午
 */
@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     *
     * @return
     */
    public abstract Byte getCommand();
}
