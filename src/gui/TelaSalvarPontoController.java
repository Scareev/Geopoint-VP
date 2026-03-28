package gui;

import dao.PontoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Ponto;
import session.Session;

public class TelaSalvarPontoController {

    @FXML private Label labelCoordX;
    @FXML private Label labelCoordY;
    @FXML private TextField nomeSalvarCoordenada;
    @FXML private Button botaoSalvarCoordenada;

    Ponto pontos = new Ponto();

    public void setCoords(double x, double y) {
        labelCoordX.setText(String.valueOf(x));
        labelCoordY.setText(String.valueOf(y));
    }

    @FXML public void salvarCoordenada() {
        PontoDAO dao = new PontoDAO();
        pontos.setEixoX(Double.parseDouble(labelCoordX.getText()));
        pontos.setEixoY(Double.parseDouble(labelCoordY.getText()));
        pontos.setNome("SEM_NOME_POR_ENQUANTO");
        pontos.setMunicipio("SEM_MUNICIPIO_POR_ENQUANTO");
        pontos.setId_usuario(Session.getInstance().getUsuario().getId());
        dao.salvarPontos(pontos);
        Stage stage = (Stage) botaoSalvarCoordenada.getScene().getWindow();
        stage.close();
        System.out.println("Ponto salvo com sucesso! Acesse-os no próximo update!");
    }
}
