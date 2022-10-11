function crReq ()
{
    let req = null;
    if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        try{
            req = new ActiveXObject("Msxml2.XMLHTTP");
        }catch(e){
            try{
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }catch(e){
                req = null;
            }
        }
    }
    return req;
}

function Fill(req){
    let xmldom = req.responseXML;
    let  sternum = xmldom.getElementsByTagName("num");
    let rc = "";

    for (let i = 0; i < sternum.length; i++){
        rc += sternum[i].textContent + " ";
    }

    return (rc);
}

function OnClick_XML(n, s){
    let pattern = new RegExp(/^[1-9]+[0-9]*$/);
    if (pattern.test(n)){
        let req = crReq();
        if (req){
            req.open("POST","http://localhost:8080/Lab_11-1.0/Sss_XML", true, false);
            req.onreadystatechange = function(){
                if (req.readyState === 4 && req.status === 200){
                        s.firstChild.data = Fill(req);
                        s.className ="h1";
                    }/*else alert("status = "+
                        req.status +"\n"+req.statusText);*/
                }
            req.setRequestHeader("XRand-N",  n)
            req.send("null");
        }
    }//else alert ("error");
}
