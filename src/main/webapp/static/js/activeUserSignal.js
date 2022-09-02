let inactivityTime = () => {
    let time,
            inpulse = document.querySelector('.loader');

    document.addEventListener('mousemove', resetTimer);
    document.addEventListener('scroll', resetTimer);
    document.addEventListener('keypress', resetTimer);

    function resetTimer() {
        inpulse.classList.add('loader');
        inpulse.classList.remove('inpulse');
        clearTimeout(time);
        time = setTimeout(fn, 3000);
    }

    function fn() {
        inpulse.classList.add('inpulse');
        inpulse.classList.remove('loader');
    }
};

document.addEventListener('DOMContentLoaded', () => {
    inactivityTime();
});


