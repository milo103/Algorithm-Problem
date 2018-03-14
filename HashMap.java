import java.io.*;
import java.util.Random;


public class HashMap {

	static int SIZE = 100000;
	static int hashindex =0;
	static int size = 0;
	
	static Node[] head = new Node[SIZE+10];	
	static Node[] hashpool = new Node[SIZE+10];	
	
	private static class Node {
		private Node next,prev;
		private int key;
		private char[] data;
		
		Node(){			
		}
	}
	
	public static Node getNewNode(){
		hashindex++;
		return hashpool[hashindex-1];
	}
	
	public static int getKey(int val){
		return val%(SIZE+10);
	}
	
	static void insert(int key, Node newnode){
		Node temp = head[key];
		if(head[key].next == null){
			newnode.prev = head[key];
			newnode.next = null;
			head[key].next = newnode;
			newnode.key =1;
		}else{
			newnode.prev = head[key];
			newnode.next = temp.next;
			temp.next.prev = newnode;
			newnode.key++;						
		}
	}
	
	static Node search(int hashkey, Node newnode){
		Node node = head[hashkey];
		
		while(node.next!= null){
			if(isSame(node.next.data, newnode.data)){
				return node.next;
			}
			node = node.next;
		}
		return null;
	}
	
	public static boolean isSame(char []stra, char []strb){
		for(int i=0;i<strb.length;i++)
			if(stra[i] != strb[i])
				return false;
		return true;
	}
	
	public static String toString(char []data){
		
		StringBuilder sb= new StringBuilder();
		sb.append(data);
		return sb.toString();
	}	
	
	static int getchar(char strtemp[]){
		int val = 0;
		for (int i =0 ;i< 5 ;i++){
			val += val *26 +strtemp[i]-'a';
			val%=SIZE;
		}
		return val;
	}
	
	public static void main(String[] args)  throws IOException {

		PrintStream mytxt=new PrintStream("./log.txt");
		PrintStream out=System.out;
		System.setOut(mytxt);
		
		//HashMap  hash = new HashMap();
		
		for(int i=0;i<head.length;i++){
			head[i] = new Node();
			hashpool[i] = new Node();
		}
		
		Random ramdon = new Random();
		
		int max = 1;
		int key =0;
		System.out.println("start");
		char[] str1 = new char[500];
		for(int i = 0; i < 100000; i++){			
			for(int j = 0; j < 500; j++){
			      str1[j] = (char) (ramdon.nextInt(26) + 'a');
		    }
			
			
			int temp = getchar(str1);			
			int hashkey = getKey(temp);
			Node newnode = getNewNode();
			newnode.data = str1;
			System.out.println("insert string: "+toString(newnode.data) + " ");
			
			Node sernode = search(hashkey,newnode);
			
			int num =1;
			if(sernode == null){
				insert(hashkey,newnode);
			}else{
				num = sernode.key++;				
			}
			
			if(num>max){
				max=num;
			}
		}
		
		System.out.println(max);

		System.setOut(out);
		System.out.println("日期保存完毕。");		
		 
		
		//in.nextToken();
		
//		for(int i=0;i<10;i++){
//			Node newnode = getNewNode();
//			newnode.data = i+1;
//			int hashkey = getKey(i);
//			
//			insert(hashkey,newnode);
//			Node newnode1 = getNewNode();
//			newnode1.data = i+2;
//			insert(hashkey,newnode1);
//			
//			Node newnode2 = getNewNode();
//			newnode2.data = i+3;
//			insert(hashkey,newnode2);
//			
//			Node newnode4 = getNewNode();
//			newnode4.data = 2;
//			
//			Node node = search(newnode4);
//			if(node != null)
//				System.out.print(node.data + " ");
//		}
		
	}
	
}