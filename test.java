import java.util.Random;
public class test{
	
	static int SIZE = 11881376; // 26*26*26*26*26
	static int SIZE1 = 100000; // 26*26*26*26*26
	int len = 5;
	static int[] data =new int[SIZE];
	static char[] str = new char[5];
	
	static int  getNum(char strtemp[]){
		int val =0;
		for(int i =0;i< 5;i++)
			val = val *26 + strtemp[i]-'a';
		data[val]++;
		
		return data[val];
	}
	static int getchar(char strtemp[]){
		int val = 0;
		for (int i =0 ;i< 5 ;i++){
			val += val *26 +strtemp[i]-'a';
			val%=SIZE1;
		}
		
		return val;
	}
	
	public static int getKey(int val){
		return val%(SIZE1+10);
	}
	
	public static void main(String[] args) { 
		
		char [] a = {'e','j','v','s','p','r'};
		char [] b = {'a','a','a','a','c'};
		//int fs = getchar(a);
		System.out.println(873%100);
		System.out.println(getchar(a));
		System.out.println(getKey(getchar(b)));
		int flag =0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=b[i]){
				flag =1;
				break;
			}
				
		}
		if(flag == 0 )
			System.out.println(" == ");
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();

		Random ramdon = new Random();
		int max = 0;
		for(int i = 0; i < 100000; i++){
			for(int j = 0; j < 5; j++){
			      str[j] = (char) (ramdon.nextInt(26) + 'a');
		    }
			int temp = getNum(str);
			if(temp>max)
				max= temp;
		}
		
		System.out.println(max);
	}
}