// Modals
let modalCloseButtons = document.querySelectorAll('.modal > .container > .close-button');
for (let i = 0; i < modalCloseButtons.length; i++) {
    modalCloseButton = modalCloseButtons[i];
    modalCloseButton.addEventListener('click', function() {
        modalCloseButton.parentElement.parentElement.classList.remove('show');
    });
}
window.addEventListener('click', function windowOnClick(event) {
    let modals = document.querySelectorAll('.modal');
    for (let i = 0; i < modals.length; i++) {
        modal = modals[i];
        if (event.target === modal) {
            modal.classList.remove('show');
        }
    }
});


// Navigation
let navItems = document.querySelectorAll('nav a');
let navItem;
for (let i = 0; i < navItems.length; i++) {
    navItem = navItems[i];
    if (window.location.pathname === navItem.getAttribute('href')) {
        navItem.classList.add('active');
    }
}
