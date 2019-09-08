# Greenfoot with Maven - Autumn 1 

This project is an adaptation of the Game chapter07/autumn-1 which can be found at [Greenfoot Book Scenarios website](https://www.greenfoot.org/book/material/book-scenarios.zip).
However, instead of using the Greenfoot IDE, we adapt it to run with Maven.

## Motivation

Developing games with Greenfoot is extremely easy compared to other Java frameworks. Unfortunately you are kind of 
forced to use the toolset supplied by Greenfoot, which might be great for beginners but is just a pain if you are 
used to develop using a real IDE. Also using a IDE to develop, means that you can use that IDE's debugging tools, which 
is great because the Greenfoot tools only offer stepwise calling of the `act()` methods to do "*debugging*". 


### Prerequisites

In any case, you'll need to clone this repo. You can do this by using any Git GUI Client or simply the command line:

```
$ git clone https://github.com/thiagoprocaci/greenfoot-maven-demo.git
``` 

Also make sure, you have the following tools installed:

- Java 8 (JDK)
- Maven 3.x
- IntelliJ or any Java IDE (such as NetBeans or Eclipse)

See how to install Maven [here](https://www.youtube.com/watch?v=rgSESP1V9c4).


### Running it

To build and run this, do the following in a terminal:

```
$ cd greenfoot-maven-demo
$ mvn clean install -DskipTests
$ java -jar target/greenfoot-maven-demo-1.0-SNAPSHOT-jar-with-dependencies.jar
```

If you try to use the jar without bundled dependencies it **won't work**!

### GUI

Open the `pom.xml` as a new project in IntelliJ or your IDE and switch on auto import for Maven.

If the import is done, create a new run configuration similar to the following:

![IntelliJ run configuration](runconfig.png)

You should now be able to run the game and even debug it!

### More Details

To get more information on the process of developing without using the Greenfoot IDE, please read 
[DEVELOPMENT.md](DEVELOPMENT.md) or [the blogpost](https://blog.lerk.io/making-games-with-greenfoot-without-greenfoot/) I made, which is essentially the same.
