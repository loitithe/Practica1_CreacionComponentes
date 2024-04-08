import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventObject;
import java.util.Vector;


public class Ficha extends Button implements Serializable {
    private int index;
    private Color colorFondo;
    private boolean mostrar;

    private Vector fichaListener= new Vector<>();


    private Ficha() {
    }

    public synchronized void mostrarIndex(FichaListener listener){
        fichaListener.addElement(listener);
    }

    Ficha(int index, Color color) {
        super("" + index);
        this.mostrar=true;
        this.index = index;
        this.colorFondo = color;
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        super.setBackground(getColorFondo());
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public void mostrarIndex() {

    }

    public void ocultarIndex() {
    }
    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
        FichaEvent event = new FichaEvent(this,mostrar);

    }

    private void notificarCambio(FichaEvent event){
        Vector lista;
        synchronized (this){
            lista = (Vector)fichaListener.clone();
        }
        for (int i = 0; i < lista.size(); i++) {
            FichaListener listener =(FichaListener) lista.elementAt(i);
            listener.ocultaIndex(event);
        }
    }

    public static void main(String[] args) {
        Ficha ficha = new Ficha();

        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("ficha.obj"));
            salida.writeObject(ficha);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
