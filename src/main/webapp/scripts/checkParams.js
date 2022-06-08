function checkParams() {
    let regex = /^(\+7|7|8)?[\s\-]?\(?[489][0-9]{2}\)?[\s\-]?[0-9]{3}[\s\-]?[0-9]{2}[\s\-]?[0-9]{2}$/;
    var login = document.getElementById('login');
    var pass = document.getElementById('password');
    document.getElementById('send').disabled = login.value && pass.value ? false : 'disabled';
}


function showElem(contId, id) {
    //var elems = document.querySelectorAll("'#" + contId + " div'");

    var container = document.getElementById(contId);
    var elems = container.getElementsByTagName('div');
    for (var i = 0; i < elems.length; i++) {
        elems[i].style.display = 'none';
    }
    container.style.display = 'flex';
    document.getElementById(id).style.display = 'flex';
}

function compareSum(idInput, str){
    document.getElementById(idInput).value = str;
    console.log(document.getElementById(idInput).value);
}

function getSelectedLabel(sel) {
    document.getElementById("selectedLabel").value = sel.options[sel.selectedIndex].text;
}