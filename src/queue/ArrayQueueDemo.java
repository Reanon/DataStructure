/**
 * Copyright (C), 2019-2020, 人生无限公司
 * FileName: ArrayQueue
 * Description: 使用数组来模拟队列
 *
 * @created: 2020/3/2 21:34
 * @author reanon
 * @version 1.0.0
 */

package queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

//数组模拟队列-编写一个ArrayQueue类

class ArrayQueue {

    //
    /**
     * maxSize:表示数组的最大容量s
     * fornt:队列头
     * rear:队列尾
     * arr:用于存放数组，模拟队列
     */
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        /**
         *  创建队列的构造器
         */
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部，指向队列头的前一个位置
        front = -1;
        //指向队列尾部，指向队尾的数据（就是队列的最后一个数据）
        rear = -1;
    }
    public boolean isFull(){
        /**
         * 判断队列是否满
         */
        return rear == maxSize -1;
    }
    public boolean isEmpty(){
        /**
         * 判读队列是否为空
         */
        return rear == front;
    }

}