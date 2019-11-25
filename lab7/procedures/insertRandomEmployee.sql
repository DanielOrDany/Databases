USE ksa;

delimiter //
DROP PROCEDURE IF EXISTS copyEmployee; //
CREATE PROCEDURE copyEmployee ()
BEGIN

	DECLARE table_one VARCHAR(100) DEFAULT CONCAT('employee_one', DATE_FORMAT(NOW(), "_%d_%m_%Y_%S"));
    DECLARE table_two VARCHAR(100) DEFAULT CONCAT('employee_two', DATE_FORMAT(NOW(), "_%d_%m_%Y_%S"));

	SET @createTable1 = CONCAT("CREATE TABLE ", table_one, "(id int, some_col varchar(55))", "SELECT * FROM employee");
    SET @createTable2 = CONCAT("CREATE TABLE ", table_two, "(id int, some_col varchar(55))", "SELECT * FROM employee");
    
	PREPARE createStmt FROM @createTable1;
	EXECUTE createStmt;
	DEALLOCATE PREPARE createStmt;
    
    PREPARE createStmt FROM @createTable2;
	EXECUTE createStmt;
	DEALLOCATE PREPARE createStmt;
    
END//

CALL copyEmployee(); //