/*
DATA ACCESS OBJECT DA CLASSE PEDIDO
*/

package br.estacio.gerenciamentopedidos.modelo;

import java.util.List;
import javax.persistence.EntityManager;

public class PedidoDAO {
    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void cadastrarPedido(Pedido pedido){
        em.persist(pedido);
    }
    
    public void editarPedido(Pedido pedido){
        em.merge(pedido);
    }
    
    public void apagarPedido(Pedido pedido){
        pedido = em.merge(pedido);
        em.remove(pedido);
    }
    
    public Pedido buscarPedido(Integer codigo){
        return em.find(Pedido.class, codigo);
    }
    
    public List<Pedido> listarPedidos(){
        List<Pedido> lista = null;
        String queryList = "SELECT p FROM pedido p";
        
        lista = em.createQuery(queryList, Pedido.class).getResultList();
        return lista;   
    }
}
