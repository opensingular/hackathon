package org.opensingular.hackathon.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FORNECEDOR")
public class FornecedorEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "EMAIL_CONTATO")
    private String emailContato;

    @Column(name = "ATIVIDADES")
    private String atividades;

    @JoinColumn(name = "ID_ENDERECO")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EnderecoEntity endereco;

    @Column(name = "NOME_CONTATO")
    private String nomeContato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public EnderecoEntity getEndereco() {
        if (endereco == null) {
            endereco = new EnderecoEntity();
        }
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }
}
