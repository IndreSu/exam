# exam

Autoservice application:
An ADMIN can add, edit and remove autoservice; add a specialist to a particular autoservice, edit and remove specialist.
CLIENT can valuate the specialist and the rating is shown in the database.

To run the application:
- Open back end directory exam on IDE
- Run ExamApplication
  
Access app via http://localhost:8080/login
As ADMIN username is Linda, password123
As CLIENT username is John, password
If you login successfully, you receive http://localhost:8080/success
To logout or change ADMIN to CLIENT or CLIENT to ADMIN roles: http://localhost:8080/logout

Access app via Swagger: http://localhost:8080/swagger-ui/index.html

In Swagger users-controller you can add new users (ADMIN or CLIENT), get all users list, get single user and delete user.

In autoservice-controller you can add a new service (with address, owner and title), get all autoservice list, get single autoservice according to the autoservice ID and see the specialists that are working in it, update autoservice or delete autoservice. When you delete the autoservice, the specialists that are working in it are deleted as well.

In specialist-controller you can add a new specialist, get all specialists list, get single specialis (with info about autoservice he is working in), update and delete specialist.

In client-specialist-controller the CLIENT can see the list af all specialists and rate single specialist from 1 to 5 and these ratings are seen in the database.

- Open front end directory exam- front-app  on VSCode
- npm install
- npm start
Access app via http://localhost:3000

