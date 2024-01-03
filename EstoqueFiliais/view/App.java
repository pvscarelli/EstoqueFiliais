package L16.view;

import L16.model.*;
import java.io.File;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        ImportadorEstoque e1 = new ImportadorEstoque();
        File arquivo = new File("C:/Users/pedro/OneDrive/Área de Trabalho/FURB23/POO/L16_Estoque.csv");
        e1.setArquivo(arquivo);
        e1.processarArquivo();
        
        Map<Produto,Integer> listaEstoque = e1.getEstoque();
        
        for (Map.Entry<Produto, Integer> entry : e1.getEstoque().entrySet()) {
            System.out.println(entry.getKey().getNome() + " R$: " + entry.getKey().getValor() + " Quantidade: " + entry.getValue());
        }

    }
}
