import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class GeradorDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

       // InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg" ));

        //InputStream inputStream = new URL("https://photos.google.com/photo/AF1QipMWuQAs_8VCQEURlDwi_RejSp8_kDtQ95eDS7w7").openStream();
        BufferedImage imagemOriginal =  ImageIO.read(inputStream);
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics= (Graphics2D) novaImagem.getGraphics();

        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar fonte

        var font= new Font(Font.SERIF, Font.BOLD, 64);

        graphics.setColor(Color.GREEN);
        graphics.setFont(font);
        graphics.drawString("TOPZERA", 300, novaAltura-100);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    //Fazer leitura da imagem

    // criear nova imagem em moemoria com transparencia e com tamanho novo 
    //escrever uma frase na nova imagem
    //copiar imagem original para nova imagem (em memória)
    //escrever a nova imagem em um arquivo
    }

}
