package ${package};

import org.fluentness.Fluentness;

public class DummyApp {

    public static void main(String[] args) {
        Fluentness.instance.initialize("${package}",args);
    }

}
