const checkUpdate = function() {
    let selector = document.querySelector(`#shareType`);
    if (selector.value === `joint`) {
        document.querySelector(`#otherPerson`).classList.toggle("hide");
    }
}