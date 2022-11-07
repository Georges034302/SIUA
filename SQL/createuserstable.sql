create table if not exists firstdb.users (
    ID integer primary key not null auto_increment,
    name varchar(40) not null,
    phone varchar(20) not null,
    email varchar(100) not null unique,
    score integer not null,
    rate decimal(4 , 2 ) not null
)  auto_increment=100000;