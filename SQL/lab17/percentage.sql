select grade, 
count(grade) 'Frequency',
concat('% ', round(count(*)*100/sum(count(*)) over(),2) ) 'Percentage'
-- concat('% ', round(count(*)*100/(select count(*) from firstdb.students),2) ) 'Percentage'
from firstdb.students
group by grade;