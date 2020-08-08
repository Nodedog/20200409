import java.lang.reflect.Field;





/*
*
*
*                          String 类  1
*
*
* */
public class Testdemo {

    public static void main(String[] args) {
     /*   byte[] 是把 String 按照一个字节一个字节的方式处理, 这种适合在网络传输, 数据存储这样的场景下使用.
          更适合针对二进制数据来操作.
           char[] 是吧 String 按照一个字符一个字符的方式处理, 更适合针对文本数据来操作, 尤其是包含中文的时候*/
        String str = "helloworld" ;
        // String 转 byte[]
        byte[] data = str.getBytes() ;
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println("======================");
        // byte[] 转 String
        System.out.println(new String(data));

    }



    public static void main3(String[] args) {
        //字符与字符串
        //获取指定位置的字符
        String str = "hello" ;
        System.out.println(str.charAt(0)); // 下标从 0 开始
        // 执行结果

        //System.out.println(str.charAt(10));
        //抛出StringIndexOutOfBoundsException 异常



        //字符串与字符数组的转换
        String str2 = "helloworld" ;
        // 将字符串变为字符数组
        char[] data = str2.toCharArray() ;
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println("=============");
        // 字符数组转为字符串
        System.out.println(new String(data)); // 全部转换
        System.out.println(new String(data,5,5));
    }



    public static void main2(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //改变 字符串 值（反射）
        String str1 = "hehe";


        //需要根据“value” 这个名字 找到Str中内部存储的value数组
        //1.获取到String对象的图纸
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);


        //2.根据图纸找到str 里面的value数组
        char[] value = (char[])field.get(str1);


        //3.然后再修改这个数组内容即可
        value[0] = 'b';
        System.out.println(str1);




        //第二种 修改 字符串的值 的 方法
        String str2 = "hello";
        str2 = "B" + str2.substring(1);
        System.out.println(str2);

    }




    public static void main1(String[] args) {
        //第一种方式
        String str1 = "hello!";
        //第二种方式
        String str2 = new String("hello world!");
        //第三种方式
        char[] array = {'a','b','c'};
        String str3 = new String(array);

        String str4 = new String("hello!");
        String str5 = "hello!";


        //两个“hello！” 是一个地址 只是str1 和 str5 两个引用
        System.out.println(str1 == str5);
        System.out.println(str1.equals(str5));



        //比较引用的地址是否相等
        System.out.println(str1 == str4);

        //比较内容（值）是否相等
        System.out.println(str1.equals(str4));



        // 重要考点
        //如果str1 为null则 运行第一个 sout会空指针异常
        //System.out.println(str1.equals("hello!"));
        System.out.println("hello!".equals(str1));//更推荐这种


        System.out.println("==============");

        //intern方法可以主动去池子中查找，看看当前这个String 是否在池中存在
        //如果池中不存在，就把这个String加入到池中
        //如果存在，就可以舍弃当前对象，直接获取到池中的对应对象的引用
        String str6 = new String("hello!").intern();
        System.out.println(str1 == str6);
    }
}
