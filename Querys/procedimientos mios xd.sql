CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_I_TRANSACTION`(PTypeF int, PTypeM int,PUser int, PTransactionCod int,PCliente varchar(45), PAmount double)
BEGIN
insert into transaction (transaction_type_id, payment_method_id, user_id, transaction_cod, Cliente, transaction_date,amount_transaction) values (
PTypeF,PTypeM,PUser,PTransactionCod,PCliente,curdate(),PAmount);
END
-------------------------------------------------------------------------------------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_I_TRANSACTIOND`(PTID int, PQUANT double,PDesc varchar(200),PUnit_p double,PIva double, PAmount double,PInvoice int )
BEGIN
insert into transacction_detail (transaction_id,quantity,description,unit_price,iva,amount,I_invoice_type) values(PTID,PQUANT,PDesc,PUnit_p,PIva,Pamount,PInvoice);
END

----------------------------------------------------------------------------------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_S_FACTURA`(PNIC INT, PTDF VARCHAR(45))
BEGIN
select * from factura_datos where id_invoice = PTDF And NIC = PNIC;
END

------------------------------------------------------------------------------------------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_S_METODOS`()
BEGIN
select * from payment_method;
END

-------------------------------------------------------------------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_S_TFACTURA`()
BEGIN
select * from invoice_type;
END

---------------------------------------------------------------------------

CREATE DEFINER=`root`@`localhost` PROCEDURE `PS_S_TRANSACTION`()
BEGIN
select *  from transaction order by id_transaction desc limit 1;
END

-----------------------------------------------------------------------