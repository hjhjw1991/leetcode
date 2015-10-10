# Write your MySQL query statement below
select Name from Employee as em, (select e.Id, e.Salary es, m.Salary ms from Employee e, Employee m where e.ManagerId=m.Id) as man
where em.Id=man.Id and man.es>man.ms