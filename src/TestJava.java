import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestJava {
//    public TestJava() {
//        System.out.println(1);
//    }
//
//    public TestJava(Integer integer) {
//        System.out.println(2);
//    }

    static {
        System.out.println("a");
    }

    public static void b(){
        System.out.println("b");
    }

    public  static int calc(int x){
        if(x==0){
            return 1;
        }else {
            return x*calc(x-1);
        }
    }

    public static synchronized void main(String[] args) throws InterruptedException {
//        Runnable r = ()->System.out.println("1");
//        new Thread(r).start();
        System.out.println("c");
        b();
//        System.out.println(calc(5));
//        Thread t = new Thread();
//        t.start();
//        System.out.println(1);
//        t.wait(10000);
//        System.out.println(2);
//
//        // initializing int array
//        Integer[] ival = new Integer[] { 3, 5 };
//
//        // hashcode for value1
//        int retval = ival.hashCode();
//
//        // printing hash code value
//        System.out.println("The hash code of value1 is: " + retval);
//
//        // value2 for double array
//        Integer[] ival2=new Integer[] { 3, 5 };
//
//        // hashcode for value2
//        int retval2=ival2.hashCode();
//
//        // printing hash code value
//        System.out.println("The hash code of value2 is: " + retval2);
//
//        System.out.println(Arrays.hashCode(ival));
//        System.out.println(Arrays.hashCode(ival2));
//
//        Set<Integer[]> set = new HashSet<>();
//        set.add(ival);
//        set.add(ival2);
//
//        System.out.println("set size:"+set.size());
//
//
//        ival2=new Integer[] { 3, 5 };
//        System.out.println(Arrays.hashCode(ival2));
//        ival2=new Integer[] { 1, 5 };
//        System.out.println(Arrays.hashCode(ival2));
//        ival2=new Integer[] { 2, 5 };
//        System.out.println(Arrays.hashCode(ival2));
//        ival2=new Integer[] { 4, 5 };
//        System.out.println(Arrays.hashCode(ival2));
//        ival2=new Integer[] { 6, 5 };
//        System.out.println(Arrays.hashCode(ival2));
//        ival2=new Integer[] { 0, 5 };
//        System.out.println(Arrays.hashCode(ival2));

//        System.out.println(-1%4);
//        System.out.println(1%4);
//
//        for (int i = 0, j = 0; i < 10; i++, j--) {
////            System.out.print(i);
//            System.out.print(j);
//        }
////        new TestJava();
//        System.out.println();
//        System.out.println(Objects.hash(1, 2));
//        System.out.println(Objects.hash(2, 1));
//        System.out.println(-3 % 7);
//        System.out.println(-10 % 7);
//        System.out.println("flower".indexOf("flow1"));
//        System.out.println("flower".substring(0, 2));
//        System.out.println("flower");


//        String paragraph = "Bob. hIt, baLl";
//        paragraph = paragraph.replaceAll("[ !?',;.]+"," ").toLowerCase();
//        String[] parray = paragraph.split(" ");
//        System.out.println(parray.length);
//        System.out.println(Arrays.toString(parray));
//
//
//        String s1 = paragraph.replaceAll("[!?',;.]"," ");
//        System.out.println(s1);
//
//        long startTimea=System.nanoTime();   //获取开始时间
//        int[] astorage = new int[1000000];
//        long endTimea=System.nanoTime(); //获取结束时间
//        System.out.println("程序运行时间1： "+(endTimea-startTimea)+"ns");
//        long startTime=System.nanoTime();   //获取开始时间
//        Integer[] storage = new Integer[1000000];
//        long endTime=System.nanoTime(); //获取结束时间
//        System.out.println("程序运行时间1： "+(endTime-startTime)+"ns");
//
//
//
//
//
//
//        long startTime2=System.nanoTime();   //获取开始时间
//        Integer[][] storage2 = new Integer[1000][1000];
//        long endTime2=System.nanoTime(); //获取结束时间
//        System.out.println("程序运行时间2： "+(endTime2-startTime2)+"ns");
//        Arrays.stream(storage2).parallel().forEach(item -> item = new Integer[1000]);
    }
}
