package antri;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class login {
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JTextField username;
    private JPasswordField password;
    private JButton btnMasuk;
    public JPanel panelMain;

    public login() {
        btnMasuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (username.getText().equals("dumatubun") && password.getText().equals("kunciajaib"))
                {
                    JOptionPane.showMessageDialog(null, "Login berhasil");
                    JFrame utama = new JFrame("main");
                    utama.setContentPane(new main().utamabox);
                    utama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    utama.setLocationRelativeTo(null);
                    utama.pack();
                    utama.setVisible(true);

                        }
                else
                {
                    JOptionPane.showMessageDialog(null, "Username atau Password Belum Sesuai");
                }

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("login");
        frame.setContentPane(new login().panelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
