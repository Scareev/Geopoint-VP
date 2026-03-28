package gui;


import dao.PontoDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent; // Import necessário para os botões
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Ponto;
import modelo.Usuario;
import session.Session;

import java.io.IOException;

public class TelaPrincipalController {

    @FXML private Label usuarioDisplay;
    @FXML private Label coordX;
    @FXML private Label coordY;
    @FXML private Button salvarCoords;
    @FXML private Button botaoSair;

    @FXML private ImageView mapaImagem;
    @FXML private Canvas mapaCanvas;

    Ponto pontos = new Ponto();

    @FXML public void initialize() {
        Usuario logado = Session.getInstance().getUsuario();

        if (logado != null) {
            usuarioDisplay.setText("Olá, " + logado.getNome());
        } else {
            usuarioDisplay.setText("Olá, Visitante");
        }

        //FUNÇÃO DO CANVAS
        //PARA COLOCAR AS COORDENADAS DO MAPA
        mapaCanvas.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            coordX.setText(String.valueOf(x));
            coordY.setText(String.valueOf(y));
            GraphicsContext gc = mapaCanvas.getGraphicsContext2D();
            gc.clearRect(0, 0, mapaCanvas.getWidth(), mapaCanvas.getHeight());
            gc.setFill(Color.BLUE);
            gc.fillOval(x, y, 7, 7);
        });
    }

    @FXML public void sair() throws IOException {

        // limpar sessão
        Session.getInstance().limparSessao();

        // fechar tela atual
        Stage telaAtual = (Stage) botaoSair.getScene().getWindow();
        telaAtual.close();

        // voltar a tela de login
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TelaLogin.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML public void salvarCoordenadas() throws IOException{
        if(!coordX.getText().isEmpty() && !coordY.getText().isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TelaSalvarPonto.fxml"));
            Parent root = loader.load();
            TelaSalvarPontoController controller = loader.getController();
            controller.setCoords(
                    Double.parseDouble(coordX.getText()),
                    Double.parseDouble(coordY.getText())
            );
            Stage telaSalvarCoordenadas = new Stage();
            telaSalvarCoordenadas.setScene(new Scene(root));
            telaSalvarCoordenadas.show();
        } else {
            System.out.println("não pode salvar vazio.");
        }
    }
}
