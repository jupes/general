package DataStructures;

public class LinkedList {
    NodeLINKEDLIST head;

    public void append(int data) {
        if (head == null) {
            head = new NodeLINKEDLIST(data);
        }
        NodeLINKEDLIST current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new NodeLINKEDLIST(data);
    }

    public void prepend(int data) {
        NodeLINKEDLIST newHead = new NodeLINKEDLIST(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        NodeLINKEDLIST current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
        }
    }
    /**
     * Method returns if there is a cycle in the linked list, think of cars going around a race track, eventually they will collide if there is a cycle
     * @param head start of linked list
     * @return
     */
    boolean hasCycle(NodeLINKEDLIST head) {
        if (head == null)
            return false;
        NodeLINKEDLIST fast = head.next;
        NodeLINKEDLIST slow = head;
        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}