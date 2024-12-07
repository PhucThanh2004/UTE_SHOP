package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.CartDetailWithProduct;
import vn.iotstar.models.CartModel;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.models.ProductModel;
import vn.iotstar.service.ICartService;
import vn.iotstar.service.ICategoryService;
import vn.iotstar.service.IOrderService;
import vn.iotstar.service.IProductService;
import vn.iotstar.service.impl.CartServiceImpl;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.OrderServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.utils.Constant;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IProductService productService;
    private ICategoryService categoryService;
    private IOrderService orderService;
    private ICartService cartService;
    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
        categoryService = new CategoryServiceImpl();
        orderService = new OrderServiceImpl();
        cartService = new CartServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
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
            req.getRequestDispatcher(Constant.USER_CHECKOUT).forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int accountId = 1;
            String paymentMethod = "COD";
            String note = request.getParameter("note");

            List<Integer> orderIds = orderService.checkoutCart(accountId, paymentMethod, note);

            // Sau khi checkout thành công, chuyển hướng về trang đơn hàng
            request.getSession().setAttribute("successMessage", "Checkout thành công với " + orderIds.size() + " đơn hàng!");
            response.sendRedirect("orders"); // Trang quản lý đơn hàng của user
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMessage", "Có lỗi xảy ra khi checkout!");
            response.sendRedirect("cart"); // Quay lại trang giỏ hàng nếu lỗi
        }
    }
}
