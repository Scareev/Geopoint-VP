package modelo;

public class Ponto {

    private int id;
    private String nome;
    private String municipio;
    private double eixoX;
    private double eixoY;
    private int id_usuario;

    public Ponto() {}

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getMunicipio() { return municipio; }
    public double getEixoX() { return eixoX; }
    public double getEixoY() { return eixoY; }
    public int getId_usuario() { return id_usuario; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }
    public void setEixoX(double eixoX) { this.eixoX = eixoX; }
    public void setEixoY(double eixoY) { this.eixoY = eixoY; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }

    @Override
    public String toString() { return "Ponto{" +
            "id=" + id + ", " +
            "nome=" + nome + "}"
            ; }
}