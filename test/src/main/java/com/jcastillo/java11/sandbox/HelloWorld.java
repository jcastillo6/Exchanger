package com.jcastillo.java11.sandbox;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class HelloWorld {


	/**
	 * This method allows to sort an array like a wave, example input [1, 2, 6, 19, 12, 3, 1]
	 * the ouput shoud be  [19, 1, 12, 1, 6, 2, 3]
	 * @param array
	 * @return
	 */
	public  static int[] waveOrder(int[] array ) {
		Arrays.sort(array);
		int[] result = new int[array.length];
		int i=array.length-1;
		int j =0;
		int z=0;	
		while(j<i) {
			result[z]=array[i];
			result[z+1]=array[j];
			i--;
			j++;
			z+=2;
		}
		if(array.length%2!=0) {
			result[array.length-1]=array[(int)(array.length/2)];
		}
		
		return result;
	
	}

	


	/**
	 * this method solve the problem of the less steps required to change a time to another, you cant go backwards
	 * @param time current time format should by 10:00
	 * @param timeToSet time to set for example 23:59
	 * @return steps 
	 */
	public static int steps(String time,String timeToSet) {
		String[] t1 = time.split(":");
		String[] tf = timeToSet.split(":");
		int t1h=Integer.parseInt(t1[0]);
		int t1s=Integer.parseInt(t1[1]);
		int tfh=Integer.parseInt(tf[0]);
		int tfs=Integer.parseInt(tf[1]);

		int hour=0;
		int steps=0;
		if(t1h==tfh&&t1s==tfs)
			return 0;
		
		
		if(tfs<t1s) {
			hour++;
			steps = 60+tfs-t1s;
		}
		else if(tfs>t1s) {
			steps=tfs-t1s;
		}
		
		if((tfh-hour)>t1h) {
			steps+=tfh+t1h-hour;
		}
		else if((tfh-hour)<t1h){
			steps+=24+tfh-t1h-hour;
		}
		
		return steps;
		
		
		
		
	}
	
	
	/**
	 * Heap of a list
	 * @param List of integer number
	 * @return 
	 */
	public static int medium(List<Integer> l ) {
    	PriorityQueue<Integer> max = new PriorityQueue<Integer>();
    	PriorityQueue<Integer> min= new PriorityQueue<Integer>(Collections.reverseOrder());
		
    	max.offer(l.get(0));
    	for(int i=1;i<l.size();i++) {
    		
    		if(max.size()>0&&max.peek()<l.get(i)) {
    			max.offer(l.get(i));
    		}
    		if(min.size()>0&&min.peek()>l.get(i)) {
    			min.offer(l.get(i));
    		}
    		
    		if(min.size()>max.size()) {
    			max.offer(min.poll());
    		}
    		else if(max.size()>min.size()) {
    			min.offer(max.poll());
    		}
    		
    	}
    	
    	System.out.println(min);
    	IntStream.range(0,min.size()).forEach((x)->{System.out.println(min.poll());});
    	System.out.println(max);
    	IntStream.range(0,max.size()).forEach((x)->{System.out.println(max.poll());});
    	
    	return 0;
		
		
	}
	
	public static void mergeSort(int[] array, int length) {
		if(length<2) {
			return; 
		}
		
		int mid= length/2;
		int[] l = Arrays.copyOfRange(array, 0, mid);
		int[] r = Arrays.copyOfRange(array, mid, length);
		
		mergeSort(l,mid);
		mergeSort(r,length-mid);
		
		merge(array,l,r,mid,length-mid);
			
	}

	
	
	
	
    private static void merge(int[] array, int[] l, int[] r, int left, int right) {
		int i=0,j=0,z=0;
		
		while(i<left && j<right) {
			if(l[i]<=r[j]) {
				array[z++]=l[i++];
				
			}else {
				array[z++]=r[j++];
			}
					
		}
		while(i < left) {
			array[z++]=l[i++];
			
		}
		while(j<right) {
			array[z++]=r[j++];
		}
		
	}




	public static void main(String... args) {
    	
    	//int[] array= new int [] {-1,2,0,3};
    	//System.out.println(Arrays.toString(waveOrder(array)));
    	
    	/*System.out.println(steps("23:30","0:10"));
    	System.out.println(steps("7:30","8:00"));

    	System.out.println( LocalTime.of(23, 30).plusMinutes(40));
    	  */	
    	   	
    	//medium(List.of(1,2,3,4,5,6,7,8,9));

    }
}
