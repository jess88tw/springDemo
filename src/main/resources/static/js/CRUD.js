function selectCRUD (e) {
    switch (e.target.value) {
        case "create":
            document.getElementById("homeForm").action = "/example/confirm/create";
            document.getElementById("name").readOnly="";
            break;
        case "search":
            document.getElementById("homeForm").action = "/example/result/search";
            document.getElementById("name").readOnly="readonly";
            break;
        case "update":
            document.getElementById("homeForm").action = "/example/confirm/update";
            document.getElementById("name").readOnly="readonly";
            break;
        case "delete":
            document.getElementById("homeForm").action = "/example/confirm/delete";
            document.getElementById("name").readOnly="readonly";
            break;
    };
};