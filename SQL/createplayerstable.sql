drop table if exists firstdb.players;

create table if not exists firstdb.players(
	ID integer primary key not null auto_increment,
    name varchar(50) not null,
    score integer not null
)auto_increment=100;

alter table firstdb.players
add rating decimal(4,2)
generated always as (score/20) stored;

describe table firstdb.players;

insert into firstdb.players (name,score)
values ("John Smith",80);

select * from firstdb.players;
