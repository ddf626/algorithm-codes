package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations">leetcode 46.全排列</a>
 */
public class C60_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backtrack(nums, new boolean[nums.length], 0, res, path);

        return res;
    }

    private void backtrack(int[] nums, boolean[] used, int index, List<List<Integer>> res, LinkedList<Integer> path) {

        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, index + 1, res, path);

            path.removeLast();
            used[i] = false;
        }
    }

}
