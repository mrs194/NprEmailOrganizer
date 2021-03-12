package com.company.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.company.Main.Main.validateEmail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @ParameterizedTest(name = "#{index} - Run test with email = {0}")
    @MethodSource("validInputs")
    void valid_email_test(String email) {
        assertTrue(validateEmail(email));
    }

    @ParameterizedTest(name = "#{index} - Run test with email = {0}")
    @MethodSource("invalidInputs")
    void invalid_email_test(String email) {
        assertFalse(validateEmail(email));
    }

    static Stream<String> validInputs() {
        return Stream.of(
                "valid@gmail.com",
                "valid@gmail.com.mx",
                "valid.1234@gmail.com",
                "valid-1234@gmail.com",
                "valid_1234@gmail.com",
                "valid_12.34@gmail.com",
                "v@gmail.com",
                "v@gmail-gmail-gmail.com",
                "v@gmail-gmail.gmail.com",
                "valid.valid-valid@gmail.com");
    }

    static Stream<String> invalidInputs() {
        return Stream.of(
                "hi",
                "invalid@inv@gmail.com",
                ".invalid@gmail.com",
                "invalid.@gmail.com",
                "invalid..@gmail.com",
                "invalid%*@gmail.com",
                "invalid@gmail.c",
                "invalid@gmail..com",
                "invalid@com",
                "invalid@-gmail.c",
                "invalid@gmail.com-",
                "qwertyuiopasdfghjklzxcvbnm1234567890123456789012345678901" +
                        "23456789012@gmail.com"); //email address can be no
                                            // longer than 64 characters
    }
}