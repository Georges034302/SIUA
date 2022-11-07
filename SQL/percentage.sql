select name, score, concat(rate*20,'%') Percentage
from firstdb.users
where score >= 50;