const armorOptions = document.querySelectorAll('.options img');
const helmetSlot = document.getElementById('helmet-slot');
const armorSlot = document.getElementById('armor-slot');
const leggingsSlot = document.getElementById('leggings-slot');
const bootsSlot = document.getElementById('boots-slot');

const saveButton = document.getElementById('save-button');
const confirmationMessage = document.getElementById('confirmation-message');

saveButton.addEventListener('click', () => {
    confirmationMessage.textContent = 'Character build saved successfully!';
});

armorOptions.forEach(option => {
    option.addEventListener('click', () => {
        const part = option.getAttribute('data-part');
        const imageSrc = option.getAttribute('src');

        if (part === 'helmet') helmetSlot.setAttribute('src', imageSrc);
        if (part === 'armor') armorSlot.setAttribute('src', imageSrc);
        if (part === 'leggings') leggingsSlot.setAttribute('src', imageSrc);
        if (part === 'boots') bootsSlot.setAttribute('src', imageSrc);

        document.querySelectorAll(`.${part}-options img`).forEach(img => img.classList.remove('selected'));
        option.classList.add('selected');
    });
});