select concat(Firstname,' ',Lastname) 'Name', grade, mark
from firstdb.students
where grade = 'HD'
order by mark desc;