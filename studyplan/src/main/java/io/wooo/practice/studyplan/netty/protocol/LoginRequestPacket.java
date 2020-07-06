package io.wooo.practice.studyplan.netty.protocol;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wushuaiping
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {

        return Command.LOGIN_REQUEST;
    }
}
