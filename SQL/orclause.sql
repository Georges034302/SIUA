select name, email, score
from firstdb.users
where score < 40 || score >= 90;
-- where score < 40 or score >= 90;