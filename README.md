![Fluentness logo](fn-core/src/main/resources/img/logo-fancy.gif?raw=true "Fluentness logo")

Fluentness is intended to be an open-source, all-rounder, easy-to-learn, fully-integrated, 
multi-platform, consistent and flexible Java-based development framework. After a quick-start you'll be able to:
* Develop rich desktop applications based on Swing without headaches, 
dynamic Single-Page-Web-Apps, using code-based, on-the-fly generated HTML, CSS and AJAX calls, the next top Android native mobile app or maybe a nice-looking, high-performing Game using OpenGL.
* Scale from small to fully-featured with very small footprint (few dependencies), yet out-of-the-box runnable applications.
* Respect standards and coding guidelines as far as possible, but applying the framework well-defined architecture.
* Enjoy the advantages of developing software using Java such as: type safety, performance, maturity, wide acceptance and knowledge, nice support of functional programming, "Write once, run everywhere"-philosophy and 3 billion devices running it since decades ;) 

## In a nutshell
![Fluentness architecture](fn-core/src/main/resources/img/architecture.svg?raw=true "Fluentness architecture")
 

## Quickstart

### 1. :arrow_down: Clone this repository 
```bash
git clone https://github.com/germede/Fluentness
```

### 2. :desktop_computer: Compile and install the sources into your local repository 
```bash
cd Fluentness && mvn clean install
```

### 3. :arrow_forward: Test the prototype in any of its flavours
After executing
```bash
mvn clean package -Dflavour=[console|desktop|game|mobile|web]
```
a stand-alone jar-with-dependencies (fat-jar) inside the prototype/target folder should have been built. Run it using:
```bash
java -jar <name_of_the_jar_file>.jar
```
### 4. :rocket: Bootstrap your application using the archetype
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

### 5. :pencil: Use an IDE to develop your own application 
Just open the generated Maven folder in an IDE / editor of your choice. I personally recommend you Intellij IDEA Community, because it integrates with Maven projects very well. 

### 6. :books: Read the docs
Read in the [project's wiki](https://github.com/germede/Fluentness/wiki) further on how the prototype application was developed. Even if this framework is intended to have no big learning curve, some documentation is always helpful.  

### 7. :busts_in_silhouette: Have fun and contribute 
Please feel free to open a [new issue](https://github.com/germede/Fluentness/issues/new) 
or a [pull request](https://github.com/germede/Fluentness/compare) directly on GitHub.  Give a star if you enjoy this project. Contact me if you have any idea on how to improve it.

## Attributions
This project uses the following open-source software:
- [OpenJDK](https://openjdk.java.net/), currently language level 8 
- Apache [Maven](https://maven.apache.org/)
- [OpenGL](https://www.opengl.org/) and its libraries [LWJGL](https://www.lwjgl.org/) and [GLFW](https://www.glfw.org/)
- The [Android](https://www.android.com) platform
- [JUnit](https://junit.org/junit4/) and [Mockito](https://site.mockito.org/) for unit testing
- [Inkscape](https://inkscape.org/) with fonts Arial, [Scriptina](https://www.fontsquirrel.com/fonts/scriptina) and [Furore](https://www.fontsquirrel.com/fonts/furore) for the art logos
- And of course a lot of engagement :muscle:

## Copyright
Copyright © 2020 Gerardo Medina.  
This project is licensed under the terms of the EUPL (1.2 or later).
