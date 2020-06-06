package org.fluentness;

import org.fluentness.service.log.AnsiColor;
import org.junit.Assert;

public enum It {

    must(AnsiColor.CYAN),
    should(AnsiColor.PURPLE),
    may(AnsiColor.BLUE);

    private static int stepNumber = 0;

    private final AnsiColor ansiColor;

    It(AnsiColor ansiColor) {
        this.ansiColor = ansiColor;
    }

    public void beEquals(Object actual, Object expected) {
        test(
            () -> Assert.assertEquals(actual, expected),
            String.format("%s %s be equal to %s", actual, toString(), expected)
        );
    }

    private void test(AssertLambda assertLambda, String description) {
        System.out.println("Step #" + (++stepNumber) + ": " + ansiColor + description + AnsiColor.RESET);
        switch (this) {
            case must:

            case should:


            case may:
                assertLambda.function();
                break;
        }


    }

    @FunctionalInterface
    private interface AssertLambda {
        void function();
    }
}
