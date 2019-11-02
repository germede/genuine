package org.fluentness;

import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.controller.console.ConsoleException;
import org.fluentness.service.dependency.DependencyService;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
        };

        dummyConsoleController = spy(new DummyConsoleController());
        DependencyService manager = mock(DependencyService.class);
        when(manager.getInstances(AbstractConsoleController.class))
            .thenReturn(Collections.singletonList(dummyConsoleController));
        when(manager.getInstance(any())).thenReturn(dummyConsoleController);

        Fluentness.instance = new Fluentness(manager);
    }

    @Test(expected = FluentnessException.class)
    public void bootstrap_nullApplication_fluentnessExceptionIsThrown() throws FluentnessException {
        Fluentness.bootstrap(null, null);
    }

    @Test(expected = FluentnessException.class)
    public void bootstrap_nullArgs_fluentnessExceptionIsThrown() throws FluentnessException {
        Fluentness.bootstrap(application, null);
    }

    @Test
    public void bootstrap_emptyArgs_helpCommandIsExecuted() throws FluentnessException {
        Fluentness.bootstrap(application, new String[0]);
        verify(dummyConsoleController, times(1)).help();
    }

    @Test
    public void bootstrap_absentAction_consoleExceptionIsThrown() {
        boolean exceptionWasThrown = false;
        try {
            Fluentness.bootstrap(application, new String[]{"absentAction"});
        } catch (FluentnessException e) {
            assertEquals(ConsoleException.class, e.getCause().getClass());
            exceptionWasThrown = true;
        }
        assertTrue(exceptionWasThrown);
    }
}