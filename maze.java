import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class maze
{
    //String fileName = "labirinto1.txt";
    int column = 0;
    int row = 0;
    String linha = "";
    
        public char[][] carregaLabirinto (String fileName){
        //inicializa o array de chars
        char[][] charArray = new char[0][0];
        
        //preenche o array com os chars do .txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            linha = reader.readLine();
            column = linha.length();
            charArray = new char[getRow(fileName)][getColumn(fileName)];
            
            for (int x=0; x<column; x++){
                charArray[x] = linha.toCharArray();
                linha = reader.readLine();
                if (linha == null) break;
                    
            }   

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
       
        return charArray;
    }
    
    // metodo checagem da saida.
    public boolean varificaLab(char[][] mat)
    {
        
        if (busca(mat, 0, 0)){
            return true;
        }
        //System.out.println("perdeu");
        return false;
    }
    
    // metodo recursivo para encontrar a saida.
    private boolean busca(char[][] mat, int x, int y)
    {
        // checar se achou a saida 
        if (mat[x][y] == 'D'){
            System.out.println("Saida na posição [" + x +"]["+ y +"]"); 
            return true;
        }
        //faz o caminho positivo
        if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length ) {
            mat[x][y]='.';
                // baixo
            if (x+1 < mat.length && (mat[x+1][y] == ' ' || mat[x+1][y] == 'D')){
                return busca(mat, x + 1, y);
            }
                // direita
            if (y+1 < mat[x].length && (mat[x][y+1] == ' ' || mat[x][y+1] == 'D')){
                return busca(mat, x, y + 1);
            }
                // cima
            if (x > 0 && (mat[x-1][y] == ' ' || mat[x-1][y] == 'D')){
                return busca(mat, x - 1, y);
            }
                // esquerda
            if (y > 0 && (mat[x][y-1] == ' ' || mat[x][y-1] == 'D')){
                return busca(mat, x, y - 1);
            }
                //se for um beco sem saida, faz o caminho negativo no eixo x
            if (x > 0 && mat[x-1][y] == '.'){
                mat[x][y] = 'X';
                return busca(mat, x - 1, y );
            }
                //se for um beco sem saida, faz o caminho negativo no eixo y
            if (y > 0 && mat[x][y-1] == '.'){
                mat[x][y] = 'X';
                return busca(mat, x, y - 1);
            }
                //se for um beco sem saida, faz o caminho positivo no eixo x
            if (x+1 < mat.length && mat[x+1][y] == '.'){
                mat[x][y] = 'X';
                return busca(mat, x + 1, y );
            }
                //se for um beco sem saida, faz o caminho positivo no eixo y
            if (y+1 < mat[x].length && mat[x][y+1] == '.'){
                mat[x][y] = 'X';
                return busca(mat, x, y + 1);
            }
        }
      return false;
    }
        
        //metodos para o labirinto. 
    public void printLab(String file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linha = reader.readLine();
            int column = linha.length();
            
            System.out.println("Seu labirinto tem " + getRow(file) 
                                    +" linhas e " + getColumn(file) +" colunas." );
            for (int x=0; x<column; x++){
                System.out.println(linha);
                linha = reader.readLine();
                    
                if (linha == null) break;
                    
            }   
            System.out.println();
            reader.close();
            
        } catch (IOException e) {
            System.out.println("Erro ao desenhar o labirinto.");
        }
    }
    
    public int getRow(String file){
        int row = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linha = reader.readLine();
            
            while (linha != null) {
                
                row++;
                linha = reader.readLine();
                
            }
            reader.close();
            
        } catch (IOException e) {
        return row;
    }
    return row;
    }
    
    public int getColumn(String file){
        int column = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            column = reader.readLine().length();
            reader.close();
            
        } catch (IOException e) {
        return column;
    }
    return column;
    }
    
}


