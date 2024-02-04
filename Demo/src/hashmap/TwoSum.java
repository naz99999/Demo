package hashmap;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 8, 9};
        int target = 17;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                System.out.println(map.get(complement)+","+i);
                break;
            }
            map.put(nums[i], i);
        }
    }
}

