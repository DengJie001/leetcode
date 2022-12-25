package year2022.month12.day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 * 46.全排列
 */
public class Permutations {
    public int[] cache;

    public List<List<Integer>> res = new ArrayList<>();

    public boolean[] visited;
    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{0}));
    }

    public List<List<Integer>> permute(int[] nums) {
        cache = new int[nums.length];
        visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int step) {
        if (step == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : cache) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                cache[step] = nums[i];
                visited[i] = true;
                dfs(nums, step + 1);
                visited[i] = false;
            }
        }
    }
}
