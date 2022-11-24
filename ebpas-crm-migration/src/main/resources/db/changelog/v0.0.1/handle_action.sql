CREATE OR REPLACE FUNCTION handle_action() RETURNS TRIGGER AS
$BODY$
DECLARE
    pk      TEXT[];
    pk_size INTEGER;
BEGIN
    IF tg_op = 'INSERT' THEN
        new.action_ind = 'INSERT';
        RETURN new;
    ELSIF tg_op = 'UPDATE' THEN
        IF new.action_ind != 'DELETE' THEN
            new.action_ind = 'UPDATE';
        END IF;
        RETURN new;
    ELSIF tg_op = 'DELETE' THEN
        IF old.action_ind != 'DELETE' THEN
            pk := get_pk_column_name(tg_table_schema, tg_table_name);
            pk_size := count(pk);
            IF pk_size = 1 THEN
                EXECUTE 'UPDATE ' || tg_table_name || ' SET action_ind = ''DELETE'' WHERE ' ||
                        pk[1] || ' IN ($1.' ||
                        pk[1] || ')'
                    USING old;
                RETURN new;
            ELSIF pk_size = 2 THEN
                EXECUTE 'UPDATE ' || tg_table_name || ' SET action_ind = ''DELETE'' WHERE ' ||
                        pk[1] || ' IN ($1.' ||
                        pk[1] || ') AND '
                            || pk[2] || ' IN ($1.' ||
                        pk[2] || ')'
                    USING old;
                RETURN new;
            END IF;
        ELSE
            RETURN old;
        END IF;
    END IF;
END;
$BODY$ LANGUAGE plpgsql;