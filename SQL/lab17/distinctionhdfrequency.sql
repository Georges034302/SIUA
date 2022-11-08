select grade, count(grade) 'Frequency'
from firstdb.students
where grade in ('D','HD')
group by grade
order by grade desc;