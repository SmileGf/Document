package com.iiaccount;
/**
 * static关键字的用途： 方便在没有创建对象的情况下进行调用(方法/变量)。
 *
 * 被static关键字修饰的方法或者变量不需要依赖于对象来进行访问，只要类被加载了，就可以通过类名去进行访问。
 *
 * static可以用来修饰类的成员方法、类的成员变量，另外也可以编写static代码块来优化程序性能
 *
 * static成员变量初始化顺序按照定义的顺序来进行初始化
 *
 * 静态初始化块可以置于类中的任何地方，类中可以有多个静态初始化块。
 * 在类初次被加载时，会按照静态初始化块的顺序来执行每个块，并且只会执行一次。
 *
 * @author gf
 * @date 2021/7/20
 */
public class StaticMainTest {

    static{
        System.out.println("test static 1");
    }
    public static void main(String[] args) {

    }

    static{
        System.out.println("test static 2");
    }

}
