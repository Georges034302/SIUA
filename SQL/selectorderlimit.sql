select name, score, rate
from firstdb.users
where score >= 50
order by score desc limit 5;