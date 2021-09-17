package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HojaSprite {
    private final int widh;
    private int heigt;
    public final int[] pixeles;

    // inicio

    public static HojaSprite Tablero = new HojaSprite(
            "/Sprites/Tablero.png", 400, 399);

    // fin

    public HojaSprite(final String ruta, final int widh, final int heigt){

        this.widh = widh;
        this.heigt = heigt;

        pixeles = new int[widh * heigt];

        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(HojaSprite.class.getResource(ruta));
            imagen.getRGB(0,0,widh,heigt,pixeles, 0, heigt);
        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }

    public int getHeigt() {
        return heigt;
    }
}
