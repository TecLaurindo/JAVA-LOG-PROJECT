import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class TelaLogin extends JFrame {
    private JTextField Usuario;
    private JPasswordField Senha;
    private JCheckBox rememberCheck;

    public TelaLogin() {
        setTitle("Tela de Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campo usuário
        Usuario = new JTextField();
        panel.add(new JLabel("Nome:"));
        panel.add(Usuario);

        // Campo senha
        Senha = new JPasswordField();
        panel.add(new JLabel("Senha:"));
        panel.add(Senha);

        // Checkbox lembrar login
        rememberCheck = new JCheckBox("Lembrar login");
        panel.add(rememberCheck);

        // Botão de login
        JButton loginButton = new JButton("Entrar");
        loginButton.addActionListener(e -> login());
        panel.add(loginButton);

        add(panel);
    }

    private void login() {
        String User = Usuario.getText();
        String password = new String(Senha.getPassword());
        boolean remember = rememberCheck.isSelected();

        if (User.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            salvarJson(User, password, remember);
            new TelaPosLogin(User); // Agora chama a nova classe
            dispose(); // Fecha a tela de login
        }
    }

    private void salvarJson(String User, String password, boolean remember) {
        String json = String.format("{\n  \"User\": \"%s\",\n  \"senha\": \"%s\",\n  \"lembrar\": %b\n}", User, password, remember);

        try (FileWriter file = new FileWriter("dados.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar JSON: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}