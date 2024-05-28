import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Aprova {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> alunos = new ArrayList<>();
        boolean addMore = true;

        while (addMore) {
            boolean validNome = false;
            while (!validNome) {
                System.out.print("Digite o nome do aluno: ");
                String nome = scanner.next();
                if (nome.matches("[a-zA-Z]+")) {
                    alunos.add(nome);
                    validNome = true;
                } else {
                    System.out.println("Nome inválido. Por favor, digite um nome composto apenas por letras.");
                }
            }

            boolean validResponse = false;
            while (!validResponse) {
                System.out.print("Deseja adicionar outro aluno? (s/n): ");
                String response = scanner.next().toLowerCase();
                if (response.equals("s")) {
                    validResponse = true;
                } else if (response.equals("n")) {
                    validResponse = true;
                    addMore = false;
                } else {
                    System.out.println("Entrada inválida. Por favor, digite 's' para sim ou 'n' para não.");
                }
            }
        }

        
        avaliarAprovacao(alunos, scanner);

        scanner.close(); 
    }

    public static void avaliarAprovacao(List<String> alunos, Scanner scanner) {
        for (String aluno : alunos) {
            double somaNotas = 0;

            for (int i = 1; i <= 4; i++) {
                boolean validNota = false;
                while (!validNota) {
                    try {
                        System.out.printf("Digite a nota %d do aluno %s (entre 0 e 10): ", i, aluno);
                        double nota = scanner.nextDouble();
                        if (nota >= 0 && nota <= 10) {
                            somaNotas += nota;
                            validNota = true;
                        } else {
                            System.out.println("Nota fora do intervalo. Por favor, digite uma nota entre 0 e 10.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, digite um número.");
                        scanner.next(); 
                    }
                }
            }

            double media = somaNotas / 4;

            if (media >= 7) {
                System.out.printf("O aluno %s passou de ano com média %.1f.%n", aluno, media);
            } else {
                System.out.printf("O aluno %s não passou de ano com média %.1f.%n", aluno, media);
            }
        }
    }
}
