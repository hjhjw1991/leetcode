class MinStack {
    	private Stack<Integer> data=new Stack();
    	private Stack<Integer> min=new Stack();
    	
        public void push(int x) {
        	data.push(x);
        	if(min.size()<=0)
        		min.push(x);
        	else if(x<=getMin()){
        		min.push(x);
        	}
        }

        public void pop() {
        	int x=data.pop();
        	if(x==min.lastElement())
        		min.pop();
        }

        public int top() {
            return data.lastElement();
        }

        public int getMin() {
            return min.lastElement();
        }
}
