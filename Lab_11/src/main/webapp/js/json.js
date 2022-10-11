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

function Fill_JSON(req){
    let  xx = eval('('+req.responseText+')');
    let rc = "";
    for (let i = 0; i < xx.X.length; i++){
        rc += (xx.X[i].rand + " ");
    }
    return (rc);
}

function OnClick_JSON(n, s){
    let pattern = new RegExp(/^[1-9]+[0-9]*$/);
    if (pattern.test(n)){
        let req = crReq();
        if (req){
            req.open("POST","http://localhost:8080/Lab_11-1.0/Sss_JSON", true, false);
            req.onreadystatechange = function(){
                if (req.readyState === 4 && req.status === 200){
                        s.firstChild.data =
                            Fill_JSON(req);
                        s.className ="h1";
                    }//else
                        //alert("status = " + req.status +"\n"+req.statusText);
                }
            req.setRequestHeader("XRand-N",  n);
            req.send("null");
        }
    }//else alert ("error");
}
