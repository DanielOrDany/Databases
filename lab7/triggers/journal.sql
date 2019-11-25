delimiter //
DROP trigger IF EXISTS save_employee_to_journal_after_insert; //
create trigger save_employee_to_journal_after_insert
before insert
on employee for each row
begin
   INSERT INTO journal (id, full_name, age, sex, degree, seniority) VALUES(new.id, new.full_name, new.age, new.sex, new.degree, new.seniority);
end// 
