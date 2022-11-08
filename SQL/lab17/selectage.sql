select email, DOB
from firstdb.students
where DOB <= '2001-01-01';
-- where DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(), DOB)), '%Y') > 21;
-- where year(DOB) < 2001;