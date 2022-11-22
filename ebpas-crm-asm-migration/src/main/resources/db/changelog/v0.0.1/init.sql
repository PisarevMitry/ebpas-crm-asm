CREATE SEQUENCE IF NOT EXISTS assembly_details_seq;

CREATE TABLE IF NOT EXISTS assembly_details
(
    assembly_details_id BIGINT                       NOT NULL DEFAULT nextval('assembly_details_seq'),
    nsi_assembly_status BIGINT,
    create_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind          VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT assembly_details_pkey
        PRIMARY KEY (assembly_details_id)
);

CREATE SEQUENCE IF NOT EXISTS core_product_seq;

CREATE TABLE IF NOT EXISTS core_product
(
    core_product_id  BIGINT                       NOT NULL DEFAULT nextval('core_product_seq'),
    core_description TEXT,
    core_option      JSONB,
    product_name     VARCHAR                      NOT NULL,
    create_dttm      TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm      TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind       VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT core_product_pkey
        PRIMARY KEY (core_product_id)
);

CREATE SEQUENCE IF NOT EXISTS delivery_method_seq;

CREATE TABLE IF NOT EXISTS delivery_method
(
    delivery_method_id BIGINT                       NOT NULL DEFAULT nextval('delivery_method_seq'),
    method_name        VARCHAR                      NOT NULL,
    system_details     BYTEA,
    create_dttm        TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm        TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind         VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT delivery_method_pkey
        PRIMARY KEY (delivery_method_id)
);

CREATE SEQUENCE IF NOT EXISTS delivery_details_seq;

CREATE TABLE IF NOT EXISTS delivery_details
(
    delivery_details_id BIGINT                       NOT NULL DEFAULT nextval('delivery_details_seq'),
    delivery_notes      VARCHAR,
    nsi_address_id      BIGINT,
    nsi_delivery_status BIGINT,
    start_delivery_dttm TIMESTAMP WITH TIME ZONE,
    end_delivery_dttm   TIMESTAMP WITH TIME ZONE,
    delivery_method_id  BIGINT                       NOT NULL,
    create_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind          VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT delivery_details_pkey
        PRIMARY KEY (delivery_details_id)

);

ALTER TABLE IF EXISTS delivery_details
    ADD CONSTRAINT payment_details_delivery_method_fkey
        FOREIGN KEY (delivery_method_id) REFERENCES delivery_method;

CREATE SEQUENCE IF NOT EXISTS organization_info_seq;

CREATE TABLE IF NOT EXISTS organization_info
(
    organization_info_id BIGINT                       NOT NULL DEFAULT nextval('organization_info_seq'),
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT organization_info_pkey
        PRIMARY KEY (organization_info_id)
);

CREATE SEQUENCE IF NOT EXISTS payment_method_seq;

CREATE TABLE IF NOT EXISTS payment_method
(
    payment_method_id BIGINT                       NOT NULL DEFAULT nextval('payment_method_seq'),
    method_name       VARCHAR,
    system_details    BYTEA,
    create_dttm       TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm       TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind        VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT payment_method_pkey
        PRIMARY KEY (payment_method_id)
);

CREATE SEQUENCE IF NOT EXISTS payment_details_seq;

CREATE TABLE IF NOT EXISTS payment_details
(
    payment_details_id BIGINT                       NOT NULL DEFAULT nextval('payment_details_seq'),
    nsi_payment_status BIGINT,
    system_details     BYTEA,
    payment_method_id  BIGINT                       NOT NULL,
    create_dttm        TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm        TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind         VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT payment_details_pkey
        PRIMARY KEY (payment_details_id)
);

ALTER TABLE IF EXISTS payment_details
    ADD CONSTRAINT payment_details_payment_method_fkey
        FOREIGN KEY (payment_method_id) REFERENCES payment_method;

CREATE TABLE IF NOT EXISTS product
(
    product_id           BIGINT                       NOT NULL DEFAULT nextval('product_seq'),
    product_nomenclature VARCHAR     DEFAULT product_nomenclature_seq_gen(),
    blocked_status       BOOLEAN     DEFAULT FALSE    NOT NULL,
    description          TEXT,
    option               JSONB,
    core_product_id      BIGINT                       NOT NULL,
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT product_pkey
        PRIMARY KEY (product_id)
);

ALTER TABLE IF EXISTS product
    ADD CONSTRAINT product_core_product_fkey
        FOREIGN KEY (core_product_id) REFERENCES core_product;

CREATE SEQUENCE IF NOT EXISTS product_category_seq;

