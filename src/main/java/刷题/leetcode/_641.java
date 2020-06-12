package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/5 9:56
 */
public class _641 {
    private class MyCircularDeque {
        int[] queue;
        int head;
        int rear;
        int maxIndex;
        int amount=0;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            queue=new int[k+1];
            head=0;
            rear=0;
            maxIndex=k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(amount==maxIndex)
                return false;
            else if(head+1<=maxIndex){
                head++;
                queue[head]=value;
            }else if(head==maxIndex){
                head++;
                head=0;
                queue[head]=value;
            }
            amount++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(amount==maxIndex)
                return false;
            else if(rear>0){
                queue[rear--]=value;
            }else if(rear==0){
                queue[rear]=value;
                rear=maxIndex;
            }
            amount++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(amount==0) return false;
            if(head==0){
                head=maxIndex;
            }else if(head!=0){
                head--;
            }
            amount--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(amount==0) return false;
            if(rear==maxIndex){
                rear=0;
            }else if(rear!=maxIndex){
                rear++;
            }
            amount--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(amount==0) return -1;
            return queue[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(amount==0) return -1;
            if(rear==maxIndex) return queue[0];
            else{
                return queue[rear+1];
            }
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            if(amount==0) return true;
            else return false;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            if(amount==maxIndex) return true;
            else return false;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
