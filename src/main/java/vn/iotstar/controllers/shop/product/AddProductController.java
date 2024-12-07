package vn.iotstar.controllers.shop.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.models.ProductImageModel;
import vn.iotstar.models.ProductModel;
import vn.iotstar.service.ICategoryService;
import vn.iotstar.service.IProductImageService;
import vn.iotstar.service.IProductService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ProductImageServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.utils.Constant;
import vn.iotstar.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@WebServlet(urlPatterns = {"/shop/product/add-product"})
@MultipartConfig
public class AddProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IProductService productService;
    private ICategoryService categoryService;
    private IProductImageService productImageService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            categoryService = new CategoryServiceImpl();
            List<CategoryModel> categories = categoryService.getCategories();

            req.setAttribute("categories", categories);

            req.getRequestDispatcher(Constant.SHOP_ADD_PRODUCT).forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String name = null;
            String description = null;
            double price = 0.0;
            int stockQuantity = 0;
            int categoryId = 0;

            Collection<Part> parts = req.getParts();
            for (Part part : parts) {
                String fieldName = part.getName();

                if ("name".equals(fieldName)) {
                    name = req.getParameter("name");
                } else if ("description".equals(fieldName)) {
                    description = req.getParameter("description");
                } else if ("price".equals(fieldName)) {
                    price = Double.parseDouble(req.getParameter("price"));
                } else if ("stock_quantity".equals(fieldName)) {
                    stockQuantity = Integer.parseInt(req.getParameter("stock_quantity"));
                } else if ("category_id".equals(fieldName)) {
                    categoryId = Integer.parseInt(req.getParameter("category_id"));
                }
            }

            ProductModel product = new ProductModel();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setStockQuantity(stockQuantity);
            product.setCategoryId(categoryId);
            product.setShopId(4); // thay shopId
            product.setCreatedAt(LocalDateTime.now());
            productService = new ProductServiceImpl();
            productService.addProduct(product);

            for (Part filePart : req.getParts()) {
                if ("product_images".equals(filePart.getName())) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

                    String webappPath = getServletContext().getRealPath("/");
                    File rootDir = new File(webappPath).getParentFile().getParentFile().getParentFile();
                    String uploadPath = rootDir + File.separator + "src" + File.separator + "main" +
                            File.separator + "webapp" + File.separator + Constant.UPLOAD_DIRECTORY;

                    File uploadFile = new File(uploadPath);
                    if (!uploadFile.exists()) {
                        uploadFile.mkdir();
                    }
                    String newFileName = new Utils().generateUniqueFileName(fileName);
                    String filePath = uploadPath + File.separator + newFileName;
                    filePart.write(filePath);

                    ProductImageModel productImage = new ProductImageModel();
                    productImage.setProductId(product.getId());
                    productImage.setProductImage("/uploads/" + newFileName);
                    productImageService = new ProductImageServiceImpl();
                    productImageService.addProductImage(productImage);
                }
            }
            req.getSession().setAttribute("message", "Thêm mới sản phẩm thành công!");
            resp.sendRedirect(req.getContextPath() + "/shop/product/list-product");
        } catch (Exception e) {
            req.getSession().setAttribute("error", "Thêm mới sản phẩm thất bại!");
            resp.sendRedirect(req.getContextPath() + "/shop/product/list-product");
            throw new RuntimeException(e);
        }
    }
}


