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

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue queue;
        queue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        System.out.println("测试队列：");
        //输出一个菜单
        while (loop)
        {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key)
            {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.print("输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try
                    {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res =queue.headQueue();
                        System.out.printf("队列头的数据是%d",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
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

    public boolean isFull() {
        /**
         * 判断队列是否满
         */
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        /**
         * 判读队列是否为空
         */
        return rear == front;
    }

    public void addQueue(int n) {
        /**
         * 添加数据到队列
         */
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据。");
            return;
        }
        //数据后移
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        /**
         * 获取队列的数据，出队列
         */
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常来处理
            throw new RuntimeException("队列为空，不能取数据");
        }
        //队列头后移
        front++;
        return arr[front];
    }

    public void showQueue() {
        /**
         * 显示队列的所有数据
         */
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    public int headQueue() {
        /**
         * 显示队列的头数据，不是取出数据
         */
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}