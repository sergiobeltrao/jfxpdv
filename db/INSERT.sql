INSERT INTO USUARIOS(NOME, LOGIN, SENHA, NIVEL_DE_ACESSO) VALUES('Administrador', 'admin', 'admin', 'ADMINISTRADOR');
INSERT INTO USUARIOS(NOME, LOGIN, SENHA, NIVEL_DE_ACESSO) VALUES('Caixa', 'caixa', 'caixa', 'CAIXA');

INSERT INTO CLIENTES(TIPO, NOME, CPF_CNPJ, RG, TELEFONE, EMAIL, ESTADO, CIDADE, RUA, BAIRRO, CEP, NUMERO, COMPLEMENTO)
VALUES ('PF', 'Dino da Silva Sauro', '000.111.222-33', '44.555.666-7', '(00) 12222-3333', 'dino@mail.com', 'AC', 'Rio Branco',
'Rua Severino Ferreira', 'Wanderley Dantas', '69902-828', '37', 'A direita do negócio que tem lá');

INSERT INTO CLIENTES(TIPO, NOME, CPF_CNPJ, TELEFONE, EMAIL, ESTADO, CIDADE, RUA, BAIRRO, CEP, NUMERO, COMPLEMENTO)
VALUES ('PJ', 'WESAYSO Development Corporation', '33.888.777/0001-25', '(33) 3333-7777', 'financeiro@wesayso.com', 'AC', 'Rio Branco',
'Travessa Cabral', 'Conquista', '69918-762', '666', 'Nenhum');

SELECT * FROM USUARIOS;
SELECT * FROM CLIENTES;
