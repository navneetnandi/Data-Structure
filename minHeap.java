//Inspired by the tutorial on Min Heap by Gayle Laakmann

import java.io.*;
import java.util.*;

public class MinHeap {
	
	private int capacity = 30;
	private int size = 0;	
	int[] items = new int[capacity];
	
	//Helper Methods for checking parent/child index and getting elements from them
	public int getLeftChildIndex(int parentIndex){
		int leftChildIndex = (2 * parentIndex) + 1;
		return(leftChildIndex);
	}
	
	public int getRightChildIndex(int parentIndex){
		int rightChildIndex = (2 * parentIndex) + 2;
		return(rightChildIndex);
	}

	public int getParentIndex(int childIndex){
		int parentIndex = (childIndex - 1) / 2;
		return(parentIndex);
	}
	
	boolean hasLeftChild(int index){ return (getLeftChildIndex(index) < size); }
	boolean hasRightChild(int index){ return (getRightChildIndex(index) < size); }
	boolean hasParent(int index){ return(getParentIndex(index) >= 0); }
	
	int leftChild(int index){
		return(items[getLeftChildIndex(index)]);
	}
	
	int rightChild(int index){
		return(items[getRightChildIndex(index)]);
	}
	
	int parent(int index){
		return(items[getParentIndex(index)]);
	}
	
	//Additional helper method to perform swap
	void swap(int indexOne, int indexTwo){
		
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	/*Ensuring enough space in our items[] array
	 * if not we copy contents into bigger array
 	 *
	 * This is how an ArrayList is implemented. So take note
	 */
	void ensureExtraCapacity(){
		if(size == capacity){
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	//Now comes the real implementation
	public int peek(){
		if(size == 0) throw new IllegalStateException();
		return(items[0]); //Returns root of the heap, ie. the minimum element
	}
	
	public int poll(){
		if(size == 0) throw new IllegalStateException();
		
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return(item);
	}
	
	public void add(int item){
		ensureExtraCapacity();
		
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	public void heapifyUp(){
		int index = size - 1; //The very last element added
		//Need to continue till there is a parent and things are out of order
		while(hasParent(index) && parent(index) > items[index]){
			
			swap(getParentIndex(index), index);
			index = getParentIndex(index); //Walking upwards
		}
	}
	
	public void heapifyDown(){
		int index = 0;
		//Only need to check leftChild coz it that is not there, a rightChild is also absent
		while(hasLeftChild(index)){
			
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index) < leftChild(index)){
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(items[index] < items[smallerChildIndex])
				break;
			else
				swap(index, smallerChildIndex);
			
			index = smallerChildIndex;
		}
	}
	public static void main(String[] args) {
		
		MinHeap m = new MinHeap();
		m.add(10); m.add(5); m.add(15); m.add(17); m.add(25);
		int p = m.poll();
		for(int i = 0; i<m.size; i++)
			System.out.print(m.items[i] + " ");
		
	}

}