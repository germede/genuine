package org.fluentness.controller;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes({"org.fluentness.controller.AbstractGameController.Action"})
public class ActionVerifier extends AbstractProcessor {

    @Override
    public final boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                String currentSignature = element.toString();
                currentSignature = currentSignature.substring(currentSignature.indexOf('('));
                String correctSignature = element.getAnnotation(AbstractGameController.Action.class).value().getSignature();
                if (!currentSignature.equals(correctSignature)) {
                    processingEnv.getMessager().printMessage(
                        Diagnostic.Kind.ERROR,
                        "Action " + element + " should have signature " + correctSignature
                    );
                }
            }
        }
        return false;
    }
}
