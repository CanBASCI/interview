CREATE TABLE hb_campaign (
  id UUID NOT NULL,
   name VARCHAR(255) NOT NULL,
   product_id UUID,
   duration INTEGER DEFAULT 1,
   price_man_limit INTEGER,
   target_sales_count INTEGER,
   total_sales INTEGER,
   status VARCHAR(255),
   CONSTRAINT pk_hb_campaign PRIMARY KEY (id)
);

CREATE TABLE hb_order (
  id UUID NOT NULL,
   quantity INTEGER,
   product_id UUID,
   CONSTRAINT pk_hb_order PRIMARY KEY (id)
);

CREATE TABLE hb_product (
  id UUID NOT NULL,
   product_code VARCHAR(255) NOT NULL,
   price DECIMAL(8, 2),
   stock INTEGER,
   CONSTRAINT pk_hb_product PRIMARY KEY (id)
);

ALTER TABLE hb_campaign ADD CONSTRAINT uc_hb_campaign_name UNIQUE (name);

ALTER TABLE hb_product ADD CONSTRAINT uc_hb_product_product_code UNIQUE (product_code);

ALTER TABLE hb_campaign ADD CONSTRAINT FK_HB_CAMPAIGN_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES hb_product (id);

ALTER TABLE hb_order ADD CONSTRAINT FK_HB_ORDER_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES hb_product (id);