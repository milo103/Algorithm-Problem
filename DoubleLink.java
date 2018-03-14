import java.util.Random;

public class DoubleLink{

    private Node head  = new Node();
    private Node tail = new Node();
    private static int size = 0  ;

    private static class Node {
        private Node next ;
        private Node prev ;
        private Object  data;

        Node(){
        }

        Node(Object  data){
            this.data = data;
        }
    }

    DoubleLink(){
        this.head = this.tail = null;
    }

    public void add(Object data){
        Node node = new Node(data);

        if(this.head == null){
            this.head = this.tail = node;
            this.size++;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
            this.size++;
        }
    }

    public Node getObjectByIndex(int index){
        if(index <0 || index >this.size)
            return null;
        if(index> this.size/2){
            Node current = this.tail;
            for(int i = this.size -1; i>= this.size/2+1 && current !=null; i--,current = current.prev){
                if(index == i)
                    return current;
            }
        }else{
            Node current = this.head;
            for(int i = 0; i<= this.size/2 && current != null; i++, current = current.next){
                if(index == i)
                    return current;
            }
        }
        return null;
    }

    public Object remove(){
        Object value = -1;
        if(this.size>1){
            value = this.tail.data;
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            this.size--;
        }else if(this.size ==1){
            value = this.head.data;
            this.head = this.tail = null;
        }
        return value;
    }

    public void insert (Object data, int index){

        Node node = getObjectByIndex(index);
        Node newNode = new Node(data);
        Node preNode = node.prev;

        if(null == preNode){
            newNode.next = node;
            newNode.prev = node.prev;
            node.prev = newNode;
            this.head = newNode;
            this.size++;
        }else{
            preNode.next = newNode;
            newNode.prev = preNode;
            newNode.next = node;
            node.prev = newNode;
            this.size++;
        }

    }

    public Object delete(int index){
        Node node = getObjectByIndex(index);
        Node pre = node.prev;
        Node next = node.next;

        if(null == pre){
            Object data = this.head.data;
            this.head = this.head.next;
            this.size--;
            return data;
        }

        if(null == next){
            Object data = this.tail.data;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
            return data;
        }

        pre.next = next;
        next.prev = pre;
        this.size--;
        return node.data;
    }

    public void addviaOrder(Object data){
        Node node = new Node(data);

        if(this.head == null){
            this.head = this.tail = node;
            this.size++;
        }else{
            int pos=0;
            int flag = 1;
            Node current = this.head;
            for(int i=0;i<getSize()&& current != null;i++,current = current.next){
                if((int)data > (int)current.data){
                    pos = i;
                    flag=0;
                    break;
                }
            }
            if(flag == 1)
                add(data);
            else
                insert(data,pos);
        }
    }

    public int getSize(){
        return this.size;
    }

    public Object getDataviaIndex(int index){
        return getObjectByIndex(index).data;
    }

    public int getIndexviaData(Object value){
        Node current = this.head;

        for (int i=0;i< getSize() && current != null;i++, current = current.next){
            if(current.data == value)
                return i;
        }
        return -1;
    }

    public String toString(){
        if (null == this.head)
            return "[]";

        StringBuilder sb= new StringBuilder();

        for(Node current = this.head; current!=null; current = current.next)
            sb.append(current.data.toString()).append(" ");

        return sb.toString();
    }


    public static void main(String[] args) {

        DoubleLink doulink = new DoubleLink();

        Random ramdon = new Random();
        
        doulink.add(103);
        doulink.add(102);

        for(int i = 0; i < 30; i++){
            int k = ramdon.nextInt(100);
            System.out.print(k+" ");
            doulink.addviaOrder(k);

        }


        System.out.println();
        System.out.println(doulink.toString());
        System.out.println(doulink.getSize());

        System.out.println();
//      doulink.insert(72,10);
//      System.out.println();
        int len = doulink.getSize();
        for(int i = 0; i < len; i++)
            System.out.print(doulink.remove()+" ");
//      System.out.println();
//      System.out.println(doulink.getSize());
//      //System.out.print(doulink.remove()+" ");
//      //doulink.insert(77,0);
//
//      System.out.println(doulink.getIndexviaData(72));
//      System.out.println(doulink.getDataviaIndex(11));
//
//      System.out.println(doulink.delete(0)+" ");
//      for(int i = 0; i < doulink.getSize(); i++){
//          System.out.print(doulink.getObjectByIndex(i).data+" ");
//
//      }
//      System.out.println();
//
//      System.out.println(doulink.remove()+" ");
//      System.out.println(doulink.remove()+" ");
//
//      for(int i = 0; i < doulink.getSize(); i++){
//          System.out.print(doulink.getObjectByIndex(i).data+" ");
//
//      }

    }

}