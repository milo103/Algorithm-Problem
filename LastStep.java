import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashSet;
import java.util.Hashtable;

public class LastStep {

	
    public static boolean isHappy(int n) {
    	int x=n;
    	int y=n;

    	while(x>1)
    	{
    		x=getResult(x);
        	if (x==1)
        		return true;	
 
        	y=getResult(getResult(y));
        	if (y==1)
        		return true;	
        	
        	if(x==y)
        		return false;
    	}

		    return true;
        
    }
    
    public static int getResult(int y)
    {
    	int sum =0;
    	while (y>0)
    	{
    		sum +=( y%10 )* (y%10);
    		y= y/10;
    	}
    	
    	return sum;
    }
    
    public boolean containsDuplicate(int[] nums) {
    	
    	for(int i=0;i<nums.length-1;i++){
    		int data = nums[i];
    		
    		for(int j=i+1; j<nums.length;j++){
    			if(nums[j]== data)
    				return true;
    		}
    	}
        return false;
    }
    
    
    public static int maxProduct(int[] nums) {
    	
    	if(nums.length ==0)
    		return 0;

    	int min = nums[0];
    	int max = nums[0];
    	int maxProd= nums[0];
    	
    	for(int i=1;i<nums.length;i++){

    		int a = max * nums[i];
    		int b = min * nums[i];
    		
    		max = Math.max(Math.max(a, b) , nums[i]);
    		min = Math.min(Math.min(a, b) , nums[i]);
    		
    		maxProd = Math.max(maxProd,max);
    	}
    	
    	return maxProd;
        
    }
    
    
    public static int[] intersection(int[] nums1, int[] nums2) {
    	
    	int j=0;
    	HashSet<Integer> res = new HashSet<Integer>() ;
    	ArrayList<Integer> data = new ArrayList<Integer>() ;
    	for(int i:nums1){
    	//for(int i=0;i<nums1.length;i++){
    		res.add(i);
    	}
    	
    	//for(int i=0;i<nums2.length;i++){
    	for(int i:nums2){
    		if(res.contains(i)){
    			//num[j++]=nums2[i];
    			data.add(i);
    			//res.remove(i);
    		}
    	}    	
    	
    	int []num=new int[data.size()];
    	for(int i=0;i<data.size();i++){
    		num[i]= data.get(i);
    	}
    	
    	return num;
        
    }
    
    public static int bubblesort(int data[],int len) {
    	
    	int num=0;
    	
    	for(int i=len-1;i>=0; i--){
    		num =data[i];
    		for(int j=i-1; j>=0;j--){
    			if(data[j]>num){
    				
    			}
    		}
    	}
    	
    	return num;
        
    }
    
    
    
    public static double findMaxAverage(int[] nums, int k) {
		
    	int  Maximum  =0,temp=0;
    	
    	for(int i=0;i<k;i++)
    		temp += nums[i];
    	
    	
    	Maximum = temp;
    	
    	for(int i=0,j=k;j<nums.length;i++,j++){
    		
    		temp= temp - nums[i] + nums[j];
    		
    		if(temp>Maximum){
    			Maximum = temp;
    		}
    	}
    	
    	return ((double) Maximum) /((double)k);
        
    }
    
    /**
     * 通过uid查询文件夹中的数据
     * @param localUid
     * @return 
     */
    private Long getTotalBytesManual(int localUid) {
//        Log.e("BytesManual*****", "localUid:" + localUid);
        File dir = new File("/proc/uid_stat/");
        String[] children = dir.list();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < children.length; i++) {
            stringBuffer.append(children[i]);
            stringBuffer.append("   ");
        }
//        Log.e("children*****", children.length + "");
//        Log.e("children22*****", stringBuffer.toString());
        if (!Arrays.asList(children).contains(String.valueOf(localUid))) {
            return 0L;
        }
        File uidFileDir = new File("/proc/uid_stat/" + String.valueOf(localUid));
        File uidActualFileReceived = new File(uidFileDir, "tcp_rcv");
        File uidActualFileSent = new File(uidFileDir, "tcp_snd");
        String textReceived = "0";
        String textSent = "0";
        try {
            BufferedReader brReceived = new BufferedReader(new FileReader(uidActualFileReceived));
            BufferedReader brSent = new BufferedReader(new FileReader(uidActualFileSent));
            String receivedLine;
            String sentLine;

            if ((receivedLine = brReceived.readLine()) != null) {
                textReceived = receivedLine;
//                Log.e("receivedLine*****", "receivedLine:" + receivedLine);
            }
            if ((sentLine = brSent.readLine()) != null) {
                textSent = sentLine;
//                Log.e("sentLine*****", "sentLine:" + sentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
//            Log.e("IOException*****", e.toString());
        }
//        Log.e("BytesManualEnd*****", "localUid:" + localUid);
        return Long.valueOf(textReceived).longValue() + Long.valueOf(textSent).longValue();
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []nums = {1,12,-5,-6,50,3};
		int []nums2 = {2, 2};
		
		
		System.out.println(findMaxAverage(nums,4));
		
		//intersection(nums1,nums2);

	}

}
