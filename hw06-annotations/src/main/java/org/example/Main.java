package org.example;

import org.example.tests.Test1;
import org.example.tests.Test2;

public class Main {

    public static void main(String[] args) {
        RunTests runTests = new RunTests();

        runTests.run(Test1.class);
        runTests.run(Test2.class);
    }

}
