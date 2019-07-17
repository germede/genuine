# Fluentness
friendly framework


## Introduction
Fluentness is intented to be what JavaEE never was, a **friendly** fully-featured web framework. 


## Decalogue

>**F**orce your code to be compact, yet legible  
>**L**oose coupling by using onion layers  
>**U**se class attributes as finished components and functions as helpers  
>**E**mbrace the consumer and producer architecture  
>**N**otice how harmful the new operator can be  
>**T**ry to avoid comments  
>**N**ame each component, as it was your child  
>**E**ndorse convention over configuration  
>**S**eparate application data (what) from application flow (how)  
>**S**tart using enums for singleton, final classes  

## Quickstart

### 1. Add Maven dependency
to your pom.xml

```xml
<dependency>
    <groupId>org.fluentness</groupId>
    <artifactId>fluentness-core</artifactId>
    <version>LATEST</version>
</dependency>
```

### 2. Initialize Fluentness
in your main method:

```java
public static void main(String[] args) { 
    Fluentness.does.initialize(args); 
}
```

### 3. Run your application
using following commands
```bash
mvn clean package
```
```bash
java -jar app.jar
```

or directly from your favourite IDE. 
I personally recommend you IntelliJ IDEA Community Edition.

## Technologies
This project is based on these technologies:
- Java 8, specifically OpenJDK
- Maven
- JUnit
- EclipseLink (JPA)
- Sun HttpServer
- Much love


## Contributing
Feel free to open issues directly on GitHub. Pull requests are also welcome. Please take the license limitations into account when using or modifying this project.

## License
Fluentness is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).
