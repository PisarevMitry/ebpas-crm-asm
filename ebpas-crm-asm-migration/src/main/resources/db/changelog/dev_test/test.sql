DELETE
FROM store
WHERE store_id = 8;

INSERT INTO store (store_id, availability_status, store_name, nsi_address_id, pickup_status)
VALUES (8, FALSE, 'Набережная 8', 32432423423423, TRUE);

UPDATE store
SET nsi_address_id=2323
WHERE store_id = 8;

DELETE
FROM store
WHERE store_id = 8;

INSERT INTO crm_asm.assembly_details (nsi_assembly_status)
VALUES (2342);

UPDATE crm_asm.assembly_details
SET nsi_assembly_status=2323
WHERE assembly_details_id = 69;

DELETE
FROM assembly_details
WHERE assembly_details_id = 52;

SELECT c[1]
FROM get_pk_column_name('crm_asm', 'store') c;

SELECT ARRAY []::VARCHAR[]
FROM array(SELECT c.column_name
           FROM information_schema.table_constraints AS pk
                    INNER JOIN information_schema.key_column_usage AS c
                               ON c.table_name = pk.table_name AND c.constraint_name = pk.constraint_name AND
                                  c.table_schema = pk.table_schema
           WHERE pk.table_schema = 'crm_asm'
             AND pk.table_name = 'store'
             AND pk.constraint_type = 'PRIMARY KEY');



INSERT INTO product ("blocked_status", "description", "core_product_id")
VALUES (FALSE, NULL, 43)
