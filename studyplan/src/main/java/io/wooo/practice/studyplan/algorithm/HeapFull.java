package io.wooo.practice.studyplan.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wushuaiping
 * @date 2020/4/1 5:59 下午
 */
public class HeapFull {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1", "2");

        Map<Integer, Integer> intMap = map;
        Integer integer = intMap.get("1");

    }
}
