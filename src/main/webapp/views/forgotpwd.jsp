<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
    <link rel="stylesheet" href="styles.css"> <!-- Thêm link đến file CSS nếu cần -->
</head>
<body>
    <div class="container">
        <h2>Quên mật khẩu</h2>
        <form action="${pageContext.request.contextPath}/forgotPassword" method="post">
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br><br>
            <button type="submit">Gửi mã xác nhận</button>
        </form>
    </div>
</body>
</html>
