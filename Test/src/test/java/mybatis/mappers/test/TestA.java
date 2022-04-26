package mybatis.mappers.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/15 22:01
 * @Version 1.0
 */
public class TestA {

    @Test
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int nums_size = nums.length;
        for (int i = 0 ; i < nums_size ; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int third = nums_size-1;
            int target = -nums[i];
            for (int j = i + 1; j < nums_size ; j++){
                if (j > i +1 && nums[j] == nums[j-1]){
                    continue;
                }
                while (j < third && (nums[j] + nums[third])>target){
                    --third;
                }
                if (j == third){
                    break;
                }
                if (nums[j] + nums[third]  == target){
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(nums[i]);
                    integerList.add(nums[j]);
                    integerList.add(nums[third]);
                    list.add(integerList);
                }
            }
        }
        return list;
    }
}
