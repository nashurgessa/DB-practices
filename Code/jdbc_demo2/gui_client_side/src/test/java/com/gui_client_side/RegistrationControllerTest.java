package com.gui_client_side;

import com.example.gui_client_side.controller.RegistrationController;
import com.example.gui_client_side.service.UserService;
import com.example.gui_client_side.utils.RegistrationResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationControllerTest {
    static RegistrationController controller;

    @BeforeAll
    static void setUp() {
        controller = new RegistrationController();
    }

    //@Test
    //@Disabled
    //void testCase() {
    //    assertAll("Multiple Test",
    //            () -> assertEquals(RegistrationResult.REGISTRATION_FAILED,
    //                    controller.userRegister("", "example@gmail.com",
    //                            "password", "password")),
    //            () -> assertEquals(RegistrationResult.PASSWORD_MISMATCH,
    //                    controller.userRegister("Alex", "example@gmail.com",
    //                            "password", "passwords")),
    //            () -> assertEquals(RegistrationResult.SUCCESS,
    //                    controller.userRegister("Alex", "example@gmail.com",
    //                            "password", "password"))
    //            );
    //}

}
