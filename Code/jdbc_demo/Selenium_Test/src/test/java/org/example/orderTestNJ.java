package org.example;

import org.junit.jupiter.api.Order; // Not this one
import org.testng.annotations.Test;

public class orderTestNJ {

    @Test
    @Order(1)
    void testJUnit() {

    }

    @Test(priority = 3)
    void test1() {
        System.out.println("This is test 1");
    }
    @Test(priority = 1)
    void test2() {
        System.out.println("This is test 2");
    }
    @Test(priority = 2)
    void test3() {
        System.out.println("This is test 3");
    }
}
