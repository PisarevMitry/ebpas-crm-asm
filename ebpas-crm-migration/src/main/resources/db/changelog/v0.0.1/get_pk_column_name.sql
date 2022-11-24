CREATE OR REPLACE FUNCTION get_pk_column_name(IN schema_name TEXT, IN table_name TEXT) RETURNS TEXT[] AS
$BODY$
BEGIN
    RETURN array(SELECT c.column_name
                 FROM information_schema.table_constraints AS pk
                          INNER JOIN information_schema.key_column_usage AS c
                                     ON c.table_name = pk.table_name AND c.constraint_name = pk.constraint_name AND
                                        c.table_schema = pk.table_schema
                 WHERE pk.table_schema = $1
                   AND pk.table_name = $2
                   AND pk.constraint_type = 'PRIMARY KEY');
END;
$BODY$ LANGUAGE plpgsql;