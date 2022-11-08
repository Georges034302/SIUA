-- select concat(Firstname,' ',Lastname) 'Name', grade
-- from firstdb.students
-- where Firstname regexp '^A.*' and grade in ('Z','P');

set SQL_SAFE_UPDATES = 0; -- turn off safe update
delete from firstdb.students
where Firstname regexp '^A.*$' and grade = 'Z' or grade = 'P';
set SQL_SAFE_UPDATES = 1; -- turn on safe update