select name, score
from firstdb.users
where name regexp '^A.*r$'; 
/*
	Find all names starting with A
    followed by zero or many characters
    ending with r
*/
