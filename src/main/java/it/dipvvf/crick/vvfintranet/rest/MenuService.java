/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.dipvvf.crick.vvfintranet.rest;

import it.dipvvf.crick.vvfintranet.model.Menu;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

/**
 *
 * @author Crick
 */
@Stateless
@LocalBean
@Path("menu")
@Produces(MediaType.APPLICATION_JSON)
public class MenuService {
    @PersistenceContext
    EntityManager em;
    
    @GET
    public List<Menu> getMenu() {
        return em.createNamedQuery("Menu.findAllSorted").getResultList();
    }
}
