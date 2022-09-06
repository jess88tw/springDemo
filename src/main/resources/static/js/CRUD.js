function selectCRUD (e) {
    
    document.getElementById("idLabel").style="display: inline-block";
    document.getElementById("nameLabel").style="display: inline-block";
    
    document.getElementById("id").type="text";
    document.getElementById("id").parentElement.className="form-control";

    document.getElementById("name").type="text";
    document.getElementById("name").readOnly=true;
    document.getElementById("name").style="color: rgb(118, 118, 118)";
    document.getElementById("name").value="unnecessary";
    document.getElementById("name").parentElement.className="form-control";
    
    switch (e.target.value) {
        case "create":
            document.getElementById("homeForm").action = "/example/confirm/create";
                
            document.getElementById("name").readOnly=false;
            document.getElementById("name").style="";
            document.getElementById("name").value="";
            break;
        case "search":
            document.getElementById("homeForm").action = "/example/result/search";
            break;
        case "update":
            document.getElementById("homeForm").action = "/example/confirm/update";
            break;
        case "delete":
            document.getElementById("homeForm").action = "/example/confirm/delete";
            break;
    };
};