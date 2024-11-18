
public class SLinkedList {

	public Node head;
	public Node tail;
	public int size;
	
	public SLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
        	head = newNode;
            tail = newNode;
        } else {
        	newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
  
    public void addAfter(Node after, int data) {
      Node newNode = new Node(data);
      newNode.setNext(after.getNext());
      after.setNext(newNode);
      size++;
    }
   
    public Node removeFirst() {
        if (head == null) return null;

        Node temp = head;
        head = head.getNext();
        temp.setNext(null);
        size--;
        return temp;
    }
	
    public Node removeLast() {
        if (tail == null) return null; // Hiç eleman yoksa
       
        Node temp = tail;
        tail.setNext(null);
        size--;
        return temp;
    }
    
    public Node removeAfter(Node after) {
    	Node temp = after.getNext();
    	after.setNext(temp.getNext());
    	size--;
    	return temp;
    	
    }
    
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
    
    public int sumData() {
        Node temp = head;
        int sum = 0;
        while (temp != null) {
            sum += temp.getData();
            temp = temp.getNext();
        }
        return sum;
    }
    
    public boolean searcLinkedList(int target) {
    	Node temp = head;
    	while(temp != null) {
    		if (temp.getData() == target) {
    			return true;
    		}
    		temp = temp.getNext();
    	}
    	return false;
    }
    
    public int findLength() {
    	int length = 0;
    	Node temp = head;
    	while(temp != null) {
    		length++;
    		temp = temp.getNext();
    	}
    	return length;
    }
    
    public int getMiddle() {
    	Node temp = head;
    	int length = findLength();
    	int midindex = length/2;
    	while(midindex > 0) {
    		temp = temp.getNext();
    		midindex--;
    	}
    	return temp.getData();
    }
    
    public int count(int key) {
    	Node temp = head;
    	int count = 0;
    	while(temp != null) {
    		if(temp.getData() == key) {
    			count++;
    		}
    		temp = temp.getNext();
    	}
    	return count;	
    }
    
    public void swapHeadWithNext() {
    	Node temp = head;
    	if(temp == null || temp.getNext() == null) {
    		System.out.println("Cannot swap.  The list has less than two nodes.");
    		return;
    	}
    	Node second = temp.getNext();
    	temp.setNext(second.getNext());
    	second.setNext(temp);
    	head = second;
    }
}

