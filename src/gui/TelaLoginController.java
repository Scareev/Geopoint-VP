package gui;

import dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;
import session.Session;

import java.io.IOException;

public class TelaLoginController {

    @FXML private TextField campoNome;
    @FXML private PasswordField campoSenha;
    @FXML private Button botaoLogar;
    @FXML private Button botaoCadastrar;

    Usuario user = new Usuario();

    @FXML public void logar() throws IOException {
        UsuarioDAO dao = new UsuarioDAO();
        user.setNome(campoNome.getText());
        user.setSenha(campoSenha.getText());
        Usuario resultado = dao.logarUsuario(user);
        if (resultado == null){
            System.out.println("Login falhou");
        } else {
            //Criar a sessão
            Session.getInstance().setUsuario(resultado);

            //Fechar login
            Stage stageLogin = (Stage) botaoLogar.getScene().getWindow();
            stageLogin.close();

            //Abrir tela principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TelaPrincipal.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Login efetuado!");
        }
    }
}
