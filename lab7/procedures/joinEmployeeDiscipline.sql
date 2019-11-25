USE ksa;

delimiter //
DROP PROCEDURE IF EXISTS joinEmployeeDiscipline;
CREATE PROCEDURE joinEmployeeDiscipline(
IN id_employee int,
IN id_discipline int
)
BEGIN
IF  EXISTS(SELECT * FROM employee WHERE id = id_employee)
AND EXISTS(SELECT * FROM discipline WHERE id = id_discipline) THEN 
	INSERT INTO employee_discipline_joint(id_employee, id_discipline) VALUES (id_employee, id_discipline);
END IF;
END
//

DELIMITER ;

CALL joinEmployeeDiscipline(1, 1);
