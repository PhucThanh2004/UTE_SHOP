<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Xác nhận mã reset</title>
    <link rel="stylesheet" href="styles.css"> <!-- Thêm link đến file CSS nếu cần -->
</head>
<body>
    <div class="container">
        <h2>Xác nhận mã reset mật khẩu</h2>
        <form action="${pageContext.request.contextPath}/verifyResetCode" method="post">
            <label for="authcode">Mã xác nhận:</label><br>
            <input type="text" id="authcode" name="authcode" required><br><br>
            <button type="submit">Xác nhận</button>
        </form>
    </div>
</body>
</html>
