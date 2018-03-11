function getResponseText(httpXMLObj)

{

    if (httpXMLObj.readyState == 4)

    {

        if (httpXMLObj.status == 200)

        {

            return httpXMLObj.responseText;

        }

    }

}







function GetXmlHttpObject()

{

    var xmlHttp=null;

    try

    {

        // Firefox, Opera 8.0+, Safari

        xmlHttp=new XMLHttpRequest();

    }

    catch (e)

    {

        // Internet Explorer

        try

        {

            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");

        }

        catch (e)

        {

            xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");

        }

    }

    return xmlHttp;

}




function getXMLRequest()

{

    var httpXMLObj = false;

//	this.sendXMLRequest = sendXMLRequest

//	this.getResponse = getResponse

//	this.callback = false




    if (window.XMLHttpRequest)

    { // for mozilla and firefox

        /*try

        {

            netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead");

        } catch (e)

        {

            alert("Permission UniversalBrowserRead denied.");

        }*/

        httpXMLObj = false;

        httpXMLObj = new XMLHttpRequest();

        if (httpXMLObj.overrideMimeType)

        {

            httpXMLObj.overrideMimeType('text/xml');

        }



    }

    else if (window.ActiveXObject)

    { //for ie

        try

        {

            httpXMLObj = new ActiveXObject("Msxml2.XMLHTTP");

        }catch (e)

        { try 	{

            httpXMLObj = new ActiveXObject("Microsoft.XMLHTTP");

        } catch (e)

        { }

        }

    }

    if( !httpXMLObj )

        alert("NO XML");

    return httpXMLObj;

}




function getResponseData(httpXMLObj)

{

    var xmldoc = false

    if (httpXMLObj && httpXMLObj.readyState == 4)

    {

        if (httpXMLObj.status == 200)

        {

            var string = httpXMLObj.responseText;

            /*if (window.XMLHttpRequest)

            {

                var parser = new DOMParser();

                var doc = parser.parseFromString(string, "text/xml");

                xmldoc = doc.documentElement;

            }

            else if (window.ActiveXObject)

            {

                xmldoc = httpXMLObj.responseXML;

            }*/

            if (window.ActiveXObject)

            {

                xmldoc = httpXMLObj.responseXML;

            }

            else if (window.XMLHttpRequest)

            {

                /* On IE7 the condition 'window.XMLHttpRequest' is valid but the object DOMParser does not exists,

                so the code will fail. */

                // so swapped the if condition to check the above first

                var parser = new DOMParser();

                var doc = parser.parseFromString(string, "text/xml");

                xmldoc = doc.documentElement;

            }

        }

        else

        {

            alert("ERROR")

        }

    }

    return xmldoc

}







var headID = document.getElementsByTagName("head")[0];

var cssNode = document.createElement('link');

cssNode.type = 'text/css';

cssNode.rel = 'stylesheet';

cssNode.target="_blank" href= 'js/ajax/ajax.css';

cssNode.media = 'screen';

headID.appendChild(cssNode);




loadingIndicator=null;

if( loadingIndicator == null )

{

    loadingIndicator=document.createElement("IMG");

    loadingIndicator.id="loading";

    loadingIndicator.src ="js/ajax/loading3.gif";

    loadingIndicator.width=16;

    loadingIndicator.height=16;

    loadingIndicator.style.border="0px solid blue";

    loadingIndicator.className="notWaiting";

}