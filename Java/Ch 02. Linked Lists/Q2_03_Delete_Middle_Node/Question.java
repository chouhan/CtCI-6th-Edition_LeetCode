package Q2_03_Delete_Middle_Node;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Question {

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}

	public static LinkedListNode removeNodes(LinkedListNode start, int x) {

		if(start == null) return start;

		if(start.data > x && start.next == null) return null;

		//find first head node
		LinkedListNode cur = start;
		LinkedListNode prev = null;

		//4,5,3,2,1,6 --- where x = 2
		while(cur != null && cur.data > x) {
			prev = cur;
			cur = cur.next;
		}

		if(prev != null)
			prev.next = null;

		LinkedListNode newHead = cur;

		while(cur.next != null) {
			if(cur.next.data > x) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

		return newHead;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNode(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
		removeNodes(head, 5); // delete node greater than 5
		System.out.println(head.printForward());
	}

}
