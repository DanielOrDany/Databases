delimiter //
DROP trigger IF EXISTS employee_before_insert; //
create trigger employee_before_insert
before insert
on employee for each row
begin
	if new.age < new.seniority
	then 
		signal sqlstate '45000' set message_text = 'Employee: Trying to insert a error value in table: ';
	end if;
    
    /* EXISTS CHECKERS */
    if not EXISTS (select id from position where position.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Employee: position not exist, yet';
	end if;
    
    if not EXISTS (select id from science_position where science_position.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Employee: science_position not exist, yet';
	end if;
    
    if not EXISTS (select id from science_degree where science_degree.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Employee: science_degree not exist, yet';
	end if;
    
    if not EXISTS (select id from discipline where discipline.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Employee: discipline not exist, yet';
	end if;
end// 

delimiter //
DROP trigger IF EXISTS employee_before_update; //
create trigger employee_before_update
before update
on employee for each row
begin
    if new.age < new.seniority
	then 
		signal sqlstate '45000' set message_text = 'Employee: Trying to insert a error value in table: ';
	end if;
    
    /* EXISTS CHECKERS */
    if not EXISTS (select id from position where position.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Employee: position not exist, yet';
	end if;
    
    if not EXISTS (select id from science_position where science_position.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Employee: science_position not exist, yet';
	end if;
    
    if not EXISTS (select id from science_degree where science_degree.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Employee: science_degree not exist, yet';
	end if;
    
    if not EXISTS (select id from discipline where discipline.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Employee: discipline not exist, yet';
	end if;
end// 

delimiter //
DROP trigger IF EXISTS employee_before_delete; //
create trigger employee_before_delete
before delete
on employee for each row
begin
    /* EXISTS CHECKERS */
    if not EXISTS (select id from discipline where discipline.id = old.id)
	then 
		INSERT INTO employee (id, full_name, age, sex, degree, seniority) VALUES(old.id, old.full_name, old.age, old.sex, old.degree, old.seniority);
		signal sqlstate '45000' set message_text = 'Employee: discipline will be crashed';
	end if;
end// 
