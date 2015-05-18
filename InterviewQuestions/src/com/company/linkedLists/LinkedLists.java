package com.company.linkedLists;

import java.util.HashSet;

public class LinkedLists {

	public class Node {

		Node next = null;
		int data;

		public Node(int data) {
			this.data = data;
		}

		public void addToLinkedList(int data) {
			Node n = this;
			Node newNode = new Node(data);
			while (n.next != null) {
				n = n.next;
			}

			n.next = newNode;
		}

		/**
		 * Will delete the first node.
		 * 
		 * @param data
		 *            Node to be deleted.
		 * @return head. Returns the head.
		 */
		public Node deleteNode(int data) {
			Node head = this;
			Node nextNode = this.next;

			if (this.data == data)
				return nextNode;

			while (nextNode.next != null) {
				if (nextNode.next.data == data) {
					nextNode.next = nextNode.next.next;
					return head;
				}
				nextNode = nextNode.next;
			}
			return head;
		}

		/**
		 * Deletes the duplicates.
		 */
		public void deleteDuplicates() {
			Node head = this;
			Node previousNode = null;
			HashSet<Integer> uniqueElements = new HashSet<Integer>();
			while (head != null) {
				if (uniqueElements.contains(head.data)) {
					previousNode.next = previousNode.next.next;
				} else {
					previousNode = head;
					uniqueElements.add(new Integer(head.data));

				}
				head = head.next;
			}

		}

		/**
		 * Prints the linked list.
		 */
		public void printLinkedList() {

			Node head = this;
			StringBuffer strBuf = new StringBuffer();
			while (head.next != null) {
				strBuf.append(head.data);
				strBuf.append("-->");
				head = head.next;

			}
			strBuf.append(head.data);
			System.out.println(strBuf.toString());
		}

		/**
		 * A recursive solution to print last K the node. The specialty in this
		 * approach is that the length is not taken into account.
		 * 
		 * @param k
		 *            The last Kth Node
		 * @return
		 */
		public int printKNodeRecurive(int k) {
			if (this.next == null)
				return 0;

			int counter = this.next.printKNodeRecurive(k) + 1;
			if (k == counter) {
				System.out.println(this.data);
				return -1 * counter;
			}
			return counter;
		}

		/**
		 * @param k
		 *            Prints the K the last Node. Is the iterative solution.
		 */
		public void printKNodeIterative(int k) {
			Node startNode = this;
			Node kNode = this;

			int diffK = 0;
			while (diffK < k && kNode != null) {
				kNode = kNode.next;
				diffK = diffK + 1;
			}
			if (kNode == null)
				return;

			while (kNode.next != null) {
				startNode = startNode.next;
				kNode = kNode.next;
			}

			System.out.println(startNode.data);
		}

		/**
		 * @param n
		 *            This is not the head node. Only access to that node is
		 *            given. Copy the next node on to this node and delete the
		 *            next node.
		 */
		public void deleteMiddleNode(Node n) {
			if (n == null || n.next == null)
				return;

			Node nextNode = n.next;
			n.data = nextNode.data;
			n.next = nextNode.next.next;

		}

		public String printValueInReverse() {
			if (this.next == null) {
				return String.valueOf(this.data);
			}

			else
				return (this.next.printValueInReverse() + String
						.valueOf(this.data));

		}
		
	
	}

	public static void main(String[] args) {
		LinkedLists lists = new LinkedLists();
		LinkedLists.Node nodes = lists.new Node(4);

		for (int i = 6; i < 13; i = i + 2) {
			nodes.addToLinkedList(i);
			;
		}

		nodes.printLinkedList();
		nodes = nodes.deleteNode(10);
		nodes.printLinkedList();
		nodes.addToLinkedList(4);
		nodes.addToLinkedList(4);
		nodes.addToLinkedList(2);
		nodes.addToLinkedList(2);
		nodes.printLinkedList();
		nodes.deleteDuplicates();
		nodes.printLinkedList();
		nodes.printKNodeRecurive(5);
		nodes.printKNodeRecurive(5);
		
		
		lists.linkedListQuestion5();
		lists.printTheHeadOfCircularNode();
	}

	public void linkedListQuestion5() {
		
		LinkedLists.Node nodes1 = this.new Node(7);
        nodes1.addToLinkedList(1);
        nodes1.addToLinkedList(6);
        nodes1.printLinkedList();
        
		LinkedLists.Node nodes2 = this.new Node(5);
        nodes2.addToLinkedList(9);
        nodes2.addToLinkedList(2);
        nodes2.printLinkedList();

        int value = Integer.parseInt(nodes1.printValueInReverse())+Integer.parseInt(nodes2.printValueInReverse());
        String reverseValue = String.valueOf(value);
        
        String s1 = reverseValue.substring(reverseValue.length()-1);
        
		LinkedLists.Node nodes3 = this.new Node(Integer.parseInt(s1));
		
        for(int i = reverseValue.length()-1 ; i>=1;i--)
        {
           String s2 = reverseValue.substring(i-1,i);
           nodes3.addToLinkedList(Integer.parseInt(s2));
        }
        
        nodes3.printLinkedList();
	}
	
	public void printTheHeadOfCircularNode()
	{
		LinkedLists.Node nodes1 = this.new Node(7);
		nodes1.addToLinkedList(8);
		nodes1.addToLinkedList(9);
		nodes1.addToLinkedList(10);
		nodes1.addToLinkedList(11);
		nodes1.addToLinkedList(12);
		
		Node nextNode = nodes1;
		while(nextNode.data!=9)
		{
			nextNode = nextNode.next;
		}
		
		Node lastNode = nodes1;
		while(lastNode.next!=null)
		{
			lastNode = lastNode.next;
		}
		
		lastNode.next = nextNode;

		Node node2 = nodes1;
		Node node3 = nodes1.next.next;
		
		while(node2.data!=node3.data)
		{
			node2 = node2.next;
			node3 = node3.next.next;
		}
		
		System.out.println(node2.data);
		
		int a = 4^3^6;
		int b = 6^3^4;
		System.out.println(a+" "+b);
	}
	

}
