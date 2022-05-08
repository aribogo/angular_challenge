CREATE TABLE tb_role (
					id BIGINT AUTO_INCREMENT PRIMARY KEY, 
					name VARCHAR(255) NOT NULL
					);


CREATE TABLE tb_user (
					id BIGINT AUTO_INCREMENT PRIMARY KEY, 
					email VARCHAR(255) NOT NULL,
					password VARCHAR(255) NOT NULL,
					role_id BIGINT NOT NULL,
					FOREIGN KEY (role_id) REFERENCES tb_role(id)
					);

CREATE UNIQUE INDEX uidx_username
ON tb_user (email);

INSERT INTO TB_ROLE (NAME) VALUES('CUSTOMER');

INSERT INTO tb_user (email, password, role_id) VALUES('exemplo@exemplo.com', '$2a$12$ipBs2PI.xWhVw8g4O41KEO6c4rSjmYRTCmzYc44mr5ZcKhCIoKQq.', 1);

INSERT INTO tb_customer(id, name, cpf, email, id_user) VALUES (1, 'Evelyn Benedita Silva', '20535713657', 'exemplo@exemplo.com', 1);

INSERT INTO tb_product(id, name, description, measurement_unit, price, product_stock, file_folder, file_name, customer_id) VALUES (1, 'Buquê de Rosas', 'Buquê de rosas vermelhos com 12 rosas. Pronto para entrega.', 'unidade', 60.5, 2, '1', 'Buquê de Rosas.jpg', 1);
INSERT INTO tb_product(id, name, description, measurement_unit, price, product_stock, file_folder, file_name, customer_id) VALUES (2, 'Babosa', 'Planta babosa de 1 metro. Vaso incluído na compra.', 'unidade', 40, 10, '1', 'Babosa.jpg', 1);
INSERT INTO tb_product(id, name, description, measurement_unit, price, product_stock, file_folder, file_name, customer_id) VALUES (3, 'Samambaia', 'Planta samambaia bebê. Vaso incluído na compra.', 'unidade', 80, 35, '1', 'Samambaia.jpg', 1);
INSERT INTO tb_product(id, name, description, measurement_unit, price, product_stock, file_folder, file_name, customer_id) VALUES (4, 'Orquídea', 'Orquídea rosa. Vaso incluso na compra.', 'unidade', 100, 0, '1', 'Orquídea.jpg', 1);
INSERT INTO tb_product(id, name, description, measurement_unit, price, product_stock, file_folder, file_name, customer_id) VALUES (5, 'Buquê sortido', '	Buquê com flores sortidas (100 flores).', 'unidade', 299.99, 5, '1', 'Buquê sortido.jpg', 1);


INSERT INTO tb_sale(id, sale_date, total_amount, zip_code, customer_id) VALUES (1, parsedatetime('17/09/2012', 'dd/MM/yyyy'), 160.5, '77019118', 1);
INSERT INTO tb_cart_items(id, product_amount, total_cost, sale_id, product_id) VALUES (1, 1, 60.5, 1, 1);
INSERT INTO tb_cart_items(id, product_amount, total_cost, sale_id, product_id) VALUES (2, 1, 100, 1, 4);
