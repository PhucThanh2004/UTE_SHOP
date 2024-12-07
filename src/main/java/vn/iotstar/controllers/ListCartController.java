package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.CartDetailWithProduct;
import vn.iotstar.models.CartModel;
import vn.iotstar.service.ICartService;
import vn.iotstar.service.impl.CartServiceImpl;
import vn.iotstar.utils.Constant;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/cart/view"})
public class ListCartController extends HttpServlet {
    private ICartService cartService;

    @Override
    public void init() throws ServletException {
        cartService = new CartServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int accountId = 1;
            CartModel cart = cartService.findCartByAccountId(accountId);
            if(cart == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found cart");
                return;
            }
            List<CartDetailWithProduct> carts = cartService.getCartDetailsWithProducts(cart.getId());
            double totalAmount = 0;

            for (CartDetailWithProduct cartDetail : carts) {
                double productPrice = cartDetail.getProductPrice();
                int quantity = cartDetail.getQuantity();
                totalAmount += productPrice * quantity;
            }

            req.setAttribute("carts", carts);
            req.setAttribute("totalAmount", totalAmount);
            req.getRequestDispatcher(Constant.USER_CART_LIST).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding to cart.");
        }
    }
}
