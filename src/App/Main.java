package App;

import Classes.*;
import Connection.Conexao;
import DAO.*;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // BANCO
        Conexao conexao = new Conexao();
        conexao.geraConexao();

        // CONEXÕES
        VacinaDAO vDAO = new VacinaDAO();
        EspecieDAO eDAO = new EspecieDAO();
        RacaDAO rDAO = new RacaDAO();
        CidadeDAO cDAO = new CidadeDAO();
        EnderecoDAO enDAO = new EnderecoDAO();
        TutorDAO tDAO = new TutorDAO();
        TelefoneDAO teDAO = new TelefoneDAO();
        AnimalDAO animalDAO = new AnimalDAO();
        AgendaDAO agendaDAO = new AgendaDAO();

        // SCANNER
        Scanner sc = new Scanner(System.in);


        // -- CODIGO SIMULANDO APP -- //
        String flag_repetir_codigo = "";

        do {
            // SELECIONA A ABA
            System.out.print("\nQual aba você deseja acessar: \n1 - Vacinas \n2 - Espécies \n3 - Raças \n4 - Animais \n5 - Cidades \n6 - Endereços \n7 - Tutores \n8 - Telefones \n9 - Agenda \nAba: ");
            int flag_aba = sc.nextInt();


            // PRINTA MSG QUE ENTROU NA ABA
            switch(flag_aba){
                case 1:
                    System.out.println("\n-- Aba Vacinas acessada --");
                    break;
                case 2:
                    System.out.println("\n-- Aba Espécies acessada --");
                    break;
                case 3:
                    System.out.println("\n-- Aba Raças acessada --");
                    break;
                case 4:
                    System.out.println("\n-- Aba Animais acessada --");
                    break;
                case 5:
                    System.out.println("\n-- Aba Cidades acessada --");
                    break;
                case 6:
                    System.out.println("\n-- Aba Endereços acessada --");
                    break;
                case 7:
                    System.out.println("\n-- Aba Tutores acessada --");
                    break;
                case 8:
                    System.out.println("\n-- Aba Telefones acessada --");
                    break;
                case 9:
                    System.out.println("\n-- Aba Agenda acessada --");
                    break;
                default:
                    System.out.println("\n-- Aba inválida --");
                    break;
            }


            // SELECIONA SE VOCE QUER INSERIR, DELETAR, ATUALIZAR, LISTAR TUDO OU LISTAR UM REGISTRO ESPECIFICO
            System.out.print("\nQual ação você deseja executar: \n1 - Inserir \n2 - Deletar \n3 - Atualizar \n4 - Listar tudo \n5 - Filtrar \nAção: ");
            int flag_acao = sc.nextInt();
            System.out.println(""); sc.nextLine(); // pula linha


            // SWITCH QUE TRATA QUAL TABELA SERÁ ALTERADA E QUAL OPERAÇÃO SERÁ FEITA
            switch(flag_aba){
                case 1:
                    // INSERIR
                    if (flag_acao == 1){
                        System.out.print("Nome da vacina: ");
                        String nome_vacina = sc.nextLine();



                        Vacina v = new Vacina(0, nome_vacina);
                        vDAO.insert(v);
                    }

                    // DELETAR
                    else if (flag_acao == 2) {
                        if (vDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma vacina cadastrada");
                            break;
                        }

                        String nome_vacina = "";
                        do {
                            System.out.print("Escolha qual vacina será deletada: ");
                            nome_vacina = sc.nextLine();

                            if (vDAO.show_filter(nome_vacina) == null){
                                System.out.println("Não existe uma vacina com este nome");
                            }
                        }
                        while(vDAO.show_filter(nome_vacina) == null);

                        vDAO.delete(vDAO.show_filter(nome_vacina));

                    }

                    // UPDATE
                    else if (flag_acao == 3) {
                        if (vDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma vacina cadastrada");
                            break;
                        }

                        String nome_vacina = "";
                        do {
                            System.out.print("Escolha qual vacina será alterada: ");
                            nome_vacina = sc.nextLine();

                            if (vDAO.show_filter(nome_vacina) == null){
                                System.out.println("Não existe uma vacina com este nome");
                            }
                        }
                        while(vDAO.show_filter(nome_vacina) == null);

                        System.out.print("Insira o novo nome da vacina: ");
                        String nome_altera_vacina = sc.nextLine();

                        Vacina v = vDAO.show_filter(nome_vacina);
                        v.setVacina(nome_altera_vacina);
                        vDAO.update(v);
                    }

                    // LISAR TUDO
                    else if(flag_acao == 4){
                        if (vDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma vacina cadastrada");
                            break;
                        }

                        for (Vacina vacina: vDAO.show_all()){
                            System.out.println("Vacina: " + vacina.getVacina());
                        }
                    }

                    // LISTA COM FILTRO
                    else {
                        if (vDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma vacina cadastrada");
                            break;
                        }

                        String nome_vacina = "";
                        do {
                            System.out.print("Escolha qual vacina será listada: ");
                            nome_vacina = sc.nextLine();

                            if (vDAO.show_filter(nome_vacina) == null){
                                System.out.println("Não existe uma vacina com este nome");
                            }
                        }
                        while(vDAO.show_filter(nome_vacina) == null);

                        System.out.println(vDAO.show_filter(nome_vacina).toString());
                    }

                    break;
                case 2:
                    // INSERIR
                    if (flag_acao == 1){
                        System.out.print("Nome da espécie: ");
                        String nome_especie = sc.nextLine();

                        Especie e = new Especie(0, nome_especie);
                        eDAO.insert(e);
                    }

                    // DELETAR
                    else if (flag_acao == 2) {
                        if (eDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma espécie cadastrada");
                            break;
                        }

                        String nome_especie = "";
                        do {
                            System.out.print("Escolha qual espécie será deletada: ");
                            nome_especie = sc.nextLine();

                            if (eDAO.show_filter(nome_especie) == null){
                                System.out.println("Não existe uma espécie com este nome");
                            }
                        }
                        while(eDAO.show_filter(nome_especie) == null);

                        eDAO.delete(eDAO.show_filter(nome_especie));

                    }

                    // UPDATE
                    else if (flag_acao == 3) {
                        if (eDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma espécie cadastrada");
                            break;
                        }

                        String nome_especie = "";
                        do {
                            System.out.print("Escolha qual espécie será alterada: ");
                            nome_especie = sc.nextLine();

                            if (eDAO.show_filter(nome_especie) == null){
                                System.out.println("Não existe uma espécie com este nome");
                            }
                        }
                        while(eDAO.show_filter(nome_especie) == null);

                        System.out.print("Insira o novo nome da espécie: ");
                        String nome_altera_especie = sc.nextLine();


                        Especie e = eDAO.show_filter(nome_especie);
                        e.setEspecie(nome_altera_especie);
                        eDAO.update(e);
                    }

                    // LISAR TUDO
                    else if(flag_acao == 4){
                        if (eDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma espécie cadastrada");
                            break;
                        }

                        for (Especie especie: eDAO.show_all()){
                            System.out.println("Espécie: " + especie.getEspecie());
                        }
                    }

                    // LISTA COM FILTRO
                    else {
                        if (eDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma espécie cadastrada");
                            break;
                        }

                        String nome_especie = "";
                        do {
                            System.out.print("Escolha qual espécie será listada: ");
                            nome_especie = sc.nextLine();

                            if (eDAO.show_filter(nome_especie) == null){
                                System.out.println("Não existe uma espécie com este nome");
                            }
                        }
                        while(eDAO.show_filter(nome_especie) == null);

                        System.out.println(eDAO.show_filter(nome_especie).toString());
                    }

                    break;
                case 3:
                    // INSERIR
                    if (flag_acao == 1){
                        if (eDAO.show_all().size() == 0){
                            System.out.println("Para inserir uma raça é necessário haver pelo menos 1 espécie cadastrada");
                            break;
                        }

                        System.out.print("Nome da raça: ");
                        String nome_raca = sc.nextLine();

                        String nome_especie = "";
                        do {
                            System.out.print("Escolha a qual espécie esta raça pertence: ");
                            nome_especie = sc.nextLine();

                            if (eDAO.show_filter(nome_especie) == null){
                                System.out.println("Não existe uma espécie com este nome");
                            }
                        }
                        while(eDAO.show_filter(nome_especie) == null);

                        int id_especie = eDAO.show_filter(nome_especie).getId();

                        Raca r = new Raca(0, nome_raca, id_especie);
                        rDAO.insert(r);

                    }

                    // DELETAR
                    else if (flag_acao == 2) {
                        if (rDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma raça cadastrada");
                            break;
                        }

                        String nome_raca = "";
                        do {
                            System.out.print("Escolha qual raça será deletada: ");
                            nome_raca = sc.nextLine();

                            if (rDAO.show_filter(nome_raca) == null){
                                System.out.println("Não existe uma raça com este nome");
                            }
                        }
                        while(rDAO.show_filter(nome_raca) == null);

                        rDAO.delete(rDAO.show_filter(nome_raca));

                    }

                    // UPDATE
                    else if (flag_acao == 3) {
                        if (rDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma raça cadastrada");
                            break;
                        }

                        String nome_raca = "";
                        do {
                            System.out.print("Escolha qual raça será alterada: ");
                            nome_raca = sc.nextLine();

                            if (rDAO.show_filter(nome_raca) == null){
                                System.out.println("Não existe uma raça com este nome");
                            }
                        }
                        while(rDAO.show_filter(nome_raca) == null);

                        System.out.print("Deseja alterar o nome da raça? (S, N): ");
                        String flag_altera_nome = sc.nextLine();

                        String nome_altera_raca = "";
                        if (flag_altera_nome.toUpperCase().equals("S")){
                            System.out.print("Insira o novo nome da raça: ");
                            nome_altera_raca = sc.nextLine();
                        } else {
                            nome_altera_raca = rDAO.show_filter(nome_raca).getRaca();
                        }

                        System.out.print("Deseja alterar a espécie da raça? (S, N): ");
                        String flag_altera_especie = sc.nextLine();

                        int id_altera_especie = 0;
                        if (flag_altera_especie.toUpperCase().equals("S")){
                            String nome_altera_especie = "";
                            do {
                                System.out.print("Insira a nova espécie desta raça: ");
                                nome_altera_especie = sc.nextLine();

                                if (eDAO.show_filter(nome_altera_especie) == null){
                                    System.out.println("Não existe uma espécie com este nome");
                                }
                            }
                            while(eDAO.show_filter(nome_altera_especie) == null);

                            id_altera_especie = eDAO.show_filter(nome_altera_especie).getId();
                        } else {
                            id_altera_especie = rDAO.show_filter(nome_raca).getId_especie();
                        }

                        Raca r = rDAO.show_filter(nome_raca);
                        r.setRaca(nome_altera_raca);
                        r.setId_especie(id_altera_especie);
                        rDAO.update(r);

                    }

                    // LISAR TUDO
                    else if(flag_acao == 4){
                        if (rDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma raça cadastrada");
                            break;
                        }

                        for (Raca raca: rDAO.show_all()){
                            System.out.println("Raça: " + raca.getRaca() + " | Id espécio: " + raca.getId_especie());
                        }
                    }

                    // LISTA COM FILTRO
                    else {
                        if (rDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma raça cadastrada");
                            break;
                        }

                        String nome_raca = "";
                        do {
                            System.out.print("Escolha qual raça será listada: ");
                            nome_raca = sc.nextLine();

                            if (rDAO.show_filter(nome_raca) == null){
                                System.out.println("Não existe uma raça com este nome");
                            }
                        }
                        while(rDAO.show_filter(nome_raca) == null);

                        System.out.println(rDAO.show_filter(nome_raca).toString());

                    }

                    break;
                case 4:
                    // INSERIR
                    if (flag_acao == 1){
                        // VERIFICA SE EXISTE OS REGISTROS NECESSÁRIOS
                        if (tDAO.show_all().size() == 0){
                            System.out.println("Para inserir um animal é necessário haver um tutor");
                            break;
                        }
                        if (rDAO.show_all().size() == 0){
                            System.out.println("Para inserir um animal é necessário haver uma raça");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Ano de nascimento: ");
                        int ano_nascimento = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Peso: ");
                        Double peso = sc.nextDouble();


                        // LISTA TODAS OS TUTORES
                        int id_tutor = 0;
                        do {
                            for (Tutor tutor: tDAO.show_all()){
                                System.out.println(tutor.getId() + " - Tutor: " + tutor.getNome());
                            }

                            System.out.print("Digite o numero do tutor: ");
                            id_tutor = sc.nextInt();
                            sc.nextLine();

                            if (tDAO.show_by_id(id_tutor) == null){
                                System.out.println("Número inválido");
                            }
                        }
                        while(tDAO.show_by_id(id_tutor) == null);

                        // LISTA TODAS AS RAÇAS
                        int id_raca = 0;
                        do {
                            for (Raca raca: rDAO.show_all()){
                                System.out.println(raca.getId() + " - Raça: " + raca.getRaca());
                            }

                            System.out.print("Digite o numero da raça: ");
                            id_raca = sc.nextInt();
                            sc.nextLine();

                            if (rDAO.show_by_id(id_raca) == null){
                                System.out.println("Número inválido");
                            }
                        }
                        while(rDAO.show_by_id(id_raca) == null);

                        Animal animal = new Animal(0, nome, ano_nascimento, peso, id_raca, id_tutor);
                        animalDAO.insert(animal);

                    }

                    // DELETAR
                    else if (flag_acao == 2) {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (animalDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro cadastro");
                            break;
                        }

                        // PROCURA REGISTRO
                        String nome = "";
                        int id_tutor = 0;
                        do {
                            System.out.print("Nome do animal que será deletado: ");
                            nome = sc.nextLine();

                            do {
                                for (Tutor tutor: tDAO.show_all()){
                                    System.out.println(tutor.getId() + " - Tutor: " + tutor.getNome());
                                }

                                System.out.print("Digite o numero do tutor que este animal pertence: ");
                                id_tutor = sc.nextInt();
                                sc.nextLine();

                                if (tDAO.show_by_id(id_tutor) == null){
                                    System.out.println("Número inválido");
                                }
                            }
                            while(tDAO.show_by_id(id_tutor) == null);

                            if (animalDAO.show_filter(nome, id_tutor) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(animalDAO.show_filter(nome, id_tutor) == null);


                        Animal animal = animalDAO.show_filter(nome, id_tutor);
                        animalDAO.delete(animal);
                    }

                    // UPDATE
                    else if (flag_acao == 3) {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (animalDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro cadastro");
                            break;
                        }

                        // PROCURA REGISTRO
                        String nome = "";
                        int id_tutor = 0;
                        do {
                            System.out.print("Nome do animal que será alterado: ");
                            nome = sc.nextLine();

                            do {
                                for (Tutor tutor: tDAO.show_all()){
                                    System.out.println(tutor.getId() + " - Tutor: " + tutor.getNome());
                                }

                                System.out.print("Digite o numero do tutor que este animal pertence: ");
                                id_tutor = sc.nextInt();
                                sc.nextLine();

                                if (tDAO.show_by_id(id_tutor) == null){
                                    System.out.println("Número inválido");
                                }
                            }
                            while(tDAO.show_by_id(id_tutor) == null);

                            if (animalDAO.show_filter(nome, id_tutor) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(animalDAO.show_filter(nome, id_tutor) == null);


                        Animal animal = animalDAO.show_filter(nome, id_tutor);

                        // PERGUNTA SE QUER ALTERAR CAMPO
                        String flag_altera = "";

                        System.out.print("Deseja alterar o nome? (S, N): ");
                        flag_altera = sc.nextLine();

                        String nome_altera = "";
                        if (flag_altera.toUpperCase().equals("S")){
                            System.out.print("Novo nome: ");
                            nome_altera = sc.nextLine();
                        } else {
                            nome_altera = animal.getNome();
                        }

                        System.out.print("Deseja alterar o ano de nascimento? (S, N): ");
                        flag_altera = sc.nextLine();
                        int ano_altera = 0;
                        if (flag_altera.toUpperCase().equals("S")){
                            System.out.print("Novo ano de nascimento: ");
                            ano_altera = sc.nextInt();
                            sc.nextLine();
                        } else {
                            ano_altera = animal.getAno_nascimento();
                        }

                        System.out.print("Deseja alterar o peso? (S, N): ");
                        flag_altera = sc.nextLine();
                        Double peso_altera = 0.0;
                        if (flag_altera.toUpperCase().equals("S")){
                            System.out.print("Novo peso: ");
                            peso_altera = sc.nextDouble();
                            sc.nextLine();
                        } else {
                            peso_altera = animal.getPeso();
                        }

                        System.out.print("Deseja alterar a raça? (S, N): ");
                        flag_altera = sc.nextLine();
                        int raca_altera = 0;
                        if (flag_altera.toUpperCase().equals("S")){
                            do {
                                for (Raca raca: rDAO.show_all()){
                                    System.out.println(raca.getId() + " - Raça: " + raca.getRaca());
                                }

                                System.out.print("Digite o numero da nova raça: ");
                                raca_altera = sc.nextInt();
                                sc.nextLine();

                                if (rDAO.show_by_id(raca_altera) == null){
                                    System.out.println("Número inválido");
                                }
                            }
                            while(rDAO.show_by_id(raca_altera) == null);
                        } else {
                            raca_altera = animal.getId_raca();
                        }

                        System.out.print("Deseja alterar o tutor? (S, N): ");
                        flag_altera = sc.nextLine();
                        int tutor_altera = 0;
                        if (flag_altera.toUpperCase().equals("S")){
                            do {
                                for (Tutor tutor: tDAO.show_all()){
                                    System.out.println(tutor.getId() + " - Tutor: " + tutor.getNome());
                                }

                                System.out.print("Digite o numero do novo tutor: ");
                                tutor_altera = sc.nextInt();
                                sc.nextLine();

                                if (tDAO.show_by_id(tutor_altera) == null){
                                    System.out.println("Número inválido");
                                }
                            }
                            while(tDAO.show_by_id(tutor_altera) == null);
                        } else {
                            tutor_altera = animal.getId_tutor();
                        }


                        // BUSCA O OBJETO QUE SERÁ ATUALIZADO E INSERE OS NOVOS VALORES
                        animal.setNome(nome_altera);
                        animal.setAno_nascimento(ano_altera);
                        animal.setPeso(peso_altera);
                        animal.setId_raca(raca_altera);
                        animal.setId_tutor(tutor_altera);

                        animalDAO.update(animal);
                    }

                    // LISTAR TUDO
                    else if(flag_acao == 4){
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (animalDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro cadastro");
                            break;
                        }

                        // LISTA TODAS AS CIDADES
                        for (Animal animal: animalDAO.show_all()){
                            System.out.println("Nome: " + animal.getNome() + " | Ano nascimento: " + animal.getAno_nascimento() + " | Peso: " + animal.getPeso() + " | Id raça: " + animal.getId_raca() + " | Id tutor: " + animal.getId_tutor());
                        }
                    }

                    // LISTA COM FILTRO
                    else {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (animalDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro cadastro");
                            break;
                        }

                        // PROCURA REGISTRO
                        String nome = "";
                        int id_tutor = 0;
                        do {
                            System.out.print("Nome do animal: ");
                            nome = sc.nextLine();

                            do {
                                for (Tutor tutor: tDAO.show_all()){
                                    System.out.println(tutor.getId() + " - Tutor: " + tutor.getNome());
                                }

                                System.out.print("Numero do tutor do animal: ");
                                id_tutor = sc.nextInt();
                                sc.nextLine();

                                if (tDAO.show_by_id(id_tutor) == null){
                                    System.out.println("Número inválido");
                                }
                            }
                            while(tDAO.show_by_id(id_tutor) == null);

                            if (animalDAO.show_filter(nome, id_tutor) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(animalDAO.show_filter(nome, id_tutor) == null);

                        Animal animal = animalDAO.show_filter(nome, id_tutor);

                        System.out.println("Nome: " + animal.getNome() + " | Ano nascimento: " + animal.getAno_nascimento() + " | Peso: " + animal.getPeso() + " | Id raça: " + animal.getId_raca() + " | Id tutor: " + animal.getId_tutor());
                    }

                    break;

                case 5:
                    // INSERIR
                    if (flag_acao == 1){
                        System.out.print("Nome do estado: ");
                        String nome_estado = sc.nextLine();

                        System.out.print("Nome da Cidade: ");
                        String nome_cidade = sc.nextLine();

                        Cidade c = new Cidade(0, nome_cidade, nome_estado);
                        cDAO.insert(c);

                    }

                    // DELETAR
                    else if (flag_acao == 2) {
                        if (cDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma cidade cadastrada");
                            break;
                        }

                        String nome_cidade = "";
                        do {
                            System.out.print("Escolha qual cidade será deletada: ");
                            nome_cidade = sc.nextLine();

                            if (cDAO.show_filter(nome_cidade) == null){
                                System.out.println("Não existe uma cidade com este nome");
                            }
                        }
                        while(cDAO.show_filter(nome_cidade) == null);

                        cDAO.delete(cDAO.show_filter(nome_cidade));

                    }

                    // UPDATE
                    else if (flag_acao == 3) {
                        // VERIFICA SE EXISTE CIDADE NO BD
                        if (cDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma raça cadastrada");
                            break;
                        }

                        // PROCURA A CIDADE QUE SERÁ ALTERADA
                        String nome_cidade = "";
                        do {
                            System.out.print("Escolha qual cidade será alterada: ");
                            nome_cidade = sc.nextLine();

                            if (cDAO.show_filter(nome_cidade) == null){
                                System.out.println("Não existe uma cidade com este nome");
                            }
                        }
                        while(cDAO.show_filter(nome_cidade) == null);

                        // PERGUNTA SE QUER ALTERAR A CIDADE
                        System.out.print("Deseja alterar o nome da cidade? (S, N): ");
                        String flag_altera_cidade = sc.nextLine();

                        String nome_altera_cidade = "";
                        if (flag_altera_cidade.toUpperCase().equals("S")){
                            System.out.print("Insira o novo nome da cidade: ");
                            nome_altera_cidade = sc.nextLine();
                        } else {
                            nome_altera_cidade = cDAO.show_filter(nome_cidade).getCidade();
                        }

                        // PERGUNTA SE QUER ALTERAR O ESTADO DA CIDADE
                        System.out.print("Deseja alterar o estado da cidade? (S, N): ");
                        String flag_altera_estado = sc.nextLine();

                        String nome_altera_estado = "";
                        if (flag_altera_estado.toUpperCase().equals("S")){
                            System.out.print("Insira o novo nome do estado: ");
                            nome_altera_estado = sc.nextLine();
                        } else {
                            nome_altera_estado = cDAO.show_filter(nome_cidade).getCidade();
                        }

                        // BUSCA O OBJETO QUE SERÁ ATUALIZADO E INSERE OS NOVOS VALORES
                        Cidade c = cDAO.show_filter(nome_cidade);
                        c.setCidade(nome_altera_cidade);
                        c.setEstado(nome_altera_estado);

                        // ATUALIZA O BD COM O OBJETO ATUALIZADO
                        cDAO.update(c);
                    }

                    // LISTAR TUDO
                    else if(flag_acao == 4){
                        // VERIFICA SE EXISTE CIDADE NO BD
                        if (cDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma cidade cadastrada");
                            break;
                        }

                        // LISTA TODAS AS CIDADES
                        for (Cidade cidade: cDAO.show_all()){
                            System.out.println("Cidade: " + cidade.getCidade() + " | Estado: " + cidade.getEstado());
                        }
                    }

                    // LISTA COM FILTRO
                    else {
                        // VERIFICA SE EXISTE CIDADE NO BD
                        if (cDAO.show_all().size() == 0){
                            System.out.println("\nNenhuma raça cadastrada");
                            break;
                        }

                        // PROCURA A CIDADE FILTRADA NO BD
                        String nome_cidade = "";
                        do {
                            System.out.print("Escolha qual cidade será listada: ");
                            nome_cidade = sc.nextLine();

                            if (cDAO.show_filter(nome_cidade) == null){
                                System.out.println("Não existe uma cidade com este nome");
                            }
                        }
                        while(cDAO.show_filter(nome_cidade) == null);

                        // EXIBE A CIDADE
                        System.out.println(cDAO.show_filter(nome_cidade).toString());

                    }

                    break;
                case 6:
                    // INSERIR
                    if (flag_acao == 1){
                        // VERIFICA SE EXISTE UMA CIDADE
                        if (cDAO.show_all().size() == 0){
                            System.out.println("Para inserir um endereço é necessário haver pelo menos 1 cidade cadastrada");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Nome da rua: ");
                        String nome_rua = sc.nextLine();

                        System.out.print("Numero da rua: ");
                        String numero = sc.nextLine();

                        System.out.print("Nome do Bairro: ");
                        String nome_bairro = sc.nextLine();

                        // VERIFICA SE EXISTE UMA CIDADE
                        String nome_cidade = "";
                        do {
                            System.out.print("Nome da cidade: ");
                            nome_cidade = sc.nextLine();

                            if (cDAO.show_filter(nome_cidade) == null){
                                System.out.println("Nenhuma cidade com este nome encontrada");
                            }
                        }
                        while(cDAO.show_filter(nome_cidade) == null);

                        int id_cidade = cDAO.show_filter(nome_cidade).getId();

                        Endereco en = new Endereco(0, nome_rua, numero, nome_bairro, id_cidade);
                        enDAO.insert(en);

                    }

                    // DELETAR
                    else if (flag_acao == 2) {
                        // VERIFICA SE EXISTE UM ENDEREÇO
                        if (enDAO.show_all().size() == 0){
                            System.out.println("Nenhum endereço encontrado");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Nome da rua: ");
                        String nome_rua = sc.nextLine();

                        System.out.print("Numero da rua: ");
                        String numero = sc.nextLine();

                        System.out.print("Nome do Bairro: ");
                        String nome_bairro = sc.nextLine();

                        // VERIFICA SE EXISTE UMA CIDADE
                        String nome_cidade = "";
                        do {
                            System.out.print("Nome da cidade: ");
                            nome_cidade = sc.nextLine();

                            if (cDAO.show_filter(nome_cidade) == null){
                                System.out.println("Nenhuma cidade com este nome encontrada");
                            }
                        }
                        while(cDAO.show_filter(nome_cidade) == null);

                        int id_cidade = cDAO.show_filter(nome_cidade).getId();

                        Endereco en = enDAO.show_filter(nome_rua, numero, nome_bairro, id_cidade);
                        if (en != null){
                            enDAO.delete(en);
                            break;
                        }

                        System.out.println("Este endereço não existe");

                    }

                    // UPDATE
                    else if (flag_acao == 3) {
                        // VERIFICA SE EXISTE UM ENDEREÇO
                        if (enDAO.show_all().size() == 0){
                            System.out.println("Nenhum endereço encontrado");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Rua que será alterado: ");
                        String nome_rua = sc.nextLine();

                        System.out.print("Numero que será alterado: ");
                        String numero = sc.nextLine();

                        System.out.print("Bairro que será alterado: ");
                        String nome_bairro = sc.nextLine();

                        // VERIFICA SE EXISTE UMA CIDADE
                        String nome_cidade = "";
                        do {
                            System.out.print("Cidade que será alterado: ");
                            nome_cidade = sc.nextLine();

                            if (cDAO.show_filter(nome_cidade) == null){
                                System.out.println("Nenhuma cidade com este nome encontrada");
                            }
                        }
                        while(cDAO.show_filter(nome_cidade) == null);

                        int id_cidade = cDAO.show_filter(nome_cidade).getId();

                        Endereco en = enDAO.show_filter(nome_rua, numero, nome_bairro, id_cidade);
                        if (en == null){
                            System.out.println("Endereço não encontrado encontrado");
                            break;
                        }

                        // PERGUNTA SE QUER ALTERAR A RUA
                        System.out.print("Deseja alterar a rua? (S, N): ");
                        String flag_altera_rua = sc.nextLine();

                        String nome_altera_rua = "";
                        if (flag_altera_rua.toUpperCase().equals("S")){
                            System.out.print("Insira o novo nome da rua: ");
                            nome_altera_rua = sc.nextLine();
                        } else {
                            nome_altera_rua = en.getRua();
                        }

                        // PERGUNTA SE QUER ALTERAR O NUMERO
                        System.out.print("Deseja alterar o numero da rua? (S, N): ");
                        String flag_altera_numero = sc.nextLine();

                        String nome_altera_numero = "";
                        if (flag_altera_numero.toUpperCase().equals("S")){
                            System.out.print("Insira o novo numero da rua: ");
                            nome_altera_numero = sc.nextLine();
                        } else {
                            nome_altera_numero = en.getNumero();
                        }

                        // PERGUNTA SE QUER ALTERAR O BAIRRO
                        System.out.print("Deseja alterar o bairo? (S, N): ");
                        String flag_altera_bairro = sc.nextLine();

                        String nome_altera_bairro = "";
                        if (flag_altera_bairro.toUpperCase().equals("S")){
                            System.out.print("Insira o novo nome do bairro: ");
                            nome_altera_bairro = sc.nextLine();
                        } else {
                            nome_altera_bairro = en.getBairro();
                        }

                        // PERGUNTA SE QUER ALTERAR A CIDADE
                        System.out.print("Deseja alterar a cidade? (S, N): ");
                        String flag_altera_cidade = sc.nextLine();

                        int id_cidade_altera = 0;
                        if (flag_altera_cidade.toUpperCase().equals("S")){

                            String nome_altera_cidade = "";
                            do {
                                System.out.print("Insira o novo nome da cidade: ");
                                nome_altera_cidade = sc.nextLine();

                                if (cDAO.show_filter(nome_altera_cidade) == null){
                                    System.out.println("Nenhuma cidade com este nome encontrada");
                                }
                            }
                            while(cDAO.show_filter(nome_altera_cidade) == null);

                            id_cidade_altera = cDAO.show_filter(nome_altera_cidade).getId();

                        } else {
                            id_cidade_altera = en.getId_cidade();
                        }

                        // BUSCA O OBJETO QUE SERÁ ATUALIZADO E INSERE OS NOVOS VALORES
                        en.setRua(nome_altera_rua);
                        en.setNumero(nome_altera_numero);
                        en.setBairro(nome_altera_bairro);
                        en.setId_cidade(id_cidade_altera);

                        enDAO.update(en);
                    }

                    // LISTAR TUDO
                    else if(flag_acao == 4){
                        // VERIFICA SE EXISTE CIDADE NO BD
                        if (enDAO.show_all().size() == 0){
                            System.out.println("\nNenhum endereço cadastrada");
                            break;
                        }

                        // LISTA TODAS AS CIDADES
                        for (Endereco endereco: enDAO.show_all()){
                            System.out.println("Rua: " + endereco.getRua() + " | Numero: " + endereco.getNumero() + " | Bairro: " + endereco.getBairro());
                        }
                    }

                    // LISTA COM FILTRO
                    else {
                        // VERIFICA SE EXISTE UM ENDEREÇO
                        if (enDAO.show_all().size() == 0){
                            System.out.println("Nenhum endereço encontrado");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Rua: ");
                        String nome_rua = sc.nextLine();

                        System.out.print("Numero: ");
                        String numero = sc.nextLine();

                        System.out.print("Bairro: ");
                        String nome_bairro = sc.nextLine();

                        // VERIFICA SE EXISTE UMA CIDADE
                        String nome_cidade = "";
                        do {
                            System.out.print("Cidade: ");
                            nome_cidade = sc.nextLine();

                            if (cDAO.show_filter(nome_cidade) == null){
                                System.out.println("Nenhuma cidade com este nome encontrada");
                            }
                        }
                        while(cDAO.show_filter(nome_cidade) == null);

                        int id_cidade = cDAO.show_filter(nome_cidade).getId();

                        Endereco en = enDAO.show_filter(nome_rua, numero, nome_bairro, id_cidade);
                        if (en == null){
                            System.out.println("Endereço não encontrado encontrado");
                            break;
                        }

                        System.out.println(en);

                    }

                    break;
                case 7:
                    // INSERIR
                    if (flag_acao == 1){
                        // VERIFICA SE EXISTE UM ENDEREÇO
                        if (enDAO.show_all().size() == 0){
                            System.out.println("Para inserir um tutor é necessário haver um endereço");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Nome: ");
                        String nome_tutor = sc.nextLine();

                        System.out.print("Email: ");
                        String email_tutor = sc.nextLine();

                        System.out.print("Senha: ");
                        String senha_tutor = sc.nextLine();


                        // LISTA TODAS OS ENDEREÇOS
                        int id_endereco_tutor = 0;
                        do {
                            for (Endereco endereco: enDAO.show_all()){
                                System.out.println(endereco.getId() + " - Rua: " + endereco.getRua() + " | Numero: " + endereco.getNumero() + " | Bairro: " + endereco.getBairro());
                            }

                            System.out.print("Digite o numero do endereço do tutor: ");
                            id_endereco_tutor = sc.nextInt();

                            if (enDAO.show_by_id(id_endereco_tutor) == null){
                                System.out.println("Número inválido");
                            }
                        }
                        while(enDAO.show_by_id(id_endereco_tutor) == null);

                        Tutor t = new Tutor(0, nome_tutor, email_tutor, senha_tutor, id_endereco_tutor);
                        tDAO.insert(t);
                        sc.nextLine();
                    }

                    // DELETAR
                    else if (flag_acao == 2) {
                        // VERIFICA SE EXISTE UM TUTOR
                        if (tDAO.show_all().size() == 0){
                            System.out.println("Nenhum tutor cadastro");
                            break;
                        }

                        // PROCURA REGISTRO
                        String nome_tutor = "";
                        do {
                            System.out.print("Nome do tutor que será deletado: ");
                            nome_tutor = sc.nextLine();

                            if (tDAO.show_filter(nome_tutor) == null){
                                System.out.println("Nome não encontrado");
                            }

                        } while(tDAO.show_filter(nome_tutor) == null);


                        Tutor t = tDAO.show_filter(nome_tutor);
                        tDAO.delete(t);
                    }

                    // UPDATE
                    else if (flag_acao == 3) {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (tDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro encontrado");
                            break;
                        }

                        // PROCURA REGISTRO
                        String nome_tutor = "";
                        do {
                            System.out.print("Nome do tutor que será atualizado: ");
                            nome_tutor = sc.nextLine();

                            if (tDAO.show_filter(nome_tutor) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(tDAO.show_filter(nome_tutor) == null);

                        Tutor t = tDAO.show_filter(nome_tutor);

                        // PERGUNTA SE QUER ALTERAR CAMPO
                        String flag_altera = "";

                        System.out.print("Deseja alterar o nome? (S, N): ");
                        flag_altera = sc.nextLine();

                        String nome_altera = "";
                        if (flag_altera.toUpperCase().equals("S")){
                            System.out.print("Novo nome: ");
                            nome_altera = sc.nextLine();
                        } else {
                            nome_altera = t.getNome();
                        }

                        System.out.print("Deseja alterar o email? (S, N): ");
                        flag_altera = sc.nextLine();

                        String email_altera = "";
                        if (flag_altera.toUpperCase().equals("S")){
                            System.out.print("Novo email: ");
                            email_altera = sc.nextLine();
                        } else {
                            email_altera = t.getEmail();
                        }

                        System.out.print("Deseja alterar a senha? (S, N): ");
                        flag_altera = sc.nextLine();

                        String senha_altera = "";
                        if (flag_altera.toUpperCase().equals("S")){
                            System.out.print("Nova senha: ");
                            senha_altera = sc.nextLine();
                        } else {
                            senha_altera = t.getSenha();
                        }

                        System.out.print("Deseja alterar o endereço? (S, N): ");
                        flag_altera = sc.nextLine();

                        int endereco_altera = 0;
                        if (flag_altera.toUpperCase().equals("S")){
                            do {
                                for (Endereco endereco: enDAO.show_all()){
                                    System.out.println(endereco.getId() + " - Rua: " + endereco.getRua() + " | Numero: " + endereco.getNumero() + " | Bairro: " + endereco.getBairro());
                                }

                                System.out.print("Digite o numero do endereço do tutor: ");
                                endereco_altera = sc.nextInt();

                                if (enDAO.show_by_id(endereco_altera) == null){
                                    System.out.println("Número inválido");
                                }
                            }
                            while(enDAO.show_by_id(endereco_altera) == null);
                        } else {
                            endereco_altera = t.getId_endereco();
                        }

                        // BUSCA O OBJETO QUE SERÁ ATUALIZADO E INSERE OS NOVOS VALORES
                        t.setNome(nome_altera);
                        t.setEmail(email_altera);
                        t.setSenha(senha_altera);
                        t.setId_endereco(endereco_altera);

                        tDAO.update(t);
                        sc.nextLine();
                    }

                    // LISTAR TUDO
                    else if(flag_acao == 4){
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (tDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro encontrado");
                            break;
                        }

                        // LISTA TODOS OS TUTORES
                        for (Tutor tutor: tDAO.show_all()){
                            System.out.println("Nome: " + tutor.getNome() + " | Email: " + tutor.getEmail());
                        }
                    }

                    // LISTA COM FILTRO
                    else {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (tDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro encontrado");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Nome: ");
                        String nome_usuario = sc.nextLine();

                        Tutor t = tDAO.show_filter(nome_usuario);
                        if (t == null){
                            System.out.println("Nehum registro encontrado");
                            break;
                        }

                        System.out.println("Nome: " + t.getNome() + " | Email: " + t.getEmail());

                    }

                    break;

                case 8:
                    // INSERIR
                    if (flag_acao == 1){
                        // VERIFICA SE EXISTE UM ENDEREÇO
                        if (tDAO.show_all().size() == 0){
                            System.out.println("Para inserir um telefone é necessário haver pelo menos 1 tutor cadastrado");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();


                        // LISTA TODAS OS TUTORES
                        int id_tutor = 0;
                        do {
                            for (Tutor tutor: tDAO.show_all()){
                                System.out.println(tutor.getId() + " - Nome: " + tutor.getNome());
                            }

                            System.out.print("Digite o numero do tutor que este telefone pertence: ");
                            id_tutor = sc.nextInt();

                            if (tDAO.show_by_id(id_tutor) == null){
                                System.out.println("Número inválido");
                            }
                        }
                        while(tDAO.show_by_id(id_tutor) == null);

                        Telefone t = new Telefone(0, telefone, id_tutor);
                        teDAO.insert(t);
                        sc.nextLine();
                    }

                    // DELETAR
                    else if (flag_acao == 2) {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (teDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro encontrado");
                            break;
                        }

                        // PROCURA REGISTRO
                        String telefone = "";
                        do {
                            System.out.print("Telefone que será deletado: ");
                            telefone = sc.nextLine();

                            if (teDAO.show_filter(telefone) == null){
                                System.out.println("Nome não encontrado");
                            }

                        } while(teDAO.show_filter(telefone) == null);


                        Telefone t = teDAO.show_filter(telefone);
                        teDAO.delete(t);
                    }

                    // UPDATE
                    else if (flag_acao == 3) {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (teDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro encontrado");
                            break;
                        }

                        // PROCURA REGISTRO
                        String telefone = "";
                        do {
                            System.out.print("Telefone que será atualizado: ");
                            telefone = sc.nextLine();

                            if (teDAO.show_filter(telefone) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(teDAO.show_filter(telefone) == null);

                        Telefone te = teDAO.show_filter(telefone);

                        // PERGUNTA SE QUER ALTERAR CAMPO
                        String flag_altera = "";

                        System.out.print("Deseja alterar o telefone? (S, N): ");
                        flag_altera = sc.nextLine();

                        String telefone_altera = "";
                        if (flag_altera.toUpperCase().equals("S")){
                            System.out.print("Novo telefone: ");
                            telefone_altera = sc.nextLine();
                        } else {
                            telefone_altera = te.getTelefone();
                        }

                        System.out.print("Deseja alterar a quem este telefone pertence? (S, N): ");
                        flag_altera = sc.nextLine();

                        int tutor_altera = 0;
                        if (flag_altera.toUpperCase().equals("S")){
                            do {
                                for (Tutor tutor: tDAO.show_all()){
                                    System.out.println(tutor.getId() + " - Nome: " + tutor.getNome());
                                }

                                System.out.print("Digite o numero do novo tutor: ");
                                tutor_altera = sc.nextInt();

                                if (tDAO.show_by_id(tutor_altera) == null){
                                    System.out.println("Número inválido");
                                }
                            }
                            while(tDAO.show_by_id(tutor_altera) == null);
                        } else {
                            tutor_altera = te.getId_tutor();
                        }

                        // BUSCA O OBJETO QUE SERÁ ATUALIZADO E INSERE OS NOVOS VALORES
                        te.setTelefone(telefone_altera);
                        te.setId_tutor(tutor_altera);

                        teDAO.update(te);
                        sc.nextLine();
                    }

                    // LISTAR TUDO
                    else if(flag_acao == 4){
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (teDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro encontrado");
                            break;
                        }

                        // LISTA TODAS AS CIDADES
                        for (Telefone telefone: teDAO.show_all()){
                            System.out.println("Telefone: " + telefone.getTelefone());
                        }
                    }

                    // LISTA COM FILTRO
                    else {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (teDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro encontrado");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();

                        Telefone te = teDAO.show_filter(telefone);
                        if (te == null){
                            System.out.println("Nehum registro encontrado");
                            break;
                        }

                        System.out.println("Telefone: " + te.getTelefone());

                    }

                    break;

                case 9:
                    // INSERIR
                    if (flag_acao == 1){
                        // VERIFICA SE EXISTE OS REGISTROS NECESSÁRIOS
                        if (vDAO.show_all().size() == 0){
                            System.out.println("Para inserir um agendamento é necessário haver uma vacina");
                            break;
                        }
                        if (animalDAO.show_all().size() == 0){
                            System.out.println("Para inserir um agendamento é necessário haver um animal");
                            break;
                        }

                        // PEGA OS NOMES DOS CAMPOS
                        System.out.print("Digite a data da vacinação no formato dd/mm/aaaa: ");
                        String input_data = sc.nextLine();

                        int dia = Integer.parseInt(input_data.substring(0, 2));
                        int mes = Integer.parseInt(input_data.substring(3, 5));
                        int ano = Integer.parseInt(input_data.substring(6, 10));

                        Date data_vacinacao = new Date(ano - 1900, mes - 1, dia);

                        // LISTA TODAS AS VACINA
                        int id_vacina = 0;
                        do {
                            for (Vacina vacina: vDAO.show_all()){
                                System.out.println(vacina.getId() + " - Vacina: " + vacina.getVacina());
                            }

                            System.out.print("Digite o numero da vacina: ");
                            id_vacina = sc.nextInt();
                            sc.nextLine();

                            if (vDAO.show_by_id(id_vacina) == null){
                                System.out.println("Número inválido");
                            }
                        }
                        while(vDAO.show_by_id(id_vacina) == null);

                        // LISTA TODAS AS RAÇAS
                        int id_animal = 0;
                        do {
                            for (Animal animal: animalDAO.show_all()){
                                System.out.println(animal.getId() + " - Animal: " + animal.getNome());
                            }

                            System.out.print("Digite o numero do animal: ");
                            id_animal = sc.nextInt();
                            sc.nextLine();

                            if (animalDAO.show_by_id(id_animal) == null){
                                System.out.println("Número inválido");
                            }
                        }
                        while(animalDAO.show_by_id(id_animal) == null);

                        Agenda agenda = new Agenda(0, data_vacinacao, id_vacina, id_animal);
                        agendaDAO.insert(agenda);

                    }

                    // DELETAR
                    else if (flag_acao == 2) {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (agendaDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro cadastro");
                            break;
                        }

                        // PROCURA REGISTRO
                        String nome = "";
                        do {
                            System.out.print("Deseja deletar o agendamento de qual tutor: ");
                            nome = sc.nextLine();

                            if (tDAO.show_filter(nome) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(tDAO.show_filter(nome) == null);


                        int id_agenda = 0;
                        do {

                            for (Agenda agenda: agendaDAO.show_filter(tDAO.show_filter(nome).getId())){
                                System.out.println(agenda.getId() + " - Data Vacinação: " + agenda.getData_vacinacao() + " | Id vacina: " + agenda.getId_vacina() + " | Id animal: " + agenda.getId_animal());
                            }

                            System.out.print("Digite o numero do agendamento: ");
                            id_agenda = sc.nextInt();
                            sc.nextLine();

                            if (agendaDAO.show_by_id(id_agenda) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(agendaDAO.show_by_id(id_agenda) == null);



                        Agenda agenda = agendaDAO.show_by_id(id_agenda);
                        agendaDAO.delete(agenda);
                    }

                    // UPDATE
                    else if (flag_acao == 3) {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (agendaDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro cadastro");
                            break;
                        }

                        // PROCURA REGISTRO
                        String nome = "";
                        do {
                            System.out.print("Deseja alterar o agendamento de qual tutor: ");
                            nome = sc.nextLine();

                            if (tDAO.show_filter(nome) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(tDAO.show_filter(nome) == null);


                        int id_agenda = 0;
                        do {

                            for (Agenda agenda: agendaDAO.show_filter(tDAO.show_filter(nome).getId())){
                                System.out.println(agenda.getId() + " - Data Vacinação: " + agenda.getData_vacinacao() + " | Id vacina: " + agenda.getId_vacina() + " | Id animal: " + agenda.getId_animal());
                            }

                            System.out.print("Digite o numero do agendamento: ");
                            id_agenda = sc.nextInt();
                            sc.nextLine();

                            if (agendaDAO.show_by_id(id_agenda) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(agendaDAO.show_by_id(id_agenda) == null);

                        Agenda agenda = agendaDAO.show_by_id(id_agenda);


                        // PERGUNTA SE QUER ALTERAR CAMPO
                        String flag_altera = "";

                        System.out.print("Deseja alterar a data? (S, N): ");
                        flag_altera = sc.nextLine();

                        Date data_altera;
                        if (flag_altera.toUpperCase().equals("S")){
                            System.out.print("Nova data da vacinação no formato dd/mm/aaaa: ");
                            String input_data = sc.nextLine();

                            int dia = Integer.parseInt(input_data.substring(0, 2));
                            int mes = Integer.parseInt(input_data.substring(3, 5));
                            int ano = Integer.parseInt(input_data.substring(6, 10));

                            data_altera = new Date(ano - 1900, mes - 1, dia);
                        } else {
                            data_altera = agenda.getData_vacinacao();
                        }


                        System.out.print("Deseja alterar a vacina? (S, N): ");
                        flag_altera = sc.nextLine();
                        int vacina_altera = 0;
                        if (flag_altera.toUpperCase().equals("S")){
                            do {
                                for (Vacina vacina: vDAO.show_all()){
                                    System.out.println(vacina.getId() + " - Vacina: " + vacina.getVacina());
                                }

                                System.out.print("Digite o numero da nova vacina: ");
                                vacina_altera = sc.nextInt();
                                sc.nextLine();

                                if (vDAO.show_by_id(vacina_altera) == null){
                                    System.out.println("Número inválido");
                                }
                            }
                            while(vDAO.show_by_id(vacina_altera) == null);
                        } else {
                            vacina_altera = agenda.getId_vacina();
                        }


                        System.out.print("Deseja alterar o animal? (S, N): ");
                        flag_altera = sc.nextLine();
                        int animal_altera = 0;
                        if (flag_altera.toUpperCase().equals("S")){
                            do {
                                for (Animal animal: animalDAO.show_all()){
                                    System.out.println(animal.getId() + " - Animal: " + animal.getNome());
                                }

                                System.out.print("Digite o numero do novo animal: ");
                                animal_altera = sc.nextInt();
                                sc.nextLine();

                                if (animalDAO.show_by_id(animal_altera) == null){
                                    System.out.println("Número inválido");
                                }
                            }
                            while(animalDAO.show_by_id(animal_altera) == null);
                        } else {
                            animal_altera = agenda.getId_vacina();
                        }


                        // BUSCA O OBJETO QUE SERÁ ATUALIZADO E INSERE OS NOVOS VALORES
                        agenda.setData_vacinacao(data_altera);
                        agenda.setId_vacina(vacina_altera);
                        agenda.setId_animal(animal_altera);

                        agendaDAO.update(agenda);
                    }

                    // LISTAR TUDO
                    else if(flag_acao == 4){
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (agendaDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro cadastro");
                            break;
                        }

                        // LISTA TODAS AS AGENDAMENTOS
                        for (Agenda agenda: agendaDAO.show_all()){
                            System.out.println(agenda.getId() + " - Data Vacinação: " + agenda.getData_vacinacao() + " | Id vacina: " + agenda.getId_vacina() + " | Id animal: " + agenda.getId_animal());
                        }
                    }

                    // LISTA COM FILTRO
                    else {
                        // VERIFICA SE EXISTE UM REGISTRO
                        if (agendaDAO.show_all().size() == 0){
                            System.out.println("Nenhum registro cadastro");
                            break;
                        }

                        // PROCURA REGISTRO
                        String nome = "";
                        do {
                            System.out.print("Deseja ver os agendamento de qual tutor: ");
                            nome = sc.nextLine();

                            if (tDAO.show_filter(nome) == null){
                                System.out.println("Registro não encontrado");
                            }

                        } while(tDAO.show_filter(nome) == null);

                        for (Agenda agenda: agendaDAO.show_filter(tDAO.show_filter(nome).getId())){
                            System.out.println("Data Vacinação: " + agenda.getData_vacinacao() + " | Id vacina: " + agenda.getId_vacina() + " | Id animal: " + agenda.getId_animal());
                        }

                    }

                    break;
                default:
                    System.out.println("Código de aba inválido");

            }


            // PERGUNTA PRO USER SE ELE QUER REPETIR A SIMULAÇÃO
            System.out.print("\nDeseja simular o App novamente? (S, N): ");
            flag_repetir_codigo = sc.nextLine();
        }
        while(flag_repetir_codigo.toUpperCase().equals("S"));
    }
}