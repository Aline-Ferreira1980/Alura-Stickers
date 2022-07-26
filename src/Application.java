import client.ClienteHttp;
import extrator.*;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {


        //fazer uma conexão HTTP e buscar os top 250 filmes 
        String url = "https://api.mocki.io/v2/549a5d8b/Top250TVs";
 //       String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD-JamesWebbSpaceTelescope.json";

//        String url = "http://localhost:8080/linguagens";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados como quiser 

        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();


 //       ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        List<Conteudo> conteudos = extrator.extraiConteudos(json);


        var geradora = new GeradorDeFigurinhas();

        for (int i = 0; i < 4; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/ " + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(nomeArquivo);
            System.out.println();
        }


    }
}