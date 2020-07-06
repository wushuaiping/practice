package io.wooo.practice.studyplan.netty.protocol;

import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author wushuaiping
 * @date 2020/7/6 3:11 下午
 */
public class LoginUtils {

    public static void markAsLogin(Channel ch) {
        ch.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel ch) {
        Attribute<Boolean> attr = ch.attr(Attributes.LOGIN);
        return attr.get() != null;
    }

}
