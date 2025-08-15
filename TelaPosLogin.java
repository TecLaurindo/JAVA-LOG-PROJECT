import javax.swing.*;
import java.awt.*;

public class TelaPosLogin extends JFrame {

    public TelaPosLogin(String User) {
        setTitle("Bem-vindo");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel mensagem = new JLabel("Olá, " + User + "! Você entrou com sucesso.", SwingConstants.CENTER);
        mensagem.setFont(new Font("Arial", Font.PLAIN, 14));

        add(mensagem);
        setVisible(true);
    }
}