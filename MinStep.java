import java.util.Scanner;

public class MinStep{
	static int [][]offset ={{1,0},{0,-1},{-1,0},{0,1}};
	static Node []data = new Node[1000] ;
	static Node star = new Node();
	static Node end = new Node();
	static int min=0;
	static boolean find = false;

	static int map[][] = { 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
			{ 1, 0, 0, 1, 0, 0, 1, 0, 1 }, 
			{ 1, 0, 0, 1, 1, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 1, 1, 0, 1, 1 }, 
			{ 1, 0, 0, 0, 0, 1, 0, 0, 1 }, 
			{ 1, 1, 0, 1, 0, 1, 0, 0, 1 },
			{ 1, 1, 0, 1, 0, 1, 0, 0, 1 }, 
			{ 1, 1, 0, 1, 0, 0, 0, 0, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	
	public static class Node{
		int x;
		int y;
		int step;
		boolean visit;
	}

	static int tail;
	static int head;
	static boolean [][]visit = new boolean[9][9];

	static void init(){
		for (int i=0;i<9;i++)
			for (int j=0;j<9;j++){
				visit[i][j]=false;
			}
		find = false;
		head = tail = 0;
		min =0;
	}

	static void push(Node value){
		data[tail++] = value;	
	}
	
	static Node pop(){
		return data[head++];
	}
	
	static void BFS(){
		Node curnode;
		while(head < tail){
			curnode = pop();

			for(int k=0;k<4;k++){
				Node newnode = new Node();
				newnode.x = curnode.x+ offset[k][0];
				newnode.y = curnode.y+ offset[k][1];
				
				if(newnode.x>=0 && newnode.x<9 &&newnode.y>=0 &&newnode.y<9 
				   && visit[newnode.x][newnode.y] == false){
					
					if(map[newnode.x][newnode.y]!=1){
						
						visit[newnode.x][newnode.y] = true;
						newnode.step = curnode.step+1;
						newnode.visit = true;
						
						if(newnode.x == end.x && newnode.y == end.y){
							min = curnode.step+1;
							find = true;
							break;
						}

						push(newnode);
					}
				}
			}
			if(find){
				break;
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		
		int T,x,y;
		Scanner sc;
		
		System.setIn(new java.io.FileInputStream("src/input.txt"));
		sc = new Scanner(System.in);
		
		T= sc.nextInt();
		for(int t=0;t<T;t++){
			
			init();
			
			star.x = sc.nextInt();
			star.y = sc.nextInt();
			star.step = 0;
			star.visit = true;
			
			end.x = sc.nextInt();
			end.y = sc.nextInt();
			
			visit[star.x][star.y]= true;			
			push(star);
			
			
			BFS();
			
			System.out.println(min);
			
		}
		
	}	
}