# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tasks (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  done                      tinyint(1) default 0,
  due_date                  datetime,
  constraint pk_tasks primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table tasks;

SET FOREIGN_KEY_CHECKS=1;

