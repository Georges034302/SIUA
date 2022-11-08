select concat(Firstname,' ',Lastname) 'Name', mark
from firstdb.students
where Firstname regexp '^A.*' and Lastname regexp '.*r$'
order by mark;