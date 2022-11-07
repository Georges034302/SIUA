select name, 
substring(name,1,2) Initials, 
concat(length(name),' characters') 'Name Length'
from firstdb.users;
