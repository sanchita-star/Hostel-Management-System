document.addEventListener('DOMContentLoaded', () => {
  const regForm = document.getElementById('registerForm');
  const loginForm = document.getElementById('loginForm');

  if (regForm) {
    regForm.addEventListener('submit', (e) => {
      e.preventDefault();
      const newPass = document.getElementById('newpass').value;
      const confirmPass = document.getElementById('confirmpass').value;

      if (newPass !== confirmPass) {
        alert("Passwords do not match!");
        return;
      }

      alert("Registered successfully!");
      window.location.href = "login.html";
    });
  }

  if (loginForm) {
    loginForm.addEventListener('submit', (e) => {
      e.preventDefault();
      alert("Login successful!");
      window.location.href = "home.html";
    });
  }
});