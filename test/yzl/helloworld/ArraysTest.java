package yzl.helloworld;

import org.junit.Test;

import java.util.Arrays;

public class ArraysTest {
    /*
     * 一个是针对一维数组，一个是针对多维数组
     */
    @Test
    public void testDeepToString() {
        Student[] arr = new Student[5];
        arr[0] = new Student("yzl", 5);
        arr[1] = new Student("cool", 10);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(arr));

        Student[][] arrs = new Student[5][2];
        arrs[0][0] = new Student("huawei", 12);
        arrs[1][0] = new Student("google", 20);
        System.out.println(Arrays.toString(arrs));
        System.out.println(Arrays.deepToString(arrs));

        Student[][][] multiArr = new Student[5][5][2];
        multiArr[0][0][0] = new Student("flink", 30);
        multiArr[1][0][0] = new Student("spark", 100);
        System.out.println(Arrays.deepToString(multiArr));
    }
}

class Student {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "{name=" + name + ", age=" + age + "}";
    }
}
