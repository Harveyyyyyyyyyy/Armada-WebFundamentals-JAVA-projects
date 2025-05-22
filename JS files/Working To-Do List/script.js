function handleEnterKey(event) {
    if (event.key === 'Enter') {
        event.preventDefault();
        addTask();
    }
}

function addTask() {
    let taskInput = document.getElementById('task-input');
    let taskText = taskInput.value.trim();
    
    if (taskText === '') return; // Prevent empty tasks

    let taskListItem = document.createElement('li');
    taskListItem.classList.add('p1'); // Default class

    let taskSpan = document.createElement('span');
    taskSpan.textContent = taskText;

    let deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent = 'Remove';
    deleteButton.onclick = function() {
        const taskText = taskSpan.textContent;
        taskListItem.parentNode.removeChild(taskListItem);
        showNotification(`Task removed: ${taskText}`);
    };

    taskListItem.appendChild(taskSpan);
    taskListItem.appendChild(deleteButton);

    let taskList = document.getElementById('task-list');
    taskList.appendChild(taskListItem);

    // Show notification
    showNotification(`Task added: ${taskText}`);

    taskInput.value = ''; // Clear input field
}

// Function to show notifications
function showNotification(message) {
    let notification = document.createElement('div');
    notification.classList.add('notification');
    notification.textContent = message;
    let notificationsContainer = document.getElementById('notifications');
    notificationsContainer.appendChild(notification);

    setTimeout(function () {
        notificationsContainer.removeChild(notification);
    }, 5000); // Remove after 5 seconds
}