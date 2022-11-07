SELECT name, insert(email,2,length(email),'#') as Hashed
FROM firstdb.users;