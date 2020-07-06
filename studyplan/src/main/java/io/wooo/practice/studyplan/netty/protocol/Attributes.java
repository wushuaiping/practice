package io.wooo.practice.studyplan.netty.protocol;

import io.netty.util.AttributeKey;

/**
 * @author wushuaiping
 * @date 2020/7/6 3:10 下午
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

}
