select name, score, rate
from firstdb.users
where score >= 70 and rate >= 4;
-- where score >= 70 && rate >= 4;