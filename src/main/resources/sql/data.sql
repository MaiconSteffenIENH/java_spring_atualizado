INSERT INTO `users` (`name`, `email`, `password`, `role`)
VALUES ('ADMIN', NULL, 'ADMIN', 'ADMIN');

INSERT INTO `income_categories` (`name`, `description`)
VALUES ('Salario', 'Salario mensal'),
       ('Freelance', 'Trabalhos freelance'),
       ('Negócio', 'Rendimento de negócio');

INSERT INTO `expense_categories` (`name`, `description`)
VALUES ('Receitas', 'Receitas mensais'),
       ('Alimentação', 'Despesas com alimentação'),
       ('Transporte', 'Despesas com transporte'),
       ('Lazer', 'Despesas com lazer'),
       ('Saúde', 'Despesas com saúde'),
       ('Educação', 'Despesas com educação'),
       ('Moradia', 'Despesas com moradia'),
       ('Outros', 'Outras despesas');
