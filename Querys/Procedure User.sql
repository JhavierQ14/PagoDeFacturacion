
/* PROCEDIMINETOS ALMACENADOS DE USER/*

use pago_de_facturacion_db;

/*CREATE USER*/
CREATE PROCEDURE SP_C_USER(p_rol_id int, p_user_state_id int, p_user_name varchar(64), p_email varchar(128), p_password varchar(256),p_perfil_img varchar(128))
	insert into pago_de_facturacion_db.user(rol_id, user_state_id, user_name, email, password, perfil_image) values (p_rol_id, p_user_state_id, p_user_name, p_email, md5(p_password),p_perfil_img);

/*READ USER*/
CREATE PROCEDURE SP_R_USER()
	select user.user_name, user.email, user.password, user_state.user_state_name,rol.rol_name from user
	inner join user_state on user.user_state_id = user_state.id_user_state
    inner join rol on user.rol_id = rol.id_rol;

/*UPDATE USER*/
CREATE PROCEDURE SP_U_USER(p_rol_id int, p_user_state_id int, p_user_name varchar(64), p_email varchar(64), p_password varchar(256), p_perfil_img varchar(128), p_id_user int)
	update pago_de_facturacion_db.user set rol_id = p_rol_id, user_state_id = p_user_state_id, user_name = p_user_name, email = p_email, password = p_password, perfil_image = p_perfil_img where id_user = p_id_user;

/*DELETE LOGIC USER*/
CREATE PROCEDURE SP_D_USER(p_id_user int)
	update pago_de_facturacion_db.user set user_state_id = 3 where id_user = p_id_user;

/*********************************************************************************************************************************************/

/* VALIDATION USER*/
CREATE PROCEDURE SP_VALIDATION_USER(PUsername varchar(64), PEmail varchar(64), Ppass varchar(256))
	Select *from  user where (user_name = PUsername or email= PEmail)  and password = Ppass;
    
/*USER ONLINE*/
CREATE PROCEDURE SP_ONLINE_USER(PUsername varchar(64), PEmail varchar(64))
	select user.id_user, user.user_name, user.email, employee.id_employee, employee.employee_name, employee.employee_lastname from employee
	inner join user on employee.user_id = user.id_user 
    where user.user_name = PUsername or user.email = PEmail;






call pago_de_facturacion_db.SP_I_USER(0, '', '@unab.edu.sv', '', '/image');

call pago_de_facturacion_db.SP_U_USER(0, '', '@gmail.com', '', '/image', 1);

call pago_de_facturacion_db.SP_D_USER(0);

call pago_de_facturacion_db.SP_R_USER();

insert into pago_de_facturacion_db.user(rol_id, user_state_id, user_name, email, password, perfil_image) values ('1','1', 'admin', 'admin@safe.es', md5('admin'));
