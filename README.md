# Background
This exercise is to complete a RESTful API in Spring Boot[1] that provides a custom-burrito ordering service.  This ZIP contains a starter project to build on top of, filling out the service as described below.

Set aside an hour for this exercise.  It's ok if you don't finish to your complete satisfaction - focus on pieces you can complete, and mark what you can't with a `// TODO` comment containing a description of the remaining portion you would implement with more time.

## Requirements
To complete this assignment, on your system you will need:
1. A Java 11 JDK
1. A Java IDE:  IntelliJ, Eclipse, or VS Code

## "Order" Data Model
An order consists of:
* Tortilla (one of):  {corn, flour}
* Protein (one of):  {bean, beef, chicken, pork, shrimp, steak}
* Vegetables  (zero or more of):  {cabbage, corn, jalapenos}
* Salsa  (one of):  {mild, medium, hot}
* Extras  (zero or more of):  {avocado}

# To-Do
1. Use this link to initialize the Spring Boot project:  https://urldefense.proofpoint.com/v2/url?u=https-3A__start.spring.io_-23-21type-3Dmaven-2Dproject-26language-3Djava-26platformVersion-3D2.5.9-26packaging-3Djar-26jvmVersion-3D11-26groupId-3Dcom.generali-26artifactId-3Dburrito-2Dordering-2Dservice-26name-3Dburrito-2Dordering-2Dservice-26description-3DAPI-2520for-2520ordering-2520custom-2520burritos-26packageName-3Dcom.generali.burrito-2Dordering-2Dservice-26dependencies-3Dlombok-2Cdevtools-2Cweb-2Cdata-2Djpa-2Cactuator&d=DwIGAg&c=BioHiDP8cpFFEOWoiyRJQw&r=G3u46DvkCw7NEoh33tEMEeTOXL9Ac1sMc2K9at5FsHE&m=V-f8yBr5Db86y-8Jv0SBn6fkIoLUbIe386gZf9y2zwt9GDTSG9XU119gbt5AqVke&s=5Mroc4j2LLJUdVx_h2WZJSrm-v_FrYNLRIA7e_5IHVw&e= 
1. Accept two requests:
    1. `POST /orders`
    1. `GET /orders/{orderId}`
1. Implement model class(es)
1. Implement controller
1. Implement repository
1. Unit and functional tests
    1. Mock the repository

# Restrictions
* Only spend 1 hour
* All work should be your own - no help other than documentation available on the internet

# Bonus
* Address security, availability, performance
* Postman test collection:
    1. Json file under src/test/postman/OrderCollection.postman_collection.json

# Footnotes
1. Prefer Java over Kotlin

# Tech Stacks
1. Spring Data JPA v.2.5.9
2. H2 db v.1.4.200
3. Jackson v.2.12.6
4. Spring Boot v.2.5.10
5. Spring Web Reactive v.5.3.16
6. Spring actuator v.2.5.10
7. Lombok v.1.2.10
8. Slf4j v.1.7.36
