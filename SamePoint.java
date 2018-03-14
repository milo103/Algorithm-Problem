import java.util.Scanner;

public class SamePoint{
	
	static Node []data = new Node[100];
	private static Scanner sc;
	
	static int [][]offset ={{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	
	public static class Node{
		int x;
		int y;
		int step;
	}
	
	static int tail;
	static int head;
	
	static int [][]map = new int[9][9];
	
	
	static void endecode(Node node){
		data[tail++]= node;
	}
	
	static Node decode(){
		return data[head++];
	}
	
	static void init(){
		for (int i=0;i<9;i++)
			for (int j=0;j<9;j++)
				map[i][j]=0;
		
		head = tail = 0;
			
	}
	
	static void BFS(){
		Node curnode;
		
		while(head<tail){
			curnode = decode();
			
			for(int i=0;i<8;i++){
			     Node tempnode = new Node();
				 tempnode.x = curnode.x + offset[i][0];
				 tempnode.y = curnode.y + offset[i][1];
				 
				 if((tempnode.x>=0 && tempnode.x<9 && tempnode.y>=0 && tempnode.y<9)){
					 if(map[tempnode.x][tempnode.y]==0){
						 Node node = new Node();
						 
						 tempnode.step = curnode.step+1;
						 map[tempnode.x][tempnode.y] = tempnode.step;
						 node = tempnode;
						 endecode(node);
					 }
				 }
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		
		Node newnode =  new Node();
		init();
//		System.setIn(new java.io.FileInputStream("src/input.txt"));
//		sc = new Scanner(System.in);
		
		//newnode.x = sc.nextInt()-1;
		//newnode.y = sc.nextInt()-1;
		newnode.x = 2;
		newnode.y = 5;
		newnode.step =1;
		
		endecode(newnode);
		
		map[newnode.x][newnode.y]=1;
		
		BFS();
		
		for (int i=0;i<9;i++){
			for (int j=0;j<9;j++)
				System.out.print(map[i][j]+" ");			
			System.out.println();
		}
		
		
	}
	
}