# Problem Statement

## Build Rest API for MasaiMail Application

- User should be able to send and receive mails
- User should able to send a mail to many persons at once
- User should able to star & delete mails
- User should able to Register to Masaimail App
- User should able to login to Masaimail App

### User table should have following fields-  
<img width="235" alt="Screenshot_20221208_231955" src="https://user-images.githubusercontent.com/110479646/213869373-ea13f325-446d-43a7-8932-0cc8b2ced081.png">

### Rest API for User Resource-
![Screenshot_20221208_225958](https://user-images.githubusercontent.com/110479646/213869335-90966434-1dc2-44e8-a57a-9f279fc30123.png)

### Rest API for Email Resource-
![Screenshot_20221208_231752](https://user-images.githubusercontent.com/110479646/213869404-55be0624-91ad-4c16-b324-f51d7566d323.png)

### Task - 1
- Build Rest API for Email, User
- Use MySQL database
- Use Response Entity depending upon the output.

### Task - 2
- Identify the Relationship between the User and Email and Implement that Relationship
- Use DTO wherever required
- Complete the All User and Email APIs

### Task - 3
- Implement Exceptional Handling in the project
    - Handle Custom Exception
    - Create Custom Error Structure Response for Client
    - Create Global Exception Handler to handle the exceptions globally: All other exception handled in this single place
- Swagger Rest API Documentation
- Add Validations
    - First Name must not contain numbers or special characters
    - Last Name must not contain numbers or special characters
    - Mobile number must have 10 digits
    - Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit.
    - date of birth should not be in future

### Task - 4
- Implement Authentication ( Verifying the User credentials )
