select Lastname, mark
from firstdb.students
-- where Lastname regexp '^A.*';
where Lastname like 'A%';