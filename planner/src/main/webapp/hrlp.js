function retrieveOptions(source_obj1, source_obj2, target_obj_name, selectboxid) {
    A = source_obj1;
    B = source_obj2;
    C = document.getElementById(selectboxid);
    url = "loadAjaxResource.edu?selectedOption1=" + A.value + "&selectedOption2=" + B.value + "&type=" + target_obj_name + "&random=" + Math.random();
    //alert("url:::"+url);
    if (window.XMLHttpRequest) {
        // Non-IE browsers
        newReq = new XMLHttpRequest();
        newReq.onreadystatechange = populateSecondBoxOptions;
        try {
            newReq.open("GET", url, true);
        } catch (e) {
            alert("Cannot connect to server");
        }
        newReq.send(null);
    } else if (window.ActiveXObject) {
        // IE browser
        newReq = new ActiveXObject("Microsoft.XMLHTTP");
        if (newReq) {
            newReq.onreadystatechange = populateSecondBoxOptions;
            newReq.open("GET", url, true);
            newReq.send();
        }
    }
}

// Callback function
function populateSecondBoxOptions() {
    C.options.length = 0;

    if (newReq.readyState == 4) { // Complete
        if (newReq.status == 200) {
            // OK response
            textToSplit = newReq.responseText;
            if (textToSplit == '803') {
                alert("No select option available on the server");
            }
            returnElements = textToSplit.split("||");
            for (var i = 0; i < returnElements.length; i++) {
                valueLabelPair = returnElements[i].split(",,,");
                C.options[i] = new Option(valueLabelPair[1], valueLabelPair[0]);
            }
        }
    } else {
        // alert("Bad response by the server");
    }
    //alert("end");
}