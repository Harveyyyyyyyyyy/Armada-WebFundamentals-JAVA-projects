// update the profile name
function updateName() {
    let newName = document.getElementById("nameInput").value;
    document.getElementById("name").innerText = newName;
}

// update the profile bio
function updateBio() {
    let newBio = document.getElementById("bioInput").value;
    document.getElementById("bio").innerText = newBio;
}

// update the profile image
function updatePic() {
    let newProfilePicture = document.getElementById("picInput").value;
    document.getElementById("profilePic").setAttribute("src", newProfilePicture);
}

// update the background color of the profile card
function updateColor() {
    let newColor = document.getElementById("colorInput").value;
    document.getElementById("profileCard").style.backgroundColor = newColor;
}

// function to update the entire profile card
function updateProfile() {
    updateName();
    updateBio();
    updatePic();
    updateColor();
}

// Add event listener to the "Update Profile Card" button
document.addEventListener('DOMContentLoaded', function () {
    let updateProfileBtn = document.getElementById('updateProfileBtn');
    updateProfileBtn.addEventListener('click', updateProfile);
});