# iban-validation-ws

Web service with an REST Endpoint which accepts an IBAN number and validates it (https://en.wikipedia.org/wiki/International_Bank_Account_Number#Validating_the_IBAN).

To run the service into a docker container, execute the following steps:

Package the application into a jar using the maven package command 
 >./mvnw clean package -DskipTests
 
Build the docker image using the following command
>docker build -t iban-validation-ws .

Then execute the docker-compose command
>docker-compose up