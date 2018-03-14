
public class List{
	
	// One Node in the list
	public static class Node{
		Object elem;
		Node next;

		public Node(Object data){
			this(data,null);
		}

		public Node(Object data, Node n) {
			this.elem = data;
			next= n;
		}
		
		public Object getObject(){
			return elem;
		}
		
		public void setObject(Object data){
			this.elem= data;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
	}
	
	//used the list to create the stack
	public static class ListStack{
		
		Node header;
		int size;
		int elemCount;
		
		public ListStack(){
			header = null;
			size=0;
			elemCount=0;
		}
		
		public ListStack(int size){
			header = null;
			this.size=size;
			elemCount=0;
		}
		
		public void setheader(Node header){
			this.header= header;
		}
		
		public boolean push(Object data){
			if(isFull()){
				System.out.println("this Stack is full ");
				return false;
			}else{
				header = new Node(data,header);
				elemCount++;
				return true;
			}
		}
		
		public  Object pop() throws Exception{
			if(isEmpty()){
				throw new Exception("this Stack is empty");
			}
			
			Object obj = header.getObject();
			header = header.getNext();
			elemCount--;
			
			return obj;
		}
		
		public boolean isEmpty(){
			return size == 0;
		}
		
		public int getElementCount(){
			return elemCount;
		}
		
		public boolean isFull(){
			return size == elemCount;			
		}
		
		public int getMaxSize(){
			return size;
		}
		
		public Object peek(){
			return header.getObject();
		}
		
		
	}
	

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		ListStack  myStack = new ListStack(100);
		
		for(int i=10;i<30 ;i++)
			myStack.push(1000-i);
		
		System.out.println("top elem is " + myStack.peek() +", size is "+  myStack.getMaxSize() + ", count size is " + myStack.getElementCount());
		
		while(myStack.getElementCount()>0)
		{
			System.out.println(" count size is "+ myStack.getElementCount() + " now pop is " + myStack.pop());
		}


	}

}
