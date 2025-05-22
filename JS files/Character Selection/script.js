document.addEventListener('DOMContentLoaded', function () {
    let characterList = document.querySelector('.character-flex');
    let selectedGif = document.getElementById('selected-gif');
    let selectedName = document.getElementById('selected-name');
    let selectedDescription = document.getElementById('selected-description');
    let currentlySelected = null;

    characterList.addEventListener('click', function (e) {
        if (e.target && e.target.closest('.character-item')) {
            let character = e.target.closest('.character-item');
            let name = character.dataset.name;
            let gif = character.dataset.gif;
            let description = character.dataset.description;

            selectedGif.src = gif;
            selectedGif.alt = name;
            selectedName.textContent = name;
            selectedDescription.textContent = description;

            if (currentlySelected) {
                currentlySelected.classList.remove('selected');
            }

            character.classList.add('selected');
            currentlySelected = character;
        }
    });
});