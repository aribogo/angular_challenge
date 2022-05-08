CREATE TABLE tb_customer (
					id BIGINT AUTO_INCREMENT PRIMARY KEY, 
					name VARCHAR(255) NOT NULL,
					cpf VARCHAR(255) NOT NULL,
					email VARCHAR(255) NOT NULL,
					id_user BIGINT NOT NULL
					);
					
CREATE TABLE tb_product (
					id BIGINT AUTO_INCREMENT PRIMARY KEY, 
					name VARCHAR(100) NOT NULL,
					description VARCHAR(600) NOT NULL,
					measurement_unit VARCHAR(255) NOT NULL,
					price NUMERIC NOT NULL,
					product_stock INTEGER NOT NULL,
					file_type VARCHAR(15),
					file_folder VARCHAR(255) NOT NULL,
					file_size BIGINT,
					file_name VARCHAR(50) NOT NULL,
					customer_id BIGINT NOT NULL,
					FOREIGN KEY (customer_id) REFERENCES tb_customer(id)
					);
					
CREATE TABLE tb_sale (
					id BIGINT AUTO_INCREMENT PRIMARY KEY, 
					sale_date DATE NOT NULL,
					total_amount NUMERIC NOT NULL,
					zip_code VARCHAR(20) NOT NULL,
					customer_id BIGINT NOT NULL,
					FOREIGN KEY (customer_id) REFERENCES tb_customer(id)
					);
					
CREATE TABLE tb_cart_items (
					id BIGINT AUTO_INCREMENT PRIMARY KEY, 
					product_amount INTEGER NOT NULL,
					total_cost NUMERIC NOT NULL,
					sale_id BIGINT NOT NULL,
					product_id BIGINT NOT NULL,
					FOREIGN KEY (sale_id) REFERENCES tb_sale(id),
					FOREIGN KEY (product_id) REFERENCES tb_product(id)
					);