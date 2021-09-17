package Graphics;

public final class Sprite {

    private final int size;

    private int x;
    private int y;

    public int[] pixles;
    private final HojaSprite hoja;


    //inicio

    public static Sprite Casilla1 = new Sprite(75, 0, 0, HojaSprite.Tablero);

    //fin



    // i = fila, j = columna
    public Sprite(final int size, final int j, final int i,
                  final HojaSprite hoja){

        this.x = j * size;
        this.y = i * size;
        this.size = size;
        this.hoja = hoja;

        pixles = new int[this.size * this.size];



        for (int y = 0; y < size; y++ ){
            for (int x = 0; x < size; x++){
                pixles[x + y * size] = hoja.pixeles[(x + this.x)
                        + (y + this.y) * hoja.getHeigt()];

            }

        }
    }

}
