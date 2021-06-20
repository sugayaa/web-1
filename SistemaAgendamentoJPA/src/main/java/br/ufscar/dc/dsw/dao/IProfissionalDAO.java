package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Consulta;

@SuppressWarnings("unchecked")
public interface IProfissionalDAO extends CrudRepository<Profissional, Long> {
    Profissional findById(long id);
    List<Profissional> findByEspecialidade(String especialidade);
    Profissional save(Profissional profissional);
    void deleteById(long id);
    List<Profissional> findAll();

    @Query("SELECT p FROM Profissional p WHERE p.email = :email")
    public Profissional getUserByUsername(@Param("email") String email);


    /*
    @Query("SELECT c.profissional FROM Consulta c WHERE c.id = :consulta_id")
    public Profissional findByConsulta(@Param("consulta") long consulta.getID());
    */
    
}

/*
SELECT orders.order_id, products.product_name,customers.customer_name,products.price
FROM orders
INNER JOIN products ON products.product_id = order.product_id
INNER JOIN customers on customers.customer_id = order.customer_id;
*/
