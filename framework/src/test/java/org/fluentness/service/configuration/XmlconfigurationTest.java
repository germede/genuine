package org.fluentness.service.configuration;

public class XmlconfigurationTest {

//    @Before
//    public void setUp() {
//        System.clearProperty("environment");
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void get_absentEnvironmentIsSet_illegalArgumentExceptionIsThrown() throws IOException {
//        System.setProperty("environment", "dummy");
//        ConfigurationService configuration = new XmlConfigurationService();
//    }
//
//    @Test
//    public void get_noEnvironmentIsSet_devConfigurationsAreGot() throws IOException {
//        ConfigurationService configuration = new XmlConfigurationService();
//        Assert.assertEquals("value1", configuration.get("key1"));
//        Assert.assertEquals("value2", configuration.get("key2"));
//        Assert.assertEquals("true", configuration.get("key3"));
//        Assert.assertEquals("false", configuration.get("key4"));
//    }
//
//    @Test
//    public void get_devEnvironmentIsSet_devConfigurationsAreGot() throws IOException {
//        System.setProperty("environment", "dev");
//        ConfigurationService configuration = new XmlConfigurationService();
//        Assert.assertEquals("value1", configuration.get("key1"));
//        Assert.assertEquals("value2", configuration.get("key2"));
//        Assert.assertEquals("true", configuration.get("key3"));
//        Assert.assertEquals("false", configuration.get("key4"));
//    }
//
//    @Test
//    public void get_prodEnvironmentIsSet_prodConfigurationsAreGot() throws IOException {
//        System.setProperty("environment", "prod");
//        ConfigurationService configuration = new XmlConfigurationService();
//        Assert.assertEquals("value1-prod", configuration.get("key1"));
//        Assert.assertNull(configuration.get("key2"));
//        Assert.assertNull(configuration.get("key3"));
//        Assert.assertNull(configuration.get("key4"));
//    }
//
//    @Test
//    public void is_devEnvironmentIsSet_devConfigurationsAreTrue() throws IOException {
//        System.setProperty("environment", "dev");
//        ConfigurationService configuration = new XmlConfigurationService();
//        Assert.assertFalse(configuration.is("key1"));
//        Assert.assertFalse(configuration.is("key2"));
//        Assert.assertTrue(configuration.is("key3"));
//        Assert.assertFalse(configuration.is("key4"));
//    }
//
//    @Test
//    public void has_devEnvironmentIsSet_devConfigurationsArePresent() throws IOException {
//        System.setProperty("environment", "dev");
//        ConfigurationService configuration = new XmlConfigurationService();
//        Assert.assertTrue(configuration.has("key1"));
//        Assert.assertTrue(configuration.has("key2"));
//        Assert.assertTrue(configuration.has("key3"));
//        Assert.assertTrue(configuration.has("key4"));
//        Assert.assertFalse(configuration.has("key5"));
//    }
//
//    @Test
//    public void has_prodEnvironmentIsSet_prodConfigurationsArePresent() throws IOException {
//        System.setProperty("environment", "pROd");
//        ConfigurationService configuration = new XmlConfigurationService();
//        Assert.assertTrue(configuration.has("key1"));
//        Assert.assertFalse(configuration.has("key2"));
//        Assert.assertFalse(configuration.has("key3"));
//        Assert.assertFalse(configuration.has("key4"));
//        Assert.assertFalse(configuration.has("key5"));
//    }
//
//    @Test
//    public void getEnvironment_environmentsAreSet_environmentsAreGot() throws IOException {
//        ConfigurationService configuration = new XmlConfigurationService();
//        Assert.assertEquals(Environment.DEV, configuration.getEnvironment());
//        System.setProperty("environment", "PROD");
//        Assert.assertEquals(Environment.PROD, configuration.getEnvironment());
//        System.setProperty("environment", "stage");
//        Assert.assertEquals(Environment.STAGE, configuration.getEnvironment());
//        System.setProperty("environment", "tEsT");
//        Assert.assertEquals(Environment.TEST, configuration.getEnvironment());
//        System.setProperty("environment", "prOD");
//        System.setProperty("environment", "dev");
//        Assert.assertEquals(Environment.DEV, configuration.getEnvironment());
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void getEnvironment_invalidEnvironmentsIsSet_illegalArgumentExceptionIsThrown() throws IOException {
//        ConfigurationService configuration = new XmlConfigurationService();
//        System.setProperty("environment", "illegal");
//        configuration.getEnvironment();
//    }
}