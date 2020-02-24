public class Main {
    public static void main(String[] args){
        CircularQueue circularQueue = new CircularQueue(6); // set the size to be 3
        circularQueue.deQueue(); // return false
        circularQueue.Front(); // return -1
        circularQueue.enQueue(1);  // return true
        circularQueue.enQueue(2);  // return true
        circularQueue.enQueue(3);  // return true
        circularQueue.enQueue(4);  // return false, the queue is full
        circularQueue.Rear();  // return 3
        circularQueue.Front(); // return 1
        circularQueue.isFull();  // return true
        circularQueue.deQueue();  // return true
        circularQueue.enQueue(4);  // return true
        circularQueue.Rear();  // return 4
    }
}

class CircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int listSize;

    CircularQueue (int size){
        data = new int[size];
        head = tail = -1;
        listSize = size;
    }

    boolean isFull(){
        return ((tail + 1) % listSize) == head;
    }

    boolean isEmpty(){
        return head == -1;
    }

    boolean enQueue(int value){
        if(isFull()){
            return false;
        }else if (isEmpty()) {
            head++;
        }
        tail++;
        if(tail == listSize){
            tail = 0;
        }
        data[tail] = value;
        return true;
    }

    boolean deQueue(){
        if(isEmpty()){
            return false;
        }else if(head == tail){
            head = tail = -1;
            return true;
        }
        head++;
        if(head == listSize){
            head = 0;
        }
        return true;
    }

    int Front(){
        if(isEmpty()){
            return -1;
        }else{
            return data[head];
        }
    }

    int Rear(){
        if(isEmpty()){
            return -1;
        }else{
            return data[tail];
        }
    }
}
