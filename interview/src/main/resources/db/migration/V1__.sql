CREATE TABLE campaign (
  id UUID NOT NULL,
   name VARCHAR(255) NOT NULL,
   product_code VARCHAR(255) NOT NULL,
   duration INTEGER DEFAULT 1,
   price_man_limit INTEGER,
   target_sales_count INTEGER,
   total_sales INTEGER,
   status VARCHAR(255),
   CONSTRAINT pk_campaign PRIMARY KEY (id)
);

CREATE TABLE "order" (
  id UUID NOT NULL,
   quantity INTEGER,
   product_code VARCHAR(255) NOT NULL,
   CONSTRAINT pk_order PRIMARY KEY (id)
);

CREATE TABLE product (
  id UUID NOT NULL,
   product_code VARCHAR(255) NOT NULL,
   price DECIMAL(8, 2),
   stock INTEGER,
   CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE campaign ADD CONSTRAINT uc_campaign_name UNIQUE (name);

ALTER TABLE campaign ADD CONSTRAINT uc_campaign_product_code UNIQUE (product_code);

ALTER TABLE "order" ADD CONSTRAINT uc_order_product_code UNIQUE (product_code);

ALTER TABLE product ADD CONSTRAINT uc_product_product_code UNIQUE (product_code);