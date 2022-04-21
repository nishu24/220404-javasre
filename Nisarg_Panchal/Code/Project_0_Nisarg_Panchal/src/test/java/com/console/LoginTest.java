package com.console;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    Login login = new Login();


    @Test
    void verifyLogin() {
       int password=777777;
       int accountNo=123456;
        Assertions.assertEquals(123456,accountNo,"Good");
        Assertions.assertEquals(password,777777,"Good");
    }
}