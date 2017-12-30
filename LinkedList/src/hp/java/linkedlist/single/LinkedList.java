package hp.java.linkedlist.single;

public class LinkedList {

	private Node head;
	
	/**
	 * @param data
 	 * 1. Creating a new node to hold the data
 	 * 2. Checking whether the list is null by checking head value for null
 	 * 3. Traversing to the last and inserting data
	 */
	public void insert(int data) {
		Node node = new Node();
		node.setData(data);
		node.setNext(null);
		
		if(head != null) {
			Node n = head;
			while(n.getNext() != null) 
				n = n.getNext();
			n.setNext(node);
		}
		else
			head = node;
	}
	
	/**
	 * @param data
	 * 1. Creating a new Node and setting the received value
	 * 2. Then setting the head value to the created node, even if head is null not a problem
	 * 3. Making the current node as head.
	 */
	public void insertAtStart(int data) {
		Node node = new Node();
		node.setData(data);
		node.setNext(head);
		head = node;
	}
	
	/**
	 * @param index
	 * @param data
	 * 1. Index values will always start from 0 in code but will receive proper values as input
	 * 2. If index value is 0, it means insert at start, hence call {@code insertAtStart(data)} and pass data
	 * 3. If index is not 0, then traverse till the previous element on index and make changes accordingly
	 * 4. Loop till index-1 cause we are using next value to insert.
	 */
	public void insertAt(int index, int data) {
		if(index == 0 || head == null)
			insertAtStart(data);
		else {
			Node node = new Node();
			node.setData(data);
			node.setNext(null);
			Node n = head;
			for(int i = 0; i < index - 1; i++)
				n = n.getNext();
			node.setNext(n.getNext());
			n.setNext(node);
		}
	}
	
	/**
	 * @param index
	 * 1. if index is 0, delete the head value by assigning next element to head.
	 * 2. else, traverse to the node before index and do necessaries
	 * 3. nullify node1 to make it eligible for garbage collection
	 */
	public void deleteAt(int index) {
		if(index == 0)
			head = head.getNext();
		else {
			Node node = head;
			Node node1 = null;
			for(int i = 0; i < index - 1; i++)
				node = node.getNext();
			node1 = node.getNext();
			node.setNext(node1.getNext());
			node1 = null;
		}
	}
	
	/**
	 * Start from head and traverse until next value becomes null while printing the data
	 */
	public void display() {
		Node n = head;
		while(n != null) {
			System.out.println(n.getData());
			n = n.getNext();
		}
	}
}
