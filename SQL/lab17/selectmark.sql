select concat(Firstname,' ',Lastname) 'Name', grade
from firstdb.students
where mark >= 50;
-- where grade in ('P','C','D','HD');