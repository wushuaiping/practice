package io.wooo.practice.studyplan.netty.protocol;

import lombok.Data;
import lombok.EqualsAndHashCode;

import static io.wooo.practice.studyplan.netty.protocol.Command.LOGIN_RESPONSE;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
