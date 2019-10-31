package org.fluentness.controller.web.markup.html;

import org.fluentness.controller.web.WebController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HtmlViewTest  {

    @Before
    public void setUp() {
        webController = new WebController();
    }

    @Test
    public void getActions_numberOfActionsIsCorrect() {



        Assert.assertEquals(9, webController.getActions().size());
    }
}
