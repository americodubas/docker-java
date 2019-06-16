package com.test.business;

import javax.xml.ws.Endpoint;

public class ExamPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9876/exam", new ExamBusiness());
    }

}