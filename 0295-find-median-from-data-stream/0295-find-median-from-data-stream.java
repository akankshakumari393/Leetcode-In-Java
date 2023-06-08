class MedianFinder {

    PriorityQueue<Integer> min ;
    PriorityQueue<Integer> max ;
    
    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // if num is less than top of max heap put it in max heap
        if(max.isEmpty() || max.peek() >= num){
            max.add(num);
        }
        else{
            min.add(num);
        }
        if(max.size() > min.size()+1){
            min.add(max.poll());
        }
        else if(max.size() < min.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            return (max.peek()/2.0) + (min.peek()/2.0);
        }
        else return max.peek(); // max heap may contain one extra element
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}