public class Fila {
    private int top;
    private int base;
    private Cordenada[] data;
    private int count;

    public Fila(int size){
        this.top = -1;
        this.base = 0;
        this.data = new Cordenada[size];
        this.count = 0;
    }


    public void add(Cordenada data){
        if (isFull()){
            throw new IllegalStateException("A fila está cheia!");
        }
        top = moveForward(top);
        this.data[top] = data;
        count++;
    }


    public int moveForward(int posicao){
        return posicao + 1 == data.length? 0 : posicao + 1;
    }


    public boolean isFull(){
        return count == data.length;
    }


    public Cordenada remove(){
        if (isEmpty()){
            throw new IllegalStateException("A fila já está vazia!");
        }
        Cordenada itemRemovido = this.data[base];
        this.data[base] = null;
        base = moveForward(base);
        count--;
        return itemRemovido;
    }


    public boolean isEmpty(){
        return count == 0;
    }


    public Cordenada[] getData(){
        return data;
    }


    public void clear(){
        data = new Cordenada[data.length];
        this.top = -1;
        this.base = 0;
        this.count = 0;
    }


    public boolean searchData (Cordenada cordenada) {
        if (!isEmpty()){
            for (Cordenada c: data) {
                if (c != null && c.getY() == cordenada.getY() && c.getX() == cordenada.getX()) {
                    return true;
                }
            }
        }
        return false;
    }

}
