let navItems = document.querySelectorAll('nav.nav a');
let navItem;
for (let i = 0; i < navItems.length; i++) {
    navItem = navItems[i];
    if (window.location.pathname === navItem.getAttribute('href')) {
        navItem.classList.add('active');
    }
}

