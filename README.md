# aws-sqs-lambda-java-v1

## Main function
```
src/main/java/example/Hello.java
```
The function will send message to another queue. Please modified/comment out it accordingly.

## Gradle build
```
gradle build
```
### Path to Zip file
```
build/distributions/aws-sqs-lambda-java-v1.zip
```

## Default is DEBUG. Edit following setting to change log level
```
src/main/resources/log4j.properties 
```

## Sample Test content for Lambda
```
{
  "firstName": "value1",
  "lastName": "value2",
  "key3": "value3"
}
```