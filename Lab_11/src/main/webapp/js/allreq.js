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

function Fill_JSON(req){
    let  xx = eval('('+req.responseText+')');
    let rc = "";
    for (let i = 0; i < xx.X.length; i++){
        rc += (xx.X[i].rand + " ");
    }
    return (rc);
}

let allRequests = (x, y, z, n, m) => {
    let pattern = new RegExp(/^[1-9]+[0-9]*$/);
    let async = document.getElementById("async").checked;
    console.log(async);

    if (pattern.test(x.value) && pattern.test(y.value)){
        let req = crReq();

        if (req){
            req.open("POST","http://localhost:8080/Lab_11-1.0/Sss_Header", async);
            req.onreadystatechange = function(){
                if (req.readyState === 4 && req.status === 200){
                    z.value = req.getResponseHeader("Value-Z");
                }
                //else alert("status = " + req.status +"\n"+req.statusText);
            }
            req.setRequestHeader("Value-X",  x.value);
            req.setRequestHeader("Value-Y",  y.value);
            req.send("null");
        }
    }//else alert ("error");

    if (pattern.test(n.value)){
        let req = crReq();
        console.log(n.value)
        if (req){
            req.open("POST","http://localhost:8080/Lab_11-1.0/Sss_XML", async);
            req.onreadystatechange = function(){
                if (req.readyState === 4 && req.status === 200){
                    document.getElementById("xml").innerText = Fill(req);
                    document.getElementById("xml").className ="h1";
                }/*else alert("status = "+
                        req.status +"\n"+req.statusText);*/
            }
            req.setRequestHeader("XRand-N",  n.value)
            req.send("null");
        }
    }//else alert ("error");

    if (pattern.test(m.value)){
        let req = crReq()
        console.log(m.value)
        if (req){
            req.open("POST","http://localhost:8080/Lab_11-1.0/Sss_JSON", async);
            req.onreadystatechange = function(){
                if (req.readyState === 4 && req.status === 200){
                    document.getElementById("json").innerText = Fill_JSON(req);
                    document.getElementById("json").className ="h1";
                }//else
                //alert("status = " + req.status +"\n"+req.statusText);
            }
            req.setRequestHeader("XRand-N",  m.value);
            req.send("null");
        }
    }//else alert ("error");

}
