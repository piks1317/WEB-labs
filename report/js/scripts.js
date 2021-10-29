function openLabItem(labItem) {

    var i, labItemContent;

    labItemContent = document.getElementsByClassName("labItemContent");
    for (i = 0; i < labItemContent.length; i++) {
        labItemContent[i].style.display = "none";
    }

    document.getElementById(labItem).style.display = "block";

}


function openLab(labName) {

    var i, labContent;

    labContent = document.getElementsByClassName("labContent");
    for (i = 0; i < labContent.length; i++) {
        labContent[i].style.display = "none";
    }

    document.getElementById(labName).style.display = "block";
}