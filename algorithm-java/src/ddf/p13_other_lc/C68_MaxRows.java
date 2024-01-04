package ddf.p13_other_lc;

/**
 * <a href="https://leetcode.cn/problems/maximum-rows-covered-by-columns">leetcode 2397.被列覆盖的最多行数</a>
 */
public class C68_MaxRows {

    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] mask = new int[m];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                mask[i] += matrix[i][j] << (n - j - 1);
            }
        }

        int limit = 1 << n;
        int res = 0;
        for (int cur = 0; cur < limit; cur++) {
            if (Integer.bitCount(cur) != numSelect) {
                continue;
            }

            int count = 0;
            for (int i=0; i<m; i++) {
                if ((mask[i] & cur) == mask[i]) {
                    count++;
                }
            }

            res = Math.max(res, count);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 0, 0}, {1, 0, 1}, {0,1,1}, {0,0,1}};

        C68_MaxRows s = new C68_MaxRows();
        System.out.println(s.maximumRows(matrix, 2));
    }

}
