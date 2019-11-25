USE ksa;

delimiter //
DROP FUNCTION IF EXISTS avgSeniority;
CREATE FUNCTION avgSeniority() 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT avg(seniority) FROM employee);
END //

DELIMITER ;

SELECT avgSeniority();