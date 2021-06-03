package antri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Queue;
import java.util.LinkedList;

public class main extends Component {
    public JPanel utamabox;
    private JLabel lbNo;
    private JLabel lbNama;
    private JLabel lbBanyak;
    private JLabel lbTotal;
    private JButton ambilNomorButton;
    private JTextArea txAntri;
    private JButton selanjutnyaButton;
    private JTextField txNama;
    private JButton resetButton;

    Queue antrian =  new LinkedList<>();
    Queue nama =  new LinkedList<>();

    int nomor = 0;

    public main() {
    inisialisasi() ;
        ambilNomorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ambilNomor();

            }
        });
        selanjutnyaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selanjutnya();
            }
        });
        txNama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char c = e.getKeyChar();

                txNama.setEditable(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }


    private void inisialisasi() {
        lbBanyak.setText("0");
        lbTotal.setText("0");
        lbNo.setText("Antrian Kosong");
        lbNama.setText("-----------");
    }

    public void reset() {
        JOptionPane.showMessageDialog(null, "Antrian ter-reset");
        lbBanyak.setText("0");
        lbTotal.setText("0");
        lbNo.setText("Antrian Kosong");
        lbNama.setText("-----------");
        txAntri.setText("");
        antrian.clear();
        nama.clear();
        nomor = 0;
    }




    public void ambilNomor() {
        if (txNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silakan Masukkan Nama Terlebih Dahulu !");

        }
        else {
            nomor++;
            String nm = txNama.getText();
            String ant = "Antrian " + nomor;
            antrian.add(ant);
            nama.add(nm);
            String jml = String.valueOf(antrian.size());
            lbBanyak.setText(jml);
            lbNo.setText(""+antrian.peek());
            lbTotal.setText(""+nomor);
            txAntri.append(nm + "\n");
            lbNama.setText(""+nama.peek());
            txNama.setText("");
        }

    }
    private void selanjutnya(){
        if(antrian.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ambil Nomor antrian terlebih dahulu !");
        }
        txAntri.setText("");
        antrian.poll();
        nama.poll();
        String jml = String.valueOf(antrian.size());
        lbBanyak.setText(jml);
        nama.forEach((Object element) -> {
            txAntri.append("" + element + "\n");
        });
        if(antrian.isEmpty()){
            lbNo.setText("Antrian Kosong");
            lbNama.setText("------------");
        }else{
            lbNo.setText(""+antrian.peek());
            lbNama.setText(""+nama.peek());
        }
    }

    public static void main(String[] args) {
        JFrame utama = new JFrame("main");
        utama.setContentPane(new main().utamabox);
        utama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        utama.setLocationRelativeTo(null);
        utama.pack();
        utama.setVisible(true);
    }
}