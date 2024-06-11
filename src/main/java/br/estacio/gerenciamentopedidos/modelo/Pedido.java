/*
CLASSE PRINCIPAL DO PEDIDO
*/
package br.estacio.gerenciamentopedidos.modelo;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="pedido")
@Table(name="pedido")
public class Pedido{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @Column(nullable=false, unique=true)
    private String telefone;
    
    @Column(nullable=false)
    private String nomePedido;
    
    @Column(nullable=false)
    private LocalDate dataLimite;
    
    @Column(nullable=false)
    private Integer quantidadePecasTotal;
    
    @Column(nullable=false)
    private Integer valorTotal;
    
    @Column(nullable=false)
    private Double valorPorPeca;

    public Pedido() {
    }

    public Pedido(String telefone, String nomePedido, LocalDate dataLimite, Integer quantidadePecasTotal, Integer valorTotal, Double valorPorPeca) {
        this.nomePedido = nomePedido;
        this.telefone = telefone;
        this.dataLimite = dataLimite;
        this.quantidadePecasTotal = quantidadePecasTotal;
        this.valorTotal = valorTotal;
        this.valorPorPeca = valorPorPeca;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public Integer getQuantidadePecasTotal() {
        return quantidadePecasTotal;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public Double getValorPorPeca() {
        return valorPorPeca;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public void setQuantidadePecasTotal(Integer quantidadePecasTotal) {
        this.quantidadePecasTotal = quantidadePecasTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setValorPorPeca(Double valorPorPeca) {
        this.valorPorPeca = valorPorPeca;
    }
    
    
    
}
