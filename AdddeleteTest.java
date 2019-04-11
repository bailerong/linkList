import java.util.HashMap;
import java.util.Hashtable;

class Node{
    Node next=null;
    int data;
    public Node(int data){
        this.data=data;
    }
}

public class AdddeleteTest {
    Node head=null;//链表头的作用
    /*
    * 向链表中插入数据
    * d:插入数据的内容*/
    public void addNode(int d){
        Node newNode=new Node(d);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    /*
    * 删除第index个节点
    * 成功返回true，失败返回false
    * */
    public Boolean deleteNode(int index){
        //删除的元素位置不合理
        if(index<1||index>length()){
            return false;
        }
        //删除链表的第一个元素
        if(index==1){
            head=head.next;
            return true;
        }
        int i=2;
        Node preNode=head;
        Node curNode=preNode.next;
        while(curNode!=null){
            if(i==index){
                preNode.next=curNode.next;
            }
            preNode=curNode;
            curNode=curNode.next;
            i++;
        }
        return false;
    }
    /*
    * 返回节点的长度
    * */
    public int length(){
        int length=0;
        Node temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    /*
    * 对链表进行排序
    * 返回排序后的头节点
    * */

    public Node orderList(){
        Node nextNode=null;
        int temp=0;
        Node curNode=head;
        while(curNode.next!=null){//外层循环
            nextNode=curNode.next;
            while(nextNode!=null){//内层循环
                if(nextNode.data>curNode.data){
                    temp=nextNode.data;
                    nextNode.data=curNode.data;
                    curNode.data=temp;
                }
                nextNode=nextNode.next;
            }
            curNode=curNode.next;
        }
        return head;
    }
    /*
    * 如何从链表中删除重复元素，最容易想到的方法就是遍历链表
    * 把遍历到的值存储到一个Hashtable中，在便利过程中，若当前
    * 访问的值在Hashtable中已经存在，则说明这个数据是重复的，就可以删除*/
    //实现代码：
    public void deleteDuplecate(){
        Hashtable<Integer,Integer> table=new Hashtable<Integer, Integer>();
        Node temp=head;
        Node pre=null;
        while(temp!=null){
            if(table.containsKey(temp.data)){
                pre.next=temp.next;
            }else{
                table.put(temp.data,1);
                pre=temp;
            }
            temp=temp.next;
        }
        }
        /*以上这种方法的优点是时间复杂度低，但是也有一个非常明显的缺点，就是在遍历过程中需要额外的存储
        空间来保存已经遍历过的值。是否还有更加高效的算法呢？我们接下来介绍利用双重循环遍历来删除重复元素的方法
        * */
        public void deleteDuplecate1(){
/*
* 这种方法的思路主要是对链表进行双重循环遍历，外循环正常便利链表，假设外循环
* 当前遍历的节点为cur，内循环从cur开始遍历，若碰到与cur所指向节点值相同，则删除这个重复
* 节点。*/
        Node p=head;
        Node cur=null;
        while(p!=null){
            cur=p;
            while(cur.next!=null){
                if(p.data==cur.next.data){
                    cur.next=cur.next.next;
                }else{
                    cur=cur.next;
                }

            }
            p=p.next;
        }
        }
        /*
        * 以上方法的优点是不需要额外的存储空间，缺点也很明显，时间复杂度上比上面的算法时间复杂度要高
        * 假设外循环当前遍历的节点为cur，内循环在遍历过程中会删除掉与cur节点值相同的所有节点。*/
    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
    AdddeleteTest list=new AdddeleteTest();
    list.addNode(3);
    list.addNode(4);
    list.addNode(5);
    list.addNode(2);
    list.addNode(1);
    list.printList();
    list.deleteNode(2);
    list.orderList();
    list.printList();
        System.out.println("==================================");
    AdddeleteTest list2=new AdddeleteTest();
    list2.addNode(2);
    list2.addNode(3);
    list2.addNode(3);
    list2.addNode(3);
    list2.addNode(4);
    list2.addNode(5);
    list2.deleteDuplecate();
    list2.printList();
    }
}
