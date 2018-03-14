public class InsertSort{
	
	static int SIZE = 1000;
	static Node []node = new Node[SIZE];
	
	public class Node{
		int data;
		Node next;
		
		Node(){
			
		}
		Node(int values){
			this.data = values;
		}
	}
		
	void init(){
		for(int i=0;i<SIZE;i++){
			node[i] = new Node();
			node[i].data = 0;
			node[i].next = null;
		}
	}

	void insert(){
		
	}
	
	int getLastDistance(int []data,int x,int y){
		int dis =99999,i,last =0;
		
		for (i=0;i<data.length;i++){
			if(data[i] == x || data[i]==y){
				last = i;
				i++;
				break;
			}
		}
		
		for(;i<data.length;i++){
			if(data[i] == x || data[i] == y){
				if(data[last] != data[i]&& i-last < dis){
					dis = i - last;
					last = i;
				}else{
					last = i;
				}
			}
		}
		return dis;
	}
	
	public static void main(String[] args)throws Exception {
		
	}
}