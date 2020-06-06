![Fluentness logo](fn-core/src/main/resources/img/logo.png?raw=true "Fluentness logo")

The project in a nutshell:
* It **adapts** to the target platform implementation. No matter which of them one is developing for: A text is a text, a button is a button, regardless of developing a pure desktop Swing, an HTML/CSS/JS-based web or a mobile native Android app.
* It **provides** a common language rather than requiring to learn many DSL. No more static HTML-files or -templates, interaction definition using JS-code or configuration and localization .properties-files.  
* It **scales** from small micro-services to fully-featured web applications with a very small footprint, yet out-of-the-box runnable applications with few dependencies.
* It **respects** standards and coding guidelines as far as possible, but applies a well-defined own architecture.
* It **profits** from Java-based software development: enforced object-orientation, type safety, performance, maturity, wide acceptance, nice support of functional programming and other paradigms, "Write once, run everywhere"-philosophy and 3 billion devices running it since decades ;) 

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

## Acknowledgments
This project relies on the following open-source technologies:
- [OpenJDK](https://openjdk.java.net/) at language level 8 
- [JUnit](https://junit.org/junit4/) for unit testing
- Apache [Maven](https://maven.apache.org/)
- [OpenGL](https://www.opengl.org/) + libraries [LWJGL](https://www.lwjgl.org/) and [GLFW](https://www.glfw.org/) [fn-game]
- The [Android](https://www.android.com) platform [fn-mobile]
- Font [Scriptina](https://www.fontsquirrel.com/fonts/scriptina) [logo]
- And of course a lot of engagement :muscle:

## Copyright
This project is licensed under the terms of the EUPL (1.2 or later).  
Copyright © 2020 Gerardo Medina.  
