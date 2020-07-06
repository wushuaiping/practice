package io.wooo.practice.studyplan.netty.protocol;

import lombok.Data;
import lombok.EqualsAndHashCode;

import static io.wooo.practice.studyplan.netty.protocol.Command.MESSAGE_RESPONSE;

/**
 * @author wushuaiping
 * @date 2020/7/6 3:05 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageResponsePacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
