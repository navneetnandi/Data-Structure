class MaxStack {
    
    Stack<Integer> s;
    int max = Integer.MIN_VALUE;
    
    /** initialize your data structure here. */
    public MaxStack() {
        s = new Stack<Integer>();
    }
    
    public void push(int x) {
        
        //While pushing elements into the stack keep track of the maximum element you push
        
        if(x > max){
            s.push(x);
            max = x;
        }
        else
            s.push(x);
    }
    
    public int pop() {
        
        int n = s.pop();
        
        //If the popped number from the stack is the maximum we need to find the next maximum number in the stack
        if(n == max){
            //Find new minimum in the existing stack
            int maximum = Integer.MIN_VALUE;
            for(int i: s){
                if(i > maximum)
                    maximum = i;
            }
            max = maximum;
        }
        return n;
    }
    
    public int top() {
        
        return(s.peek());
    }
    
    public int peekMax() {
        
        return max;
    }
    
    public int popMax() {
        
        Stack<Integer> temp = new Stack<Integer>();
        int retVal = 0;
        
        //Pop elements from the stack till you encounter 'max'. Store them in temp and then put them back into the stack
        while(!s.isEmpty()){
          
            if(s.peek() == max){
                retVal = s.pop();
                break;
            }
            else
                temp.push(s.pop());
        }
        
        //Add the elements in temp back to the stack
        while(!temp.isEmpty()){
                s.push(temp.pop());
        }
        
        //Find new max in the stack
        int maximum = Integer.MIN_VALUE;
        for(int i: s){
            if(i > maximum)
                maximum = i;
        }
        max = maximum;
        
        return retVal;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */