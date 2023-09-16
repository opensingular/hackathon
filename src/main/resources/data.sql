INSERT INTO ENDERECO (LOGRADOURO, CEP, COMPLEMENTO, BAIRRO, LOCALIDADE, UF)
VALUES ('Rua A', '72120202', 'Apto 101', 'Centro', 'São Paulo', 'SP'),
       ('Avenida B', '22110304', 'Casa 2', 'Bairro X', 'Rio de Janeiro', 'RJ'),
       ('Travessa C', '22321879', NULL, 'Bairro Y', 'Belo Horizonte', 'MG');

INSERT INTO FORNECEDOR (RAZAO_SOCIAL, CNPJ, NOME_DO_CONTATO, EMAIL_CONTATO, ATIVIDADES, ID_ENDERECO)
VALUES ('Fornecedor A', '12345678901234', 'Eletro','fornecedora@email.com', 'Venda de produtos eletrônicos', 1),
       ('Fornecedor B', '56789012345678', 'Alimento', 'fornecedorb@email.com', 'Distribuição de alimentos', 2),
       ('Fornecedor C', '90123456789012',  'Consult','fornecedorc@email.com', 'Serviços de consultoria', 3);
