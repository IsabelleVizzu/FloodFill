public class Cordenada {
    int x;
    int y;

    public Cordenada (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    public Cordenada soma (Cordenada c) {
        int x = this.x + c.getX();
        int y = this.y + c.getY();
        return new Cordenada(x,y);
    }

}
