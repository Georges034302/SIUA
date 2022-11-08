select concat(Firstname,' ',Lastname) 'Name', grade
from firstdb.students
where grade in ('Z','C','HD');
-- where grade = 'C' or grade = 'Z' or grade = 'HD';