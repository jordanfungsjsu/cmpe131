import java.util.Arrays;
//public class LinkedFrontBackCappedList<T> 
//implements FrontBackCappedListInterface<T> { 

public class LinkedFrontBackCappedList<T extends Comparable<? super T>> 
implements FrontBackCappedListInterface<T>,  
Comparable<LinkedFrontBackCappedList<T>> {
	private Node head, tail;
	private int size, maxSize;
   
	@Override
	public int compareTo(LinkedFrontBackCappedList<T> other) {
		Node a = this.head;
		Node b = other.head;
		while(a!=null&&b!=null) {
			if(a.data.compareTo(b.data)!=0)
				return a.data.compareTo(b.data);
			else {
				a=a.next;
				b=b.next;
			}
		}
		if(this.size<other.size) {
			return -1;
		}
		else if(this.size>other.size) {
			return 1;
		}
		else {
			return 0;
		}
	}
	//constructor
	public LinkedFrontBackCappedList(int initSize) {
		maxSize=initSize;
	}
	
	@Override
	public String toString() {
		if(!isEmpty()) {
			Node current=head;
			@SuppressWarnings("unchecked")
			T[] a = (T[])new Comparable[size];
			int count=0;
			while(current!=null&&count<size) {
				a[count]=current.data;
				current=current.next;
				count++;
			}
			return Arrays.toString(a)+"\tsize="+size 
					+"\tcapacity="+maxSize+"\thead="+head.data+" tail="+tail.data;
		}
		return "[]"+"\tsize="+size 
				+"	capacity="+maxSize;
	}
	//adds to the front, returns true if successful
	//returns false when unsuccessful
	public boolean addFront(T value) {
		if(isFull())
			return false;
		if(isEmpty()) {
			Node a= new Node(value);
			head= a;
			tail=a;
			size++;
			return true;
		}
		Node a = new Node(value);
		a.next= head;
		head= a;
		size++;
		return true;
	}
	//adds to back of the list, returns true if successful
	//returns false when unsuccessful
	public boolean addBack(T value) {
		if(isFull())
			return false;
		if(isEmpty()) {
			Node a= new Node(value);
			head= a;
			tail=a;
			size++;
			return true;
		}
		else {
			Node a = new Node(value);
			tail.next=a;
			tail=a;
			size++;
			return true;
		}
	}
	//removes and returns element at the front or head, returns null if list is empty
	public T removeFront() {
		if(isEmpty()) {
			return null;
		}
		if(size==1) {
			T temp = head.data;
			head=null;
			tail=null;
			size--;
			return temp;
		}
		T temp = head.data;
		head=head.next;
		size--;
		return temp;
	}
	//removes and returns last item in the list, returns null if list is empty
	public T removeBack() {
		if(isEmpty()) {
			return null;
		}
		if(size==1) {
			T temp = head.data;
			head=null;
			tail=null;
			size--;
			return temp;
		}
		Node current= head;
		while(current.next!=tail) {
			current=current.next;
		}
		T temp= current.next.data;
		tail=current;
		size--;
		return temp;
	}
	
	//returns true of list contains certain value, false otherwise
	public boolean contains(T value) {
		Node current = head;
		while(current!=null) {
			if(value.equals(current.data))
				return true;
			current=current.next;
		}
		return false;
	}
	
	//returns location of item in list, if item isn't in list it returns -1
	public int indexOf(T item) {
		Node current = head;
		int count=0;
		while(current!=null) {
			if(item.equals(current.data))
				return count;
			count++;
			current=current.next;
		}
		return -1;
	}
	
	//returns last location of item in list, returns -1 if item isn't in list
	public int lastIndexOf(T item) {
		Node current = head;
		int count=0;
		int lastCount=-1;
		while(current!=null) {
			if(item.equals(current.data))
				lastCount=count;
			count++;
			current=current.next;
		}
		return lastCount;
	}
	
	//returns itmem at given position
	public T getEntry(int pos) {
		if(pos>size||pos<0) {
			return null;
		}
		Node current= head;
		int count=0;
		while(count<pos) {
			current=current.next;
			count++;
		}
		if(current==null)
			return null;
		T temp = current.data;
		return temp;
	}
	
	public void clear() {
		head=null;
		tail=null;
		size=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size==maxSize;
	}
	
	public int size() {
		return size;
	}
	
	public class Node {
		public T data; 
		public Node next; 

		private Node(T dataValue) {
			data = dataValue;
			next = null;
		}

		private Node(T dataValue, Node nextNode) {
			data = dataValue;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} 
	} 
}
