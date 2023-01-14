
# Fenix - Meeting attendance control 📝  
 

## Developer goals 🚀  
Consolidate knowlede of development and tests on Java

## Software goal ✨  
Attendance control software designed to help a Masonic lodge to calculate attendance rates and control of member registers;

### Stack: 📝
- Java 17
- Spring Boot
- PostgreSQL

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
