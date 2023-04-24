import javax.swing.*;

class Praktikum3 extends JFrame{
    public Praktikum3(String title){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,150);
        setLocation(200, 150);
        setTitle(title);
        setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Praktikum3("Window Utama");
    }
}