![Fluentness logo](framework/src/main/resources/art/logo.png?raw=true "Fluentness logo")

// todo
few dependencies -> many target platforms (web, desktop, mobile, etc.) -> one code basis, one language

## Introduction
Fluentness is intended to be an open-source, all-rounder, easy-to-learn, fully-integrated, 
multi-platform, consistent and flexible Java development framework. After a quick-start you'll be able to:
* develop rich desktop applications based on Swing without headaches, 
dynamic Single-Page-Web-Apps, using code-based, on-the-fly generated HTML, CSS and AJAX calls
or maybe the next top Android native mobile app
* scale from small XML-based REST-Web-Services to fully-featured enterprise Apps 
with very small footprint (few dependencies), yet out-of-the-box runnable as in Spring Boot
* respect standards and coding guidelines as far as possible, but applying own, 
well-defined [Architecture](https://github.com/germede/Fluentness/wiki/Architecture)
* enjoy the advantages of developing in Java such as: type safety, performance, 
maturity, wide acceptance and knowledge, nice support of functional programming
, "Write once, run everywhere" and "3 billion devices run Java" ;) 

## Decalogue

>**F**orce your code to be compact, yet legible  
>**L**oose coupling of application components  
>**U**se static factories, avoiding the new operator  
>**E**mbrace constructor-based dependency injection  
>**N**otice how unit tests help assure software quality    
>**T**ry to avoid comments and anti-patterns  
>**N**ame every component as if it were your child    
>**E**ndorse convention over configuration  
>**S**upply your own implementation only when needed    
>**S**tart applying SOLID, KISS and DRY principles

## Quickstart

### 1. Clone this repository :arrow_down:
```bash
git clone https://github.com/germede/Fluentness
```

### 2. Compile and install the sources into your local repository :desktop_computer:
```bash
cd Fluentness && mvn clean install
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
This will generate a naked project based on the project's Maven archetype.
Hit <kbd>Enter</kbd> when confirmation needed.    
Run the main method on DummyApp.java with your favourite IDE.  

### 4. Read the docs :books:
Read in the [project's wiki](https://github.com/germede/Fluentness/wiki) how the prototype library application was developed. 
Even if this framework is intended to be easy for newbies to learn, some documentation is always helpful.  

### 5. Have fun and contribute :busts_in_silhouette:
Please feel free to open a [new issue](https://github.com/germede/Fluentness/issues/new) 
or a [pull request](https://github.com/germede/Fluentness/compare) directly on GitHub.  

Give a star if you enjoy this project. Contact me if you have any idea on how to improve it.

## Dependencies
This project is based on these open-source technologies:
- [OpenJDK](https://openjdk.java.net/) implementing Java 8 
- [Maven](https://maven.apache.org/) with PLUGINS for building and distributing the framework itself, projects based on it and their dependencies
- The Android platform
- [JUnit](https://junit.org/junit4/) and [Mockito](https://site.mockito.org/) for unit testing
- Darcula Swing Look and Feel
- [Inkscape](https://inkscape.org/) with fonts Arial, [Scriptina](https://www.fontsquirrel.com/fonts/scriptina) and [Furore](https://www.fontsquirrel.com/fonts/furore) for the art logos
- Much Engagement :muscle:

## License
Fluentness is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).

Copyright © 2020 Gerardo Medina
