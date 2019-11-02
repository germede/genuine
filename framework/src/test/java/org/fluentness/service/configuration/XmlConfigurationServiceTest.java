package org.fluentness.service.configuration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class XmlConfigurationServiceTest {

    @Before
    public void setUp() {
        System.clearProperty("environment");
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_absentEnvironmentIsSet_illegalArgumentExceptionIsThrown() throws IOException {
        System.setProperty("environment","dummy");
        ConfigurationService configurationService = new XmlConfigurationService();
    }

    @Test
    public void get_noEnvironmentIsSet_devConfigurationsAreGot() throws IOException {
        ConfigurationService configurationService = new XmlConfigurationService();
        Assert.assertEquals("value1",configurationService.get("key1"));
        Assert.assertEquals("value2",configurationService.get("key2"));
        Assert.assertEquals("true",configurationService.get("key3"));
        Assert.assertEquals("false",configurationService.get("key4"));
    }

    @Test
    public void get_devEnvironmentIsSet_devConfigurationsAreGot() throws IOException {
        System.setProperty("environment","dev");
        ConfigurationService configurationService = new XmlConfigurationService();
        Assert.assertEquals("value1",configurationService.get("key1"));
        Assert.assertEquals("value2",configurationService.get("key2"));
        Assert.assertEquals("true",configurationService.get("key3"));
        Assert.assertEquals("false",configurationService.get("key4"));
    }

    @Test
    public void get_prodEnvironmentIsSet_prodConfigurationsAreGot() throws IOException {
        System.setProperty("environment","prod");
        ConfigurationService configurationService = new XmlConfigurationService();
        Assert.assertEquals("value1-prod",configurationService.get("key1"));
        Assert.assertNull(configurationService.get("key2"));
        Assert.assertNull(configurationService.get("key3"));
        Assert.assertNull(configurationService.get("key4"));
    }

    @Test
    public void is_devEnvironmentIsSet_devConfigurationsAreTrue() throws IOException {
        System.setProperty("environment","dev");
        ConfigurationService configurationService = new XmlConfigurationService();
        Assert.assertFalse(configurationService.is("key1"));
        Assert.assertFalse(configurationService.is("key2"));
        Assert.assertTrue(configurationService.is("key3"));
        Assert.assertFalse(configurationService.is("key4"));
    }

    @Test
    public void has_devEnvironmentIsSet_devConfigurationsArePresent() throws IOException {
        System.setProperty("environment","dev");
        ConfigurationService configurationService = new XmlConfigurationService();
        Assert.assertTrue(configurationService.has("key1"));
        Assert.assertTrue(configurationService.has("key2"));
        Assert.assertTrue(configurationService.has("key3"));
        Assert.assertTrue(configurationService.has("key4"));
        Assert.assertFalse(configurationService.has("key5"));
    }

    @Test
    public void has_prodEnvironmentIsSet_prodConfigurationsArePresent() throws IOException {
        System.setProperty("environment","pROd");
        ConfigurationService configurationService = new XmlConfigurationService();
        Assert.assertTrue(configurationService.has("key1"));
        Assert.assertFalse(configurationService.has("key2"));
        Assert.assertFalse(configurationService.has("key3"));
        Assert.assertFalse(configurationService.has("key4"));
        Assert.assertFalse(configurationService.has("key5"));
    }

    @Test
    public void getEnvironment_environmentsAreSet_environmentsAreGot() throws IOException {
        ConfigurationService configurationService = new XmlConfigurationService();
        Assert.assertEquals(Environment.DEV, configurationService.getEnvironment());
        System.setProperty("environment","PROD");
        Assert.assertEquals(Environment.PROD, configurationService.getEnvironment());
        System.setProperty("environment","stage");
        Assert.assertEquals(Environment.STAGE, configurationService.getEnvironment());
        System.setProperty("environment","tEsT");
        Assert.assertEquals(Environment.TEST, configurationService.getEnvironment());
        System.setProperty("environment","prOD");
        System.setProperty("environment","dev");
        Assert.assertEquals(Environment.DEV, configurationService.getEnvironment());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getEnvironment_invalidEnvironmentsIsSet_illegalArgumentExceptionIsThrown() throws IOException {
        ConfigurationService configurationService = new XmlConfigurationService();
        System.setProperty("environment","illegal");
        configurationService.getEnvironment();
    }
}