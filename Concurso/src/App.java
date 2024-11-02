import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual a quantidade de pessoas? ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Pessoa> pessoas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados da " + (i + 1) + "a pessoa:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Nota etapa 1: ");
            double nota1 = sc.nextDouble();
            System.out.print("Nota etapa 2: ");
            double nota2 = sc.nextDouble();
            sc.nextLine();

            pessoas.add(new Pessoa(nome, nota1, nota2));
        }

        System.out.println("### TABELA ###");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }

        System.out.println("### PESSOAS APROVADAS ###");
        List<Pessoa> aprovados = new ArrayList<>();
        Pessoa pessoaMaiorMedia = pessoas.get(0);

        for (Pessoa pessoa : pessoas) {
            if (pessoa.isAprovado()) {
                aprovados.add(pessoa);
                System.out.println(pessoa.getNome());
            }
            if (pessoa.getMedia() > pessoaMaiorMedia.getMedia()) {
                pessoaMaiorMedia = pessoa;
            }
        }

        double porcentagemAprovacao = (double) aprovados.size() / n * 100.0;
        System.out.printf("Porcentagem de aprovação: %.1f %% %n", porcentagemAprovacao);

        System.out.println("Maior média: " + pessoaMaiorMedia.getNome());

        if (aprovados.size() > 0) {
            double somaMediasAprovados = aprovados.stream().mapToDouble(Pessoa::getMedia).sum();
            double mediaAprovados = somaMediasAprovados / aprovados.size();
            System.out.printf("Nota média dos aprovados: %.2f%n", mediaAprovados);
        } else {
            System.out.println("Não há candidatos aprovados");
        }

        sc.close();
    }
}
