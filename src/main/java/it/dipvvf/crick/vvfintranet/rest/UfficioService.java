/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.dipvvf.crick.vvfintranet.rest;

import it.dipvvf.crick.vvfintranet.model.Ufficio;
import it.dipvvf.crick.vvfintranet.producer.IntranetLogger;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;

/**
 *
 * @author Crick
 */
@Stateless
@LocalBean
@Path("ufficio")
@Produces(MediaType.APPLICATION_JSON)
public class UfficioService {
    @PersistenceContext
    EntityManager em;
    @Inject
    @IntranetLogger
    Logger logger;
    
    @GET
    public List<Ufficio> getUffici()  {
        return em.createNamedQuery("Ufficio.findAll").getResultList();
    }
    
    @GET
    @Path("{codice: \\w+}")
    public Response getUfficio(@PathParam("codice") String codice) {
        logger.debug("Requesting Ufficio with code [{}].", codice);
        Ufficio u = em.find(Ufficio.class, codice);
        return (u!=null) 
                ? Response.ok(u).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
