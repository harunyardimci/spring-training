package com.gg.petclinic.web;

import com.gg.petclinic.model.Vet;
import com.gg.petclinic.service.PetClinicService;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * User: { "id": "hyardimci", "email":nosqlsolutions@gmail.com"}
 * Date: 5/11/13
 * Time: 11:09 AM
 */
@WebServlet(name = "PetClinicServlet")
public class PetClinicServlet extends HttpServlet {

    public PetClinicServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getVets".equals(action)) {
            WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

            PetClinicService petClinicService = applicationContext.getBean(PetClinicService.class);
            Collection<Vet> vets = petClinicService.getVets();
            response.getWriter().write("<h1>Vets</h1>" + StringUtils.collectionToDelimitedString(vets,"<br/>"));

        } else {
            response.getWriter().write("unknown action :" + action);
        }
    }
}
