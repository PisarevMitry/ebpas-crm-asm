CREATE OR REPLACE PROCEDURE remove_deleted_assembly_details()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.assembly_details
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_available_product()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.available_product
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_client_address()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.client_address
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_client_deferred_product()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.client_deferred_product
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_client()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.client
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_client_ordered_product()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.client_ordered_product
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_client_payment_method()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.client_payment_method
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_client_shopped_product()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.client_shopped_product
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_core_order()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.core_order
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_core_product()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.core_product
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_core_special_condition()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.payment_method
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_core_user()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.core_user
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_defective_product()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.defective_product
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_defective_product_photo()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.defective_product_photo
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_delivery_details()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.delivery_details
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_delivery_type()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.payment_method
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_feedback_photo()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.feedback_photo
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_organization_info()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.organization_info
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_payment_details()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.payment_details
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_payment_type()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.payment_method
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_product_category()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.product_category
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_product()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.product
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_product_feedback()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.product_feedback
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_product_photo()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.product_photo
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_return_details()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.return_details
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_special_condition_method()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.special_condition_method
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_store()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.store
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

CREATE OR REPLACE PROCEDURE remove_deleted_user_info()
    LANGUAGE plpgsql AS
$BODY$
BEGIN
    DELETE
    FROM crm_asm.user_info
    WHERE modify_dttm < current_timestamp - INTERVAL '365 days'
      AND action_ind = 'D';
END;
$BODY$;

