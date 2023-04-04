package leetcode.tree

class LowestCommonAncestor {
    fun lowestCommonAncestorSolution(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null

        var cur = root

        while (cur != null) {
            cur = if (p.`val` < cur.`val` && q.`val` < cur.`val`) {
                cur.left
            } else if (p.`val` > cur.`val` && q.`val` > cur.`val`) {
                cur.right
            } else {
                return cur
            }
        }

        return null
    }
}

// Time - O(log n)
// Space - O(1)