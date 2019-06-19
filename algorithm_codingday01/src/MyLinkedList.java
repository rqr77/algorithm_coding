/***
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用
 * 。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


class MyLinkedList {
    private Node head;
    private int length;


    /** Initialize your data structure here. */
    public MyLinkedList() {
        head=new Node(-1);
        length=0;

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index<length && index>0){
            Node t=head;
            for (int i=0 ;i <= index; i++) {
                t = t.next;
            }
            return t.val;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node new_head =new Node(val);
        new_head.next=head.next;
        head.next= new_head;
        length++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node t=head;
        for (int i=0 ;i<length;i++) {
            t=t.next;
        }
        Node tail=new Node(val);
        t.next=tail;
        length++;

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be
     *  appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0){
            index = index+length+1;
        }
        Node current = head;
        if (index<length && index>0){
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            Node t= current.next;
            Node add = new Node(val);
            current.next=add;
            add.next=t;
            length++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index>0 && index <length){
            Node t =head;
            for (int i=0;i<index;i++){
                t=t.next;
            }
            t.next=t.next.next;
            length--;
        }

    }
}

class Node{
    public Node next;
    public int val;
    public Node(int val){
        this.val=val;

    }




}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

