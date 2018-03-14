import java.io.IOException;
import java.util.Scanner;

public class Staff{
	
	static int SIZE = 100000;
	static int legth = 20;
	static int index = 0;
	static Node []head = new Node[SIZE+2];
	static Node[] hashpool = new Node[SIZE+2];
	static int []levelnum = new int[200];
	static int kbs = 0;
	static class Node{
		 Node next;
		 Node child, parent, brother;
		 int key;
		 char [] name;
		 
		 Node(){
		 }
	}
	
	static void init(){
		index =0;
		for(int i =0;i< SIZE;i++){
			head[i] = new Node();
			hashpool[i]=new Node();
		}
	}
	
	static int getKey(char []name){
		int val =0;
		for(int i=0;i<name.length;i++){
			if(name[i] == '.' || name[i] =='_'){
				val += val - '.';
			}
			if(name[i]>='0'){
				val += (name[i] - '0')*20;
			}
		}
		return val;
	}
	
	static Node getNewNode(){
		index++;
		return hashpool[index-1];
	}

	static Node findStaff(char []name){
		int key = getKey(name);
		Node current = head[key].next;
		while(current!=null){
			if(isSame(name, current.name)){
				return current;
			}				
			current = current.next;
		}
		
		return null;
	}
	
	static boolean isSame(char []name1, char []name2){
		if(name1.length != name2.length)
			return false;
		
		for(int i=0; i<name2.length;i++){
			if(name1[i] != name2[i]){
				return false;
			}
		}
		return true;
	}
	

	static Node createNode(char []name){
		Node newnode = getNewNode();
		newnode.name = new char[name.length];
		for(int i=0;i<name.length;i++)
			  newnode.name[i] = name[i];		
		return newnode;
	}
	
	static void insert(int key, Node newnode){
		newnode.next = head[key].next;
		head[key].next = newnode;
	}
	
	static String toString1(int key){
		Node current = head[key].next.child;
		StringBuilder sb= new StringBuilder();
		
		while(current!=null){
			for(int i=0;i< current.name.length;i++)				
			   sb.append(current.name[i]);
			current = current.brother;
			sb.append(" ");
		}
		
		return sb.toString();
	}

	static String toString2(char []name){

		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i<name.length;i++){
			sb.append(name[i]);
		}		
		return sb.toString();
	}
	
	static void Lead(char []staffname, char []leadername){
		Node staff = findStaff(staffname);
		Node leader = findStaff(leadername);
		

		if(staff ==null){
			int key = getKey(staffname);
			staff = createNode(staffname);
			insert(key,staff);
		}
		
		if(leader ==null){
			int key = getKey(leadername);
			leader = createNode(leadername);
			insert(key,leader);
		}
		
		if(staff.parent!=null){
			if(staff.parent.child == staff){
				staff.parent.child = staff.brother;
			}else{
				Node newnode = staff.parent.child;
				while(newnode!= null){
					if(newnode.brother == staff){
						newnode.brother = staff.brother;
						break;
					}else{
						newnode = newnode.brother;
					}
				}
			}
		}
		
		staff.brother = leader.child;
		leader.child = staff;
		staff.parent = leader;

	}
	
	static void findLeader(char []staffname, char []leadername){
		Node staff = findStaff(staffname);
		if(staff == null){
			Lead(staffname,leadername);
		}
		
		Node leader = staff.parent;
		
		if(leader == null){
			System.out.println("FINDLEADER "+ toString2(staffname)+" Boss");
		}else{
			if(isSame(leader.name,leadername)){
				System.out.println("FINDLEADER "+ toString2(staffname)+" "+ toString2(leader.name));
			}			
		}
	}
	
	static int staffNum(char []staffname){
		Node staff = findStaff(staffname);
		int count =0;
		Node current = staff.child;
		Node curbro = staff.brother;
		
		if(current == null){
			return count;
		}else{
			count++;
			while(current.brother!=null){
				    count++;
					count  += staffNum(current.name);					
					current = current.brother;
					if(current.brother==null && current.child!=null){
						count += staffNum(current.name);
					}						
			}
		}
		
		return count;
	}
	
	static int getLevel(char []staffname){
		Node staff = findStaff(staffname);
		int count =1;
		Node current = staff.child;
		
		while(current!=null){
			count += getLevel(current.name);
			current = current.brother;
		}
		
		return count;
	}
	
	static int staffNum1(char []staffname){
		Node staff = findStaff(staffname);
		int count =0;
		Node current = staff.child;
		Node curbro = staff.brother;
		
		if( toString2(staffname).equals("liang2010.wu"))
			kbs=1;
		
		if(current == null)
			return count;

		if(current != null){
			count += staffNum1(current.name)+1;
		}
		if(curbro!=null)
			count += staffNum1(curbro.name)+1;
		
		return count++;
	}
	
	public static void main(String[] args)  throws IOException {
		Scanner sc;
		System.setIn(new java.io.FileInputStream("src/input.txt"));
		sc = new Scanner(System.in);
		
		init();
		String cmd;
		char [] staff = new char[legth];
		char [] lead = new char[legth];
		int num =0;
		int value =0;
		
		while(true){
			cmd = sc.next();
			if(cmd.equals("END")){
				break;
			}

			if(cmd.equals("LEAD")){
				staff = sc.next().toCharArray();
				lead = sc.next().toCharArray();
				Lead(staff,lead);
			}
			
			if(cmd.equals("FINDLEADER")){
				staff = sc.next().toCharArray();
				lead = sc.next().toCharArray();
				findLeader(staff,lead);
			}
			
			if(cmd.equals("STAFFNUM")){
				staff = sc.next().toCharArray();
				num  = sc.nextInt();
				value = staffNum(staff);
				System.out.println("STAFFNUM "+ toString2(staff)+" "+value);
			}
			
			if(cmd.equals("STAFFLEVEL")){
				staff = sc.next().toCharArray();
				num  = sc.nextInt();
				value = getLevel(staff);
			}
			
		}

		
		System.out.println();
	}
	
	
}