import java.util.Scanner;

public class Queue{
	
	static int front=0;
	static int rear=-1;
	static int maxsize=100;
	static int ncount=0;
	static int [][]offset ={{1,0},{0,-1},{-1,0},{0,1}};
	static Node []data ;
		
	public Queue(int n){
		maxsize = n;
		data =new Node[maxsize];
		front = 0;
		rear = -1;
		ncount = 0;
	}
	
	public static class Node{
		int x;
		int y;
		int step;
		
		Node(){
			
		}
	}
	
	static boolean isEmpty(){
		return ( ncount == 0) ? true:false;
	}
	
	static boolean isFull(){
		return (ncount == maxsize)?true:false;
	}
	
	static void push(Node value){
		if(isFull())
			return ;
		data[++rear] = value;
		ncount++;		
	}
	
	static Object pop(){
		if(isEmpty())
			return null;
		
		Object temp = data[front++];
		ncount--;
		return temp;
	}

	public String toString(){
		
		StringBuilder sb= new StringBuilder();
		for(int i=front;i<=rear;i++){
			sb.append(data[i]).append(" ");
		}
		return sb.toString();
	}	
	
	public static void main(String[] args)throws Exception {
		Queue myQue = new Queue(100);
		
		data = new Node[100];
		
		for(int i=0;i<100;i++){
			data[i].x=0;
			data[i].y=0;
			data[i].step =0;
		}
		
		int [][]map = new int[9][9];
		int T,x,y,min=0;
		Scanner sc;
		boolean find = false;
		Node star = new Node();
		Node end = new Node();
		int []dx ={0,0,1,-1};
		int []dy ={1,-1,0,0};
		
		System.setIn(new java.io.FileInputStream("src/input.txt"));
		sc = new Scanner(System.in);
		
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++){
				map[i][j] = sc.nextInt();
			}

		T= sc.nextInt();
		for(int t=0;t<T;t++){
			
			star.x = sc.nextInt();
			star.y = sc.nextInt();
			
			end.x = sc.nextInt();
			end.y = sc.nextInt();
			
			
			int [][]visit = new int[9][9];
			
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
					visit[i][j]=0;			
			
			data[front].x = star.x;
			data[front].y = star.y;
			data[front].step = 0;
			front++;
			visit[star.x][star.y] = 1;
			
			while(front>rear){
				
				for(int k=0;k<4;k++){
					 x = data[rear].x+ dx[k];
					 y = data[rear].y+ dy[k];
					
					 if((x>=0 && x<9) && (y>=0&&y<9) && visit[x][y] ==0 && map[x][y] ==0){
						 if(x == end.x && y == end.y){
							 min = data[rear].step;
							 find = true;
							 break;
						 }
						 
						 data[front].x = x;
						 data[front].y = y;
						 data[front].step = data[rear].step+1;
						 front++;
						 visit[x][y]=1;
						 
					 }
				}
				if(find)
					break;
				rear++;
			}
			
			System.out.println(min);
			
		}
		
	}
	
	
}