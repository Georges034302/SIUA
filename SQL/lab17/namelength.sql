select concat(Firstname,' ', Lastname) 'Name',
length(trim(concat(Firstname,Lastname))) 'Lenght'
from firstdb.students;