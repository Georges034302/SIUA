select concat(Firstname,' ',Lastname) 'Name', DOB
from firstdb.students
-- where DOB between '2000-01-01' and '2000-12-31';
where year(DOB) = 2000;