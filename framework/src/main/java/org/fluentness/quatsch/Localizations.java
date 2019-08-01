package org.fluentness.quatsch;

import static com.company.Language.*;

public class Localizations {


    @Translate(to = es, as = "Hola mundo")
    @Translate(to = de, as = "Hallo welt")
    String testMessage = "Hello world";


    @Translate(to = es, as = "Hola mundo")
    @Translate(to = de, as = "Hallo welt")
    String openForm = "Hello world";

}
