CREATE OR REPLACE FUNCTION product_nomenclature_seq_gen()
    RETURNS VARCHAR AS
$BODY$
DECLARE
    seq_id BIGINT     := nextval('product_seq');
    type   VARCHAR(5) := 'draft';
BEGIN
    RETURN concat(type, ':', seq_id, ':', to_char(current_date, 'dd-mm-YYYY'));
END
$BODY$ LANGUAGE plpgsql;