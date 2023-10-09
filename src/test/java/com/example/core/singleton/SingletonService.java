package com.example.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글 톤 객체 로직 호출");
    }
}
