import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
     

        //fazer uma conexão HTTP e buscar os top 250 filmes 
        String endpoint = "https://api.mocki.io/v2/549a5d8b/Top250TVs";

        URI endereco = URI.create(endpoint);

        var client = HttpClient.newHttpClient();
        
        var request =HttpRequest.newBuilder(endereco).GET().build();

       HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());

       String body = response.body();
      // System.out.println(body);
        
        //pegar só os dados que interessam (título, poster e classificação) chamada de parsear os dados

        var parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        System.out.println(listaDeFilmes.size());

        // exibir e manipular os dados como quiser 


        var geradora = new GeradorDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {

           
            try{

 
                String urlImagem  = filme.get("image");
            
                String titulo = filme.get("title");
            
                InputStream inputStream = new URL(urlImagem).openStream();

                String nomeArquivo = titulo+ ".png";

                geradora.cria(inputStream, nomeArquivo); 
                System.out.println(titulo);
            }catch(FileNotFoundException e){
                System.out.println("Imagem não encontrada ou link inválido");
            }
           
    
        }

    }
}
