public class Pilha {
    private int top;
    private Cordenada[] data;

    public Pilha(int size){
        this.top = -1;
        this.data = new Cordenada[size];
    }


    public void push(Cordenada data){
        if (isFull()){
            throw new IllegalStateException("A pilha está cheia!");
        }
        this.data[++top] = data;
    }


    public boolean isFull(){
        return top + 1 == data.length;
    }


    public Cordenada pop(){
        if (isEmpty()){
            throw new IllegalStateException("A pilha já está vazia!");
        }
        Cordenada itemRemovido = this.data[top];
        this.data[top] = null;
        top--;
        return itemRemovido;
    }


    public boolean isEmpty(){
        return top == -1;
    }


    public void clear(){
        data = new Cordenada[data.length];
        top = -1;
    }


    public int getSize() {
        return data.length;
    }

}
