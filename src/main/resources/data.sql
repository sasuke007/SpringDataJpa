insert into courses(id,name,created_date,last_updated_date)
values (10001,'JPA in 50 steps',current_timestamp,current_timestamp);
insert into courses(id,name,created_date,last_updated_date)
values (10002,'Angular in 50 steps',current_timestamp,current_timestamp);

insert into passports(id,number)
values(40001,'E123456');
insert into passports(id,number)
values(40002,'N123456');
insert into passports(id,number)
values(40003,'Z123456');

insert into students(id,name,passport_id)
values (20001,'Rohit',40001);
insert into students(id,name,passport_id)
values (20002,'Adam',40002);
insert into students(id,name,passport_id)
values (20003,'Jane',40003);


insert into reviews(id,rating,description)
values(50001,'5','Great Course');
insert into reviews(id,rating,description)
values(50002,'5','Great Course');
insert into reviews(id,rating,description)
values(50003,'5','Great Course');