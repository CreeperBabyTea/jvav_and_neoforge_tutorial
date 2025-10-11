# OOP的高级特征

学习目标：掌握封装、继承、多态三大特征  
内容要点：

- 封装
    - private关键字、setter和getter
- 继承
    - extends关键字、super关键字
- 多态
    - 向上转型、向下转型
    - instanceof关键字
    - 方法重写
    - final关键字

## 封装

对于我们上一节用到的[Cat](../src/tutorial/oop/basic/Cat.java)类，我们有一个`public int weight;`
字段。因为其他的类可能需要访问这个字段，所以我们可以设置其访问控制修饰符为`public`。

但是，这就引申出一个问题：  
如果说存在一个恶意插件，那么它完全可以修改任何一个Cat对象的weight，因为weight是public且非final的，而你的程序对此一无所知  
对此，我们的解决方案就是**封装**。

封装，简单来说，就是当你有一个变量，需要一定的公开性，但是又不能允许外部随意更改时，采用的一系列设计思路。
封装的做法是：

1. 将你要封装的字段设为private
2. 按需要创建setter和getter方法

setter和getter方法，就是专门用于访问你封装的字段的方法。常见的封装例子如下：

```java
private int value;

public void setValue(int value) {
    this.value = value;
}

public int getValue() {
    return value;
}
```

清晰易懂，无需多言。

哦对了，对于boolean类型的getter往往采用is来命名，如

```java
private boolean afk;

public boolean isAfk() {
    return afk;
}
```

setter和getter中你可以添加额外的逻辑，这当然取决于你喜欢怎么做。同时setter和getter也不一定同时出现，而是你需要就写。比如在这里，我们可以检测weight为正：

```java
private int weight;

public void setWeight(int weight) {
    if (weight > 0)
        this.weight = weight;
}

/* 自己写getter去 */
```

同样的道理，对于age，你也可以直接不提供setter方法，而是提供一个方法age()，使其年龄自增。这里留给读者完成

现在，你可以把Cat类改写了成[EncapsulatedCat](../src/tutorial/oop/advanced/encapsulation/EncapsulatedCat.java)

## 继承

现在我们在EncapsulatedCat的基础上，又发现了一种新的动物：Dog。  
我们当然可以写一个这样的类来处理Dog：

```java
public class Dog {
    private final String name;
    /**
     * unit: kg
     */
    public int weight = 2;
    /**
     * unit: year
     */
    public int age = 3;

    public Dog(String name) {
        this.name = name;
        System.out.println("Constructor!");
    }

    public Dog() {
        this("wild");
    }

    public String voice() {
        return name + " barked: woof!!!";
    }

    public void setWeight(int weight) {
        if (weight > 0)
            this.weight = weight;
    }

    public void age() {
        this.age++;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }
}
```

但是这很唐，Dog和Cat的类高度相似，因此我我们可以利用**继承**来实现方法的复用。

首先，我们提取Dog和Cat相同的非静态部分：(这里把一些没必要的输出给毙了)

[代码](../src/tutorial/oop/advanced/inheritance/Animal.java)

```java
public class Animal {
    private final String name;
    /**
     * unit: kg
     */
    public int weight;
    /**
     * unit: year
     */
    public int age = 3;

    public Animal(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void age() {
        this.age++;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
```

然后，我们令Cat和Dog分别继承Animal(这里仅提供Cat，Dog你可以试着自己完成)：

[代码](../src/tutorial/oop/advanced/inheritance/Cat.java)

```java
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}
```

这里我们注意到了两个新的关键字：extends和super。extends就是标志这个类继承自extends后面的的类。java仅允许单继承，即一个类只能继承一个父类。

super关键字即父类指代关键字。子类的构造器在调用时，必须先调用父类构造器。对，就是super(你要的参数)。
如果父类有一个可以访问(也就是说，在你子类的访问范围内)的一个或几个构造器，那么在子类的**每个**构造器中都必须调用**一个**
父类构造器。

