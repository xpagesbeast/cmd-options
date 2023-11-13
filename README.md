# cmd-options
Demonstrates handling command line arguments with jopt-simple.

Setup a OptionParser object and add all arguments accepted.

Then parse the 'args' passed in by the main(String[] args)...

Then use the args in flow control structures.

# Build
`mvn clean install`

# Run
`java -jar target/cmd-options-1.0.0-SNAPSHOT.jar -e UAT`

# Run help
`java -jar target/cmd-options-1.0.0-SNAPSHOT.jar -h`

# console out -h (help)
```
java -jar target/cmd-options-1.0.0-SNAPSHOT.jar -h

HELP Command Line Options
Usage: java -jar target/cmd-options-2.0-SNAPSHOT.jar -e UAT

Option (* = required)  Description
---------------------  -----------                                              
-?, -h, --help         shows this help
-e, --env <String>   which environment? -e or -env.  appends environment to   
  configuration files. Example: settings-{env}.properties
  ```

# console out -e UAT
```
java -jar target/cmd-options-1.0.0-SNAPSHOT.jar -e UAT

Looking for settings-UAT.properties

Looking for configuration-UAT.properties
```


