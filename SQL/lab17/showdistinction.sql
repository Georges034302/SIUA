select concat(Firstname,' ',Lastname) 'Name', grade
from firstdb.students
-- where mark >= 50 and grade ='D';
where mark >= 75 && mark < 85;