CREATE TABLE IF NOT EXISTS product_category
(
    product_category_id   BIGINT                       NOT NULL DEFAULT nextval('product_category_seq'),
    product_category_name VARCHAR,
    parent_id             BIGINT,
    create_dttm           TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm           TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind            VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT product_category_pkey
        PRIMARY KEY (product_category_id)
);

ALTER TABLE IF EXISTS product_category
    ADD CONSTRAINT product_category_fkey
        FOREIGN KEY (parent_id) REFERENCES product_category;

CREATE TABLE IF NOT EXISTS product_by_category
(
    product_id          BIGINT                       NOT NULL,
    product_category_id BIGINT                       NOT NULL,
    create_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind          VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT product_by_category_pkey
        PRIMARY KEY (product_id, product_category_id)
);

ALTER TABLE IF EXISTS product_by_category
    ADD CONSTRAINT product_by_category_fkey
        FOREIGN KEY (product_category_id) REFERENCES product_category,
    ADD CONSTRAINT product_by_category_product_fkey
        FOREIGN KEY (product_id) REFERENCES product;

CREATE SEQUENCE IF NOT EXISTS product_photo_seq;

CREATE TABLE IF NOT EXISTS product_photo
(
    product_photo_id BIGINT                       NOT NULL DEFAULT nextval('product_photo_seq'),
    nsi_media_id     BIGINT,
    product_id       BIGINT                       NOT NULL,
    create_dttm      TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm      TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind       VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT product_photo_pkey
        PRIMARY KEY (product_photo_id)
);

ALTER TABLE IF EXISTS product_photo
    ADD CONSTRAINT product_photo_product_fkey
        FOREIGN KEY (product_id) REFERENCES product;

CREATE SEQUENCE IF NOT EXISTS return_details_seq;

CREATE TABLE IF NOT EXISTS return_details
(
    return_details_id      BIGINT                       NOT NULL DEFAULT nextval('return_details_seq'),
    nsi_return_reason      BIGINT,
    nsi_return_requirement BIGINT,
    nsi_return_status      BIGINT,
    system_details         BYTEA,
    create_dttm            TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm            TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind             VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT return_details_pkey
        PRIMARY KEY (return_details_id)
);

CREATE SEQUENCE IF NOT EXISTS defective_product_seq;

CREATE TABLE IF NOT EXISTS defective_product
(
    defective_product_id BIGINT                       NOT NULL DEFAULT nextval('defective_product_seq'),
    defect_description   VARCHAR,
    receiving_status     BOOLEAN,
    system_details       BYTEA,
    product_id           BIGINT                       NOT NULL,
    return_details_id    BIGINT                       NOT NULL,
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT defective_product_pkey
        PRIMARY KEY (defective_product_id)
);

ALTER TABLE IF EXISTS defective_product
    ADD CONSTRAINT defective_product_product_fkey
        FOREIGN KEY (product_id) REFERENCES product,
    ADD CONSTRAINT defective_product_return_details_fkey
        FOREIGN KEY (return_details_id) REFERENCES return_details;

CREATE SEQUENCE IF NOT EXISTS defective_product_photo_seq;

CREATE TABLE IF NOT EXISTS defective_product_photo
(
    defective_product_photo_id BIGINT                       NOT NULL DEFAULT nextval('defective_product_photo_seq'),
    nsi_media_id               BIGINT,
    defective_product_id       BIGINT                       NOT NULL,
    create_dttm                TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm                TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind                 VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT defective_product_photo_pkey
        PRIMARY KEY (defective_product_photo_id)
);

ALTER TABLE IF EXISTS defective_product_photo
    ADD CONSTRAINT defective_product_photo_defective_product_fkey
        FOREIGN KEY (defective_product_id) REFERENCES defective_product;

CREATE SEQUENCE IF NOT EXISTS special_condition_method_seq;

CREATE TABLE IF NOT EXISTS special_condition_method
(
    special_condition_method_id BIGINT                       NOT NULL DEFAULT nextval('special_condition_method_seq'),
    method_name                 VARCHAR,
    system_details              BYTEA,
    create_dttm                 TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm                 TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind                  VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT special_condition_method_pkey
        PRIMARY KEY (special_condition_method_id)
);

CREATE SEQUENCE IF NOT EXISTS special_condition_details_seq;

