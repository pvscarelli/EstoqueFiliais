package L16.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ImportadorEstoque {

    private Map<Produto, Integer> estoque;
    private File arquivo;

    public ImportadorEstoque() {
        estoque = new HashMap<>();
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public void processarArquivo() {

        try {
            FileInputStream is = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            //pula o cabeçalho
            br.readLine();

            String linha = br.readLine();

            while (linha != null) {

                String[] dados = linha.split(";");

                Produto produtoNovo = new Produto(dados[0], Double.parseDouble(dados[1]));

                Integer qtEstoque = estoque.get(produtoNovo);

                if (qtEstoque != null) {
                    estoque.put(produtoNovo, Integer.parseInt(dados[2]) + qtEstoque);
                } else {
                    estoque.put(produtoNovo, Integer.parseInt(dados[2]));
                }
                linha = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("Não encontrou o arquivo texto.");
        } catch (IOException ex) {
            System.out.println("Não conseguiu ler a linha.");
        }

    }

    public Map<Produto, Integer> getEstoque() {
        return estoque;
    }

}
