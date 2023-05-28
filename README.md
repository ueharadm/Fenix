
# Fenix - Meeting attendance control 📝  
 

## Developer goals 🚀  
Consolidate knowlede of development and tests on Java

## Software goal ✨  
Attendance control software designed to help a Masonic lodge to calculate attendance rates and control of member registers;

### Stack: 📝
- Java 17
- Spring Boot
- PostgreSQL
- React

## Next Steps
- <s>Basic CRUD without validations for Member
- Basic CRUD without validations for Meeting
- Basic CRUD without validations for Lodge</s>
- Create Business logic for attendance calculation
  - Check specifications.md: https://github.com/ueharadm/Fenix/blob/master/Specifications.md
- Create endpoints for attendance calculation
- Create validations on the cruds
    - Member
      - Cannot have more than 1 member with same registration
      - Member register: Lodge id must exist
    - Meeting
      - Cannot have more than 1 meeting with same number
      - presentMembers
        - Create logic for relation with meeting.type with member.degree
    - Lodge
      - Cannot have more than 1 lodge with same register

## Get Started
Clone the project on to a local git folder
```
git clone https://github.com/ueharadm/Fenix.git
```
Using IntelliJ got to File >> Project Structure... >> And set SDK and Language level to at least JAVA 17

Open docker-compose.yml and install the IntelliJ Docker plugin

If you are running docker engine on WSL, configure the plugin for that.

Run the service on your docker-compose.yml (docker compose up)

Open a terminal with access to docker and find the postgres container

```
docker ps
```
Execute the container on iterative mode
```
docker exec -it <container_name or container_id> bash
```
Log onto psql
```
psql -U <postgres_username>
```
create the fenix database
```
create database fenix;
```

Open the Application (src/main/java/Fenix/Application.java) and execute it

Congratulations back-end application is already running on localhost:8080

## Run the Front-end

## Expose the application to the world using ngrok

- https://ngrok.com/docs/getting-started/