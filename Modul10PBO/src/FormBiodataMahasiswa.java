import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FormBiodataMahasiswa extends JFrame {
    protected JLabel biodataMahasiswa, nim, nama, alamat, jenisKelamin, labelprogramStudi, labeljurusan;
    protected JTextField textNim, textNama;
    protected JTextArea areaAlamat;
    protected JScrollPane scAlamat;
    protected JRadioButton radioPria, radioWanita;
    protected ButtonGroup radiogroup;
    protected JComboBox<String> comboProgramStudi, comboJurusan;
    protected JButton simpan, bacaData, keluar;
    protected JPanel panel;

    public FormBiodataMahasiswa(String namaWindow) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocation(200, 150);
        setTitle(namaWindow);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        biodataMahasiswa = new JLabel("Biodata Mahasiswa");
        biodataMahasiswa.setFont(new Font("Calibri", Font.BOLD, 30));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.insets = new Insets(20, 50, 20, 0);
        panel.add(biodataMahasiswa, constraints);

        nim = new JLabel("NIM");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(0, 0, 10, 55); // Jarak kanan
        panel.add(nim, constraints);

        textNim = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(textNim, constraints);

        nama = new JLabel("Nama");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        // constraints.anchor = G
        constraints.insets = new Insets(0, 0, 10, 0);
        panel.add(nama, constraints);

        textNama = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(textNama, constraints);

        alamat = new JLabel("Alamat");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        panel.add(alamat, constraints);

        areaAlamat = new JTextArea(5, 20);
        scAlamat = new JScrollPane(areaAlamat);
        scAlamat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(scAlamat, constraints);

        jenisKelamin = new JLabel("Jenis Kelamin");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(0, 0, 0, 55);
        panel.add(jenisKelamin, constraints);

        radiogroup = new ButtonGroup();

        radioPria = new JRadioButton("Pria");
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        panel.add(radioPria, constraints);
        radiogroup.add(radioPria);

        radioWanita = new JRadioButton("Wanita");
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        panel.add(radioWanita, constraints);
        radiogroup.add(radioWanita);

        labelprogramStudi = new JLabel("Program Studi");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        panel.add(labelprogramStudi, constraints);

        String[] programStudi = {"D3", "S1", "S2"};
        comboProgramStudi = new JComboBox<String>(programStudi);
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 10, 0);
        panel.add(comboProgramStudi, constraints);

        labeljurusan = new JLabel("Jurusan");
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        panel.add(labeljurusan, constraints);

        String[] jurusan = {"Sistem Informasi", "Teknik Informatika", "Manajemen Informatika", "Teknik Sipil"};
        comboJurusan = new JComboBox<String>(jurusan);
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        panel.add(comboJurusan, constraints);

        simpan = new JButton("Simpan");
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 0, 10);
        panel.add(simpan, constraints);

        bacaData = new JButton("Baca Data");
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 0, 10);
        panel.add(bacaData, constraints);

        keluar = new JButton("Keluar");
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        panel.add(keluar, constraints);

        simpan.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                try {
                    simpanData();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
           } 
        });

        bacaData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    readData();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        add(panel);
    }

    public void simpanData() throws IOException {
        String namaFile = "DataMahasiswa.txt";
        String inputNim = textNim.getText();
        String inputNama = textNama.getText();
        String inputAlamat = areaAlamat.getText();
        String inputJenisKelamin = "";
        if (radioPria.isSelected()) {
            inputJenisKelamin = "Laki-laki";
        } else if (radioWanita.isSelected()) {
            inputJenisKelamin = "Perempuan";
        }
        String inputProgramStudi = (String) comboProgramStudi.getSelectedItem();
        String inputJurusan = (String) comboJurusan.getSelectedItem();

        FileOutputStream outFile = new FileOutputStream(namaFile, true);
        try {
            DataOutputStream outStream = new DataOutputStream(outFile);
            outStream.writeUTF(inputNim);
            outStream.writeUTF(inputNama);
            outStream.writeUTF(inputAlamat);
            outStream.writeUTF(inputJenisKelamin);
            outStream.writeUTF(inputProgramStudi);
            outStream.writeUTF(inputJurusan);
            outStream.close();
        }
        catch(IOException e){
            System.out.println("IOERROR : " + e.getMessage() + "\n");
        }
    }

    public void readData() throws IOException {
        BacaData dialog = new BacaData(FormBiodataMahasiswa.this);
        dialog.setVisible(true);
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new FormBiodataMahasiswa("Form Biodata Mahasiswa").setVisible(true);
    }
}



class BacaData extends JDialog {
    private JTextArea data;
    private JScrollPane scData;
    private JPanel readPanel;
    private JButton closeDialog;

    public BacaData(JFrame parent) throws IOException {
        super(parent, "Baca Data", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLocation(200, 150);
        
        readPanel = new JPanel();
        readPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        data = new JTextArea(20, 30);
        scData = new JScrollPane(data);
        scData.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        readPanel.add(scData, gbc);

        closeDialog = new JButton("Tutup");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        readPanel.add(closeDialog, gbc);

        bacaDataMahasiswa();

        closeDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(readPanel);

    }

    public void bacaDataMahasiswa() throws IOException {
        String namaFile = "DataMahasiswa.txt";
        String nimMhs, namaMhs, alamatMhs, jenisKelaminMhs, programStudiMhs, jurusanMhs;

        StringBuilder sb = new StringBuilder();

        try{
            FileInputStream inFile = new FileInputStream(namaFile);
            DataInputStream inStream = new DataInputStream(inFile);
            while (inStream.available() > 0) {
                nimMhs = inStream.readUTF();
                namaMhs = inStream.readUTF();
                alamatMhs = inStream.readUTF();
                jenisKelaminMhs = inStream.readUTF();
                programStudiMhs = inStream.readUTF();
                jurusanMhs = inStream.readUTF();

                sb.append("NIM : ").append(nimMhs).append("\nNama : ").append(namaMhs)
                    .append("\nAlamat : ").append(alamatMhs).append("\nJenis Kelamin : ")
                    .append(jenisKelaminMhs).append("\nProgram Studi : ").append(programStudiMhs)
                    .append("\nJurusan : ").append(jurusanMhs).append("\n\n");
                
                data.setText(sb.toString());
            }
            inStream.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File " + namaFile + "Tidak ada!\n");
        }
        catch(IOException ex){
            System.out.println("IOERROR : " + ex.getMessage() + "\n");
        }
    }
    
}
