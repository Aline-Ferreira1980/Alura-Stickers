package extrator;

import javax.imageio.ImageIO;

import resizeble.ResizeImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Graphics2D;
import java.awt.Font;

public class GeradorDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        ResizeImage size = new ResizeImage();
        imagemOriginal = size.resizeImage(imagemOriginal, 700, 900);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();

        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar fonte

        var font = new Font(Font.SERIF, Font.BOLD, 100);

//        graphics.setColor(Color.GREEN);
        graphics.setFont(font);
        graphics.drawString("TOPZERA", 100, 1050);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}