CREATE OR REPLACE TRIGGER handle_action_on_assembly_details
    BEFORE DELETE OR UPDATE OR INSERT
    ON assembly_details
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_available_product
    BEFORE DELETE OR UPDATE OR INSERT
    ON available_product
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_client_address
    BEFORE DELETE OR UPDATE OR INSERT
    ON client_address
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_client_deferred_product
    BEFORE DELETE OR UPDATE OR INSERT
    ON client_deferred_product
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_client
    BEFORE DELETE OR UPDATE OR INSERT
    ON client
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_client_ordered_product
    BEFORE DELETE OR UPDATE OR INSERT
    ON client_ordered_product
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_client_payment_method
    BEFORE DELETE OR UPDATE OR INSERT
    ON client_payment_method
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_client_shopped_product
    BEFORE DELETE OR UPDATE OR INSERT
    ON client_shopped_product
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_core_order
    BEFORE DELETE OR UPDATE OR INSERT
    ON core_order
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_core_product
    BEFORE DELETE OR UPDATE OR INSERT
    ON
        core_product
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_core_user
    BEFORE DELETE OR UPDATE OR INSERT
    ON core_user
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_defective_product
    BEFORE DELETE OR UPDATE OR INSERT
    ON defective_product
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_defective_product_photo
    BEFORE DELETE OR UPDATE OR INSERT
    ON defective_product_photo
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_delivery_details
    BEFORE DELETE OR UPDATE OR INSERT
    ON delivery_details
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_delivery_type
    BEFORE DELETE OR UPDATE OR INSERT
    ON delivery_method
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_feedback_photo
    BEFORE DELETE OR UPDATE OR INSERT
    ON feedback_photo
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_organization_info
    BEFORE DELETE OR UPDATE OR INSERT
    ON organization_info
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_payment_details
    BEFORE DELETE OR UPDATE OR INSERT
    ON payment_details
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_payment_type
    BEFORE DELETE OR UPDATE OR INSERT
    ON payment_method
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_product_category
    BEFORE DELETE OR UPDATE OR INSERT
    ON product_category
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_product
    BEFORE DELETE OR UPDATE OR INSERT
    ON product
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_product_feedback
    BEFORE DELETE OR UPDATE OR INSERT
    ON product_feedback
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_product_photo
    BEFORE DELETE OR UPDATE OR INSERT
    ON product_photo
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_return_details
    BEFORE DELETE OR UPDATE OR INSERT
    ON return_details
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_special_condition_type
    BEFORE DELETE OR UPDATE OR INSERT
    ON special_condition_method
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_store
    BEFORE DELETE OR UPDATE OR INSERT
    ON store
    FOR EACH ROW
EXECUTE FUNCTION handle_action();

CREATE OR REPLACE TRIGGER handle_action_on_user_info
    BEFORE DELETE OR UPDATE OR INSERT
    ON user_info
    FOR EACH ROW
EXECUTE FUNCTION handle_action();