/*package ci.hack.plugin;

public class CCEServicePortTypeProxy implements cgg.gov.cce.CCEServicePortType {
  private String _endpoint = null;
  private ci.hack.plugin.CCEServicePortType cCEServicePortType = null;
  
  public CCEServicePortTypeProxy() {
    _initCCEServicePortTypeProxy();
  }
  
  public CCEServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCCEServicePortTypeProxy();
  }
  
  private void _initCCEServicePortTypeProxy() {
    try {
      cCEServicePortType = (new cgg.gov.cce.CCEServiceLocator()).getCCEServiceHttpPort();
      if (cCEServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cCEServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cCEServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cCEServicePortType != null)
      ((javax.xml.rpc.Stub)cCEServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cgg.gov.cce.CCEServicePortType getCCEServicePortType() {
    if (cCEServicePortType == null)
      _initCCEServicePortTypeProxy();
    return cCEServicePortType;
  }
  
  public cgg.gov.cce.CCEData CCEStudentData(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (cCEServicePortType == null)
      _initCCEServicePortTypeProxy();
    return cCEServicePortType.CCEStudentData(in0, in1, in2);
  }
  
  
}*/