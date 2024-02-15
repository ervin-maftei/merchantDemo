
create schema company;

create table PROJECT
(
    ID   INTEGER not null AUTO_INCREMENT,
    NAME CHARACTER VARYING,
    INDUSTRY CHARACTER VARYING,
    constraint PK
        primary key (ID)
);

create table PERSON
(
    ID   INTEGER not null AUTO_INCREMENT,
    FIRST_NAME CHARACTER VARYING,
    LAST_NAME CHARACTER VARYING,
    GRADE CHARACTER VARYING,
    DISCIPLINE CHARACTER VARYING,
    constraint PK
        primary key (ID)
);

create table PERSON_PROJECT
(
    ID INTEGER AUTO_INCREMENT,
    PROJECT_ID INTEGER not null,
    PERSON_ID  INTEGER not null,
    constraint PK primary key (PROJECT_ID, PERSON_ID),
    foreign key (PERSON_ID) references PERSON (ID),
    foreign key (PROJECT_ID) references PROJECT (ID),
)