function showNotification() {
    createNotification("You have a new message!");
}

function createNotification(message) {
    // Create notification element
    let notification = document.createElement("div");
    notification.classList.add("notification");

    // Create text node
    let textNode = document.createTextNode(message);
    notification.appendChild(textNode);

    // Create close button
    let closeBtn = document.createElement("button");
    closeBtn.textContent = "X";
    closeBtn.classList.add("close-btn");
    closeBtn.onclick = function () {
        notification.remove();
    };

    // Append close button to notification
    notification.appendChild(closeBtn);

    // Get notification container
    let notificationContainer = document.getElementById("notificationContainer");

    // Insert notification
    if (notificationContainer.firstChild) {
        notificationContainer.insertBefore(notification, notificationContainer.firstChild);
    } else {
        notificationContainer.appendChild(notification);
    }

    // Auto-remove after 5 seconds
    setTimeout(() => {
        if (notificationContainer.contains(notification)) {
            notification.remove();
        }
    }, 5000);
}