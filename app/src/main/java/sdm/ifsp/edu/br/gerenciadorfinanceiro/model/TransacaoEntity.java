package sdm.ifsp.edu.br.gerenciadorfinanceiro.model;

import java.util.Date;

public class TransacaoEntity {

    private Integer id;
    private ContaEntity conta;
    private String operacao;
    private String tipoOperacao;
    private String descricao;
    private Long valor;
    private Date dataCriacao;

    public TransacaoEntity() {
    }

    public TransacaoEntity(ContaEntity conta, String operacao, String tipoOperacao, Long valor, String descricao, Date dataCriacao) {
        this.conta = conta;
        this.operacao = operacao;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public ContaEntity getConta() {
        return conta;
    }

    public void setConta(ContaEntity conta) {
        this.conta = conta;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TransacaoEntity{" +
                "id=" + id +
                ", conta=" + conta +
                ", operacao='" + operacao + '\'' +
                ", tipoOperacao='" + tipoOperacao + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
