import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerFactory {
    void create(InputStream inputStream, String outFileName) throws IOException{
        // 1 - Leitura do arquivo
        BufferedImage originalImage = ImageIO.read(inputStream);

        // 2 - Cria nova imagem em memória com transparência e com tamanho novo        
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        
        // 3 - Copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D)newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // 4 - Escrever uma frase na imagem
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 44);   
        graphics.setColor(Color.YELLOW);     
        graphics.setFont(font);
        graphics.drawString("TOPZERA", 20, newHeight - 100);

        // 5 -Escrever a nova imagem em um novo arquivo
        String validOutFileName =outFileName.replaceAll("[^a-zA-Z0-9]"," ");

        File file = new File(String.format("assets/out/%s.png", validOutFileName));

        ImageIO.write(newImage, "png", file);
    }
}
