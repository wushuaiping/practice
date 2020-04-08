package io.wooo.practice.studyplan.algorithm;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author wushuaiping
 * @date 2020/4/1 4:25 下午
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 4, 2};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(new Gson().toJson(ints));
    }

    /**
     * 暴力解法
     * 通过循环两次，然后让两次循环分别相加得到预期值。然后返回数组相对应的index即可。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 通过HashMap来解决
     * map中，key存的是值，value是index。
     * 循环一次，通过目标值减去当前数组index位置的数据，得到一个预期值，
     * 然后通过这个预期值与hashmap中的数据进行比对，
     * 如果hashmap中已存在这个预期值，则直接返回，
     * 如果不存在这个预期值，则把当前数组index位置的的值做key，value存index。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int expectedValue = target - nums[i];
            if (map.containsKey(expectedValue)) {
                return new int[]{map.get(expectedValue), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
