select 
count(score) 'Count Scores' , 
round(avg(score),2) 'Average Score',
min(score) 'Minimum Score',
max(score) 'Maximum Score',
now() 'Current Date'
from firstdb.users;