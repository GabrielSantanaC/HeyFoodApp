package com.heyfood.heyfoodapp.restaurante.dominio;
import com.heyfood.heyfoodapp.categoria.dominio.Categoria;
import com.heyfood.heyfoodapp.contato.dominio.Contato;
import com.heyfood.heyfoodapp.endereco.dominio.Endereco;
import com.heyfood.heyfoodapp.proprietario.dominio.Proprietario;


public class Restaurante{
    private long id;
    private String nome;
    private float notaMedia;
    private String cnpj;
    private Endereco endereco;
    private Contato contato;
    private Categoria especialidades;
    private Proprietario proprietario;

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public Categoria getEspecialidades() {
        return especialidades;
    }

    public void setId(int id) {
        this.id = new Long(id);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setEspecialidades(Categoria especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", notaMedia=" + notaMedia +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}