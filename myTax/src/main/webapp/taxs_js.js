function showKid() {
    var check = document.getElementById("check").checked;
    var select = "<select name=\"sel\">" +
            "<option value=\"noKid\">NO KIDS</option>" +
            "<option value=\"oneKid\">ONE KID</option>" +
            "<option value=\"twoKid\">TWO KIDS</option>" +
            "<option value=\"threeKid\">THREE KIDS</option>" +
            "<option value=\"moreThan3Kid\">MORE THAN THREE KIDS</option>" +
            "</select>";
    if (check) {
        document.getElementById("kids").innerHTML =  select;
    }else{
        document.getElementById("kids").innerHTML = "";
    }
}
