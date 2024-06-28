package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.service.traducao.ConsultaMyMemory;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao()))
                .orElse(0);
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        if (this.genero == null) {
            System.out.println("Categoria desconhecida: " + dadosSerie.genero().split(",")[0].trim());
            // Você pode atribuir uma categoria padrão aqui, se necessário
        }
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse()).trim();

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    // getters e setters

    @Override
    public String toString() {
        return "Série: " + titulo +
                "\nTotalTemporadas=" + totalTemporadas +
                "\nAvaliacao: " + avaliacao +
                "\nGenero: " + genero +
                "\nAtores(as): " + atores +
                "\nposter='" + poster +
                "\nSinopse='" + sinopse + "\n--------------" ;
    }
}
