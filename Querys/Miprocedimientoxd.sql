CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_TARJETABANK`(Nombre1 varchar(64), Numero_Tarjeta1 varchar(100),fecha_vencimineto1 date, CVV1 int )
BEGIN

select *from bank_card where Nombre = Nombre1 and Numero_Tarjeta = Numero_Tarjeta1 and fecha_vencimineto = fecha_vencimineto1 and CVV = CVV1;

END