document.addEventListener('DOMContentLoaded', function () {
    let boxImage = document.getElementById('boxImage');
    let boxButton = document.getElementById('boxButton');
    let soundEffect = document.getElementById('soundEffect');

    let closedImage = boxImage.dataset.closed;
    let openImage = boxImage.dataset.open;

    let isOpen = false;

    function updateImage() {
        if (isOpen) {
            // close the box
            boxImage.src = closedImage;
            isOpen = false;
        } else {
            // open the box
            boxImage.src = openImage;
            isOpen = true;

            //sound effect
            soundEffect.play();

            // reset to Default State after the gif
            setTimeout(() => {
                boxImage.src = closedImage;
                isOpen = false;
            }, 6000);
        }
    }

    boxImage.addEventListener('click', updateImage);
    boxButton.addEventListener('click', updateImage);
});