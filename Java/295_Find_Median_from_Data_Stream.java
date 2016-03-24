import java.util.PriorityQueue;
public class MedianFinder {
    // 对称堆技巧求中位数
    private PriorityQueue<Integer> maxTop;// 注意取相反值模拟大顶堆
    private PriorityQueue<Integer> minTop;// 默认就是小顶堆
    public MedianFinder(){
        maxTop = new PriorityQueue<>();
        minTop = new PriorityQueue<>();
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(maxTop.size()==0){
            maxTop.offer(-num);
        }else if(minTop.size()==0){
            if(-maxTop.peek()>num){
                minTop.offer(-maxTop.poll());
                maxTop.offer(-num);
            }else{
                minTop.offer(num);
            }
        }else{
            if(maxTop.size()==minTop.size()){
                if(minTop.peek()<num){
                    maxTop.offer(-minTop.poll());
                    minTop.offer(num);
                }else{
                    maxTop.offer(-num);
                }
            }else{
                if(-maxTop.peek()>num){
                    minTop.offer(-maxTop.poll());
                    maxTop.offer(-num);
                }else{
                    minTop.offer(num);
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int ret;
        if(maxTop.size()==minTop.size()){
            if(maxTop.size()!=0){
                return (-maxTop.peek()+minTop.peek())/2.0;
            }else{
                return 0;
            }
        }else{
            return -maxTop.peek();
        }
    }
    
    public static void main(String[] argv){
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
                mf.addNum(2);
        System.out.println(mf.findMedian());
                mf.addNum(3);
        System.out.println(mf.findMedian());
                mf.addNum(4);
        System.out.println(mf.findMedian());       
        mf.addNum(5);
        System.out.println(mf.findMedian());
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();