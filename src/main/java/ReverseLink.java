public class ReverseLink {

    public static class Node{
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newHead = reverse(node.next);
        Node temp = node.next;
        temp.next = node;
        node.next = null;
        return newHead;
    }



    public static Node reverseListNode(Node head){
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null){
            return head;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点指针
        Node curNode = head;
        //下一个节点指针
        Node nextNode = null;

        while (curNode != null){
            //1、nextNode 指向下一个节点（先把原来的nextNode保存起来）
            nextNode = curNode.next;
            //2、将当前节点next域指向前一个节点（把next指向前一个）
            curNode.next = preNode;
            //3、preNode 指针向后移动
            preNode = curNode;
            //4、curNode 指针向后移动
            curNode = nextNode;

            //打印逻辑
            print(preNode);
            System.out.println();
        }
        return preNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node reverse = reverseListNode(node1);
        //print(reverse);
    }

    public static void print(Node head){
        System.out.print(head.value);
        System.out.print("  ");
        if ( head.next != null ){
            print(head.next);
        }
    }
}