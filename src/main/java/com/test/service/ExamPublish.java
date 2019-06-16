package com.test.service;

import javax.xml.ws.Endpoint;

public class ExamPublish {

    public static void main (String[] args) {
        Endpoint endpoint = Endpoint.publish("http://localhost:8088/exam", new ExamService());
    }

}
