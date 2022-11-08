create table if not exists firstdb.students(
	ID integer primary key not null auto_increment,
    Firstname varchar(100) not null,
    Lastname varchar(100) unique not null,
    email varchar(100) unique not null,
    mark integer not null,
    DOB date not null
)auto_increment=100000;

alter table firstdb.students
add grade varchar(10) as (case 
								when mark >= 85 then 'HD'
								when mark >= 75 then 'D'
                                when mark >= 65 then 'C'
                                when mark >= 50 then 'P'
                                else 'Z'
						  end);