CREATE TABLE IF NOT EXISTS special_condition_details
(
    special_condition_details_id BIGINT                       NOT NULL DEFAULT nextval('special_condition_details_seq'),
    blocked_status               BOOLEAN,
    condition_description        VARCHAR,
    display_status               BOOLEAN,
    end_condition_dttm           TIMESTAMP,
    start_condition_dttm         TIMESTAMP,
    system_details               BYTEA,
    special_condition_method_id  BIGINT                       NOT NULL,
    create_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind                   VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT special_condition_details_pkey
        PRIMARY KEY (special_condition_details_id)
);

ALTER TABLE IF EXISTS special_condition_details
    ADD CONSTRAINT special_condition_details_special_condition_method_fkey
        FOREIGN KEY (special_condition_method_id) REFERENCES special_condition_method;

CREATE TABLE IF NOT EXISTS category_special_condition
(
    product_category_id          BIGINT                       NOT NULL,
    special_condition_details_id BIGINT                       NOT NULL,
    create_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind                   VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT category_special_condition_pkey
        PRIMARY KEY (product_category_id, special_condition_details_id)
);

ALTER TABLE IF EXISTS category_special_condition
    ADD CONSTRAINT category_special_condition_special_condition_details_fkey
        FOREIGN KEY (special_condition_details_id) REFERENCES special_condition_details,
    ADD CONSTRAINT category_special_condition_product_category_fkey
        FOREIGN KEY (product_category_id) REFERENCES product_category;

CREATE TABLE IF NOT EXISTS product_special_condition
(
    product_id                   BIGINT                       NOT NULL,
    special_condition_details_id BIGINT                       NOT NULL,
    create_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind                   VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT product_special_condition_pkey
        PRIMARY KEY (product_id, special_condition_details_id)
);

ALTER TABLE IF EXISTS product_special_condition
    ADD CONSTRAINT product_special_condition_special_condition_details_fkey
        FOREIGN KEY (special_condition_details_id) REFERENCES special_condition_details,
    ADD CONSTRAINT product_special_condition_product_fkey
        FOREIGN KEY (product_id) REFERENCES product;

CREATE SEQUENCE IF NOT EXISTS store_seq;

CREATE TABLE IF NOT EXISTS store
(
    store_id            BIGINT                       NOT NULL DEFAULT nextval('store_seq'),
    availability_status BOOLEAN,
    store_name          VARCHAR,
    nsi_address_id      BIGINT,
    pickup_status       BOOLEAN,
    create_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind          VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT store_pkey
        PRIMARY KEY (store_id)
);

CREATE SEQUENCE IF NOT EXISTS available_product_seq;

CREATE TABLE IF NOT EXISTS available_product
(
    available_product_id BIGINT                       NOT NULL DEFAULT nextval('available_product_seq'),
    amount_total         INTEGER,
    blocked_total        INTEGER,
    price_unit           BIGINT,
    product_id           BIGINT                       NOT NULL,
    store_id             BIGINT                       NOT NULL,
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT available_product_pkey
        PRIMARY KEY (available_product_id)
);

ALTER TABLE IF EXISTS available_product
    ADD CONSTRAINT available_product_product_fkey
        FOREIGN KEY (product_id) REFERENCES product,
    ADD CONSTRAINT available_product_store_fkey
        FOREIGN KEY (store_id) REFERENCES store;

CREATE TABLE IF NOT EXISTS available_product_special_condition
(
    available_product_id         BIGINT                       NOT NULL,
    special_condition_details_id BIGINT                       NOT NULL,
    create_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind                   VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT available_product_special_condition_pkey
        PRIMARY KEY (available_product_id, special_condition_details_id)
);

ALTER TABLE IF EXISTS available_product_special_condition
    ADD CONSTRAINT available_product_sp_condition_special_condition_details_fkey
        FOREIGN KEY (special_condition_details_id) REFERENCES special_condition_details,
    ADD CONSTRAINT available_product_special_condition_available_product_fkey
        FOREIGN KEY (available_product_id) REFERENCES available_product;

CREATE TABLE IF NOT EXISTS client_ordered_product
(
    assembly_details_id  BIGINT                       NOT NULL,
    available_product_id BIGINT                       NOT NULL,
    amount_total         INTEGER,
    price_unit           BIGINT,
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT client_ordered_product_pkey
        PRIMARY KEY (assembly_details_id, available_product_id)
);

ALTER TABLE IF EXISTS client_ordered_product
    ADD CONSTRAINT client_ordered_product_assembly_details_fkey
        FOREIGN KEY (assembly_details_id) REFERENCES assembly_details,
    ADD CONSTRAINT client_ordered_product_available_product_fkey
        FOREIGN KEY (available_product_id) REFERENCES available_product;

