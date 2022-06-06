use pago_de_facturacion_db;

/*X Employe Create*/
CREATE PROCEDURE SP_C_employee(p_user_id int, p_employee_name varchar(64), p_employee_lastname varchar(64), p_e_identification_document varchar(32), p_phone varchar(32), p_email_address varchar(64))
	insert into pago_de_facturacion_db.employee(user_id, employee_name, employee_lastname, e_identification_document, phone, email_address) values (p_user_id, p_employee_name, p_employee_lastname, p_e_identification_document, p_phone, p_email_address);


/*X Employe read*/
CREATE PROCEDURE sp_r_employe()
select employee.id_employee, employee.user_id, employee.employee_name, employee.employee_lastname, employee.e_identification_document, employee.phone, employee.email_address, user.user_name from employee
	inner join user on employee.user_id = user.id_user
    order by employee.id_employee desc;