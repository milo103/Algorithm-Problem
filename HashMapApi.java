import java.io.IOException;

// API for HashMap: insert, search, remove

public class HashMapApi{
    static int index =0;
    static int SIZE = 10000;

    static Node[] head = new Node[SIZE+2];
    static Node[] hashpool = new Node[SIZE+2];

    static class Node{
        Node prev, next;
        int count;
        Object data;
    }

    static Node getNewNode(){
        index++;
        return hashpool[index-1];
    }
    
    static void init(){
        for(int i=0;i<head.length;i++){
            head[i] = new Node();
            hashpool[i] = new Node();
        }    	
    }

    static void insertNode(int hashkey, Node newnode){
        Node node = head[hashkey];
        head[hashkey].count++;
        if(node.next == null){
            node.next = newnode;
            newnode.prev = node;
        }else{
            node.next.prev = newnode;
            newnode.next = node.next;
            newnode.prev = node;
            node.next = newnode;
        }
    }

    static boolean removeNode(int hashkey, Node node){

        Node keynode = head[hashkey].next;
        for(int i=0;i<head[hashkey].count;i++,keynode = keynode.next){
            if(keynode.data.equals(node.data)){
            	if(keynode.next == null)
            		keynode.prev.next =null;
            	else{
                    keynode.prev.next = keynode.next;
                    keynode.next.prev =keynode.prev;
                }
                head[hashkey].count--;
                return true;
            }
        }
        return false;
    }

    static boolean searchNode(int hashkey, Node node){
        Node keynode = head[hashkey].next;
        for(int i=0;i<head[hashkey].count;i++,keynode = keynode.next){
            if(keynode.data.equals(node.data))
                return true;
        }
        return false;
    }

    static String tostring(int hashkey){
        StringBuilder sb= new StringBuilder();
        Node keynode = head[hashkey].next;
        for(int i=0;i<head[hashkey].count;i++){
            sb.append(keynode.data).append(" ");
            keynode = keynode.next;
        }

        return sb.toString();
    }

    public static void main(String[] args)  throws IOException {

    	init();

        for(int i=1;i<=10;i++){

            Node newnode = getNewNode();
            newnode.data = i;
            int hashkey = 1;
            insertNode(hashkey, newnode);
        }
        
        System.out.println(tostring(1));

        Node newnode = getNewNode();
        newnode.data = 1;
        System.out.println(searchNode(1,newnode));


        System.out.println(removeNode(1,newnode));

        System.out.println(tostring(1));
    }
}