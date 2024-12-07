package vn.iotstar.controllers.shop.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.ProductModel;
import vn.iotstar.service.IProductService;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.utils.Constant;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/shop/product/list-product"})
public class ListProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IProductService productService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService = new ProductServiceImpl();
        int page = Integer.parseInt(req.getParameter("page") != null ? req.getParameter("page") : "1");
        int pageSize = 10;

        int shopId = 4; //co the lay theo account login

        try {
            List<ProductModel> products = productService.getProductsByShop(shopId, page, pageSize);

            int totalRecords  = productService.getProductCountByShop(shopId);
            int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
            int begin = Math.max(page - 2, 1);
            int end = Math.min(page + 2, totalPages);

            req.setAttribute("products", products);
            req.setAttribute("currentPage", page);
            req.setAttribute("totalPages", totalPages);
            req.setAttribute("begin", begin);
            req.setAttribute("end", end);
            req.getRequestDispatcher(Constant.SHOP_LIST_PRODUCT).forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


