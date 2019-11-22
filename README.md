![Fluentness logo](core/art/logo.png?raw=true "Fluentness logo")

>Slogan 

badges

Controllers === Views
||
||
||
Repositories === Models
||
||
||
Services

3 billion devices run java
Java SE & EE revamp
Java rethought
Fluentness: The Friendly face of Java SE & EE 

## Introduction
Fluentness is intended to be an easy-to-learn, fully-integrated, Java-based, consistent and flexible (mobile, ) web and desktop development framework. 

So let's say you want a fancy application that just says Hello to someone. Just add this to your flow/Controllers.java
```java
public class Controllers extends ControllerProvider {
    Controller main = actions(
        hello -> get("/hello", request -> response("Hello " + request.getGetParameter("name")))
    );
}
```
Visit http://localhost:8000/hello?name=YourName

## Decalogue

>**F**orce your code to be compact, yet legible Flent APIS 
>**L**oose coupling by splitting your application in base, data and flow: the Fluentness way  
>**U**se class attributes as finished components and functions as helpers  
>**E**mbrace the consumer-provider, onion-layer-like base-data-flow architecture  
>**N**otice how unit tests may help you define and accept requirements  
>**T**ry to avoid abusing of comments, singletons, statics and annotations  
>**N**ame every component as if it were your child  
>**E**ndorse convention over configurator and dependency definition over injection  
>**S**ubstitute framework default implementation with your own when needed  
>**S**tart applying SOLID, KISS and DRY principles

## Quickstart

### 1. Clone this repository :arrow_down:
into your working directory

```bash
git clone https://github.com/germede/Fluentness
```

### 2. Compile and install the sources :desktop_computer:
into your local Maven repository

```bash
cd Fluentness
mvn clean install
```

### 3. Bootstrap your application :rocket:

Navigate to your project root directory and execute following:
```bash
mvn archetype:generate                                  \
  -DarchetypeGroupId=org.fluentness                     \
  -DarchetypeArtifactId=archetype                       \
  -DarchetypeVersion=LATEST                             \
  -DgroupId=your.group.id                               \
  -DartifactId=your.artifact.id                         \
  -Dversion=0.0.1
```
Hit <kbd>Enter</kbd> when confirmation needed.  
In this guide we'll be using IntelliJ IDE Community Edition.  
Open the recently created project with your IDE.  
Enable Auto-Import when asked for.  
Open the DummyApp.java bootstrapper class and click on 'Run'.  
Under "Run Configurations", set "server:start" as program argument. Run again. 

### 4. Read the docs :books:

Read in the [project's wiki](https://github.com/germede/Fluentness/wiki) how the sample Fluentness-based application "SongLibrary" was developed. Fluentness is intended to be easy to learn 
for newbies, but some documentation is always needed.

That sample project "SongLibrary" is used for functional testing, but you can still use it as base project instead of generating an archetype.  

### 5. Have fun and contribute :busts_in_silhouette:
Feel free to [open a new issue](https://github.com/germede/Fluentness/issues/new) directly on GitHub. 
Pull requests into the develop branch are also welcome. 

Fluentness is thought to be extendable, either within your application's base package or even developing standalone plugins. 

## Technologies
This project is based on these open source technologies:
- Java 8, specifically [OpenJDK](https://openjdk.java.net/)
- JPA as ORM, implemented by [EclipseLink](https://www.eclipse.org/eclipselink/) 
- [JUnit](https://junit.org/junit4/) and Mockito for unit testing
- Apache [Maven](https://maven.apache.org/) for building and distributing
- [NanoHTTPD](https://github.com/NanoHttpd/nanohttpd) as embedded Web server
- [Inkscape](https://inkscape.org/) with fonts [Scriptina](https://www.fontsquirrel.com/fonts/scriptina) and [Furore](https://www.fontsquirrel.com/fonts/furore) for the logo
- Much Engagement :muscle:

## License
Fluentness is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).

Copyright © 2020 Gerardo Medina
