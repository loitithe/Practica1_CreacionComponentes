import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main implements ActionListener {

    private static JButton btnStart;
    private static boolean pulsado;
    private static ArrayList<Ficha>listafichas;
    public void initPantalla() {
        pulsado = false;
        listafichas= new ArrayList<>();
        JPanel ventana = new JPanel();
        JFrame ventanaPrincipal = new JFrame();
        ventanaPrincipal.setLayout(new BorderLayout());
        ventana.setLayout(new GridLayout(3, 3));
        for (int i = 9; i > 0; i--) {
            Ficha ficha = new Ficha(i, Color.blue);
            listafichas.add(ficha);
            ventana.add(ficha);
        }
        ventanaPrincipal.add(ventana, BorderLayout.CENTER);

        btnStart = new JButton("START");
        btnStart.addActionListener(this);
        btnStart.setBackground(Color.green);
        btnStart.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        btnStart.setForeground(Color.white);
        ventanaPrincipal.add(btnStart, BorderLayout.SOUTH);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setSize(400, 400);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initPantalla();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass() == JButton.class) {
            JButton btnPulsado = (JButton) e.getSource();
            if (btnPulsado.equals(btnStart)) {
                pulsado =!pulsado;
                System.out.println("pulsado :"+pulsado);
                if (pulsado) {
                    btnStart.setBackground(Color.red);
                    btnStart.setText("STOP");
                    listafichas.forEach((x)-> x.ocultarIndex());
                }else{
                    btnStart.setBackground(Color.green);
                    btnStart.setText("START");
                    listafichas.forEach((x)-> x.mostrarIndex());
                }
            }
        }
    }


}