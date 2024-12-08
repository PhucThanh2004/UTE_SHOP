package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.models.ProductModel;
import vn.iotstar.models.ReviewModel;
import vn.iotstar.service.ICategoryService;
import vn.iotstar.service.IProductService;
import vn.iotstar.service.IReviewService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.service.impl.ReviewServiceImpl;
import vn.iotstar.utils.Constant;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/product/detail"})
public class ProductDetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IProductService productService;
    private ICategoryService categoryService;
    private IReviewService reviewService;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
        categoryService = new CategoryServiceImpl();
        reviewService = new ReviewServiceImpl(); // Khởi tạo ReviewService

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int productId = Integer.parseInt(req.getParameter("id"));

            categoryService = new CategoryServiceImpl();
            List<CategoryModel> categories = categoryService.getCategories();

            req.setAttribute("categories", categories);

            ProductModel product = productService.getProductById(productId);
            req.setAttribute("product", product);
            
            List<ReviewModel> reviews = reviewService.getReviewsWithAuthorByProductId(productId);
            req.setAttribute("reviews", reviews); 

            req.getRequestDispatcher(Constant.USER_PRODUCT_DETAIL).forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   

}
