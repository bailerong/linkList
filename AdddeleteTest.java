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
        /*
        * 如何找出单链表中的倒数第K个元素
        * */
        /*
        * 为了找出单链表中的倒数第K个元素，最容易象到的方法是首先遍历一遍单链表，求出单链表的长度n，然后再将倒数第K个
        * 转换成为正数第n-k个，接下来去遍历一遍就可以了，但是该方法的最大的一个失误就是将我们的链表
        * 要遍历两次，所以我们不用这种方法，我们用我们的自己的方法*/
        public Node findElem(int k){
            if(k<1)
                return null;
            Node p1=head;
            Node p2=head;
            for(int i=0;i<k-1&&p1!=null;i++){
                p1=p1.next;
            }
            if(p1==null){
                System.out.println("我们的K不合法");
            }
            while(p1.next!=null){
                p1=p1.next;
                p2=p2.next;
            }
            return p2;
        }
        /*实现链表的反转*/
    public void ReverseIteratively(){
        Node pReserseHead=head;
        Node pNode=head;
        Node pPrev=null;
        while(pNode!=null){
            Node pNext=pNode.next;
            if(pNext==null)
                pReserseHead=pNode;//我们先将我们的下一个结点存储起来
            pNode.next=pPrev;
            pPrev=pNode;
            pNode=pNext;
        }
        this.head=pReserseHead;
    }
    /*如何从尾到头输出单链表*/
public void printListReversely(Node PListHead){

    if(PListHead!=null){
        printListReversely(PListHead.next);
        System.out.print(PListHead.data);
    }
}
/*
* 如何寻找链表的中间结点*/
public Node SearchMid(){
    Node p=head;
    Node q=head;
    while(p!=null&&q!=null&&p.next.next!=null){
        p=p.next.next;
        q=q.next;
    }
    return q;
}
/*
* 检查链表是否是带环链表*/
public boolean IsLoop(){
    Node fast=head;
    Node slow=head;
    if(fast==null){
        return false;
    }
    while(fast!=null&&fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
        if(fast==slow){
            return true;
        }
    }
    return !(fast==null||fast.next==null);
}
public Node FindLoopPort(){
    Node slow=head;
    Node fast=head;
    while(fast!=null&&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)
            break;
    }
    if(fast==null||fast.next==null){
        return null;
    }
    slow=head;
    while(slow!=fast){
        slow=slow.next;
        fast=fast.next;
    }
    return slow;
}
public boolean deleteNode(Node n){
    if(n==null||n.next==null)
        return false;
    int temp=n.data;
    n.data=n.next.data;
    n.next.data=temp;
    n.next=n.next.next;
    return true;
}
public boolean isIntersect(Node head1,Node head2){
    if(head1==null||head2==null)
        return false;
    Node tail1=head1;
    Node tail2=head2;
    while(tail1.next!=null)
        tail1=tail1.next;
    while(tail2.next!=null)
        tail2=tail2.next;

    return tail1==tail2;
}
    public static Node getFirstMeetNode(Node head1,Node head2){
    if(head1==null||head2==null)
        return null;
    Node tail1=head1;
    int len1=0;
    while(tail1!=null){
        tail1=tail1.next;
        len1++;
    }
    Node tail2=head2;
    int len2=0;
    while(tail2!=null){
        tail2=tail2.next;
        len2++;
    }
    //两个链表不相交
        if(tail1!=tail2)
            return null;
        Node t1=head1;
        Node t2=head2;
        if(len1>len2){
            int d=len1-len2;
            while(d!=0){
                t1=t1.next;
                d--;
            }
        }else{
            int d=len2-len1;
            while(d!=0){
                t2=t2.next;
                d--;
            }
        }
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
        }
        return t1;
    }
    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
    AdddeleteTest list2=new AdddeleteTest();
    list2.addNode(2);
    list2.addNode(3);
    list2.addNode(3);
    list2.addNode(3);
    list2.addNode(4);
    list2.addNode(5);
    Node temp=list2.head;
    while(temp.next!=null){
        temp=temp.next;
    }
   temp.next.next= list2.head.next.next;
    boolean bool=list2.IsLoop();
        System.out.println(bool);
    list2.printListReversely(list2.head);
    }
}
//我们的链表
