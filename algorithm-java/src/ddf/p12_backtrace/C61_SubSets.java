package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets">leetcode 78.子集</a>
 */
public class C61_SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backtrack(nums, 0, res, path);
        return res;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> res, LinkedList<Integer> path) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[index]);
        backtrack(nums, index + 1, res, path);
        path.removeLast();

        backtrack(nums, index + 1, res, path);
    }

}
