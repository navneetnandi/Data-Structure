class MedianFinder {
    
    private PriorityQueue<Integer> small ; //This is the Max Heap
    private PriorityQueue<Integer> large ; //This is the Min Heap
    

    /** initialize your data structure here. */
    public MedianFinder() {
         small = new PriorityQueue<Integer>(Collections.reverseOrder());
         large = new PriorityQueue<Integer>();
       
    }
    
    public void addNum(int num) {
        
        if (large.size() == 0 && small.size() == 0) {
            small.add(num);
        } 
        else if (num < small.peek()) {
            small.add(num);
        }
        else {
            large.add(num);
        }
        
        //Balancing the two heaps
        int sizeDiff = small.size() - large.size();
        if(sizeDiff > 1)
            large.add(small.poll());
        if(sizeDiff < -1)
            small.add(large.poll());
       
    }
    
 
    public double findMedian() {
        
        int sizeDiff = small.size() - large.size();
        
        if(sizeDiff == 0){
            double a = large.peek() + small.peek();
            return(a/2);
        }
        else if(sizeDiff > 0)
            return((double)small.peek());
        else
            return((double)large.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */