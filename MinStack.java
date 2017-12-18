//We need to return the minimum element in constant time, ie. keep a track of the minimum number at every step
//This can be done using one or two stacks

class MinStack {
    
    Stack<Integer> s;
    int min = Integer.MAX_VALUE;
    
    
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<Integer>();
    }
    
    public void push(int x) {
        
        //While pushing elements into the stack keep track of the minimum element you push
        
        if(x < min){
            s.push(x);
            min = x;
        }
        else
            s.push(x);
    }
    
    //pop() will remove the top element from the stack
    public void pop() {
        
        int n = s.pop();
        
        //If the popped number from the stack is the minimum we need to find the next minimum number in the stack
        if(n == min){
            //Find new minimum in the existing stack
            int minimum = Integer.MAX_VALUE;
            for(int i: s){
                if(i<minimum)
                    minimum = i;
            }
            min = minimum;
        }
    }
    
    //top() will only view the element at the top of the stack without removing it
    public int top() {
        
        return(s.peek());
    }
    
    public int getMin() {
        
        return(min);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */