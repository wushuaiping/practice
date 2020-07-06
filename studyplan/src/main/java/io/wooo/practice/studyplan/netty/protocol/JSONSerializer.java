package io.wooo.practice.studyplan.netty.protocol;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

/**
 * @author wushuaiping
 * @date 2020/7/6 10:54 上午
 */
public class JSONSerializer implements Serializer{
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
