import java.util.*;

public class BinTreeIter {

      /**
        *        1
        *      /  \
        *     2    3
        *    / \  / \
        *   4  5 6   7
        * */
    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode six=new TreeNode(6);
        TreeNode seven=new TreeNode(7);
        head.rightNode=three;
        head.leftNode=second;
        second.rightNode=five;
        second.leftNode=four;
        three.rightNode=seven;
        three.leftNode=six;
        System.out.print("广度优先遍历结果：");
        new DeepFirstSort().BroadFirstSearch(head);
        System.out.println();
        System.out.print("深度优先遍历结果：");
        new DeepFirstSort().depthFirstSearch(head);
        System.out.println();
        System.out.print("先序遍历结果：");
        new OrderIterater().preOrderIterater(head);
        System.out.println();
        System.out.print("中序遍历结果：");
        new OrderIterater().midOrderIterater(head);
        System.out.println();
        System.out.print("后序遍历结果：");
        new OrderIterater().postOrderIterater(head);
        System.out.println();
        System.out.print("蛇形遍历结果：");
        new DeepFirstSort().zigzagLevelOrder(head);
    }

    public static class TreeNode {
        int data;
        TreeNode leftNode;
        TreeNode rightNode;
        public TreeNode() {
        }
        public TreeNode(int d) {
            data=d;
        }
        public TreeNode(TreeNode left,TreeNode right,int d) {
            leftNode=left;
            rightNode=right;
            data=d;
        }
    }

    /**
     *  二叉树的优先遍历
     * */
    public static class DeepFirstSort {
        /**
          *  广度优先遍历是使用队列实现的
        * */
        public void BroadFirstSearch(TreeNode nodeHead) {
            if(nodeHead==null) {
                return;
            }
            Queue<TreeNode> myQueue=new LinkedList<>();
            myQueue.add(nodeHead);
            while(!myQueue.isEmpty()) {
                TreeNode node=myQueue.poll();
                System.out.print(node.data+" ");
                if(null!=node.leftNode) {
                    //广度优先遍历，我们在这里采用每一行从左到右遍历
                    myQueue.add(node.leftNode);
                }
                if(null!=node.rightNode) {
                    myQueue.add(node.rightNode);
                }
            }
        }
         /**
          *  深度优先遍历是使用栈实现的
          * */
        public void depthFirstSearch(TreeNode nodeHead) {
            if(nodeHead==null) {
                return;
            }
            Stack<TreeNode> myStack=new Stack<>();
            myStack.add(nodeHead);
            while(!myStack.isEmpty()) {
                //弹出栈顶元素
                TreeNode node=myStack.pop();
                System.out.print(node.data+" ");
                if(node.rightNode!=null) {
                    //深度优先遍历，先遍历左边，后遍历右边,栈先进后出
                    myStack.push(node.rightNode);
                }
                if(node.leftNode!=null) {
                    myStack.push(node.leftNode);
                }
            }
        }

        /**
         *  蛇形遍历
         * */
        public void zigzagLevelOrder(TreeNode headNode) {
            if (headNode == null) {
                return;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(headNode);
            //排序后的数据
            List<Integer> resultList = new LinkedList<>();
            boolean flag = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                //如果是倒序排列的层 记录resultList列表上一层数据添加完毕后最后一个元素的位置、也就是后面层数据的队首，新的元素插入到队首的位置 达到倒序排列的目的
                int listSize = resultList.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    //flag决定是奇数行还是偶数行：在同一层的范围内 奇数行正序添加数据；偶数行倒序添加数据，也就是新数据放在本层数据的队首；不同层之间正序排列数据；
                    if (!flag) {
                        //正序添加数据
                        resultList.add(node.data);
                    } else {
                        //倒序添加数据，也就是新数据放在本层数据的队首
                        resultList.add(listSize, node.data);
                    }
                    if (node.leftNode != null) {
                        queue.add(node.leftNode);
                    }
                    if (node.rightNode != null) {
                        queue.add(node.rightNode);
                    }
                }
                flag = !flag;
            }
            for (Integer i  : resultList){
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }

    /**
     *  按序遍历
     * */
    public static class OrderIterater {
        /**
         * 先序遍历
         * */
        public void preOrderIterater (TreeNode nodeHead) {
            System.out.print(nodeHead.data);
            System.out.print(" ");
            if( nodeHead.leftNode != null ){
                preOrderIterater(nodeHead.leftNode);
            }
            if( nodeHead.rightNode != null ){
                preOrderIterater(nodeHead.rightNode);
            }
        }

        /**
         * 中序遍历
         * */
        public void midOrderIterater (TreeNode nodeHead) {
            if( nodeHead.leftNode != null ){
                midOrderIterater(nodeHead.leftNode);
            }
            System.out.print(nodeHead.data);
            System.out.print(" ");
            if( nodeHead.rightNode != null ){
                midOrderIterater(nodeHead.rightNode);
            }
        }

        /**
         * 后序遍历
         * */
        public void postOrderIterater (TreeNode nodeHead) {
            if( nodeHead.leftNode != null ){
                postOrderIterater(nodeHead.leftNode);
            }
            if( nodeHead.rightNode != null ){
                postOrderIterater(nodeHead.rightNode);
            }
            System.out.print(nodeHead.data);
            System.out.print(" ");
        }
    }
}