
INSERT INTO cozinha (id, nome) VALUES (1, 'Tailandesa');
INSERT INTO cozinha (id, nome) VALUES (2, 'Japonesa');
INSERT INTO cozinha (id, nome) VALUES (3, 'Italiana');
INSERT INTO cozinha (id, nome) VALUES (4, 'Brasileira');

INSERT INTO restaurante (id, nome, taxa_frete, cozinha_id) VALUES (1, 'Thai Gourmet', 10, 1);
INSERT INTO restaurante (id, nome, taxa_frete, cozinha_id) VALUES (2, 'Boteco do Gaucho', 15, 4);
INSERT INTO restaurante (id, nome, taxa_frete, cozinha_id) VALUES (3, 'Helena Bratchion', 8, 2);

insert into estado (id, nome) values (1, 'Minas Gerais');
    insert into estado (id, nome) values (2, 'São Paulo');
    insert into estado (id, nome) values (3, 'Ceará');

    insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
    insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
    insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
    insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
    insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

    insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
    insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
    insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');

    insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
    insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');