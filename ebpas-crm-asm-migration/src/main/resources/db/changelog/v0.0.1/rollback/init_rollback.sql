DROP TABLE IF EXISTS product_by_category;
DROP TABLE IF EXISTS product_photo;
DROP TABLE IF EXISTS defective_product_photo;
DROP TABLE IF EXISTS defective_product;
DROP TABLE IF EXISTS category_special_condition;
DROP TABLE IF EXISTS product_category;
DROP TABLE IF EXISTS product_special_condition;
DROP TABLE IF EXISTS available_product_special_condition;
DROP TABLE IF EXISTS client_ordered_product;
DROP TABLE IF EXISTS store_special_condition;
DROP TABLE IF EXISTS client_address;
DROP TABLE IF EXISTS client_deferred_product;
DROP TABLE IF EXISTS client_payment_method;
DROP TABLE IF EXISTS client_shopped_product;
DROP TABLE IF EXISTS available_product;
DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS client_special_condition;
DROP TABLE IF EXISTS special_condition_details;
DROP TABLE IF EXISTS special_condition_method;
DROP TABLE IF EXISTS core_order;
DROP TABLE IF EXISTS assembly_details;
DROP TABLE IF EXISTS delivery_details;
DROP TABLE IF EXISTS delivery_method;
DROP TABLE IF EXISTS payment_details;
DROP TABLE IF EXISTS payment_method;
DROP TABLE IF EXISTS return_details;
DROP TABLE IF EXISTS feedback_photo;
DROP TABLE IF EXISTS product_feedback;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS core_product;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS core_user;
DROP TABLE IF EXISTS organization_info;

DROP TABLE IF EXISTS user_info;
DROP SEQUENCE assembly_details_seq CASCADE;
DROP SEQUENCE core_product_seq CASCADE;
DROP SEQUENCE delivery_method_seq CASCADE;
DROP SEQUENCE delivery_details_seq CASCADE;
DROP SEQUENCE organization_info_seq CASCADE;
DROP SEQUENCE payment_method_seq CASCADE;
DROP SEQUENCE payment_details_seq CASCADE;
DROP SEQUENCE product_category_seq CASCADE;
DROP SEQUENCE product_photo_seq CASCADE;
DROP SEQUENCE return_details_seq CASCADE;
DROP SEQUENCE defective_product_seq CASCADE;
DROP SEQUENCE defective_product_photo_seq CASCADE;
DROP SEQUENCE special_condition_method_seq CASCADE;
DROP SEQUENCE special_condition_details_seq CASCADE;
DROP SEQUENCE store_seq CASCADE;
DROP SEQUENCE available_product_seq CASCADE;
DROP SEQUENCE user_info_seq CASCADE;
DROP SEQUENCE core_user_seq CASCADE;
DROP SEQUENCE client_seq CASCADE;
DROP SEQUENCE client_address_seq CASCADE;
DROP SEQUENCE client_payment_method_seq CASCADE;
DROP SEQUENCE core_order_seq CASCADE;
DROP SEQUENCE product_feedback_seq CASCADE;
DROP SEQUENCE feedback_photo_seq CASCADE;