package IsolationTree;

public class IsolationTreeNode {
    protected Double divdNum;//划分区间的值
    protected int size;//当前节点中容纳的值
    protected IsolationTreeNode left;//左孩子
    protected IsolationTreeNode right;//右孩子

    public IsolationTreeNode(Double divdNum) {
        this.divdNum = divdNum;
    }

    /**
     * 判断是否是外部节点（叶子节点）
     *
     * @return
     */
    public boolean isExtenal() {
        return (this.left == null && this.right == null);
    }

}