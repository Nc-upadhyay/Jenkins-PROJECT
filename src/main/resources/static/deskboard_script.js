const url = "http:localhost:8080/home/";
function favTutorial() {
    const status = document.getElementById("myList").value;
    console.log(status);
    filterTask(status)

}

document.getElementById("addTask").onclick = function addTask() {
    openForm();
}
displayTask();
function displayTask() {
    const userId = localStorage.getItem("userId");
    if (userId == null) {
        alert("You Did't Have Any Task")
        return;
    }
    const endPoint = url + "desk-board/" + userId
    fetch(endPoint, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    }).then(response => {
        console.log("response " + response);
        if (!response.ok) {
            throw new Error(`Task not created ${response.status}`);
        }
        const contentType = response.headers.get('content-type');
        if (!contentType || !contentType.includes('application/json')) {
            return response.text(); // Read the response as text
        }

        return response.json();
    })
        .then(data => {
            console.log("data is " + data);
            // alert('task fetch Succesfuly');
            data.forEach(task => createCard(task));
        }).catch(error => {
            console.log(error);
        });


}
function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("savebtn").onclick = function save(event) {
        event.preventDefault(); // Prevent the default form submission behavior

        const endPoint = url + "create";
        const userId = localStorage.getItem("userId");
        // alert(userId);

        console.log("userid " + userId);
        fetch(endPoint, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "taskname": document.getElementById("taskname").value,
                "description": document.getElementById("description").value,
                "status": "Todo",
                "user": userId
            })
        })
            .then(response => {
                if (!response.ok) {
                    alert('Task Not created');
                    throw new Error(`Task not created ${response.status}`);
                }
                const contentType = response.headers.get('content-type');
                if (!contentType || !contentType.includes('application/json')) {
                    return response.text();
                }

                return response.json();
            })
            .then(data => {
                console.log("data is saved in ->" + data);
                // alert('Task Save Successfully');
                closeForm();
                location.reload();

            })
            .catch(error => {
                console.error('Error:', error);
                alert('An error occurred. Please try again later.');
            });
    };
});
function filterTask(status) {
    const userId = localStorage.getItem("userId");
    const endPoint = url + 'status/' + status + "/" + userId;
    console.log("endpoint is " + endPoint);
    fetch(endPoint, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => {
            if (!response.ok) {
                alert('data not filter ');
                throw new Error(`Task not created ${response.status}`);
            }
            const contentType = response.headers.get('content-type');
            if (!contentType || !contentType.includes('application/json')) {
                return response.text(); // Read the response as text
            }

            return response.json();

        })
        .then(data => {
            console.log("task list "+data)
            cardContainer.innerHTML='';
            data.forEach(task => createCard(task));
        }).catch(errro => {
            console.error('Error:', error);
            alert('An error occurred. Please try again later.');
        })

}


// Reference to the card container
const cardContainer = document.getElementById('data-width');

// Function to create a card
function createCard(task) {

    const back = document.createElement('div');
    back.classList.add('back');

    const taskName = document.createElement('div');
    taskName.classList.add('width-6');
    const taskName2 = document.createElement('div');
    taskName2.classList.add('text-set');
    const para = document.createElement('span');
    para.textContent = "Task Name :";
    taskName2.appendChild(para);
    taskName.appendChild(taskName2);


    const taskNamed = document.createElement('div');
    taskNamed.classList.add('width-6');
    const taskNamed2 = document.createElement('div');
    taskNamed2.classList.add('text-set');
    const parad = document.createElement('span');
    parad.textContent = task.taskname;
    taskNamed2.appendChild(parad);
    taskNamed.appendChild(taskNamed2);


    const taskDescription = document.createElement('div');
    taskDescription.classList.add('width-6');
    const taskDescription2 = document.createElement('div');
    taskDescription2.classList.add('text-set');
    const desc = document.createElement('span');
    desc.textContent = "Description :";
    taskDescription2.appendChild(desc);
    taskDescription.appendChild(taskDescription2);

    const taskDescriptiond = document.createElement('div');
    taskDescriptiond.classList.add('width-6');
    const taskDescriptiond2 = document.createElement('div');
    taskDescriptiond2.classList.add('text-set');
    const descd = document.createElement('p');
    descd.textContent = task.description;
    taskDescriptiond2.appendChild(descd);
    taskDescriptiond.appendChild(taskDescriptiond2);




    const dropdown = document.createElement('div');
    dropdown.classList.add('dropdown');
    const select = document.createElement('select');
    // Add options to the dropdown if needed
    select.innerHTML = `<option value="${task.status}">${task.status}</option>
                        <option value="Todo">Todo</option>
                        <option value="Progress">Progress</option>
                        <option value="Testing">Testing</option>
                        <option value="Review">Review</option>
                        <option value="Done">Done</option>`;

    select.addEventListener('change', (event) => {
        console.log("task id " + task.id + " value is " + event.target.value);
        updateStatus(task.id, event.target.value);
    })
    dropdown.appendChild(select);


    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-button');
    deleteButton.textContent = 'Delete';

    deleteButton.addEventListener('click', () => {
        // console.log("task id "+task.id);
        deleteTask(task.id)
        back.remove();
    });

    // Append elements to the card
    back.appendChild(taskName);
    back.appendChild(taskNamed);
    back.appendChild(taskDescription);
    back.appendChild(taskDescriptiond);
    back.appendChild(dropdown);
    back.appendChild(deleteButton);

    // Append the card to the container
    cardContainer.appendChild(back);
}

function updateStatus(taskId, status) {
    const endPoint = url + "update-status/" + taskId + "/" + status;
    fetch(endPoint, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => {
            if (response.status >= 200 && response.status < 300) {
                const contentType = response.headers.get('content-type');
                if (contentType && contentType.includes('application/json')) {
                    return response.json();
                } else {
                    return response.text();
                }
            } else {
                alert("Status not updated");
                throw new Error(`Status not updated ${response.status}`);
            }
        })
        .then(data => {
            // alert("task updated");
        }).catch(error => {
            console.error('Error:', error);
            alert('An error occurred. Please try again later.');
        })
}
function deleteTask(taskId) {
    const endPoint = url + "delete-task/" + taskId;
    fetch(endPoint, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => {
            if (!response.ok) {
                alert('Task not Deleted ');
                throw new Error(`Task not created ${response.status}`);
            }
            const contentType = response.headers.get('content-type');
            if (!contentType || !contentType.includes('application/json')) {
                return response.text();
            }

            return response.json();

        })
        .then(data => {

        }).catch(errro => {
            console.error('Error:', error);
            alert('An error occurred. Please try again later.');
        })
}
