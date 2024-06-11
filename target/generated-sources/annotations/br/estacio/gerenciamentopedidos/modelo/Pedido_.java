package br.estacio.gerenciamentopedidos.modelo;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-07T16:34:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Integer> codigo;
    public static volatile SingularAttribute<Pedido, String> telefone;
    public static volatile SingularAttribute<Pedido, Double> valorPorPeca;
    public static volatile SingularAttribute<Pedido, Integer> valorTotal;
    public static volatile SingularAttribute<Pedido, LocalDate> dataLimite;
    public static volatile SingularAttribute<Pedido, String> nomePedido;
    public static volatile SingularAttribute<Pedido, Integer> quantidadePecasTotal;

}