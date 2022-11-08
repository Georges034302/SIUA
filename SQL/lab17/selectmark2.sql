select concat(Firstname,' ',Lastname) 'Name', mark
from firstdb.students
-- where mark >= 50 and mark <= 75;
where mark between 50 and 75;