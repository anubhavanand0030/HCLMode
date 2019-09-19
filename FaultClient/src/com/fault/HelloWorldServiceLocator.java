/**
 * HelloWorldServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fault;

public class HelloWorldServiceLocator extends org.apache.axis.client.Service implements com.fault.HelloWorldService {

    public HelloWorldServiceLocator() {
    }


    public HelloWorldServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloWorldServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloWorldPort
    private java.lang.String HelloWorldPort_address = "http://127.0.0.1:5555/HelloWorld";

    public java.lang.String getHelloWorldPortAddress() {
        return HelloWorldPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloWorldPortWSDDServiceName = "HelloWorldPort";

    public java.lang.String getHelloWorldPortWSDDServiceName() {
        return HelloWorldPortWSDDServiceName;
    }

    public void setHelloWorldPortWSDDServiceName(java.lang.String name) {
        HelloWorldPortWSDDServiceName = name;
    }

    public com.fault.HelloWorld getHelloWorldPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloWorldPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloWorldPort(endpoint);
    }

    public com.fault.HelloWorld getHelloWorldPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.fault.HelloWorldPortBindingStub _stub = new com.fault.HelloWorldPortBindingStub(portAddress, this);
            _stub.setPortName(getHelloWorldPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloWorldPortEndpointAddress(java.lang.String address) {
        HelloWorldPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.fault.HelloWorld.class.isAssignableFrom(serviceEndpointInterface)) {
                com.fault.HelloWorldPortBindingStub _stub = new com.fault.HelloWorldPortBindingStub(new java.net.URL(HelloWorldPort_address), this);
                _stub.setPortName(getHelloWorldPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HelloWorldPort".equals(inputPortName)) {
            return getHelloWorldPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://fault.com/", "HelloWorldService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://fault.com/", "HelloWorldPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloWorldPort".equals(portName)) {
            setHelloWorldPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
