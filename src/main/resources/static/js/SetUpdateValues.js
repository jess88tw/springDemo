const path = document.getElementById("path").value;

if (path == "/result/update") {
    document.getElementById("id").type="text";
    document.getElementById("id").readOnly = true;
    document.getElementById("name").type="text";
}