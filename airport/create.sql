create table airport_user (username varchar(255) not null, password varchar(255), primary key (username));
create table airport_user_roles (airport_user_username varchar(255) not null, roles varchar(255));
alter table if exists airport_user_roles add constraint FKj9jifhxemic2jh6a7wxcefki4 foreign key (airport_user_username) references airport_user;