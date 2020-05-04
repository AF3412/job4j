create table users 
(
   id serial primary key, 
   name text
);

create table meeting 
(
   id serial primary key, 
   name text
);

create table meet_status 
(
   id serial primary key, 
   name text
);

create table user_meeting 
(
   id serial primary key, 
   meeting_id references meeting, 
   user_id references users, 
   user_meet_status references meet_status
);

insert into users (name) values ('Ivan'), ('Sergey'), ('Alex'), ('Nick'), ('John'), ('Bill');
insert into meeting (name) values ('Morning standup'), ('Talks about COVID19'), ('Lerning Java streams'), ('Reading club');
insert into meeting (name) values ('Weekend zoom calls');
insert into meet_status (name) values ('ACCEPT'), ('DECLINE');
insert into user_meeting (meeting_id, user_id, user_meet_status) values (1, 1, 1), (1, 2, 1), (1, 3, 1), (1, 4, 1), (1, 5, 1), (1, 6, 2);
insert into user_meeting (meeting_id, user_id, user_meet_status) values (2, 1, 2), (2, 2, 2), (2, 3, 2), (2, 4, 2), (2, 5, 2), (2, 6, 2);
insert into user_meeting (meeting_id, user_id, user_meet_status) values (3, 1, 1), (3, 2, 1), (3, 3, 1);
insert into user_meeting (meeting_id, user_id, user_meet_status) values (4, 1, 2);

select m.name as meeting_name, count (u.id) as count_accept_users from meeting m 
   left join user_meeting um on (um.meeting_id = m.id and um.user_meet_status = (select id from meet_status where name = 'ACCEPT')) 
   left join users u on (u.id = um.user_id) 
   group by m.name;

select m.id, m.name from meeting m
   left join user_meeting um on (um.meeting_id = m.id and um.user_meet_status = 2)
   where m.id not in (select um2.meeting_id from user_meeting um2 where um2.user_meet_status = 1)
   group by m.id, m.name;