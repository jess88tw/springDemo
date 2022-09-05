const form = document.getElementById("homeForm");
const id = document.getElementById("id");
const name = document.getElementById("name");

document.getElementById("homeForm").addEventListener("submit", e => {
    checkInputs(e);
});

function checkInputs (e) {
    if (id.value == "") {
        e.preventDefault();
        setErrorFor(id, "ID 不得為空白");
    }
    else if (!/^[0-9]+$/.test(id.value)) {
        e.preventDefault();
        setErrorFor(id, "ID 只能為數字");
    }
    else if (id.value.length > 5) {
        e.preventDefault();
        setErrorFor(id, "ID 長度只能小於 5 位數");
    }
    else {
        setSuccessFor(id);
    };
};

function setErrorFor(input, message) {
	const formControl = input.parentElement;
	const small = formControl.querySelector("small");
	formControl.className = "form-control error";
	small.innerText = message;
}

function setSuccessFor(input) {
	const formControl = input.parentElement;
	formControl.className = "form-control success";
}