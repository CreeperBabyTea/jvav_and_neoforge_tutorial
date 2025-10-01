package tutorial.oop.special;

public enum EnumDemo {  //enum类型
    A,  //枚举项直接使用逗号分隔。枚举项就是枚举类的实例
    B,
    C;  //最后一项枚举，以分号结束

    // public EnumDemo() {}  错误，枚举构造器都默认隐式地被private修饰，这里相当于重复的访问限制修饰符。
    //因此，枚举类的实例仅有其枚举项，而不能创建这之外的任何实例

    public static void main(String[] args) {
        System.out.println(EnumDemo.A.name());  //枚举类特有的隐式实例方法
        System.out.println(EnumDemo.valueOf("A"));  //枚举类特有的隐式静态方法
    }
}

// class BadInheritance extends EnumDemo {/* ... */}  错误，不允许继承。关于继承，见第六节内容。