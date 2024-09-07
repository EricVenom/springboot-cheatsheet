package uepb.estudo.filme.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="tb_filme")
public class Filme {

    @Id
    @GeneratedValue
    private Integer id;

    private String titulo;

    private int ano;

    @ManyToOne
    @JoinColumn(name="autor_id", nullable=false)
    @JsonBackReference
    private Autor autor;

    public Filme() {
    }

    public Filme(String titulo, int ano, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
