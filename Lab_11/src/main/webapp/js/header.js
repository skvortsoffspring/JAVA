// crReq.js
function crReq ()
{
    //alert( "crReq");
    let req = null;
    if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
        //alert( "req = XMLHttpRequest");
    }
    else if (window.ActiveXObject)
    {
        try{
            req = new ActiveXObject("Msxml2.XMLHTTP");
            ////alert( "req = Msxml2.XMLHTTP");
        }catch(e){
            try{
                req = new ActiveXObject("Microsoft.XMLHTTP");
                //alert( "req = Microsoft.XMLHTTP");
            }catch(e){
                req = null;
                //alert( "req = null");
            }
        }
    }
    return req;
}


function OnClick_Header(x,y, z){
    let pattern = new RegExp(/^[0-9]*\.?[0-9]+$/);
    if (pattern.test(x.value) && pattern.test(y.value)){
        let req = crReq();

        if (req){
            req.open("POST","http://localhost:8080/Lab_11-1.0/Sss_Header", true, false);
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
}
