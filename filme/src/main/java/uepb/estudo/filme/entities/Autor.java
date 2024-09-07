package uepb.estudo.filme.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_autor")
public class Autor {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    @OneToMany(mappedBy="autor", cascade=CascadeType.ALL)
    @JsonManagedReference
    private List<Filme> filmes;

    public Autor() {}

    public Autor(String nome, List<Filme> filmes) {
        this.nome = nome;
        this.filmes = filmes;
    }

    public Autor(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
