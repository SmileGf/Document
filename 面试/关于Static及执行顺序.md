#### 关于static 及执行顺序:

```java
/**

- static关键字的用途： 方便在没有创建对象的情况下进行调用(方法/变量)。
  *

- 被static关键字修饰的方法或者变量不需要依赖于对象来进行访问，只要类被加载了，就可以通过类名去进行访问。
  *

- static可以用来修饰类的成员方法、类的成员变量，另外也可以编写static代码块来优化程序性能
  *

- static成员变量初始化顺序按照定义的顺序来进行初始化
  *

- 静态初始化块可以置于类中的任何地方，类中可以有多个静态初始化块。

- 在类初次被加载时，会按照静态初始化块的顺序来执行每个块，并且只会执行一次。
  *

- @author gf

- @date 2021/7/20
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
```

```java
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
```

```java
/**
 * static 执行顺序
 *
 * 找到main方法入口，main方法是程序入口，但在执行main方法之前，要先加载 StaticTest2 类
 *
 * 加载 StaticTest2 类的时候，发现 StaticTest2 类有static块，而是先执行static块，输出test static结果
 *
 * 然后执行new MyClass(),执行此代码之前，先加载MyClass类，发现MyClass类继承 StaticTest2 类，而是要先加载 StaticTest2 类，StaticTest2 类之前已加载
 *
 * 加载MyClass类，发现MyClass类有static块，而是先执行static块，输出myclass static结果
 *
 * 然后调用MyClass类的构造器生成对象，在生成对象前，需要先初始化父类 StaticTest2的成员变量，而是执行Person person = new Person("Test")代码，发现Person类没有加载
 *
 * 加载Person类，发现Person类有static块，而是先执行static块，输出person static结果
 *
 * 接着执行Person构造器，输出person Test结果
 *
 * 然后调用父类 StaticTest2构造器，输出test constructor结果，这样就完成了父类StaticTest2的初始化了
 *
 * 再初始化MyClass类成员变量，执行Person构造器，输出person MyClass结果
 *
 * 最后调用MyClass类构造器，输出myclass constructor结果，这样就完成了MyClass类的初始化了
 *
 * @author gf
 * @date 2021/7/20
 */
public class StaticTest2 {

    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }

    public StaticTest2() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class Person{
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}


class MyClass extends StaticTest2 {
    Person person = new Person("MyClass");
    static{
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}

```

