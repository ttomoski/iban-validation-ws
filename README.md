# iban-validation-ws

Web service with an REST Endpoint which accepts an IBAN number and validates it (https://en.wikipedia.org/wiki/International_Bank_Account_Number#Validating_the_IBAN).

To run the service, a PostgreSQL database is required to be configured, which will used for retreiving the supported country codes and IBAN lengths for them.

In the iban-validation-ws/src/main/resources/create_table_and_init_data.sql file, contains the SQL code for creating the needed table and initializing it with some data.
