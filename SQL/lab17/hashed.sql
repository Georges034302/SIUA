select concat(Firstname,' ',Lastname) 'Name',
insert(email,2,length(email),'#') as 'Hashed-Email'
from firstdb.students;
