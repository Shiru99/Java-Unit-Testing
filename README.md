# JUnit-5

JUnit 5 - Testing Framework 


### Steps to run test :
```
    Preparation                             (developer)
    provide test input                      (developer)
    run the tests                   -->     JUnit(/Testing Framework)
    provide expected output                 (developer)
    verify result                   -->     JUnit(/Testing Framework)
    alert developer if test failed  -->     JUnit(/Testing Framework)
```

### JUnit-5 Architecture
```
    Jupiter (for junit-5)       Vintage (older versions)        EXT (3rd party)

                                JUnit Platform (Test Engine) 
```

### JUnit-5 Maven dependencies
```
    junit-jupiter-api : API to write JUnit 5 tests
    junit-jupiter-engine : Engine to run JUnit 5 tests
```

### To Run Junit-5 test cases

    $ mvn clean test
    $ mvn clean test -Dtest=io.fall.BasicMathsTest
    $ mvn clean test -Dtest=io.fall.BasicMathsTest#testAssertMethods
