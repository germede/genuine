![Fluentness logo](core/art/logo.png?raw=true "Fluentness logo")

## Introduction
Fluentness is intended to be what JavaEE never was: an easy-to-learn, fully-integrated, consistent web framework. 

## Decalogue

>**F**orce your code to be compact, yet legible  
>**L**oose coupling by using onion layers  
>**U**se class attributes as finished components and functions as helpers  
>**E**mbrace the consumer-provider architecture  
>**N**otice how harmful the new operator can be  
>**T**ry to avoid comments and do more unit testing instead  
>**N**ame each component as if it were your child  
>**E**ndorse convention over configuration  
>**S**eparate application data (what) from application flow (how)  
>**S**tart using enums for singleton objects  

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
mvn install
```

### 3. Bootstrap your application :rocket:
You have basically 3 options:


### 3a. Using the CLI
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
Hit <kbd>Enter</kbd> when confirmation needed.:desktop_computer:
```bash
cd your.artifact.id
mvn compile exec:java -Dexec.mainClass=your.group.id.DummyApp -Dexec.args="server:start"
```
 
### 3b. Using an IDE
In this guide we'll be using IntelliJ IDE Community Edition:

1. Click on "Create new project" and choose Maven as project type.
2. Check "Create from archetype".
3. Click on "Add archetype...".
4. GroupId = org.fluentness, ArtifactId = archetype, Version = LATEST, OK.
5. Select the newly added Fluentness archetype. Next.
6. Choose your own application's GroupId, ArtifactId and Version. Next.
7. Check whether all the creation parameters are correct. Next.
8. Choose project name and location. Finish. Enable Auto-Import when asked for.
9. Open the DummyApp.java bootstrapper class and click on 'Run'.
10. Under "Run Configurations", set "server:start" as program argument. Run again. 

### 3c. Checkout the SongLibrary sample project
in the directory /sample. This sample project is used for functional testing, but you can use it as base project instead of generating archetype.

### 4. Read the docs :closed_book:
Read in the [project's wiki](https://github.com/germede/Fluentness/wiki) how the sample Fluentness-based application "SongLibrary" was developed. Fluentness is intended to be easy to learn 
for newbies, but some documentation is always needed.   

### 5. Have fun and contribute :construction_worker:
Feel free to [open a new issue](https://github.com/germede/Fluentness/issues/new) directly on GitHub. Pull requests into the develop branch are also welcome. 
Please take the license limitations into account when using or modifying this project.


## Technologies
This project is based on these technologies:
- Java 8, specifically OpenJDK
- Maven
- JUnit
- EclipseLink (JPA)
- Sun integrated HttpServer
- Scriptina font and Inkscape for the logo artwork
- Engagement :heart:

## License
Fluentness is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).

Copyright © 2019 germede