CREATE TABLE IF NOT EXISTS store_special_condition
(
    store_id                     BIGINT                       NOT NULL,
    special_condition_details_id BIGINT                       NOT NULL,
    create_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind                   VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT store_special_condition_pkey
        PRIMARY KEY (store_id, special_condition_details_id)
);

ALTER TABLE IF EXISTS store_special_condition
    ADD CONSTRAINT store_special_condition_special_condition_details_fkey
        FOREIGN KEY (special_condition_details_id) REFERENCES special_condition_details,
    ADD CONSTRAINT store_special_condition_store_fkey
        FOREIGN KEY (store_id) REFERENCES store;

CREATE SEQUENCE IF NOT EXISTS user_info_seq;

CREATE TABLE IF NOT EXISTS user_info
(
    user_info_id BIGINT                       NOT NULL DEFAULT nextval('user_info_seq'),
    first_name   VARCHAR,
    mail         VARCHAR,
    middle_name  VARCHAR,
    phone_number VARCHAR(19),
    second_name  VARCHAR,
    create_dttm  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind   VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT user_info_pkey
        PRIMARY KEY (user_info_id)
);

CREATE SEQUENCE IF NOT EXISTS core_user_seq;

CREATE TABLE IF NOT EXISTS core_user
(
    core_user_id         BIGINT                       NOT NULL DEFAULT nextval('core_user_seq'),
    blocked_status       BOOLEAN     DEFAULT FALSE,
    organization_info_id BIGINT                       NOT NULL,
    user_info_id         BIGINT                       NOT NULL,
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT core_user_pkey
        PRIMARY KEY (core_user_id)
);

ALTER TABLE IF EXISTS core_user
    ADD CONSTRAINT core_user_organization_info_fkey
        FOREIGN KEY (organization_info_id) REFERENCES organization_info,
    ADD CONSTRAINT core_user_user_info_fkey
        FOREIGN KEY (user_info_id) REFERENCES user_info;

CREATE SEQUENCE IF NOT EXISTS client_seq;

CREATE TABLE IF NOT EXISTS client
(
    client_id    BIGINT                       NOT NULL DEFAULT nextval('client_seq'),
    core_user_id BIGINT                       NOT NULL,
    create_dttm  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm  TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind   VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT client_pkey
        PRIMARY KEY (client_id)
);

ALTER TABLE IF EXISTS client
    ADD CONSTRAINT client_core_user_fkey
        FOREIGN KEY (core_user_id) REFERENCES core_user;

CREATE SEQUENCE IF NOT EXISTS client_address_seq;

CREATE TABLE IF NOT EXISTS client_address
(
    client_address_id    BIGINT                       NOT NULL DEFAULT nextval('client_address_seq'),
    default_using_status BOOLEAN     DEFAULT FALSE,
    display_status       BOOLEAN     DEFAULT TRUE,
    nsi_address_id       BIGINT,
    client_id            BIGINT                       NOT NULL,
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT client_address_pkey
        PRIMARY KEY (client_address_id)
);

ALTER TABLE IF EXISTS client_address
    ADD CONSTRAINT client_address_client_fkey
        FOREIGN KEY (client_id) REFERENCES client;

CREATE TABLE IF NOT EXISTS client_deferred_product
(
    available_product_id BIGINT                       NOT NULL,
    client_id            BIGINT                       NOT NULL,
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT client_deferred_product_pkey
        PRIMARY KEY (available_product_id, client_id)
);

ALTER TABLE IF EXISTS client_deferred_product
    ADD CONSTRAINT client_deferred_product_available_product_fkey
        FOREIGN KEY (available_product_id) REFERENCES available_product,
    ADD CONSTRAINT client_deferred_product_client_fkey
        FOREIGN KEY (client_id) REFERENCES client;

CREATE SEQUENCE IF NOT EXISTS client_payment_method_seq;

CREATE TABLE IF NOT EXISTS client_payment_method
(
    client_payment_method_id BIGINT                       NOT NULL DEFAULT nextval('client_payment_method_seq'),
    blocked_status           BOOLEAN     DEFAULT FALSE,
    using_default_status     BOOLEAN     DEFAULT FALSE,
    display_status           BOOLEAN     DEFAULT TRUE,
    system_details           BYTEA,
    client_id                BIGINT                       NOT NULL,
    payment_method_id        BIGINT                       NOT NULL,
    create_dttm              TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm              TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind               VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT client_payment_method_pkey
        PRIMARY KEY (client_payment_method_id)
);

