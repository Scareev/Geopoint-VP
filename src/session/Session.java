package session;

import modelo.Usuario;

public class Session {
    //Variavel da classe
    private static Session instance;
    private Usuario usuarioLogado;

    // Construtor privado: ninguém de fora consegue instanciar
    private Session() {}

    // Ponto de acesso global
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    //Getter e Setter
    public Usuario getUsuario() {return usuarioLogado;}
    public void setUsuario(Usuario usuario) {this.usuarioLogado = usuario;}

    // Apontar o objeto para null
    public void limparSessao() {
        this.usuarioLogado = null;
    }
}