document.addEventListener('DOMContentLoaded', function() {
    const themeToggle = document.getElementById('theme');
    const body = document.body;

    themeToggle.addEventListener('change', () => {
        body.classList.toggle('light-mode');
        if (body.classList.contains('light-mode')) {
            localStorage.setItem('mode', 'light');
        } else {
            localStorage.setItem('mode', 'dark');
        }
    });

    // Check for saved mode preference
    const savedMode = localStorage.getItem('mode');
    if (savedMode === 'light') {
        body.classList.add('light-mode');
        themeToggle.checked = true; // Asegura que el checkbox esté marcado
    }
});