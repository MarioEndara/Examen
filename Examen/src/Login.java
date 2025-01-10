import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    private JTextField textField1;
    private JButton loginButton;
    private JPasswordField passwordField1;

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener datos de los campos
                    String usuario = textField1.getText();
                    String contraseña = new String(passwordField1.getPassword());
                    validarUsuario(usuario, contraseña);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

    }
    public void validarUsuario(String usuarioInput, String contraseñaInput) {
        try {
            String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, usuarioInput);
            ps.setString(2, contraseñaInput);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema!");
                // Abrir ventana de registro
                Registro registro = new Registro();
                registro.setVisible(true);
                this.dispose(); // Cierra la ventana de login
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al validar usuario: " + e.getMessage());
        }
    }

}

