USE ksa;

delimiter //
DROP FUNCTION IF EXISTS findEmployeeAcceptanceForm;
CREATE FUNCTION findEmployeeAcceptanceForm(employee_id int)
RETURNS nvarchar(40)
DETERMINISTIC
BEGIN
	RETURN (SELECT name FROM acceptance_form WHERE id = employee_id);
END//

DELIMITER ;

SELECT *, ksa.findEmployeeAcceptanceForm(1) AS acceptance_form FROM employee;