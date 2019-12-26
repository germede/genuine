package org.fluentness;

import org.fluentness.controller.console.Action;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injector.Injector;
import org.junit.Before;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class FluentnessTest {

    private Application application;
    private DummyConsoleController dummyConsoleController;

    private static class DummyConsoleController extends AbstractConsoleController {
        @Action(category = "", description = "Dummy help command")
        public void help() {
        }
    }

    @Before
    public void setUp() {
        application = new Application() {
            @Override
            public void configure(Configuration configuration) {

            }

            @Override
            public Platform getPlatform() {
                return null;
            }

            @Override
            public Environment getEnvironment() {
                return null;
            }
        };

        dummyConsoleController = spy(new DummyConsoleController());
        Injector manager = mock(Injector.class);
        when(manager.getInstances(AbstractConsoleController.class))
            .thenReturn(Collections.singletonList(dummyConsoleController));
        when(manager.getInstance(any())).thenReturn(dummyConsoleController);

    }
//
//    @Test(expected = FluentnessException.class)
//    public void bootstrap_nullApplication_fluentnessExceptionIsThrown() throws FluentnessException {
//        Fluentness.bootstrap(null, null);
//    }
//
//    @Test(expected = FluentnessException.class)
//    public void bootstrap_nullArgs_fluentnessExceptionIsThrown() throws FluentnessException {
//        Fluentness.bootstrap(application, null);
//    }
//
//    @Test
//    public void bootstrap_emptyArgs_helpCommandIsExecuted() throws FluentnessException {
//        Fluentness.bootstrap(application, new String[0]);
//        verify(dummyConsoleController, times(1)).help();
//    }
//
//    @Test
//    public void bootstrap_absentAction_consoleExceptionIsThrown() {
//        boolean exceptionWasThrown = false;
//        try {
//            Fluentness.bootstrap(application, new String[]{"absentAction"});
//        } catch (FluentnessException e) {
//            assertEquals(ConsoleException.class, e.getCause().getClass());
//            exceptionWasThrown = true;
//        }
//        assertTrue(exceptionWasThrown);
//    }
}