特别的，如果父类有可访问的、无形参的构造器，可以隐去`super();`(会自动调用)；如果父类无可用构造器，则无法继承。

**特别的，枚举类和记录类都不允许继承**

## 多态

累死我了，这一节内容怎么这么多，不会要打破第三节的行数记录了吧zzz

如果我们现在又需要建一个Shelter来收容动物，但是不考虑其具体是什么动物，该怎么办呢？

这里我们可以利用**多态**。

### 向上转型

```java
public static void host(Animal animal) {
    /* ... */
}
```

因为Cat和Dog都继承自Animal，所以这两者的类型也可以用作Animal。这个方法，我们既可以传入Cat，又可以传入Dog。

这也就是说，Cat值可以直接赋给一个Animal类型的变量，如下语句完全正确：  
`Animal animal = new Cat("Akami Karubi")`

这种多态行为称为**向上转型**，即允许子类型自动转为父类型。

### 向下转型

现在我们有一个Cat对象，但是由于我们储存时进行了向上转型，现在这个对象储存在一个类型为Animal的容器中。那么，如果我们需要将其变回Cat，可以直接强制转型：  
`Cat cat = (Cat) animal;`

这种转型叫做**向下转型**。向上转型和向下转型即多态。

但是，你肯定也会想到，万一其他语境下，我们不知道Animal对象的确切类型，该怎么办呢？

### instanceof

如果说你运行下面的代码，程序会报异常(反正就是运行不了了，异常是什么后面讲)：

```java
Animal animal = new Dog("Mamehinata");
Cat cat = (Cat) animal;
```

其实在大多数情况下，我们利用多态时完全不知道对象的具体类型。在程序体量大的情况下，复杂的继承树会导致，对于越接近根类型的多态操作，其对象类型越模糊未知。

所以我们在强制转型时，如果类型不确定，则应当进行判断。这里的运算符就是instanceof。语法如下：  
`变量 instanceof 类型`。  
这个语句返回一个布尔值，代表"变量"是否属于"类型"。

同时，instanceof允许辅助声明模式变量，即：  
`变量 instanceof 类型 模式变量名`  
这里返回值不变，但是相当于同时声明了一个"类型"类型的模式变量。

比如你可以这么搞：

```java
public void detectType(Animal animal) {
    if (animal instanceof Cat cat)
        System.out.println("Cat name: " + cat.getName());
    if (animal instanceof Dog dog)
        System.out.println("Dog weight: " + dog.getWeight());
}
```

### 方法重写

我们现在为Animal类添加一个onHungry()方法。这里我们希望Cat和Dog的onHungry()实现一些不同的行为，此时我们可以重写这个方法。

在Cat中：
```java
@Override
public void onHungry() {
    System.out.println("Hunting!");
}
```

在Dog中：
```java 
@Override
public void onHungry() {
    System.out.println("Finding my master!");
}
```

这里我们重写了这个方法。当我们调用一个对象的实例方法时，我们调用的时其**最顶层类型的方法**。比如下面这段代码：

```
Animal animal = new Cat("Nekoha Shizuku");
animal.onHungry();
```

你会看到被执行的方法实际上是Cat类重写后的方法。这也就是说，对象在被向上转型时，其类型不会被丢弃。
无论我们怎么进行转型，Cat的实例永远是Cat的对象。

同时，如果你需要调用父类的方法，也可以使用super关键字，如：

```java
@Override
public void onHungry() {
    super.onHungry();
    System.out.println("Finding my master!");
}
```

需要注意的是，如果存在多级继承，那这种调用只能调用上一级父类，而不能调用父类的父类的方法。如果遇到了这种问题，可以采用方法委托来实现。

### final关键字

现在我们再介绍final关键字的另外两个用途：
1. 修饰类时，使这个类不可以被继承
2. 修饰方法时，使这个方法不可以被重写

这很简单，我就不多说了zzz

[返回](../大纲.md)