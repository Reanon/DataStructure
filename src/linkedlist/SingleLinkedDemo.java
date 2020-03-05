/**
 * Copyright (C), 2019-2020, 人生无限公司
 * FileName: SingleLinked
 * Description: 单链表的创建和遍历的分析实现
 *
 * @created: 2020/3/4 10:15
 * @author reanon
 * @version 1.0.0
 */

package linkedlist;

public class SingleLinkedDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        //测试add，按照编号加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);


        // 测试addByOrder,不按照编号加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        //显示一下链表
        singleLinkedList.list();
    }
}

class SingleLinkedList {
    /**
     * 定义SingleLinkedList,来管理我们的英雄人物
     * head:先初始化一个头结点，头结点不要动
     */

    private HeroNode head = new HeroNode(0, "", "");

    public void addByOrder(HeroNode heroNode) {
        /**
         * 第二种方式添加节点，根据排名（no)将英雄插入到指定的位置
         * 因为头节点不能动，所以通过一个辅助指针（变量）来找到位置
         * 而且因为是单链表，所以需要找到要加入位置的前一个节点
         */
        HeroNode temp = head;
        //标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            //当temp已经在链表的最后时
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                //希望添加的heroNode已经存在，说明编号存在
                flag = true;
            }
            //后移，遍历当前的链表
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备插入的英雄编号%d已经存在，不能添加。\n ",heroNode.no);
        }else{
            //插入到链表中，temp的后面
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    public void add(HeroNode heroNode) {
        /**
         * 当不考虑编号的顺序时
         * 1、找到当前列表的最后一个节点
         * 2、将最后的节点的next指向新的节点
         * 因为head不能移动，所以我们需要一个辅助遍历temp
         */
        HeroNode temp = head;
        //遍历链表，当while退出循环时，temp 也就指向了最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void list() {
        /**
         * 显示链表
         */
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！！！");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }
}

class HeroNode {
    /**
     * 定义HeroNode,每一个HeroNode对象就是一个节点
     */
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        /**
         * 构造器
         */
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        /**
         * 为了显示方法，我们重写toString
         */
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\''+'}';
    }
}