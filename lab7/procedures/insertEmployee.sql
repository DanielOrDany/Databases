USE ksa;

delimiter //
DROP PROCEDURE IF EXISTS insertEmployee;
CREATE PROCEDURE insertEmployee(
IN fullName nvarchar(30),
IN age int,
IN sex nvarchar(15),
IN degree nvarchar(40))
BEGIN
INSERT INTO employee (full_name, age, sex, degree) VALUES (fullName, age, sex, degree);
END
//

DELIMITER ;

CALL insertEmployee('Павельчак Володимир', 21, 'man','pro');