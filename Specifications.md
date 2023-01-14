# Specifications

___
## User Story 01

#### **As** a member of a masonic lodge
#### **I want** to be able to register new lodges on the system
#### **So that** i can manage the lodges when needed



## Scenario: Member registration

*Spec 01*

**Given** that i have all the lodge registration data

**When**  i register the lodge

**Then** the lodge should be registered

 ~~~bash  
  {
    "name": "Loja Abacaxi",
    "register": 377
}
~~~


*Spec 02*

**Given** that i have all the member registration data  
**And** there's a lodge with the register 377 on the system

**When**  i register the lodge

**Then** the lodge should not be registered  
**And** the system shold notify the user that that register is already on the system

 ~~~bash  
**Request**
{
    "name": "Loja Abobrinha",
    "register": 377
}
**Response Example**

"The register 377 is already is use by another lodge"
~~~

___
## User Story 02

#### As a member of a masonic lodge
#### I want to be able to register new members on the system
#### So that i can manage the members when needed



## Scenario: Lodge Registration

*Spec 01*

**Given** that i have all the member registration data  
**But** the lodge 3 is not registered


**When**  i register the member

**Then** the member should not be registered   
**And** the system shold notify the user that the lodge isn't registered

 ~~~bash  
  {
    "name": "Jose da Silva",
    "registration": 333,
    "degree": "MESTRE",
    "lodge": 3,
    "birthDate": "1970-12-01",
    "initiationDate": "2000-01-01"
}
~~~


*Spec 02*

**Given** that i have all the member registration data  
**And** the lodge 1 is registered

**When**  i register the member

**Then** the member should be registered on the system

 ~~~bash  
  {
    "name": "Jose da Silva",
    "registration": 333,
    "degree": "MESTRE",
    "lodge": 1,
    "birthDate": "1970-12-01",
    "initiationDate": "2000-01-01"
}
~~~

___
## User Story 03 - TODO

#### As a member of a masonic lodge
#### I want to be able to register new meetings on the system
#### So that i can manage the meetings when needed



## Scenario: Meeting Registration

*Spec 01*


Create meeting successfully
~~~bash  
{
    "number": 401,
    "type": "APRENDIZ",
    "date": "2022-12-01",
    "presentMemberIds": []
}
~~~


*Spec 02*

Cannot create meeting with same number

*Spec 03*

presentMemberIds must check member.degree by id and compare with meeting type


Table 1. Member.degree allowed per Meeting.type

| Degree/Type              |   APRENDIZ  | COMPENHEIRO |  MESTRE  |
|--------------------------|:-----------:|:-----------:|:--------:|
| APRENDIZ                 |     YES     |     NO      |    NO    |
| COMPANHEIRO              |     YES     |    YES      |    NO    |
| MESTRE                   |     YEA     |    YES      |    YES   |