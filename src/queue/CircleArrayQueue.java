/**
 * Copyright (C), 2019-2020, 人生无限公司
 * FileName: CircleArrayQueue
 * Description: 环形的数组队列
 *
 * @created: 2020/3/3 21:41
 * @author reanon
 * @version 1.0.0
 */

package queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        //创建一个队列
        CircleArray circleQueue;
        //这里最大空间设置为4，但是有效数据为3，需要空出一格
        circleQueue = new CircleArray(4);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        System.out.println("测试环形队列：");
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
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("输入一个数：");
                    int value = scanner.nextInt();
                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    try
                    {
                        int res = circleQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res =circleQueue.headQueue();
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


class CircleArray {
    /**
     * 模拟环形队列，预留一格方便管理
     * maxSize:表示数组的最大容量s
     * fornt:队列头,指向队列的第一个元素
     * rear:队列尾，指向队列的最后一个元素的后一个位置
     * arr:用于存放数组，模拟队列
     */
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        /**
         *  创建队列的构造器
         */
        maxSize = arrMaxSize;
        //创建环形队列
        arr = new int[maxSize];
        //指向队列头部，指向队列头
        front = 0;
        //指向队列尾部的后一个位置
        rear = 0;
    }

    public boolean isFull() {
        /**
         * 判断队列是否满
         */
        return (rear + 1) % maxSize == front;
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
        //因为rear指向最后元素的后一个位置，所以直接加入
        arr[rear] = n;
        //讲rear后移，需要考虑取模
        rear = (rear + 1) % maxSize;
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
        //先把front的值保存下来，再后移front指针（后移考虑取模），再返回值
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        /**
         * 显示队列的所有数据
         */
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        //
        int length = size();
        //从front开始遍历，遍历环形元素的个数
        for (int i = front,j =0; i < front + length; i++) {
            //对元素下标取个模
            j=i%maxSize;
            System.out.printf("arr[%d] = %d\n", j, arr[j]);
        }
    }
    public int size() {
        /**
         * 求出当前队列的有效元素个数
         */
        return (rear - front + maxSize) % maxSize;
    }
    public int headQueue() {
        /**
         * 显示队列的头数据，不是取出数据
         */
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //front指向队列的第一个元素
        return arr[front];
    }
}