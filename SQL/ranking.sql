select score, rate,
rank() over(partition by rate order by score) 'RANK',
dense_rank() over(partition by rate order by score) 'DENSE RANK',
row_number() over(partition by rate order by score) 'ROW NUMBER',
ntile(5) over(partition by rate order by score) 'NTILE'
from firstdb.users
where score >= 50;