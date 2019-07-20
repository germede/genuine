package ${package};

import org.fluentness.Fluentness;

public class DummyApp {

    public static void main(String[] args) {
        Fluentness.initialize("${package}",args);
    }

}
