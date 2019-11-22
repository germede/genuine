![Fluentness logo](core/art/logo.png?raw=true "Fluentness logo")

> The friendly face of Java 

badges

## Introduction
Fluentness is intended to be an easy-to-learn, fully-integrated, 
multi-platform, inter-operable, consistent and flexible 
application development framework. After a quick-start you'll be able to build both:
* rich desktop applications based on Swing without headaches 
* fast and dynamic Single-Page-Web-Apps, using code-based, on-the-fly 
generated HTML, CSS and AJAX calls. 

From small XML-based REST-Web-Services to fully-featured enterprise Apps:
* with small footprint (few dependencies), yet standalone runtime based on 
JDK-integrated Swing and out of the box Servlet / Server implementation
* respecting standards and coding guidelines as far as possible, but with own, 
well-defined [Architecture](https://github.com/germede/Fluentness/wiki/Architecture)

Why Java? Well:
* Type safety
* Performance
* Maven conventions
* Maturity of enterprise standards
* Wide acceptance and knowledge
* Nice functional programming
* Nicer object orientation
* Write once, run everywhere
* 3 billion devices run java? ;) 

## Decalogue

>**F**orce your code to be compact, yet legible  
>**L**oose coupling of application components  
>**U**se static factories, avoiding the new operator  
>**E**mbrace constructor-based dependency injection  
>**N**otice how unit tests do assure software quality    
>**T**ry to avoid comments and anti-patterns  
>**N**ame every component as if it were your child    
>**E**ndorse convention over configuration  
>**S**upply your own implementation only when needed    
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

## Dependencies
This project is based on these open-source technologies:
- [OpenJDK](https://openjdk.java.net/) implementing Java 8 
- Apache [OpenJPA](http://openjpa.apache.org/) as JPA implementation
- Apache [Tomcat](http://tomcat.apache.org/) as embedded web server and Servlet implementation
- Apache [Maven](https://maven.apache.org/) for building and distributing the framework itself and projects based on it
- [JUnit](https://junit.org/junit4/) and [Mockito](https://site.mockito.org/) for unit testing
- [Inkscape](https://inkscape.org/) with fonts Arial, [Scriptina](https://www.fontsquirrel.com/fonts/scriptina) and [Furore](https://www.fontsquirrel.com/fonts/furore) for the art
- Much Engagement :muscle:

## License
Fluentness is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).

Copyright © 2020 Gerardo Medina
