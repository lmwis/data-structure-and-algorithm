package hard;

/**
 * @Description: 1579. 保证图可完全遍历
 * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
 *
 * 类型 1：只能由 Alice 遍历。
 * 类型 2：只能由 Bob 遍历。
 * 类型 3：Alice 和 Bob 都可以遍历。
 * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
 *
 * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
 *
 * 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
 * 输出：2
 * 解释：如果删除 [1,1,2] 和 [1,1,3] 这两条边，Alice 和 Bob 仍然可以完全遍历这个图。再删除任何其他的边都无法保证图可以完全遍历。所以可以删除的最大边数是 2 。
 *
 * hard我直接cv
 * @Author: lmwis
 * @Date 2021-01-27 16:47
 * @Version 1.0
 */
public class MaxNumEdgesToRemove {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufa = new UnionFind(n);
        UnionFind ufb = new UnionFind(n);
        int ans = 0;

        // 节点编号改为从 0 开始
        for (int[] edge : edges) {
            --edge[1];
            --edge[2];
        }

        // 公共边
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!ufa.unite(edge[1], edge[2])) {
                    ++ans;
                } else {
                    ufb.unite(edge[1], edge[2]);
                }
            }
        }

        // 独占边
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                // Alice 独占边
                if (!ufa.unite(edge[1], edge[2])) {
                    ++ans;
                }
            } else if (edge[0] == 2) {
                // Bob 独占边
                if (!ufb.unite(edge[1], edge[2])) {
                    ++ans;
                }
            }
        }

        if (ufa.setCount != 1 || ufb.setCount != 1) {
            return -1;
        }
        return ans;
    }
}
