INSERT INTO store (store_id, availability_status, store_name, nsi_address_id, pickup_status)
VALUES (843, FALSE, 'Набережная 8', 32432423423423, TRUE);

UPDATE store
SET nsi_address_id=2323
WHERE store_id = 843;

DELETE
FROM store
WHERE store_id = 843;

INSERT INTO crm_asm.assembly_details (nsi_assembly_status)
VALUES (2342);

UPDATE crm_asm.assembly_details
SET nsi_assembly_status=2323
WHERE assembly_details_id = 1;

SELECT c[1]
FROM get_pk_column_name('crm_asm', 'store') c;

SELECT c.column_name
FROM information_schema.table_constraints AS pk
         INNER JOIN information_schema.key_column_usage AS c
                    ON c.table_name = pk.table_name AND c.constraint_name = pk.constraint_name AND
                       c.table_schema = pk.table_schema
WHERE pk.table_schema = 'crm_asm'
  AND pk.table_name = 'store'
  AND pk.constraint_type = 'PRIMARY KEY';

INSERT INTO product ("blocked_status", "description", "core_product_id")
VALUES (FALSE, NULL, 43);

select p.product_nomenclature, (count(*) - count(dp.product_id)) as "count"
from core_order co
         left join client_ordered_product cop on co.assembly_details_id = cop.assembly_details_id
         left join available_product ap on cop.available_product_id = ap.available_product_id
         left join product p on ap.product_id = p.product_id
         left join return_details rd on co.return_details_id = rd.return_details_id
         left join defective_product dp on rd.return_details_id = dp.return_details_id
where ap.store_id = 13
group by p.product_nomenclature
order by count desc;

delete
from core_order
where core_order_id = 1;

select *
from core_order
where core_order_id in (1, 2, 3, 4)



