
/* PROCEDIMINETOS ALMACENADOS DE USER/*

use pago_de_facturacion_db;

/*X CREATE USER*/
CREATE PROCEDURE SP_C_USER(p_rol_id int, p_user_state_id int, p_user_name varchar(64), p_password varchar(256))
	insert into pago_de_facturacion_db.user(rol_id, user_state_id, user_name, password) values (p_rol_id, p_user_state_id, p_user_name, md5(p_password));

/*X READ USER*/
CREATE PROCEDURE SP_R_USER()
	select user.id_user, user.user_name, user.password, user_state.user_state_name, rol.rol_name from user
	inner join user_state on user.user_state_id = user_state.id_user_state
    inner join rol on user.rol_id = rol.id_rol;

/*X UPDATE USER*/
CREATE PROCEDURE SP_U_USER(p_rol_id int, p_user_state_id int, p_user_name varchar(64), p_id_user int)
	update pago_de_facturacion_db.user set rol_id = p_rol_id, user_state_id = p_user_state_id, user_name = p_user_name where id_user = p_id_user;

/*DELETE LOGIC USER*/
CREATE PROCEDURE SP_D_USER(p_id_user int)
	update pago_de_facturacion_db.user set user_state_id = 3 where id_user = p_id_user;

/*********************************************************************************************************************************************/

/*X VALIDATION USER*/
CREATE PROCEDURE SP_VALIDATION_USER(PUsername varchar(64), Ppass varchar(256))
Select user.user_name, user_state.user_state_name from user
	inner join user_state on user.User_State_id = user_state.id_User_State
where user.user_name = PUsername and user.password = Ppass;
    
/*USER ONLINE*/
CREATE PROCEDURE SP_ONLINE_USER(PUsername varchar(64))
	select user.id_user, user_state.user_state_name, rol.rol_name, user.user_name, employee.employee_name, employee.employee_lastname from employee
	inner join user on employee.user_id = user.id_user
    inner join user_state on user.user_state_id = user_state.id_user_state
    inner join rol on user.rol_id = rol.id_rol
    where user.user_name = PUsername;






call pago_de_facturacion_db.SP_I_USER(0, '', '@unab.edu.sv', '', '/image');

call pago_de_facturacion_db.SP_U_USER(0, '', '@gmail.com', '', '/image', 1);

call pago_de_facturacion_db.SP_D_USER(0);

call pago_de_facturacion_db.SP_R_USER();

insert into pago_de_facturacion_db.user(rol_id, user_state_id, user_name, email, password, perfil_image) values ('1','1', 'admin', 'admin@safe.es', md5('admin'));
