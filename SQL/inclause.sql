select name, score
from firstdb.users
where score in (50,75,90)
order by score desc;