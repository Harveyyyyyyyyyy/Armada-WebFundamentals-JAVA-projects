document.addEventListener('DOMContentLoaded', function () {
    let colorButtons = document.querySelectorAll('.color-button');
    let selectedColorSpan = document.getElementById('selected-color');
    let colorContainer = document.getElementById('color-container');
    let h1 = document.querySelector('h1');
    let p = document.querySelectorAll('p');

    colorButtons.forEach(button => {
        button.addEventListener('click', function () {
            // get the color from the class name
            let color = this.classList[1].replace('color-button-', '');
            let capitalizedColor = color.charAt(0).toUpperCase() + color.slice(1);

            // background colors
            document.body.style.backgroundColor = color;
            colorContainer.style.backgroundColor = color;

            // remove highlight from all buttons and add to clicked button
            colorButtons.forEach(btn => btn.classList.remove('highlight'));
            this.classList.add('highlight');

            // update selected color text
            selectedColorSpan.textContent = capitalizedColor;

            // change text color on selected color buttons
            let textColor = (color === 'red' || color === 'blue' || color === 'green' || color === 'purple') ? 'white' : '';
            h1.style.color = textColor;
            p.forEach(pElement => pElement.style.color = textColor); // Apply to both <p> elements
        });
    });
});