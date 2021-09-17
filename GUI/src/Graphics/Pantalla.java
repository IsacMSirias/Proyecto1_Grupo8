package Graphics;

public class Pantalla {

    private final int widh;
    private final int heigt;

    public final int[] pixeles;

    private final static int LADOSPRITE = 75;
    private final static int MASCK = LADOSPRITE -1;

    public Pantalla(final int widh, final int heigt){

        this.widh = widh;
        this.heigt = heigt;

        pixeles = new int[ widh * heigt];

    }

    public void clean(){

        for (int i = 0; i < pixeles.length; i++){
            pixeles[i] = 0;

        }
    }

    public void mostrar(final int compX, final int compY){

        for (int y = 0; y < heigt; y++){
            int posicionY = y + compY;
            if (posicionY < 0 || posicionY >= heigt){
                continue;
            }

            for (int x = 0; x < heigt; x++){
                int posicionX = x + compX;
                if (posicionX < 0 || posicionX >= heigt){
                    continue;
                }

                pixeles[posicionX + posicionY * heigt] =
                        Sprite.Casilla1.pixles[(x & MASCK) + (y & MASCK) * LADOSPRITE];

            }
        }

    }

}
