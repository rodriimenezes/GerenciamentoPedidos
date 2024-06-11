/*
FUNÇÕES PRINCIPAIS
*/

package br.estacio.gerenciamentopedidos.controle;

import br.estacio.gerenciamentopedidos.modelo.Pedido;
import br.estacio.gerenciamentopedidos.modelo.PedidoDAO;
import br.estacio.gerenciamentopedidos.utils.ConexaoDB;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;

public class ControlePedido {
    private Pedido pedido;
    private PedidoDAO dao;
    private EntityManager em;
    
    public static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
    public void novoPedido(Integer ano, Integer mes, Integer dia, String nome, Integer qtdPecas, String telefone, Integer valorTotal){
        em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        pedido = new Pedido();
        pedido.setDataLimite(LocalDate.of(ano,mes,dia));
        pedido.setNomePedido(nome);
        pedido.setQuantidadePecasTotal(qtdPecas);
        pedido.setTelefone(telefone);
        pedido.setValorTotal(valorTotal);
        pedido.setValorPorPeca(round(valorTotal * 1.0 /qtdPecas,2));
        dao = new PedidoDAO(em);
        dao.cadastrarPedido(pedido);
        em.getTransaction().commit();
        em.close();
    }
    
    public void apagarPedido(Integer codigo){
        pedido = buscaPedido(codigo);
        em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        dao = new PedidoDAO(em);
        dao.apagarPedido(pedido);
        em.getTransaction().commit();
        em.close();

    }
    
    public void editarPedido(String codigo, String nome, String telefone, String qtdPecas, 
                                    String valorTotal, String dia, String mes, String ano){
        em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        dao = new PedidoDAO(em);
        
        Integer intDia;
        Integer intMes;
        Integer intAno;
        
        pedido = dao.buscarPedido(Integer.valueOf(codigo));
        System.out.println(pedido.getCodigo()+"\n"+pedido.getNomePedido());
        
        if(!Objects.equals(nome,"")){
            pedido.setNomePedido(nome);
        }
        if(!Objects.equals(telefone,"")){
            pedido.setTelefone(telefone);
        }
        if(!Objects.equals(qtdPecas,"")){
            pedido.setQuantidadePecasTotal(Integer.valueOf(qtdPecas));
        }
        if(!Objects.equals(valorTotal,"")){
            pedido.setValorTotal(Integer.valueOf(valorTotal));
        }
        if(Objects.equals(dia,"")){
            intDia = pedido.getDataLimite().getDayOfMonth();
        }else{
            intDia = Integer.valueOf(dia);
        }
        if(Objects.equals(mes,"")){
            intMes = pedido.getDataLimite().getMonthValue();
        }else{
            intMes = Integer.valueOf(mes);
        }
        if(Objects.equals(ano,"")){
            intAno = pedido.getDataLimite().getYear();
        }else{
            intAno = Integer.valueOf(ano);
        }
        
        pedido.setValorPorPeca(round(pedido.getValorTotal()*1.0/pedido.getQuantidadePecasTotal(), 2));
        pedido.setDataLimite(LocalDate.of(intAno,intMes,intDia));
 
        dao.editarPedido(pedido);
       
        em.getTransaction().commit();
        em.close();
    }

    public Pedido buscaPedido(Integer codigo) {
        em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        dao = new PedidoDAO(em);
        pedido = dao.buscarPedido(codigo);
        em.getTransaction().commit();
        em.close();
        return pedido;  
    }
    
    public List<Pedido> listarPedidos(){
        List<Pedido> lista = null;
        em = ConexaoDB.getEntityManager();
        em.getTransaction().begin();
        dao = new PedidoDAO(em);
        lista = dao.listarPedidos();
        em.getTransaction().commit();
        em.close();
        return lista;
    }
}
