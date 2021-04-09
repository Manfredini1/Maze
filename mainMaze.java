import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class mainMaze
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        maze lab = new maze();
        System.out.println();
        System.out.println("Bem vindo");
        System.out.print("Digite o nome do arquivo:");
        String x = sc.nextLine();
        System.out.println();
        lab.carregaLabirinto(x);
        lab.printLab(x);
        
        //cria o resultado.txt
        try{
            File f = new File ("Solved.txt");
            FileWriter fr= new FileWriter(f);
            PrintWriter out = new PrintWriter(fr);
            try{
                if (lab.varificaLab(lab.carregaLabirinto(x))) 
                    out.println("Existe um caminho para o labirinto");
                else
                    out.println("Não existe um caminho para o labirinto");
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("Array ");
            }
            out.close();
            
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String result = reader.readLine();
              
            System.out.println(result);
            reader.close();
            }catch (IOException e) {
                System.out.println("Erro ao escrever arquivo resposta.");
            }
        
    }
}
