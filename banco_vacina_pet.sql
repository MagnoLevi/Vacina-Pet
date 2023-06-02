-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.9.3-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para vacina_pet
CREATE DATABASE IF NOT EXISTS `vacina_pet` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `vacina_pet`;

-- Copiando estrutura para tabela vacina_pet.agenda
CREATE TABLE IF NOT EXISTS `agenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_vacinacao` date DEFAULT NULL,
  `id_vacina` int(11) DEFAULT NULL,
  `id_animal` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_vacina` (`id_vacina`),
  KEY `id_animal` (`id_animal`),
  CONSTRAINT `agenda_ibfk_1` FOREIGN KEY (`id_vacina`) REFERENCES `vacinas` (`id`),
  CONSTRAINT `agenda_ibfk_2` FOREIGN KEY (`id_animal`) REFERENCES `animais` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Armazena as datas de quando os animais vão tomar vacinas, e qual será a vacina';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela vacina_pet.animais
CREATE TABLE IF NOT EXISTS `animais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `ano_nascimento` int(11) DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `id_raca` int(11) DEFAULT NULL,
  `id_tutor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_raca` (`id_raca`),
  KEY `id_tutor` (`id_tutor`),
  CONSTRAINT `animais_ibfk_1` FOREIGN KEY (`id_raca`) REFERENCES `racas` (`id`),
  CONSTRAINT `animais_ibfk_2` FOREIGN KEY (`id_tutor`) REFERENCES `tutores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Armazena animais, a qual tutor pertence e qual sua raca';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela vacina_pet.cidades
CREATE TABLE IF NOT EXISTS `cidades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela vacina_pet.enderecos
CREATE TABLE IF NOT EXISTS `enderecos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rua` varchar(50) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `id_cidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cidade` (`id_cidade`),
  CONSTRAINT `enderecos_ibfk_1` FOREIGN KEY (`id_cidade`) REFERENCES `cidades` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='Armazena enderecos dos tutores';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela vacina_pet.especies
CREATE TABLE IF NOT EXISTS `especies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `especie` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='Armazena as especies dos animais';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela vacina_pet.racas
CREATE TABLE IF NOT EXISTS `racas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `raca` varchar(50) DEFAULT NULL,
  `id_especie` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_especie` (`id_especie`),
  CONSTRAINT `racas_ibfk_1` FOREIGN KEY (`id_especie`) REFERENCES `especies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='Armazena a raca, e de qual especie é a raca';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela vacina_pet.telefones
CREATE TABLE IF NOT EXISTS `telefones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `telefone` varchar(50) DEFAULT NULL,
  `id_tutor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tutor` (`id_tutor`),
  CONSTRAINT `telefones_ibfk_1` FOREIGN KEY (`id_tutor`) REFERENCES `tutores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Armazena telefones dos tutores';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela vacina_pet.tutores
CREATE TABLE IF NOT EXISTS `tutores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(30) DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_endereco` (`id_endereco`),
  CONSTRAINT `tutores_ibfk_1` FOREIGN KEY (`id_endereco`) REFERENCES `enderecos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COMMENT='Armazena dados de tutores';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela vacina_pet.vacinas
CREATE TABLE IF NOT EXISTS `vacinas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vacina` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COMMENT='Armazena as vacinas';

-- Exportação de dados foi desmarcado.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
