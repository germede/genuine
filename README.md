# Fluentness
friendly framework


## Introduction
Fluentness is intented to be what JavaEE never was, a **friendly** fully-featured web framework. 

It is based on these technologies:
- Java 8
- Maven
- JUnit
- EclipseLink (JPA)
- Sun HttpServer
- Much love

## Decalogue

**F**orce your code to be compact, yet legible  
**L**oose coupling by using onion layers  
**U**se class attributes as finished components and functions as helpers  
**E**mbrace the consumer and producer architecture  
**N**otice how harmful the new operator can be  
**T**ry to avoid comments  
**N**ame each component, as it was your child  
**E**ndorse convention over configuration  
**S**eparate application data (what) from application flow (how)  
**S**tart using enums for singleton, final classes  

## Quickstart

### 1. Add maven dependency
to your pom.xml

```xml
<dependency>
    <groupId>org.fluentness</groupId>
    <artifactId>fluentness-core</artifactId>
    <version>LATEST</version>
</dependency>
```

### 2. Bootstrap Fluentness
in your main method:

```java
public static void main(String[] args) { 
    Fluentness.does.initialize(args); 
}
```

### 3. Run your application
using commands
```bash
mvn clean package
```
```bash
java -jar app.jar
```

or directly from your favourite IDE. 
I personally recommend you IntelliJ IDEA Community Edition.


## License

This project is licensed under the Apache License 2.0 - see the LICENSE.md file for details
