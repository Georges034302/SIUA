select min(mark) 'Min', 
max(mark) 'Max',
round(avg(mark),2) 'Average'
from firstdb.students;