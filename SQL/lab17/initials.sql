select 
concat(substring(Firstname,1,1),'.',substring(Lastname,1,1),'.') 'Initials',
email
from firstdb.students;