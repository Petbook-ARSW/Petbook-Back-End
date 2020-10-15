--USUARIO--
create table if not exists petbookuser (id serial primary key, username varchar(30) not null, pasword varchar(100) not null, usertype varchar(30) not null, mail varchar(50) not null, numberPhone bigint, information varchar(500), birthdate date not null);
alter table petbookuser add constraint uk_userName unique(userName);
alter table petbookuser add constraint uk_mail unique(mail);

--EVENTO--
create table if not exists companyevent (id serial primary key, eventname varchar(30) not null, isDonaton boolean not null, address varchar(30) not null, eventdate date, eventhour time, information varchar(500), hostcompany int);
alter table companyevent add constraint ck_eventdate check (eventdate > current_date);
alter table companyevent add constraint fk_hostcompany foreign key (hostcompany) references petbookuser(id) ON DELETE cascade;

create table if not exists participants (id serial primary key, iduser int, idevent int);
alter table participants add constraint fk_iduser foreign key (iduser) references petbookuser(id)ON DELETE cascade;
alter table participants add constraint fk_idevent foreign key (idevent) references companyevent(id)ON DELETE cascade;

create table if not exists goal (id serial primary key, eventid int, prize varchar(50) not null, state boolean, value_money int);
alter table goal add constraint fk_eventid foreign key (eventid) references companyevent(id)ON DELETE cascade;
----PET-----
create table if not exists pet (id serial primary key, idowner int not null, petname varchar(30) not null, birthdate date not null,information varchar(500));
alter table pet add constraint fk_ownerid foreign key (idowner) references petbookuser(id)ON DELETE cascade;

