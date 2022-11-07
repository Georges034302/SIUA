select count(score) 'Frequency', rate 'RATING'
from firstdb.users
where score >= 50
group by rate
having rate >= 3
order by rate desc;