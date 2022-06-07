CREATE PROCEDURE PS_I_TRANSACTION(PTypeF int, PTypeM int,PUser int, PTransactionCod int,PCliente varchar(45), PAmount double)
	insert into transaction (transaction_type_id, payment_method_id, user_id, transaction_cod, Cliente, transaction_date,amount_transaction) values (
	PTypeF,PTypeM,PUser,PTransactionCod,PCliente,curdate(),PAmount);
-------------------------------------------------------------------------------------------

CREATE PROCEDURE `PS_I_TRANSACTIOND`(PTID int, PQUANT double,PDesc varchar(200),PUnit_p double,PIva double, PAmount double,PInvoice int )
insert into transacction_detail (transaction_id,quantity,description,unit_price,iva,amount,I_invoice_type) values(PTID,PQUANT,PDesc,PUnit_p,PIva,Pamount,PInvoice);


----------------------------------------------------------------------------------------

CREATE PROCEDURE `PS_S_FACTURA`(PNIC INT, PTDF VARCHAR(45))
select * from factura_datos where id_invoice = PTDF And NIC = PNIC;

------------------------------------------------------------------------------------------------

CREATE PROCEDURE `PS_S_METODOS`()
select * from payment_method;

-------------------------------------------------------------------------

CREATE PROCEDURE `PS_S_TFACTURA`()
select * from invoice_type;

---------------------------------------------------------------------------

CREATE PROCEDURE `PS_S_TRANSACTION`()
select *  from transaction order by id_transaction desc limit 1;

-----------------------------------------------------------------------
CREATE PROCEDURE `PS_D_FACTURA`(PNIC int, PTDF int)
Delete from factura_datos where NIC = PNIC and Id_invoice = PTDF  limit 4;