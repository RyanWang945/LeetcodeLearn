package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/5 11:18
 */
public class _622 {
    class MyCircularQueue {
        int[] queue;
        int front;
        int rear;
        int amount=0;
        int maxIndex;
        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            queue=new int[k+1];
            front=0;
            rear=0;
            maxIndex=k;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(amount==maxIndex) return false;
            if(rear==0){
                queue[0]=value;
                rear=maxIndex;
            }else{
                queue[rear--]=value;
            }
            amount++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(amount==0) return false;
            if(front==0) front=maxIndex;
            else front--;
            amount--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if(amount==0) return -1;
            return queue[front];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if(amount==0) return -1;
            if(rear==maxIndex)
                return queue[0];
            else return queue[rear+1];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return amount==0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return amount==maxIndex;
        }
    }
}
