# OOP的高级特征

学习目标：掌握封装、继承、多态三大特征  
内容要点：

- 封装
    - private关键字、setter和getter
- 继承
    - extends关键字、super关键字、方法重写
- 多态
    - 向上转型、向下转型、instanceof关键字
- final关键字

## 封装

对于我们上一节用到的[Cat](../src/tutorial/oop/basic/Cat.java)类，我们有一个`public String sound;`
字段。因为其他的类可能需要访问这个字段，所以我们可以设置其访问控制修饰符为`public`。  
但是，这就引申出一个问题：

如果说存在一个恶意插件，那么它完全可以修改任何一个Cat对象的sound，因为sound是public且非final的。  
对此，我们的解决方案就是**封装**。

封装，简单来说，就是当你有一个变量，需要一定的公开性，但是又不能允许外部随意更改时，采用的一系列设计思路。
封装的做法是：

1. 将你要封装的字段设为private
2. 按需要创建setter和getter方法

setter和getter方法，就是专门用于access(孩子们我想不到词了)你封装的字段的方法。常见的封装例子如下：

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

setter和getter中你可以添加额外的逻辑，这当然取决于你喜欢怎么做。同时setter和getter也不一定同时出现，而是你需要就写。

现在，你可以把Cat类改写了成[EncapsulatedCat](../src/tutorial/oop/advanced/encapsulation/EncapsulatedCat.java)

## 继承

现在我们在EncapsulatedCat的基础上，又发现了一种新的动物：Dog。  
我们当然可以写一个这样的类来处理Dog：

```java
package tutorial.oop.advanced.encapsulation;

import tutorial.oop.basic.Cat;
import tutorial.oop.basic.Shelter;

public class Dog {
    public static final String SPECIES = "dog";

    private final String name;
    private String sound = "woof";

    {
        System.out.println("Initializer Block!");
    }

    public Dog(String name) {
        this.name = name;
        System.out.println("Constructor!");
    }

    public Dog() {
        this("wild");
    }

    public String voice() {
        return name + ':' + sound;
    }

    public String getSound() {
        return sound;
    }
}
```

但是这不唐吗，Dog和Cat的类高度相似。因此我我们可以利用**继承**来实现方法的复用。

首先，我们提取Dog和Cat相同的非静态部分：(这里把一些没必要的输出给毙了)

[代码](../src/tutorial/oop/advanced/inheritance/Animal.java)

```java
package tutorial.oop.advanced.inheritance;

public class Animal {
    private final String name;
    private String sound;

    public Animal(String name) {
        this.name = name;
    }

    protected void setSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public String voice() {
        return name + ':' + sound;
    }
}
```

然后，我们令Cat和Dog分别继承Animal(这里仅提供Cat，Dog你可以试着自己完成)：

[代码](../src/tutorial/oop/advanced/inheritance/Cat.java)

```java
package tutorial.oop.advanced.inheritance;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        this.setSound("nya~");
    }
}
```

这里我们注意到了两个新的关键字：extends和super。extends就是标志这个类继承自extends后面的的类。java仅允许单继承，嗯

super关键字即父类指代关键字。子类的构造器在调用时，必须先调用父类构造器。对，就是super(你要的参数)。
如果父类有一个可以访问(也就是说，在你子类的访问范围内)的一个或几个构造器，那么在子类的**每个**构造器中都必须调用**一个**父类构造器。

特别的，如果父类有可访问的、无形参的构造器，可以隐去`super();`(会自动调用)；如果父类无可用构造器，则无法继承。

### 覆写

如果说，我们需要使Dog的voice