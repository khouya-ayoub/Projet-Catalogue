package fr.catalogue.servlets;

import fr.catalogue.beans.Panier;
import fr.catalogue.beans.Produit;
import fr.catalogue.ejb.controllers.PanierEJB;
import fr.catalogue.ejb.interfaces.remote.PanierRemote;
import fr.catalogue.global.AppContext;
import fr.catalogue.global.EnumEJB;
import fr.catalogue.interfaces.PanierMethodes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet implements PanierMethodes {

    private static final long serialVersionUID = -2543996090073074652L;

    private PanierRemote panierRemote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Session
        HttpSession session = req.getSession(true);

        Map<String, String[]> mapParams = req.getParameterMap();

        req.getRequestDispatcher("/pages/panier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Session
        HttpSession session = req.getSession(true);

        Map<String, String[]> mapParams = req.getParameterMap();
        Panier panier = (Panier) session.getAttribute("panier");

        if (mapParams.isEmpty()) {
            doGet(req, resp);
        }

        if (mapParams.containsKey("add")) {
            if (panier != null) {

                panier.getProduits().add(addProduitToPanier(Integer.parseInt(mapParams.get("add")[0])));
                session.setAttribute("panier", panier);

            } else {

                panier = new Panier();
                panier.getProduits().add(addProduitToPanier(Integer.parseInt(mapParams.get("add")[0])));
                session.setAttribute("panier", panier);

            }
        } if (mapParams.containsKey("remove")) {

            if (panier != null) {

                panier.getProduits().remove(Integer.parseInt(mapParams.get("remove")[0]));
                session.setAttribute("panier", panier);

            }
        }

    }

    @Override
    public Panier getPanier(int id) {
        panierRemote = (PanierRemote) AppContext.getRemote(PanierRemote.class, EnumEJB.PANIER.getEjbName());
        return panierRemote.getPanier(id);
    }

    @Override
    public Produit addProduitToPanier(int id) {
        panierRemote = (PanierRemote) AppContext.getRemote(PanierRemote.class, EnumEJB.PANIER.getEjbName());
        return panierRemote.getProduit(id);
    }

    @Override
    public Produit getProduitFromPanier(int id) {
        panierRemote = (PanierRemote) AppContext.getRemote(PanierRemote.class, EnumEJB.PANIER.getEjbName());
        return panierRemote.getProduit(id);
    }


}
