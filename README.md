# form2\_materials\_cost
Automatically logs into FormLabs and adds the materials cost to the notes field of each print.

Uses [Geb](http://www.google.com) and [Groovy](http://groovy.codehaus.org), so you get to kick back and watch it work for you.


## Installation
You need to have [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed. Do that.

### Edit
Edit the beginning of **src/main/groovy/form2\_materials\_cost.groovy** where it says

```python
user = ''
pass = ''
```
and enter your formlabs.com login.

### Build (optional)
If you want to build this as an executable, run:

```
./gradlew clean build
```
Your deliverables will be in

```
build/distributions
```

## Configuration (optional)
If you did not specify a user/pass, and you have [LastPass](https://www.lastpass.com) and the CLI tools installed ```brew install lastpass-cli```, you need to log in first:

```
lpass login <email>
```


## Run
Once Java is installed, ```cd form2_materials_cost/``` and type:

```
./gradlew run
```