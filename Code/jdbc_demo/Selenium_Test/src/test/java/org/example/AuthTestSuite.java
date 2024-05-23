package org.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        LoginSuccessTest.class,
        LoginFailureTest.class
})
public class AuthTestSuite {
    // No method needed,
    // this class only serves as a holder for the suite configuration
}
