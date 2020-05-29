import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Administrator on 2018/5/14.
 */
public class Algorithm1 {

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * */
    public static boolean Find1(int target, int [][] array) {
        if(array == null||array.length==0){
            return false;
        }
        int rowIdx = 0,colIdx = array[0].length-1;
        while( rowIdx < array.length && colIdx >= 0 ){
            if( array[rowIdx][colIdx] == target ){
                return true;
            }
            else if ( target > array[rowIdx][colIdx] ){
                rowIdx++;
            }
            else if (target < array[rowIdx][colIdx]){
                colIdx--;
            }
        }
        return false;
    }

    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==' '){
                sb.append("%20");
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    //从头到尾打印列表
    //输入一个链表，从尾到头打印链表每个节点的值。
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        if(listNode == null){
            return result;
        }
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
            return result;
    }

    public static void main(String[] args) {
        //test Find1
        /*int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12},
                {50,56,59}
        };
        System.out.println(Find1(56,arr));*/
        /*StringBuffer stringBuffer = new StringBuffer("I am your father");
        System.out.println(replaceSpace(stringBuffer));*/
        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        String s = "UPDATE supplier_category a INNER JOIN ( SELECT cd.`NAME`,sc.supplier_id,cd.CATALOG_ID,sc.company_id,GROUP_CONCAT(cd.`NAME` SEPARATOR '&||&') AS directory_name,GROUP_CONCAT(cd.ID SEPARATOR ',') AS directory_id FROM supplier_category sc INNER JOIN corp_directory cd ON sc.category_id = cd.CATALOG_ID AND sc.company_id = cd.company_id WHERE sc.company_id = -1 GROUP BY sc.supplier_id, sc.category_id ) b ON a.supplier_id = b.supplier_id AND a.category_id = b.CATALOG_ID AND a.company_id = b.company_id SET a.directory_id = b.directory_id,a.directory_name = b.directory_name";

        System.out.println(s);


    }

}