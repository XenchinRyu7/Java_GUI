import java.awt.*;
import java.awt.event.*;
// import java.awt.event.ActionListener;

import javax.swing.*;

public class KonversiSuhu extends JFrame {
    protected JLabel labelSuhuCel;
    protected JTextField textSuhuCel, labelhasil;
    protected JButton btnKonversi;
    protected JPanel panel;

    public KonversiSuhu(String namaWindow) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocation(200, 150);
        setTitle(namaWindow);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        
        labelSuhuCel = new JLabel("<html>Masukkan Suhu<br>dalam celcius</html>");
        panel.add(labelSuhuCel);

        textSuhuCel = new JTextField();
        panel.add(textSuhuCel);

        labelhasil = new JTextField();
        panel.add(labelhasil);

        btnKonversi = new JButton("KONVERSI");
        panel.add(btnKonversi); 

        btnKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                konversiSuhu();
            }
        });

        add(panel);
    }

    public void konversiSuhu() {
        try {
            double suhuCelcius = Double.parseDouble(textSuhuCel.getText());
            double suhuFahrenheit = (suhuCelcius * 9 / 5) + 32;
            labelhasil.setText(suhuFahrenheit + " Fahrenheit");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukan suhu yang valid untuk celcius!");
        }
    }


    public static void main(String[] args) {
        // JFrame.setDefaultLookAndFeelDecorated(true);
        new KonversiSuhu("KONVERSI SUHU").setVisible(true);
    }
}
