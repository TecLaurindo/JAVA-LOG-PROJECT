CREATE TABLE `Usuario` (
  `id_usuario` int PRIMARY KEY,
  `nome` varchar(255),
  `email` varchar(255) UNIQUE,
  `senha` varchar(255),
  `tipo_usuario` varchar(255)
);

CREATE TABLE `Empresa` (
  `id_empresa` int PRIMARY KEY,
  `nome` varchar(255),
  `cnpj` varchar(255) UNIQUE
);

CREATE TABLE `Aluno` (
  `id_aluno` int PRIMARY KEY,
  `id_usuario` int,
  `id_empresa` int,
  `matricula` varchar(255)
);

CREATE TABLE `Relatorio` (
  `id_relatorio` int PRIMARY KEY,
  `id_aluno` int,
  `periodo_referencia` varchar(255),
  `descricao_atividades` text,
  `data_envio` date,
  `situacao` varchar(255)
);

CREATE TABLE `AvaliacaoGestor` (
  `id_avaliacao` int PRIMARY KEY,
  `id_relatorio` int,
  `id_gestor` int,
  `data_avaliacao` date,
  `parecer` text
);

CREATE TABLE `AprovacaoEmpresario` (
  `id_aprovacao` int PRIMARY KEY,
  `id_relatorio` int,
  `id_empresario` int,
  `data_aprovacao` date,
  `status` varchar(255)
);

CREATE TABLE `LogAcesso` (
  `id_log` int PRIMARY KEY,
  `id_usuario` int,
  `data_hora` timestamp,
  `acao` varchar(255)
);

ALTER TABLE `Aluno` ADD FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id_usuario`);

ALTER TABLE `Aluno` ADD FOREIGN KEY (`id_empresa`) REFERENCES `Empresa` (`id_empresa`);

ALTER TABLE `Relatorio` ADD FOREIGN KEY (`id_aluno`) REFERENCES `Aluno` (`id_aluno`);

ALTER TABLE `AvaliacaoGestor` ADD FOREIGN KEY (`id_relatorio`) REFERENCES `Relatorio` (`id_relatorio`);

ALTER TABLE `AvaliacaoGestor` ADD FOREIGN KEY (`id_gestor`) REFERENCES `Usuario` (`id_usuario`);

ALTER TABLE `AprovacaoEmpresario` ADD FOREIGN KEY (`id_relatorio`) REFERENCES `Relatorio` (`id_relatorio`);

ALTER TABLE `AprovacaoEmpresario` ADD FOREIGN KEY (`id_empresario`) REFERENCES `Usuario` (`id_usuario`);

ALTER TABLE `LogAcesso` ADD FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id_usuario`);
