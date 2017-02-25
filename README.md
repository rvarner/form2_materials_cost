# form2\_materials\_cost
Automatically logs into FormLabs and adds the materials cost to the notes field of each print.

Uses [Geb](http://www.google.com) and [Groovy](http://groovy.codehaus.org), so you get to kick back and watch it work for you.


## Installation
You need to have [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed.

## Configuration
If you have [LastPass](https://www.lastpass.com) and you have the CLI tools installed, you need to log in first:

```
lpass login <email>
```


## Run
Once Java is installed, ```cd form2_materials_cost/``` and type:

### If using LastPass
```
./gradlew run
```
### If using args
```
./gradlew run <user> <pass>
```

### (Optional)
You can optionally add your user/pass to the beginning of ```src/main/groovy/form2_matersials_cost.groovy``` and then run:

```
./gradlew run
```