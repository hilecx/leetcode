import java.util.Arrays;
import java.util.Objects;

public class TestJava {
    public static void main(String[] args) {
        System.out.println(Objects.hash(1, 2));
        System.out.println(Objects.hash(2, 1));
        System.out.println(-3%7);
        System.out.println(-10%7);
        System.out.println("flower".indexOf("flow1"));
        System.out.println("flower".substring(0,2));
        System.out.println("flower");


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
