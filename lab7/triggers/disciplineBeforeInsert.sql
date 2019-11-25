delimiter //
DROP trigger IF EXISTS discipline_before_insert; //
create trigger discipline_before_insert
before insert
on discipline for each row
begin
	if new.semester NOT BETWEEN 1 AND 10
	then 
		signal sqlstate '45000' set message_text = 'Discipline: Trying to insert a error value in table: ';
	end if;
    
    if not EXISTS (select id from employee where employee.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Discipline: employee not exist, yet';
	end if;
    
    if not EXISTS (select id from acceptance_form where acceptance_form.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Discipline: acceptance_form not exist, yet';
	end if;
end// 

delimiter //
DROP trigger IF EXISTS discipline_before_update; //
create trigger discipline_before_update
before update
on discipline for each row
begin
	if new.semester NOT BETWEEN 1 AND 10
	then 
		signal sqlstate '45000' set message_text = 'Discipline: Trying to insert a error value in table: ';
	end if;
    
    if not EXISTS (select id from employee where employee.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Discipline: employee not exist, yet';
	end if;
    
    if not EXISTS (select id from acceptance_form where acceptance_form.id = new.id)
	then 
		signal sqlstate '45000' set message_text = 'Discipline: acceptance_form not exist, yet';
	end if;
end// 

delimiter //
DROP trigger IF EXISTS discipline_before_delete; //
create trigger discipline_before_delete
before delete
on discipline for each row
begin
    if not EXISTS (select id from employee where employee.id = old.id)
	then 
		INSERT INTO discipline (id, name, type, semester) VALUES(old.id, old.name, old.type, old.semester);
		signal sqlstate '45000' set message_text = 'Discipline: employee will be crashed';
	end if;
end// 
