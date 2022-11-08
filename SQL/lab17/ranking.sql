select concat(Firstname,' ',Lastname) 'Name', grade, mark,
dense_rank() over(partition by grade order by mark) 'Dense Rank',
rank() over(partition by grade order by mark) 'Rank'
from firstdb.students;
