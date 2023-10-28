CREATE SCHEMA client;
CREATE SCHEMA delivery;
CREATE SCHEMA discount;
CREATE SCHEMA "order";
CREATE SCHEMA payment;
CREATE SCHEMA product;
CREATE SCHEMA contractor;

CREATE TABLE IF NOT EXISTS product.payment_method
(
    payment_method_id BIGSERIAL
        CONSTRAINT payment_method_pkey
            PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    method_name       VARCHAR(255),
    system_details    BYTEA,
    create_dttm       TIMESTAMPTZ  DEFAULT NOW()                  NOT NULL,
    modify_dttm       TIMESTAMPTZ  DEFAULT NOW()                  NOT NULL,
    action_ind        VARCHAR(255) DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS contractor.organization_info
(
    organization_info_id BIGSERIAL
        CONSTRAINT organization_info_pkey
            PRIMARY KEY,
    create_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind           VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS contractor.user_info
(
    user_info_id BIGSERIAL
        CONSTRAINT user_info_pkey
            PRIMARY KEY,
    first_name   VARCHAR(255)                               NOT NULL,
    mail         VARCHAR(255),
    middle_name  VARCHAR(255),
    phone_number VARCHAR(19),
    second_name  VARCHAR(255)                               NOT NULL,
    create_dttm  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind   VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS contractor.core_user
(
    core_user_id         BIGSERIAL
        CONSTRAINT core_user_pkey
            PRIMARY KEY,
    blocked_status       BOOLEAN     DEFAULT FALSE                  NOT NULL,
    organization_info_id BIGINT                                     NOT NULL
        CONSTRAINT core_user_organization_info_id_fkey
            REFERENCES contractor.organization_info,
    user_info_id         BIGINT                                     NOT NULL
        CONSTRAINT core_user_user_info_id_fkey
            REFERENCES contractor.user_info,
    create_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind           VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS client.client
(
    client_id    BIGSERIAL
        CONSTRAINT client_pkey
            PRIMARY KEY,
    core_user_id BIGINT                                     NOT NULL
        CONSTRAINT client_core_user_id_fkey
            REFERENCES contractor.core_user,
    create_dttm  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind   VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS client.client_address
(
    client_id            BIGINT                                     NOT NULL
        CONSTRAINT client_address_client_id_fkey
            REFERENCES client.client,
    nsi_address_id       BIGINT                                     NOT NULL,
    default_using_status BOOLEAN     DEFAULT FALSE                  NOT NULL,
    display_status       BOOLEAN     DEFAULT TRUE                   NOT NULL,
    create_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind           VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT client_address_pkey
        PRIMARY KEY (client_id, nsi_address_id)
)
;

CREATE TABLE IF NOT EXISTS delivery.delivery_method
(
    delivery_method_id BIGSERIAL
        CONSTRAINT delivery_method_pkey
            PRIMARY KEY,
    method_name        VARCHAR(255)                               NOT NULL,
    system_details     BYTEA,
    create_dttm        TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm        TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind         VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS discount.special_condition_method
(
    special_condition_method_id BIGSERIAL
        CONSTRAINT special_condition_method_pkey
            PRIMARY KEY,
    method_name                 VARCHAR(255),
    system_details              BYTEA,
    create_dttm                 TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm                 TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind                  VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS discount.special_condition_details
(
    special_condition_details_id BIGSERIAL
        CONSTRAINT special_condition_details_pkey
            PRIMARY KEY,
    special_condition_method_id  BIGINT                                     NOT NULL
        CONSTRAINT special_condition_details_special_condition_method_id_fkey
            REFERENCES discount.special_condition_method,
    blocked_status               BOOLEAN                                    NOT NULL,
    description                  VARCHAR(255),
    display_status               BOOLEAN                                    NOT NULL,
    end_condition_dttm           TIMESTAMP(6),
    start_condition_dttm         TIMESTAMP(6),
    system_details               BYTEA,
    create_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind                   VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS discount.client_special_condition
(
    client_id            BIGINT                                     NOT NULL
        CONSTRAINT client_special_condition_client_id_fkey
            REFERENCES client.client,
    special_condition_id BIGINT                                     NOT NULL
        CONSTRAINT client_special_condition_special_condition_id_fkey
            REFERENCES discount.special_condition_details,
    create_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind           VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT client_special_condition_pkey
        PRIMARY KEY (client_id, special_condition_id)
)
;

CREATE TABLE IF NOT EXISTS "order".assembly_details
(
    assembly_details_id BIGSERIAL
        CONSTRAINT assembly_details_pkey
            PRIMARY KEY,
    nsi_assembly_status BIGINT                                     NOT NULL,
    create_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind          VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS "order".delivery_details
(
    delivery_details_id BIGSERIAL
        CONSTRAINT delivery_details_pkey
            PRIMARY KEY,
    delivery_notes      VARCHAR(255),
    nsi_address_id      BIGINT                                     NOT NULL,
    nsi_delivery_status BIGINT                                     NOT NULL,
    start_delivery_dttm TIMESTAMP(6) WITH TIME ZONE,
    end_delivery_dttm   TIMESTAMP(6) WITH TIME ZONE,
    delivery_method_id  BIGINT                                     NOT NULL
        CONSTRAINT delivery_details_delivery_method_id_fkey
            REFERENCES delivery.delivery_method,
    create_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind          VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS "order".return_details
(
    return_details_id      BIGSERIAL
        CONSTRAINT return_details_pkey
            PRIMARY KEY,
    nsi_return_reason      BIGINT                                     NOT NULL,
    nsi_return_requirement BIGINT                                     NOT NULL,
    nsi_return_status      BIGINT                                     NOT NULL,
    system_details         BYTEA,
    create_dttm            TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm            TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind             VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS payment.payment_method
(
    payment_method_id BIGSERIAL
        CONSTRAINT payment_method_pkey
            PRIMARY KEY,
    method_name       VARCHAR(255),
    system_details    BYTEA,
    create_dttm       TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm       TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind        VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS client.client_payment_method
(
    client_id            BIGINT                                     NOT NULL
        CONSTRAINT client_payment_method_client_id_fkey
            REFERENCES client.client,
    payment_method_id    BIGINT                                     NOT NULL
        CONSTRAINT client_payment_method_payment_method_id_fkey
            REFERENCES payment.payment_method,
    blocked_status       BOOLEAN     DEFAULT FALSE                  NOT NULL,
    using_default_status BOOLEAN     DEFAULT FALSE                  NOT NULL,
    display_status       BOOLEAN     DEFAULT TRUE                   NOT NULL,
    system_details       BYTEA,
    create_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind           VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT client_payment_method_pkey
        PRIMARY KEY (client_id, payment_method_id)
)
;

CREATE TABLE IF NOT EXISTS "order".payment_details
(
    payment_details_id BIGSERIAL
        CONSTRAINT payment_details_pkey
            PRIMARY KEY,
    payment_method_id  BIGINT                                     NOT NULL
        CONSTRAINT payment_details_payment_method_id_fkey
            REFERENCES payment.payment_method,
    nsi_payment_status BIGINT,
    system_details     BYTEA,
    create_dttm        TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm        TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind         VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS "order".core_order
(
    core_order_id              BIGSERIAL
        CONSTRAINT core_order_pkey
            PRIMARY KEY,
    nsi_core_order_status      BIGINT                                     NOT NULL,
    requirement_org_doc_status BOOLEAN     DEFAULT FALSE                  NOT NULL,
    assembly_details_id        BIGINT                                     NOT NULL
        CONSTRAINT core_order_assembly_details_id_fkey
            REFERENCES "order".assembly_details,
    client_id                  BIGINT                                     NOT NULL
        CONSTRAINT core_order_client_id_fkey
            REFERENCES client.client,
    delivery_details_id        BIGINT                                     NOT NULL
        CONSTRAINT core_order_delivery_details_id_fkey
            REFERENCES "order".delivery_details,
    payment_details_id         BIGINT                                     NOT NULL
        CONSTRAINT core_order_payment_details_id_fkey
            REFERENCES "order".payment_details,
    return_details_id          BIGINT                                     NOT NULL
        CONSTRAINT core_order_return_details_id_fkey
            REFERENCES "order".return_details,
    create_dttm                TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm                TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind                 VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS product.core_product
(
    core_product_id BIGSERIAL
        CONSTRAINT core_product_pkey
            PRIMARY KEY,
    name            VARCHAR(255)                               NOT NULL
        CONSTRAINT core_product_name_key
            UNIQUE,
    description     TEXT,
    option          JSONB,
    create_dttm     TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm     TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind      VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS product.product
(
    product_id      BIGSERIAL
        CONSTRAINT product_pkey
            PRIMARY KEY,
    core_product_id BIGINT
        CONSTRAINT product_core_product_id_fkey
            REFERENCES product.core_product,
    blocked_status  BOOLEAN     DEFAULT FALSE                  NOT NULL,
    description     TEXT,
    option          JSONB,
    create_dttm     TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm     TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind      VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS client.client_deferred_product
(
    client_id   BIGINT                                     NOT NULL
        CONSTRAINT client_deferred_product_client_id_fkey
            REFERENCES client.client,
    product_id  BIGINT                                     NOT NULL
        CONSTRAINT "FKclient_def633206"
            REFERENCES product.product,
    create_dttm TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind  VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT client_deferred_product_pkey
        PRIMARY KEY (client_id, product_id)
)
;

CREATE TABLE IF NOT EXISTS discount.product_special_condition
(
    product_id                   BIGINT                                     NOT NULL
        CONSTRAINT product_special_condition_product_id_fkey
            REFERENCES product.product,
    special_condition_details_id BIGINT                                     NOT NULL
        CONSTRAINT product_special_condition_special_condition_details_id_fkey
            REFERENCES discount.special_condition_details,
    create_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind                   VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT product_special_condition_pkey
        PRIMARY KEY (product_id, special_condition_details_id)
)
;

CREATE TABLE IF NOT EXISTS "order".defective_product
(
    defective_product_id BIGSERIAL
        CONSTRAINT defective_product_pkey
            PRIMARY KEY,
    defect_description   VARCHAR(255),
    receiving_status     BOOLEAN                                    NOT NULL,
    system_details       BYTEA,
    product_id           BIGINT                                     NOT NULL
        CONSTRAINT defective_product_product_id_fkey
            REFERENCES product.product,
    return_details_id    BIGINT                                     NOT NULL
        CONSTRAINT defective_product_return_details_id_fkey
            REFERENCES "order".return_details,
    create_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind           VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS "order".defective_product_photo
(
    defective_product_photo_id BIGSERIAL
        CONSTRAINT defective_product_photo_pkey
            PRIMARY KEY,
    nsi_media_id               BIGINT                                     NOT NULL,
    defective_product_id       BIGINT                                     NOT NULL
        CONSTRAINT defective_product_photo_defective_product_id_fkey
            REFERENCES "order".defective_product,
    create_dttm                TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm                TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind                 VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS product.product_category
(
    product_category_id BIGSERIAL
        CONSTRAINT product_category_pkey
            PRIMARY KEY,
    parent_id           BIGINT
        CONSTRAINT product_category_parent_id_fkey
            REFERENCES product.product_category,
    name                VARCHAR(255)                               NOT NULL,
    create_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind          VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS discount.category_special_condition
(
    product_category_id          BIGINT                                     NOT NULL
        CONSTRAINT category_special_condition_product_category_id_fkey
            REFERENCES product.product_category,
    special_condition_details_id BIGINT                                     NOT NULL
        CONSTRAINT category_special_condition_special_condition_details_id_fkey
            REFERENCES discount.special_condition_details,
    create_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind                   VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT category_special_condition_pkey
        PRIMARY KEY (product_category_id, special_condition_details_id)
)
;

CREATE TABLE IF NOT EXISTS product.product_by_category
(
    product_id          BIGINT                                     NOT NULL
        CONSTRAINT product_by_category_product_id_fkey
            REFERENCES product.product,
    product_category_id BIGINT                                     NOT NULL
        CONSTRAINT product_by_category_product_category_id_fkey
            REFERENCES product.product_category,
    create_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind          VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT product_by_category_pkey
        PRIMARY KEY (product_id, product_category_id)
)
;

CREATE TABLE IF NOT EXISTS product.product_feedback
(
    product_feedback_id BIGSERIAL
        CONSTRAINT product_feedback_pkey
            PRIMARY KEY,
    description         TEXT,
    grade               SMALLINT,
    client_id           BIGINT
        CONSTRAINT product_feedback_client_id_fkey
            REFERENCES client.client,
    product_id          BIGINT                                     NOT NULL
        CONSTRAINT product_feedback_product_id_fkey
            REFERENCES product.product,
    create_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind          VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS product.feedback_photo
(
    feedback_photo_id   BIGSERIAL
        CONSTRAINT feedback_photo_pkey
            PRIMARY KEY,
    nsi_media_id        BIGINT,
    product_feedback_id BIGINT                                     NOT NULL
        CONSTRAINT feedback_photo_product_feedback_id_fkey
            REFERENCES product.product_feedback,
    create_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind          VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS product.product_photo
(
    product_id   BIGINT                                     NOT NULL
        CONSTRAINT product_photo_product_id_fkey
            REFERENCES product.product,
    nsi_media_id BIGINT                                     NOT NULL,
    create_dttm  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind   VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT product_photo_pkey
        PRIMARY KEY (product_id, nsi_media_id)
)
;

CREATE TABLE IF NOT EXISTS product.store
(
    store_id            BIGSERIAL
        CONSTRAINT store_pkey
            PRIMARY KEY,
    availability_status BOOLEAN                                    NOT NULL,
    store_name          VARCHAR(255)                               NOT NULL
        CONSTRAINT store_store_name_key
            UNIQUE,
    nsi_address_id      BIGINT,
    pickup_status       BOOLEAN                                    NOT NULL,
    create_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm         TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind          VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS discount.store_special_condition
(
    store_id                     BIGINT                                     NOT NULL
        CONSTRAINT store_special_condition_store_id_fkey
            REFERENCES product.store,
    special_condition_details_id BIGINT                                     NOT NULL
        CONSTRAINT store_special_condition_special_condition_details_id_fkey
            REFERENCES discount.special_condition_details,
    create_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind                   VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT store_special_condition_pkey
        PRIMARY KEY (store_id, special_condition_details_id)
)
;

CREATE TABLE IF NOT EXISTS product.available_product
(
    available_product_id BIGSERIAL
        CONSTRAINT available_product_pkey
            PRIMARY KEY,
    amount_total         INTEGER,
    blocked_total        INTEGER,
    price_unit           BIGINT,
    product_id           BIGINT                                     NOT NULL
        CONSTRAINT available_product_product_id_fkey
            REFERENCES product.product,
    store_id             BIGINT                                     NOT NULL
        CONSTRAINT available_product_store_id_fkey
            REFERENCES product.store,
    create_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind           VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL
)
;

CREATE TABLE IF NOT EXISTS client.client_shopped_product
(
    available_product_id BIGINT                                     NOT NULL
        CONSTRAINT client_shopped_product_available_product_id_fkey
            REFERENCES product.available_product,
    client_id            BIGINT                                     NOT NULL
        CONSTRAINT client_shopped_product_client_id_fkey
            REFERENCES client.client,
    amount_total         INTEGER,
    create_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm          TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind           VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT client_shopped_product_pkey
        PRIMARY KEY (available_product_id, client_id)
)
;

CREATE TABLE IF NOT EXISTS discount.available_product_special_condition
(
    available_product_id         BIGINT                                     NOT NULL
        CONSTRAINT available_product_special_condition_available_product_id_fkey
            REFERENCES product.available_product,
    special_condition_details_id BIGINT                                     NOT NULL
        CONSTRAINT available_product_special_con_special_condition_details_id_fkey
            REFERENCES discount.special_condition_details,
    create_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    modify_dttm                  TIMESTAMPTZ DEFAULT NOW()                  NOT NULL,
    action_ind                   VARCHAR(1)  DEFAULT 'I'::CHARACTER VARYING NOT NULL,
    CONSTRAINT available_product_special_condition_pkey
        PRIMARY KEY (available_product_id, special_condition_details_id)
);