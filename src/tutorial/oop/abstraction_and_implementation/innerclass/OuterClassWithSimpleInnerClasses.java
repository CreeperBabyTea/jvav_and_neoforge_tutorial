package tutorial.oop.abstraction_and_implementation.innerclass;

public class OuterClassWithSimpleInnerClasses {
    private static final OuterClassWithSimpleInnerClasses INSTANCE = new OuterClassWithSimpleInnerClasses();

    private static String zzz = "zzz";
    private boolean afk = true;

    public static class StaticInnerClass {
        public StaticInnerClass() {
            System.out.println(zzz);   //可以访问外部类的私有成员
            //System.out.println(afk);   //不可直接访问外部类的实例字段
            System.out.println(INSTANCE.afk);   //正常通过实例访问实例字段
        }
    }

    public static void testStaticInnerClass() {
        System.out.println("Testing static inner class: ");
        new StaticInnerClass();   //与普通的类完全一致的行为
    }

    public class MemberInnerClass {
        public MemberInnerClass() {
            System.out.println(zzz);
            System.out.println(afk);   //可以访问其所属外部类对象的实例字段
        }
    }

    public static void testMemberInnerClass() {
        System.out.println("Testing member inner class: ");
         //new OuterClass.MemberInnerClass();   //不允许静态语境下创建实例
        var inner = INSTANCE.createInnerClassInstance();   //调用实例方法创建对象
    }

    private MemberInnerClass createInnerClassInstance() {
        return new MemberInnerClass();
    }

    public void testMemberLocalInnerClass() {
        System.out.println("Testing member local inner class: ");
        class LocalInnerClass {
            public LocalInnerClass() {
                System.out.println(afk);
            }
        }
        new LocalInnerClass();
    }

    public static void textStaticLocalInnerClass() {
        System.out.println("Testing static local inner class: ");
        class LocalInnerClass {
            public LocalInnerClass() {
                System.out.println(zzz);
            }
        }
        new LocalInnerClass();
    }
}
