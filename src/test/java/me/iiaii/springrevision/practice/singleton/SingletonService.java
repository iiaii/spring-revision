package me.iiaii.springrevision.practice.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    private SingletonService() {
    }

    public static SingletonService getInstance() {
        return instance;
    }

    public void login() {
        System.out.println("로직 호출");
    }
}
