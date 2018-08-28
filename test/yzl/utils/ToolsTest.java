package yzl.utils;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ToolsTest {
    @Ignore
    @Test
    public void testIntArrToDoubleArr() {
        int[] arr = new int[]{1,2,3};
        Double[] newArr = Tools.toDoubleArr(arr);
        System.out.println(Arrays.toString(newArr));
    }
}