ALTER TABLE IF EXISTS client_payment_method
    ADD CONSTRAINT client_payment_method_client_fkey
        FOREIGN KEY (client_id) REFERENCES client,
    ADD CONSTRAINT client_payment_method_payment_method_fkey
        FOREIGN KEY (payment_method_id) REFERENCES payment_method;

CREATE TABLE IF NOT EXISTS client_shopped_product
(
    available_product_id BIGINT                       NOT NULL,
    client_id            BIGINT                       NOT NULL,
    amount_total         INTEGER,
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT client_shopped_product_pkey
        PRIMARY KEY (available_product_id, client_id)
);

ALTER TABLE IF EXISTS client_shopped_product
    ADD CONSTRAINT client_shopped_product_available_product_fkey
        FOREIGN KEY (available_product_id) REFERENCES available_product,
    ADD CONSTRAINT client_shopped_product_client_fkey
        FOREIGN KEY (client_id) REFERENCES client;

CREATE TABLE IF NOT EXISTS client_special_condition
(
    client_id            BIGINT                       NOT NULL,
    special_condition_id BIGINT                       NOT NULL,
    create_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind           VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT client_special_condition_pkey
        PRIMARY KEY (client_id, special_condition_id)
);

ALTER TABLE IF EXISTS client_special_condition
    ADD CONSTRAINT client_special_condition_special_condition_details_fkey
        FOREIGN KEY (special_condition_id) REFERENCES special_condition_details,
    ADD CONSTRAINT client_special_condition_client_fkey
        FOREIGN KEY (client_id) REFERENCES client;

CREATE SEQUENCE IF NOT EXISTS core_order_seq;

CREATE TABLE IF NOT EXISTS core_order
(
    core_order_id              BIGINT                       NOT NULL DEFAULT nextval('core_order_seq'),
    nsi_core_order_status      BIGINT,
    requirement_org_doc_status BOOLEAN     DEFAULT FALSE,
    assembly_details_id        BIGINT                       NOT NULL,
    client_id                  BIGINT                       NOT NULL,
    delivery_details_id        BIGINT                       NOT NULL,
    payment_details_id         BIGINT                       NOT NULL,
    return_details_id          BIGINT                       NOT NULL,
    create_dttm                TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm                TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind                 VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT core_order_pkey
        PRIMARY KEY (core_order_id)
);

ALTER TABLE IF EXISTS core_order
    ADD CONSTRAINT core_order_assembly_details_fkey
        FOREIGN KEY (assembly_details_id) REFERENCES assembly_details,
    ADD CONSTRAINT core_order_client_fkey
        FOREIGN KEY (client_id) REFERENCES client,
    ADD CONSTRAINT core_order_delivery_details_fkey
        FOREIGN KEY (delivery_details_id) REFERENCES delivery_details,
    ADD CONSTRAINT core_order_payment_details_fkey
        FOREIGN KEY (payment_details_id) REFERENCES payment_details,
    ADD CONSTRAINT core_order_return_details_fkey
        FOREIGN KEY (return_details_id) REFERENCES return_details;

CREATE SEQUENCE IF NOT EXISTS product_feedback_seq;

CREATE TABLE IF NOT EXISTS product_feedback
(
    product_feedback_id BIGINT                       NOT NULL DEFAULT nextval('product_feedback_seq'),
    description         TEXT,
    grade               SMALLINT,
    client_id           BIGINT,
    product_id          BIGINT                       NOT NULL,
    create_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind          VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT product_feedback_pkey
        PRIMARY KEY (product_feedback_id)
);

ALTER TABLE IF EXISTS product_feedback
    ADD CONSTRAINT product_feedback_client_fkey
        FOREIGN KEY (client_id) REFERENCES client,
    ADD CONSTRAINT product_feedback_product_fkey
        FOREIGN KEY (product_id) REFERENCES product;

CREATE SEQUENCE IF NOT EXISTS feedback_photo_seq;

CREATE TABLE IF NOT EXISTS feedback_photo
(
    feedback_photo_id   BIGINT                       NOT NULL DEFAULT nextval('feedback_photo_seq'),
    nsi_media_id        BIGINT,
    product_feedback_id BIGINT                       NOT NULL,
    create_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT now()    NOT NULL,
    action_ind          VARCHAR     DEFAULT 'INSERT' NOT NULL,
    CONSTRAINT feedback_photo_pkey
        PRIMARY KEY (feedback_photo_id)
);

ALTER TABLE IF EXISTS feedback_photo
    ADD CONSTRAINT feedback_photo_product_feedback_fkey
        FOREIGN KEY (product_feedback_id) REFERENCES product_feedback;

