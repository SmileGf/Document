package com.iiaccount;
/**
 * static  执行顺序
 *
 * 找到main方法入口，main方法是程序入口，但在执行main方法之前，要先加载 StaticTest1 类
 *
 * 加载 StaticTest1 类的时候，发现 StaticTest1 类继承Base类，于是先去加载Base类
 *
 * 加载Base类的时候，发现Base类有static块，而是先执行static块，输出base static结果
 *
 * Base类加载完成后，再去加载 StaticTest1 类，发现 StaticTest1 类也有static块，而是执行 StaticTest1 类中的static块，输出StaticTest1 static结果
 *
 * Base类和StaticTest1类加载完成后，然后执行main方法中的new StaticTest1()，调用子类构造器之前会先调用父类构造器
 *
 * 调用父类构造器，输出base constructor结果
 *
 * 然后再调用子类构造器，输出StaticTest1 constructor结果
 *
 * @author gf
 * @date 2021/7/20
 */
public class StaticTest1 extends Base {

    static{
        System.out.println("StaticTest1 static");
    }

    public StaticTest1(){
        System.out.println("StaticTest1 constructor");
    }

    public static void main(String[] args) {
        new StaticTest1();
    }
}
class Base{

    static{
        System.out.println("base static");
    }

    public Base(){
        System.out.println("base constructor");
    }
}