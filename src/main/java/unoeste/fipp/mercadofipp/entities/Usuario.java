package unoeste.fipp.mercadofipp.entities;

public class Usuario {
    private Long id;
    private String nome;
    private String senha;
    private int level;

    public Usuario(Long id, String nome, String senha, int level) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.level = level;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
