package org.fluentness;

import org.fluentness.common.AnsiColor;
import org.junit.Assert;

public enum It {

    must(AnsiColor.CYAN),
    should(AnsiColor.PURPLE),
    may(AnsiColor.BLUE);

    private static int stepNumber = 0;

    private static void test(It it, AssertLambda assertLambda, String description) {
        System.out.println("Step #" + (++stepNumber) + ": " + it.ansiColor + description + AnsiColor.RESET);
        switch (it) {
            case must:

            case should:


            case may:
                assertLambda.function();
                break;
        }


    }

    private final AnsiColor ansiColor;

    It(AnsiColor ansiColor) {
        this.ansiColor = ansiColor;
    }

    public void equals(Object actual, Object expected) {
        test(
                this,
                () -> Assert.assertEquals(actual, expected),
                String.format("%s %s be equal to %s", actual, toString(), expected)
        );
    }

    @FunctionalInterface
    private interface AssertLambda {
        void function();
    }
}
