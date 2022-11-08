select concat(Firstname,' ',Lastname) 'Name', grade, mark
from firstdb.students
where grade = 'D' and mark <= 80;