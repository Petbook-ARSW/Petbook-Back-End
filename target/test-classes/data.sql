DROP TABLE IF EXISTS petbookuser CASCADE;
DROP TABLE IF EXISTS companyevent CASCADE;
DROP TABLE IF EXISTS goal CASCADE;
DROP TABLE IF EXISTS participants CASCADE;
DROP TABLE IF EXISTS raffle CASCADE;
DROP TABLE IF EXISTS pet CASCADE;

create table if not exists petbookuser (id serial primary key, username varchar(30) not null, pasword varchar(100) not null, usertype varchar(30) not null, mail varchar(50) not null, numberPhone bigint, information varchar(500), birthdate date not null);
create table if not exists companyevent (id serial primary key, eventname varchar(30) not null, isDonaton boolean not null, address varchar(30) not null, eventdate date, eventhour time, information varchar(500), hostcompany int);
create table if not exists participants (id serial primary key, iduser int, idevent int);
create table if not exists goal (id serial primary key, eventid int, prize varchar(50) not null, state boolean, valor int);
create table if not exists raffle (id serial primary key, raffledate date not null, rafflehour time not null, idgoal int not null, ganador int not null,eventid int not null);
create table if not exists pet (id serial primary key, idowner int not null, petname varchar(30) not null, birthdate date not null,information varchar(500));