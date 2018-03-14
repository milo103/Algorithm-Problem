import java.util.Random;


public class link{
	
	Node head;
	Node tail;
	int size = 0;	
	
	private class Node {
		Node pre;
		Node next;
		int data;
		
		Node(){
		}
		
		Node(Node pre, int data, Node next){
			this.pre = pre;
			this.data = data;
			this.next = next;
		}
	}
	
	link(){
		this.head = this.tail = null;
	}
	
	link(int data){
		Node node = new Node(null,data, null);
		this.head = node;
		this.tail = this.head;
		this.size++;
	}
	
	
	void add(int data){
		Node newNode = new Node(null,data,null);
		if(this.head == null){
			this.head = this.tail = newNode;
			this.size++;
		}else{
			
			Node temp = this.head;
			
			if(newNode.data>head.data){
				newNode.next = head;
				head.pre = newNode;
				this.head = newNode;
			}else if(newNode.data < tail.data){
				newNode.pre = tail;
				tail.next = newNode;
				tail = newNode;
			}else {
				
				while(temp !=null){
					if(temp.data < newNode.data){
						newNode.pre = temp.pre;
						newNode.next= temp;
						temp.pre = newNode;
						break;
					}
					temp = temp.next;
				}
			}

			
//			newNode.pre = this.tail;
//			this.tail.next = newNode;
//			this.tail = newNode;
			this.size++;
		}
	}
	
	Object remove(){
		if(this.size>1){
			Object value = this.tail.data;
			this.tail.pre.next = null;
			this.tail = this.tail.pre;
			this.size--;
			return value;
		}else if(this.size ==1){
			Object value = this.head.data;
			this.head = this.tail = null;
			return value;
		}else{
			return -1;
		}
	}
	
	Node search(int index){
		if(index > -1 && index < this.size){
			Node current = this.head;
			for(int i=0 ;i<this.size && current!=null; current = current.next,i++){
				if(i == index)
					return current;
			}
		}
		return null;
	}
	
	void insert(int data, int index){
		if(index <0 || index>=this.size)
			return ;

		Node node = search(index);
		Node newnode = new Node(null,data,null);
		Node preNode = node.pre;
		
		if(preNode == null){
			newnode.pre = null;
			newnode.next = this.head.next;
			this.head.next.pre = newnode;
			this.head = newnode;
			this.size++;
		}else{
			preNode.next = newnode;
			newnode.pre = preNode;
			newnode.next = node;
			node.pre = newnode;
			this.size++;
		}
	}
	
	public String toString(){
		if (null == this.head)
			return "[]";
		
		StringBuilder sb= new StringBuilder();
		
		for(Node current = this.head; current!=null; current = current.next)
			sb.append(current.data).append(" ");
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		link doulink = new link();
		
		Random ramdon = new Random();
		
		for(int i = 0; i < 22; i++){
			int k = ramdon.nextInt(1000);
			System.out.print(k+" ");
			doulink.add(k);
			
		}
		System.out.println();
		System.out.println(doulink.toString());
		for(int i = 0; i < 2; i++)
			doulink.remove();
		System.out.println(doulink.toString());
		
		System.out.println(doulink.search(6).data +" " + doulink.size);
		
		doulink.insert(166,19);
		System.out.println(doulink.toString());
		
		
	}
}