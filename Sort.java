import java.lang.Math;
import java.util.Random;

public class Sort{

	static void QuickSort(int data[],int low, int high){
		int i = low;
		int j = high;
		if(i>j) return ;
		int key = data[i];
		while(i<j){
			while(i<j && data[j]>=key)
				j--;
			data[i] = data[j];
			while(i<j && data[i]<=key)
				i++;
			data[j] = data[i];
		}
		data[i] = key;
		QuickSort(data,low,i-1);
		QuickSort(data,i+1,high);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		Random ramdon = new Random();
		
		int temp[] ={5,45,47,584,48,184,547,65,9,54};
		QuickSort(temp,0,temp.length-1);
		
		for(int i =0 ;i< temp.length;i++)
			System.out.print( temp[i]+" ");
		System.out.println( );
	}
}