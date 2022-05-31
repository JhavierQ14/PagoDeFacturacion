CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_S_FACTURA`(PNIC INT, PTDF VARCHAR(45))
BEGIN
select * from factura_datos;
END


-----------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_S_METODOS`()
BEGIN
select * from payment_method;
END

-----------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_S_TFACTURA`()
BEGIN
select * from invoice_type;
END

------------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_S_TRANSACTION`()
BEGIN
select *  from transaction order by transaction_cod desc limit 1;
END
------------------